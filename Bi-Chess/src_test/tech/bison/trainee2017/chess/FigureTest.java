package tech.bison.trainee2017.chess;

import static org.hamcrest.CoreMatchers.is;
import static org.junit.Assert.assertThat;

import org.junit.Test;

public class FigureTest {
  @Test
  public void figure_moveOneUp_isAMove() throws Exception {
    Figure figure = new TestFigure();

    boolean isAMove = figure.isAMove(1, 0);

    assertThat(isAMove, is(true));
  }

  @Test
  public void figure_moveOneRight_isAMove() throws Exception {
    Figure figure = new TestFigure();

    boolean isAMove = figure.isAMove(0, 1);

    assertThat(isAMove, is(true));
  }

  @Test
  public void figure_moveNothing_isAMove() throws Exception {
    Figure figure = new TestFigure();

    boolean isAMove = figure.isAMove(0, 0);

    assertThat(isAMove, is(false));
  }

  class TestFigure extends Figure {

    @Override
    protected boolean isAValidMove(Movement movement) {
      return false;
    }
  }

  @Test
  public void testIsAValidMoveStringString() throws Exception {
    throw new RuntimeException("not yet implemented");
  }
}
