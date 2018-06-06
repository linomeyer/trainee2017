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

  private Move(Piece piece, Piece capturedPiece, Movement movement, boolean kingInCheck) {
    this.piece = piece;
    this.capturedPiece = capturedPiece;
    this.movement = movement;
    this.kingInCheck = kingInCheck;
  }

  private Move(Piece piece, Piece capturedPiece, Movement movement) {
    this(piece, capturedPiece, movement, false);
  }

  public static Move movePiece(Chessboard chessboard, Movement movement)
      throws InvalidMoveException, InvalidSquareException {
    return movePiece(chessboard, movement, null);
  }

  @SuppressWarnings("finally")
  public static Move movePiece(Chessboard chessboard, Movement movement, Move lastMove)
      throws InvalidMoveException, InvalidSquareException {

    try {
      Piece pieceToMove = chessboard.getPiece(movement.start);
      if (pieceToMove == null) {
        throw new InvalidMoveException(GameState.EMPTY_SQUARE);
      }
      Piece pieceToCatch = chessboard.getPiece(movement.end);

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
        if (pieceToCatch != null) {
          if (Math.abs(movement.x) == 1 && Math.abs(movement.y) == 1) {
            isAValidMove = true;
          } else {
            throw new InvalidMoveException(GameState.CATCH_DIAGONAL);
          }
        }
      }

      if (pieceToMove.getClass() == King.class) {
        if (kingMovesInCheck(chessboard, movement)) {
          throw new InvalidMoveException(GameState.KING_IN_CHECK);
        }
      }

      if (lastMove != null) {
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
          if (pieceToMove.hasSameColor(pieceToCatch)) {
            throw new InvalidMoveException(GameState.FRIENDED_COLOR);
          }
        } catch (NullPointerException e) {
        } finally {
          Piece capturedPiece = chessboard.movePiece(movement);
          boolean kingInCheck = isKingInCheck(chessboard, pieceToMove, movement.end);
          return new Move(pieceToMove, capturedPiece, movement, kingInCheck);
        }
      } else {
        throw new InvalidMoveException(GameState.INVALID_MOVE);
      }
    } catch (NullPointerException e) {
      throw new InvalidMoveException(GameState.INVALID_MOVE);
    }
  }

  public static boolean isKingInCheck(Chessboard chessboard, Piece piece, Square square) {
    Color enemyColor = piece.getEnemyColor();
    Square squareOfKing = chessboard.getSquareOfKing(enemyColor);
    if (squareOfKing == null) {
      return false;
    }
    return piece.isAValidMove(square, squareOfKing);
  }

  public static boolean kingMovesInCheck(Chessboard chessboard, Movement movement) {
    Color enemyColor = chessboard.getPiece(movement.start).getEnemyColor();
    Set<Square> squares = chessboard.getSquares();
    for (Square square : squares) {
      Piece piece = chessboard.getPiece(square);
      if (piece != null) {
        if (piece.color.equals(enemyColor)) {
          if (piece.isAValidMove(new Movement(square, movement.end))) {
            return true;
          }
        }
      }
    }
    return false;
  }

}