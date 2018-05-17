package tech.bison.trainee2017.chess;

public class Move {
  final Piece piece;
  final Piece capturedPiece;
  final Movement movement;

  private Move(Piece piece, Piece capturedPiece, Movement movement) {
    this.piece = piece;
    this.capturedPiece = capturedPiece;
    this.movement = movement;
  }

  public static Move movePiece(Chessboard chessboard, Movement movement) throws InvalidMoveException {
    return movePiece(chessboard, movement, null);
  }

  public static Move movePiece(Chessboard chessboard, Movement movement, Move lastMove) throws InvalidMoveException {
    Square start = movement.start;

    Piece pieceToMove = chessboard.getPiece(start);

    boolean isAValidMove = pieceToMove.isAValidMove(movement);

    if (isAValidMove) {
      try {
        if (pieceToMove.color == chessboard.getPiece(movement.end).color) {
          throw new InvalidMoveException();
        } else {
          Piece capturedPiece = chessboard.movePiece(movement);
          return new Move(pieceToMove, capturedPiece, movement);
        }
      } catch (NullPointerException e) {
        Piece capturedPiece = chessboard.movePiece(movement);
        return new Move(pieceToMove, capturedPiece, movement);
      }
    } else {
      throw new InvalidMoveException();
    }
  }

}