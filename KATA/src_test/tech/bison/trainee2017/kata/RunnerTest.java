package tech.bison.trainee2017.kata;

import static org.hamcrest.CoreMatchers.is;
import static org.junit.Assert.assertThat;

import org.junit.Test;

public class RunnerTest {
  @Test
  public void runner_movementIsDiagonal_validMove() throws Exception {
    Runner runner = new Runner();

    boolean validMove = runner.move("2c", "4e");

    assertThat(validMove, is(true));
  }

  @Test
  public void runner_verticalMovement_invalidMove() throws Exception {
    Runner runner = new Runner();

    boolean validMove = runner.move("2b", "2d");

    assertThat(validMove, is(false));
  }

  @Test
  public void runner_horizontalMovement_invalidMove() throws Exception {
    Runner runner = new Runner();

    boolean validMove = runner.move("2c", "5c");

    assertThat(validMove, is(false));
  }

  @Test
  public void runner_startAndEndPositionAreSimilar_invalidMove() throws Exception {
    Runner runner = new Runner();

    boolean validMove = runner.move("2c", "2c");

    assertThat(validMove, is(false));
  }

  @Test
  public void runner_startAndEndPositionOutOfField_invalidMove() throws Exception {
    Runner runner = new Runner();

    boolean validMove = runner.move("8h", "9i");

    assertThat(validMove, is(false));
  }

}
