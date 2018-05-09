package tech.bison.trainee2017.chess;

public class Move {

  public static Move movePiece(Chessboard chessboard, Movement movement, Move lastMove) {
    Square start = movement.start;

    Piece pieceToMove = chessboard.get(start);

    boolean isAValidMove = pieceToMove.isAValidMove(movement);

    if (isAValidMove) {
      chessboard.movePiece(movement);
    }
    return new Move();
  }

}