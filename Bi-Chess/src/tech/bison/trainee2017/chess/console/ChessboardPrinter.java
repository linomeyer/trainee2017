package tech.bison.trainee2017.chess.console;

import tech.bison.trainee2017.chess.Chessboard;
import tech.bison.trainee2017.chess.Square;
import tech.bison.trainee2017.chess.UTF8;
import tech.bison.trainee2017.chess.pieces.Piece;

public class ChessboardPrinter {

  private Chessboard chessboard;

  public ChessboardPrinter(Chessboard chessboard) {
    this.chessboard = chessboard;
  }

  public Piece[][] constituteAsArray() {
    int width = this.chessboard.width;
    int length = this.chessboard.length;

    Piece[][] chessboard = new Piece[width][length];

    for (int x = 0; x < width; x++) {
      for (int y = 0; y < length; y++) {
        chessboard[x][y] = this.chessboard.getPiece(new Square(x + 1, y + 1));
      }
    }
    return chessboard;
  }

  public String print() {
    Piece[][] chessboardArray = constituteAsArray();
    String printedChessboard = "";

    printedChessboard += "\n";
    for (int y = chessboardArray[0].length - 1; y >= 0; y--) {
      printedChessboard += y + 1 + UTF8.FOUR_PER_EM_SPACE + "|";//$NON-NLS-1$
      for (int x = 0; x < chessboardArray.length; x++) {
        Piece piece = chessboardArray[x][y];
        try {
          printedChessboard += piece.getSymbol() + UTF8.THREE_PER_EM_SPACE + "|";
        } catch (NullPointerException e) {
          printedChessboard += UTF8.FOUR_PER_EM_SPACE + UTF8.FOUR_PER_EM_SPACE + "|"; //$NON-NLS-1$
        }
      }
      printedChessboard += "\n";
    }
    printedChessboard += UTF8.FOUR_PER_EM_SPACE + UTF8.FOUR_PER_EM_SPACE + UTF8.FOUR_PER_EM_SPACE; // $NON-NLS-1$
    char width = 'A';
    for (int i = 0; i < chessboardArray.length; i++) {
      printedChessboard += width++ + UTF8.FOUR_PER_EM_SPACE + UTF8.FOUR_PER_EM_SPACE; // $NON-NLS-1$
    }
    printedChessboard += "\n"; //$NON-NLS-1$
    return printedChessboard;

  }
}
