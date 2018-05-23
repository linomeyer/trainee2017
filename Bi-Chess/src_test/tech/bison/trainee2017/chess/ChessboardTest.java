package tech.bison.trainee2017.chess;

import static org.hamcrest.CoreMatchers.is;
import static org.hamcrest.CoreMatchers.nullValue;
import static org.junit.Assert.assertThat;

import org.junit.Rule;
import org.junit.Test;
import org.junit.rules.ExpectedException;

import tech.bison.trainee2017.chess.Piece.colors;

public class ChessboardTest {

  @Rule
  public ExpectedException thrown = ExpectedException.none();

  @Test
  public void chessboard_getPieceWithSquare_piece() throws Exception {
    Chessboard chessboard = new Chessboard();

    Piece pieceOnSquare = chessboard.getPiece(new Square("A1"));

    assertThat(pieceOnSquare, is(new Rook(colors.WHITE)));
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
    chessboard.addPiece(new Square("A2"), new Queen(colors.WHITE));
    chessboard.movePiece(new Movement(new Square("A2"), new Square("H2")));
  }
}
