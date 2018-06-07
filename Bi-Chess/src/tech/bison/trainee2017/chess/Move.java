package tech.bison.trainee2017.chess;

import java.util.ArrayList;
import java.util.Set;

import tech.bison.trainee2017.chess.Game.GameState;
import tech.bison.trainee2017.chess.pieces.BlackPawn;
import tech.bison.trainee2017.chess.pieces.King;
import tech.bison.trainee2017.chess.pieces.Piece;
import tech.bison.trainee2017.chess.pieces.Piece.Color;
import tech.bison.trainee2017.chess.pieces.WhitePawn;

public class Move {
  public final Piece piece;
  public final Piece capturedPiece;
  public final Movement movement;
  public final boolean kingInCheck;
  public final boolean kingInCheckMate;

  private Move(Piece piece, Piece capturedPiece, Movement movement, boolean kingInCheck, boolean kingInCheckMate) {
    this.piece = piece;
    this.capturedPiece = capturedPiece;
    this.movement = movement;
    this.kingInCheck = kingInCheck;
    this.kingInCheckMate = kingInCheckMate;
  }

  private Move(Piece piece, Piece capturedPiece, Movement movement, boolean kingInCheck) {
    this(piece, capturedPiece, movement, kingInCheck, false);
  }

  private Move(Piece piece, Piece capturedPiece, Movement movement) {
    this(piece, capturedPiece, movement, false, false);
  }

  public static Move movePiece(Chessboard chessboard, Movement movement)
      throws InvalidMoveException, InvalidSquareException {
    return movePiece(chessboard, movement, null);
  }

  public static Move movePiece(Chessboard chessboard, Movement movement, Move lastMove)
      throws InvalidMoveException, InvalidSquareException {

    try {
      Piece pieceToMove = chessboard.getPiece(movement.start);
      if (pieceToMove == null) {
        throw new InvalidMoveException(GameState.EMPTY_SQUARE);
      }
      Piece pieceToCapture = chessboard.getPiece(movement.end);

      if (lastMove == null) {
        if (pieceToMove.color.equals(Color.BLACK)) {
          throw new InvalidMoveException(GameState.WHITE_BEGINS);
        }
      } else if (pieceToMove.hasSameColor(lastMove.piece)) {
        throw new InvalidMoveException(GameState.MOVE_ALTERNATELY);
      }

      boolean isAValidMove = pieceToMove.isAValidMove(movement);

      // Pawn catches diagonal
      if (pieceToMove.getClass() == WhitePawn.class || pieceToMove.getClass() == BlackPawn.class) {
        if (pieceToCapture != null) {
          if (Math.abs(movement.x) == 1 && Math.abs(movement.y) == 1) {
            isAValidMove = true;
          } else {
            throw new InvalidMoveException(GameState.CATCH_DIAGONAL);
          }
        }
      }

      if (pieceToMove.getClass() == King.class) {
        if (kingMovesInCheck(chessboard, movement)) {
          throw new InvalidMoveException(GameState.KING_MOVES_IN_CHECK);
        }
      } else if (lastMove != null) {
        if (lastMove.kingInCheck) {
          Movement lastMovement = lastMove.movement;
          Square squareOfKing = chessboard.getSquareOfKing(lastMove.piece.getEnemyColor());
          Movement movementToKing = new Movement(lastMovement.end, squareOfKing);
          ArrayList<Square> wayToKing = movementToKing.getWay();
          if (!wayToKing.contains(movement.end)) {
            throw new InvalidMoveException(GameState.KING_IN_CHECK);
          }
        }
      }

      if (isAValidMove) {
        try {
          if (pieceToMove.hasSameColor(pieceToCapture)) {
            throw new InvalidMoveException(GameState.FRIENDED_COLOR);
          } else {
            Piece capturedPiece = chessboard.movePiece(movement);
            boolean kingInCheck = isKingInCheck(chessboard, pieceToMove, movement.end);
            boolean kingInCheckMate = isKingInCheckMate(chessboard, pieceToMove);
            return new Move(pieceToMove, capturedPiece, movement, kingInCheck, kingInCheckMate);
          }
        } catch (NullPointerException e) {
          Piece capturedPiece = chessboard.movePiece(movement);
          boolean kingInCheck = isKingInCheck(chessboard, pieceToMove, movement.end);
          boolean kingInCheckMate = isKingInCheckMate(chessboard, pieceToMove);
          return new Move(pieceToMove, capturedPiece, movement, kingInCheck, kingInCheckMate);
        }
      } else {
        throw new InvalidMoveException(GameState.INVALID_MOVE);
      }
    } catch (

    NullPointerException e) {
      throw new InvalidMoveException(GameState.INVALID_MOVE);
    }
  }

