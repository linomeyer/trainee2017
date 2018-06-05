package tech.bison.trainee2017.chess.console;

import static org.hamcrest.CoreMatchers.is;
import static org.junit.Assert.assertArrayEquals;
import static org.junit.Assert.assertThat;

import org.junit.Test;

import tech.bison.trainee2017.chess.Chessboard;
import tech.bison.trainee2017.chess.Game;
import tech.bison.trainee2017.chess.Movement;
import tech.bison.trainee2017.chess.Square;
import tech.bison.trainee2017.chess.pieces.Bishop;
import tech.bison.trainee2017.chess.pieces.BlackPawn;
import tech.bison.trainee2017.chess.pieces.Piece;
import tech.bison.trainee2017.chess.pieces.Piece.Color;

public class ChessboardPrinterTest {
  @Test
  public void customChessboard_addPieces_constituteAsArray() throws Exception {

    Chessboard chessboard = new Chessboard(2, 2);
    ChessboardPrinter chessboardPrinter = new ChessboardPrinter(chessboard);

    chessboard.addPiece(new Square("A1"), new BlackPawn());
    chessboard.addPiece(new Square("B2"), new Bishop(Color.WHITE));

    assertArrayEquals(chessboardPrinter.constituteAsArray(), new Piece[][] {
        { new BlackPawn(), null },
        { null, new Bishop(Color.WHITE) }
    });
  }

  @Test // refactoring
  public void chesboard_printChessboard_stringWithPrintedChessboard() throws Exception {
    Chessboard chessboard = new Chessboard();
    ChessboardPrinter chessboardPrinter = new ChessboardPrinter(chessboard);

    String printedChessboard = chessboardPrinter.print();

    assertThat(printedChessboard, is("\n" +
        "8 |♜ |♞ |♝ |♛ |♚ |♝ |♞ |♜ |\n" +
        "7 |♟ |♟ |♟ |♟ |♟ |♟ |♟ |♟ |\n" +
        "6 |  |  |  |  |  |  |  |  |\n" +
        "5 |  |  |  |  |  |  |  |  |\n" +
        "4 |  |  |  |  |  |  |  |  |\n" +
        "3 |  |  |  |  |  |  |  |  |\n" +
        "2 |♙ |♙ |♙ |♙ |♙ |♙ |♙ |♙ |\n" +
        "1 |♖ |♘ |♗ |♕ |♔ |♗ |♘ |♖ |\n" +
        "   A  B  C  D  E  F  G  H  \n"));
  }

  @Test // refactoring
  public void chessboard_movePiece_printChessboard() throws Exception {
    Game game = new Game();
    ChessboardPrinter chessboardPrinter = new ChessboardPrinter(game.getChessboard());
    game.movePiece(new Movement(new Square("A2"), new Square("A4")));
    String printedChessboard = chessboardPrinter.print();

    assertThat(printedChessboard, is("\n" +
        "8 |♜ |♞ |♝ |♛ |♚ |♝ |♞ |♜ |\n" +
        "7 |♟ |♟ |♟ |♟ |♟ |♟ |♟ |♟ |\n" +
        "6 |  |  |  |  |  |  |  |  |\n" +
        "5 |  |  |  |  |  |  |  |  |\n" +
        "4 |♙ |  |  |  |  |  |  |  |\n" +
        "3 |  |  |  |  |  |  |  |  |\n" +
        "2 |  |♙ |♙ |♙ |♙ |♙ |♙ |♙ |\n" +
        "1 |♖ |♘ |♗ |♕ |♔ |♗ |♘ |♖ |\n" +
        "   A  B  C  D  E  F  G  H  \n"));
  }

}
