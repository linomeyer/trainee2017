package trainee.chess.movement;

import trainee.chess.Board;
import trainee.chess.piece.Pawn;
import trainee.chess.piece.Piece;
import trainee.chess.piece.Piece.Color;

public class Move {
  public enum MoveState {
    OK, EMPTY_START_SQUARE, PIECE_CAPTURED, FRIENDLY_PIECE_NOT_CAPTURABLE, PIECE_IN_WAY, INVALID_MOVE_OF_PIECE
  }

  public static MoveState movePiece(Board board, Movement movement) {
    if (board.getPiece(movement.getStartSquare()) != null) {
      Piece piece = board.getPiece(movement.getStartSquare());
      if (piece.isAValidMove(movement)) {
        if (!board.isPieceInWay(movement)) {
          if (board.getPiece(movement.getEndSquare()) != null) {
            return capturePiece(board, movement, piece);
          }
          changeSquareOfPiece(board, movement, piece);
          return MoveState.OK;
        } else {
          return MoveState.PIECE_IN_WAY;
        }
      } else {
        if (piece.equals(new Pawn(Color.BLACK)) || piece.equals(new Pawn(Color.WHITE))) {
          return capturePieceAsPawn(board, movement, piece);
        }
        return MoveState.INVALID_MOVE_OF_PIECE;
      }
    } else {
      return MoveState.EMPTY_START_SQUARE;
    }
  }

  private static MoveState capturePiece(Board board, Movement movement, Piece piece) {
    if (board.getPiece(movement.getEndSquare()).getColor() != piece.getColor()) {
      board.removePiece(movement.getEndSquare());
      changeSquareOfPiece(board, movement, piece);
      return MoveState.PIECE_CAPTURED;
    } else {
      return MoveState.FRIENDLY_PIECE_NOT_CAPTURABLE;
    }
  }

  private static MoveState capturePieceAsPawn(Board board, Movement movement, Piece piece) {
    if (piece.getColor().equals(Color.WHITE)) {
      if (movement.getYMovement() == 1 && Math.abs(movement.getXMovement()) == 1) {
        return capturePiece(board, movement, piece);
      }
    } else {
      if (movement.getYMovement() == -1 && Math.abs(movement.getXMovement()) == 1) {
        return capturePiece(board, movement, piece);
      }
    }
    return MoveState.INVALID_MOVE_OF_PIECE;
  }

  private static void changeSquareOfPiece(Board board, Movement movement, Piece piece) {
    board.removePiece(movement.getStartSquare());
    board.addPiece(movement.getEndSquare(), piece);
  }
}
