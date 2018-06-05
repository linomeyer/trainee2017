package tech.bison.trainee2017.chess.pieces;

import static org.hamcrest.CoreMatchers.is;
import static org.junit.Assert.assertThat;

import org.junit.Test;

import tech.bison.trainee2017.chess.Movement;

public class PieceTest {
  @Test
  public void piece_moveOneUp_isAMove() throws Exception {
    Piece piece = new TestFigure();

    boolean isAMove = piece.isAMove(1, 0);

    assertThat(isAMove, is(true));
  }

  @Test
  public void piece_moveOneRight_isAMove() throws Exception {
    Piece piece = new TestFigure();

    boolean isAMove = piece.isAMove(0, 1);

    assertThat(isAMove, is(true));
  }

  @Test
  public void piece_dontMove_isNotAMove() throws Exception {
    Piece piece = new TestFigure();

    boolean isAMove = piece.isAMove(0, 0);

    assertThat(isAMove, is(false));
  }

  @Test
  public void piece_moveOutOfField_invalidMove() throws Exception {
    Piece piece = new TestFigure();

    boolean isAValidMove = piece.isAValidMove("h8", "h9");

    assertThat(isAValidMove, is(false));
  }

  class TestFigure extends Piece {

    @Override
    public boolean isAValidMove(Movement movement) {
      return false;
    }

    @Override
    public char getSymbol() {
      return '0';
    }
  }

}
