package tech.bison.trainee2017.chess;

import static org.hamcrest.CoreMatchers.is;
import static org.junit.Assert.assertThat;

import org.junit.Test;

public class RunnerTest {
  @Test
  public void runner_isAllowedToMoveDiagonalUpAndRight_validMove() throws Exception {
    Runner runner = new Runner();

    boolean validMove = runner.isAValidMove("d3", "h7");

    assertThat(validMove, is(true));
  }

  @Test
  public void runner_isAllowedToMoveDiagonalDownAndRight_validMove() throws Exception {
    Runner runner = new Runner();

    boolean validMove = runner.isAValidMove("a8", "h1");

    assertThat(validMove, is(true));
  }

  @Test
  public void runner_isAllowedToMoveDiagonalDownAndLeft_validMove() throws Exception {
    Runner runner = new Runner();

    boolean validMove = runner.isAValidMove("b4", "a3");

    assertThat(validMove, is(true));
  }

  @Test
  public void runner_isAllowedToMoveDiagonalUpAndLeft_validMove() throws Exception {
    Runner runner = new Runner();

    boolean validMove = runner.isAValidMove("g5", "e7");

    assertThat(validMove, is(true));
  }

  @Test
  public void runner_isAllowedToMoveOneUp_invalidMove() throws Exception {
    Runner runner = new Runner();

    boolean validMove = runner.isAValidMove("c2", "c3");

    assertThat(validMove, is(false));
  }

  @Test
  public void runner_isAllowedToMoveOneDown_invalidMove() throws Exception {
    Runner runner = new Runner();

    boolean validMove = runner.isAValidMove("h3", "h2");

    assertThat(validMove, is(false));
  }

  @Test
  public void runner_isAllowedToMoveOneRight_invalidMove() throws Exception {
    Runner runner = new Runner();

    boolean validMove = runner.isAValidMove("e5", "f5");

    assertThat(validMove, is(false));
  }

  @Test
  public void runner_isAllowedToMoveOneLeft_invalidMove() throws Exception {
    Runner runner = new Runner();

    boolean validMove = runner.isAValidMove("e8", "d8");

    assertThat(validMove, is(false));
  }

  @Test
  public void runner_isAllowedToMoveWetherHorizontalVerticalOrDiagonal_invalidMove() throws Exception {
    Runner runner = new Runner();

    boolean validMove = runner.isAValidMove("c2", "d4");

    assertThat(validMove, is(false));
  }
}
