package tech.bison.trainee2017.chess;

public class Move {
  final Piece piece;
  final Movement movement;

  private Move(Piece piece, Movement movement) {
    this.piece = piece;
    this.movement = movement;
  }

  public static Move movePiece(Chessboard chessboard, Movement movement, Move lastMove) throws InvalidMoveException {
    Square start = movement.start;

    Piece pieceToMove = chessboard.get(start);

    boolean isAValidMove = pieceToMove.isAValidMove(movement);

    if (isAValidMove) {
      try {
        if (pieceToMove.color == chessboard.get(movement.end).color) {
          throw new InvalidMoveException();
        } else {
          chessboard.movePiece(movement);
          return new Move(pieceToMove, movement);
        }
      } catch (NullPointerException e) {
        chessboard.movePiece(movement);
        return new Move(pieceToMove, movement);
      }
    } else {
      throw new InvalidMoveException();
    }
  }

}