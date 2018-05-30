package tech.bison.trainee2017.chess;

import static org.hamcrest.CoreMatchers.is;
import static org.hamcrest.CoreMatchers.nullValue;
import static org.junit.Assert.assertArrayEquals;
import static org.junit.Assert.assertThat;

import org.junit.Rule;
import org.junit.Test;
import org.junit.rules.ExpectedException;

import tech.bison.trainee2017.chess.Piece.Color;

public class ChessboardTest {

  @Rule
  public ExpectedException thrown = ExpectedException.none();

  @Test
  public void chessboard_getPieceWithSquare_piece() throws Exception {
    Chessboard chessboard = new Chessboard();

    Piece pieceOnSquare = chessboard.getPiece(new Square("A1"));

    assertThat(pieceOnSquare, is(new Rook(Color.WHITE)));
  }

  @Test
  public void chessboard_movePiece_pieceIsOnNewSquare() throws Exception {
    Chessboard chessboard = new Chessboard();

    Movement movement = new Movement(new Square("A2"), new Square("A4"));

    Piece capturedPiece = chessboard.movePiece(movement);

    assertThat(chessboard.getPiece(movement.start), is(nullValue()));
    assertThat(capturedPiece, is(nullValue()));
    assertThat(chessboard.getPiece(movement.end), is(new WhitePawn()));
  }

  @Test
  public void chessboardWith6x5Squares_movePiece_invalidSquareException() throws Exception {
    thrown.expect(InvalidSquareException.class);

    Chessboard chessboard = new Chessboard(6, 5);
    chessboard.addPiece(new Square("A2"), new Queen(Color.WHITE));
    chessboard.movePiece(new Movement(new Square("A2"), new Square("H2")));
  }

  @Test
  public void chessboardWith4x4Squares_addPiece_invalidSquareException() throws Exception {
    thrown.expect(InvalidSquareException.class);

    Chessboard chessboard = new Chessboard(4, 4);
    chessboard.addPiece(new Square("A5"), new Queen(Color.WHITE));
  }

  @Test
  public void chessboardWith8x8Squares_addPiece_OccupiedSquareException() throws Exception {
    thrown.expect(OccupiedSquareException.class);

    Chessboard chessboard = new Chessboard(8, 8);
    chessboard.addPiece(new Square("A2"), new Queen(Color.WHITE));
    chessboard.addPiece(new Square("A2"), new King(Color.WHITE));
  }

  @Test
  public void chessboard_isAValidSquare_invalidSquare() throws Exception {
    Chessboard chessboard = new Chessboard(2, 2);

    assertThat(chessboard.isAValidSquare(new Square("c5")), is(false));
  }

  @Test
  public void chessboard_isAValidSquare_validSquare() throws Exception {
    Chessboard chessboard = new Chessboard(4, 4);

    assertThat(chessboard.isAValidSquare(new Square("d3")), is(true));
  }

  @Test
  public void customChessboard_addPieces_constituteAsArray() throws Exception {
    Chessboard chessboard = new Chessboard(2, 2);

    chessboard.addPiece(new Square("A1"), new BlackPawn());
    chessboard.addPiece(new Square("B2"), new Bishop(Color.WHITE));

    assertArrayEquals(chessboard.constituteAsArray(), new Piece[][] {
        { new BlackPawn(), null },
        { null, new Bishop(Color.WHITE) }
    });
  }

  @Test
  public void chesboard_printChessboard_stringWithPrintedChessboard() throws Exception {
    Chessboard chessboard = new Chessboard();

    String printedChessboard = chessboard.printChessboard();

    assertThat(printedChessboard, is("\n" +
        "8 |♜ |♞ |♝ |♛ |♚ |♝ |♞ |♜ |\n" +
        "7 |♟ |♟ |♟ |♟ |♟ |♟ |♟ |♟ |\n" +
        "6 |  |  |  |  |  |  |  |  |\n" +
        "5 |  |  |  |  |  |  |  |  |\n" +
        "4 |  |  |  |  |  |  |  |  |\n" +
        "3 |  |  |  |  |  |  |  |  |\n" +
        "2 |♙ |♙ |♙ |♙ |♙ |♙ |♙ |♙ |\n" +
        "1 |♖ |♘ |♗ |♕ |♔ |♗ |♘ |♖ |\n" +
        "   A  B  C  D  E  F  G  H  \n\n"));
  }

  @Test
  public void chessboard_movePiece_printChessboard() throws Exception {
    Game game = new Game();
    game.movePiece(new Movement(new Square("A2"), new Square("A4")));
    String printedChessboard = game.getChessboard().printChessboard();

    assertThat(printedChessboard, is("\n" +
        "8 |♜ |♞ |♝ |♛ |♚ |♝ |♞ |♜ |\n" +
        "7 |♟ |♟ |♟ |♟ |♟ |♟ |♟ |♟ |\n" +
        "6 |  |  |  |  |  |  |  |  |\n" +
        "5 |  |  |  |  |  |  |  |  |\n" +
        "4 |♙ |  |  |  |  |  |  |  |\n" +
        "3 |  |  |  |  |  |  |  |  |\n" +
        "2 |  |♙ |♙ |♙ |♙ |♙ |♙ |♙ |\n" +
        "1 |♖ |♘ |♗ |♕ |♔ |♗ |♘ |♖ |\n" +
        "   A  B  C  D  E  F  G  H  \n\n"));
  }

  @Test
  public void chessboard_removePiece_squareWasEmptyNoPieceRemoved() throws Exception {
    Chessboard chessboard = new Chessboard();

    Piece removedPiece = chessboard.removePiece(new Square("A2"));

    assertThat(removedPiece, is(new WhitePawn()));
    assertThat(chessboard.getPiece(new Square("A2")), is(nullValue()));
  }

  @Test
  public void chessboard_removePiece_pieceCouldNotBeRemoved() throws Exception {
    Chessboard chessboard = new Chessboard();

    Piece removedPiece = chessboard.removePiece(new Square("F4"));

    assertThat(removedPiece, is(nullValue()));
  }
}
