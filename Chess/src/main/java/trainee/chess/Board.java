package trainee.chess;

import java.util.List;

import trainee.chess.movement.Movement;
import trainee.chess.piece.Piece;

public class Board {
  private Piece[][] board;
  public final int rowLength;
  public final int columnLength;

  public Board() {
    rowLength = 8;
    columnLength = 8;
    board = BoardSetUp.chess();
  }

  public Board(int rowLength, int columnLength) {
    this.rowLength = rowLength;
    this.columnLength = columnLength;
    board = new Piece[rowLength][columnLength];
  }

  public Piece[][] getBoard() {
    return board;
  }

  public void addPiece(Square square, Piece piece) {
    int[] arrayLocation = getArrayLocation(square);
    board[arrayLocation[0]][arrayLocation[1]] = piece;
  }

  public void removePiece(Square square) {
    int[] arrayLocation = getArrayLocation(square);
    board[arrayLocation[0]][arrayLocation[1]] = null;
  }

  public Piece getPiece(Square square) {
    int[] arrayLocation = getArrayLocation(square);
    return board[arrayLocation[0]][arrayLocation[1]];
  }

  public boolean isPieceInWay(Movement movement) {
    List<Square> way = movement.getWay();
    if (way != null) {
      for (Square square : way) {
        if (getPiece(square) != null) {
          return true;
        }
      }
    }
    return false;
  }

  private int[] getArrayLocation(Square square) {
    int column = Math.abs(square.getCoordinates().getY() - 7);
    int row = square.getCoordinates().getX();
    return new int[] { column, row };
  }

}
