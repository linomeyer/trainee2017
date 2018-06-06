package tech.bison.trainee2017.chess;

import tech.bison.trainee2017.chess.Game.GameState;
import tech.bison.trainee2017.chess.pieces.BlackPawn;
import tech.bison.trainee2017.chess.pieces.Piece;
import tech.bison.trainee2017.chess.pieces.Piece.Color;
import tech.bison.trainee2017.chess.pieces.WhitePawn;

public class Move {
  final Piece piece;
  final Piece capturedPiece;
  final Movement movement;

  private Move(Piece piece, Piece capturedPiece, Movement movement) {
    this.piece = piece;
    this.capturedPiece = capturedPiece;
    this.movement = movement;
  }

  public static Move movePiece(Chessboard chessboard, Movement movement)
      throws InvalidMoveException, InvalidSquareException {
    return movePiece(chessboard, movement, null);
  }

  public static Move movePiece(Chessboard chessboard, Movement movement, Move lastMove)
      throws InvalidMoveException, InvalidSquareException {

    try {
      Piece pieceToMove = chessboard.getPiece(movement.start);

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

      if (isAValidMove) {
        try {
          if (pieceToMove.hasSameColor(pieceToCatch)) {
            throw new InvalidMoveException(GameState.FRIENDED_COLOR);
          } else {
            Piece capturedPiece = chessboard.movePiece(movement);
            return new Move(pieceToMove, capturedPiece, movement);
          }
        } catch (NullPointerException e) {
          Piece capturedPiece = chessboard.movePiece(movement);
          return new Move(pieceToMove, capturedPiece, movement);
        }
      } else {
        throw new InvalidMoveException(GameState.INVALID_MOVE);
      }
    } catch (

    NullPointerException e) {
      throw new InvalidMoveException(GameState.EMPTY_SQUARE);
    }
  }

}