package tech.bison.trainee2017.chess;

import static org.hamcrest.CoreMatchers.is;
import static org.junit.Assert.assertThat;

import org.junit.Test;

public class RunnerTest {
  @Test
  public void runner_movementIsDiagonal_validMove() throws Exception {
    Runner runner = new Runner();

    boolean validMove = runner.move("c2", "e4");

    assertThat(validMove, is(true));
  }

  @Test
  public void runner_verticalMovement_invalidMove() throws Exception {
    Runner runner = new Runner();

    boolean validMove = runner.move("b2", "d2");

    assertThat(validMove, is(false));
  }

  @Test
  public void runner_horizontalMovement_invalidMove() throws Exception {
    Runner runner = new Runner();

    boolean validMove = runner.move("c2", "c5");

    assertThat(validMove, is(false));
  }

  @Test
  public void runner_startAndEndPositionAreSimilar_invalidMove() throws Exception {
    Runner runner = new Runner();

    boolean validMove = runner.move("c2", "c2");

    assertThat(validMove, is(false));
  }

  @Test
  public void runner_startAndEndPositionOutOfField_invalidMove() throws Exception {
    Runner runner = new Runner();

    boolean validMove = runner.move("h8", "i9");

    assertThat(validMove, is(false));
  }

}
