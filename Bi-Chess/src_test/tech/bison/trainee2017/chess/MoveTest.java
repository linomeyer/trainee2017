package tech.bison.trainee2017.chess;

import static org.hamcrest.CoreMatchers.is;
import static org.junit.Assert.assertThat;

import org.junit.Test;

public class MoveTest {
  @Test
  public void piece_move_pieceIsOnANewSquare() throws Exception {
    Chessboard chessboard = new Chessboard();
    Move.movePiece(chessboard, new Movement(new Square("A2"), new Square("A4")), null);

    assertThat(chessboard.getPiece(new Square("A4")), is(new WhitePawn()));
  }
}
