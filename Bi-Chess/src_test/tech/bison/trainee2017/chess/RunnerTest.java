package tech.bison.trainee2017.chess;

import static org.hamcrest.CoreMatchers.is;
import static org.junit.Assert.assertThat;

import org.junit.Test;

public class RunnerTest {
  @Test
  public void Runner_isAllowedToMoveOneUp_invalidMove() throws Exception {
    Runner Runner = new Runner();

    boolean validMove = Runner.isAValidMove("c2", "c3");

    assertThat(validMove, is(false));
  }

  @Test
  public void Runner_isAllowedToMoveOneDown_invalidMove() throws Exception {
    Runner Runner = new Runner();

    boolean validMove = Runner.isAValidMove("h3", "h2");

    assertThat(validMove, is(false));
  }

  @Test
  public void Runner_isAllowedToMoveOneRight_invalidMove() throws Exception {
    Runner Runner = new Runner();

    boolean validMove = Runner.isAValidMove("e5", "f5");

    assertThat(validMove, is(false));
  }

  @Test
  public void Runner_isAllowedToMoveOneLeft_invalidMove() throws Exception {
    Runner Runner = new Runner();

    boolean validMove = Runner.isAValidMove("e8", "d8");

    assertThat(validMove, is(false));
  }

  @Test
  public void Runner_isAllowedToMoveOneDiagonal_validMove() throws Exception {
    Runner Runner = new Runner();

    boolean validMove = Runner.isAValidMove("a2", "b3");

    assertThat(validMove, is(true));
  }

  @Test
  public void Runner_isAllowedToMoveSevenDiagonal_validMove() throws Exception {
    Runner Runner = new Runner();

    boolean validMove = Runner.isAValidMove("a8", "h1");

    assertThat(validMove, is(true));
  }

  @Test
  public void Runner_isAllowedToMoveSevenUp_invalidMove() throws Exception {
    Runner Runner = new Runner();

    boolean validMove = Runner.isAValidMove("a1", "a8");

    assertThat(validMove, is(false));
  }

  @Test
  public void Runner_isAllowedToMoveTwoLeft_invalidMove() throws Exception {
    Runner Runner = new Runner();

    boolean validMove = Runner.isAValidMove("h5", "a5");

    assertThat(validMove, is(false));
  }

  @Test
  public void Runner_isAllowedToMoveWetherHorizontalVerticalOrDiagonal_invalidMove() throws Exception {
    Runner Runner = new Runner();

    boolean validMove = Runner.isAValidMove("c2", "d4");

    assertThat(validMove, is(false));
  }
}