  // public static boolean enPassent(Move lastMove, Movement movement) {
  // if (lastMove.movement.getWay() != null) {
  // Square enPassent = lastMove.movement.getWay().get(0);
  // if (enPassent == movement.end) {
  // return true;
  // }
  // }
  // return false;
  // }

  public static boolean isKingInCheck(Chessboard chessboard, Piece piece, Square square) {
    Color enemyColor = piece.getEnemyColor();
    Square squareOfKing = chessboard.getSquareOfKing(enemyColor);
    if (squareOfKing == null) {
      return false;
    }
    return piece.isAValidMove(square, squareOfKing);
  }

  public static boolean kingMovesInCheck(Chessboard chessboard, Movement movement) {
    try {
      Color enemyColor = chessboard.getPiece(movement.start).getEnemyColor();
      Color colorOfKing = chessboard.getPiece(movement.start).color;
      Set<Square> squares = chessboard.getSquares();
      for (Square square : squares) {
        Piece piece = chessboard.getPiece(square);
        if (piece != null) {
          if (piece.color.equals(enemyColor)) {
            Movement movementToKing = new Movement(square, movement.end);
            if (piece.isAValidMove(movementToKing)
                && chessboard.isWayEmpty(movementToKing, chessboard.getSquareOfKing(colorOfKing))
                && chessboard.isAValidSquare(square)) {
              return true;
            }
          }
        }
      }
      return false;
    } catch (InvalidSquareException e) {
      return true;
    }
  }

  public static boolean isKingInCheckMate(Chessboard chessboard, Piece piece) {
    Color enemyColor = piece.getEnemyColor();
    Square squareOfKing = chessboard.getSquareOfKing(enemyColor);
    if (squareOfKing == null) {
      return false;
    }
    for (Square square : getSurroundingSquares(squareOfKing)) {
      boolean kingMovesInCheck = kingMovesInCheck(chessboard, new Movement(squareOfKing, square));
      boolean squareEmpty;
      try {
        Piece pieceOnGoal = chessboard.getPiece(square);
        squareEmpty = pieceOnGoal == null;
        if (!kingMovesInCheck && squareEmpty) {
          return false;

        } else if (!kingMovesInCheck && !squareEmpty) {
          boolean squareOccupiedByEnemyPiece = pieceOnGoal.getEnemyColor().equals(enemyColor);
          if (squareOccupiedByEnemyPiece) {
            return false;
          }
        }
      } catch (InvalidSquareException e) {
      }
    }
    return true;
  }

  public static ArrayList<Square> getSurroundingSquares(Square square) {
    ArrayList<Square> surroundingSquares = new ArrayList<Square>();
    surroundingSquares.add(new Square(square.x, square.y + 1));
    surroundingSquares.add(new Square(square.x + 1, square.y + 1));
    surroundingSquares.add(new Square(square.x + 1, square.y));
    surroundingSquares.add(new Square(square.x + 1, square.y - 1));
    surroundingSquares.add(new Square(square.x, square.y - 1));
    surroundingSquares.add(new Square(square.x - 1, square.y - 1));
    surroundingSquares.add(new Square(square.x - 1, square.y));
    surroundingSquares.add(new Square(square.x - 1, square.y + 1));
    return surroundingSquares;
  }
}