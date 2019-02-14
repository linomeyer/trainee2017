package trainee.chess;

import trainee.chess.piece.Bishop;
import trainee.chess.piece.King;
import trainee.chess.piece.Knight;
import trainee.chess.piece.Pawn;
import trainee.chess.piece.Piece;
import trainee.chess.piece.Piece.Color;
import trainee.chess.piece.Queen;
import trainee.chess.piece.Rook;

public class BoardSetUp {

  /**
   * Standard 8x8 Chessboard with Pieces
   */
  public static Piece[][] chess() {
    Piece[][] board = new Piece[8][8];
    for (int i = 0; i < 8; i++) {
      board[1][i] = new Pawn(Color.BLACK);
      board[6][i] = new Pawn(Color.WHITE);
    }
    setUpFirstRow(board, Color.BLACK);
    setUpFirstRow(board, Color.WHITE);
    return board;
  }

  private static void setUpFirstRow(Piece[][] board, Color color) {
    int columnIndex = color == Color.BLACK ? 0 : 7;
    board[columnIndex][0] = new Rook(color);
    board[columnIndex][1] = new Knight(color);
    board[columnIndex][2] = new Bishop(color);
    board[columnIndex][3] = new Queen(color);
    board[columnIndex][4] = new King(color);
    board[columnIndex][5] = new Bishop(color);
    board[columnIndex][6] = new Knight(color);
    board[columnIndex][7] = new Rook(color);
  }

}
