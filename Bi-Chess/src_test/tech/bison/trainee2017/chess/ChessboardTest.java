package tech.bison.trainee2017.chess;

import static org.hamcrest.CoreMatchers.is;
import static org.hamcrest.CoreMatchers.nullValue;
import static org.junit.Assert.assertThat;

import org.junit.Test;

import tech.bison.trainee2017.chess.Piece.colors;

public class ChessboardTest {
  @Test
  public void chessboard_getPieceWithSquare_piece() throws Exception {
    Chessboard chessboard = new Chessboard();

    Piece gettedPiece = chessboard.get(new Square("A1"));

    assertThat(gettedPiece, is(new Rook(colors.WHITE)));
  }

  @Test
  public void chessboard_movePiece_pieceIsOnNewSquare() throws Exception {
    Chessboard chessboard = new Chessboard();

    Movement movement = new Movement(new Square("A2"), new Square("A4"));

    chessboard.movePiece(movement);

    assertThat(chessboard.get(movement.start), is(nullValue()));
    assertThat(chessboard.get(movement.end), is(new WhitePawn()));
  }

  @Test
  public void g() throws Exception {

  }
}
