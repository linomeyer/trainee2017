package tech.bison.trainee17.chess;

import static org.hamcrest.CoreMatchers.is;
import static org.junit.Assert.assertThat;

import org.junit.Test;

import tech.bison.trainee17.chess.Figure.color;

public class RunnerTest {
  @Test
  public void blackRunnerWithStartPosition_moveToEndPosition_validMoveDifferentStartPosition() throws Exception {
    Runner blackRunner = new Runner(color.black, 1);

    boolean validMove = blackRunner.move("6e");

    assertThat(validMove, is(true));
    assertThat(blackRunner.startPosition.getStringPosition(), is("6e"));
  }

  @Test
  public void whiteRunner_movehorizontalOrVertival_invalidMoveSameStartPosition() throws Exception {
    Runner whiteRunner = new Runner(color.white, 2);

    boolean validMove = whiteRunner.move("2f");

    assertThat(validMove, is(false));
    assertThat(whiteRunner.startPosition.getStringPosition(), is("1f"));
  }

  @Test
  public void whiteRunner_movementIsntHorizontalverticalOrDiagonal_invalidMoveSameStartPosition() throws Exception {
    Runner whiteRunner = new Runner(color.white, 2);

    boolean validMove = whiteRunner.move("2h");

    assertThat(validMove, is(false));
    assertThat(whiteRunner.startPosition.getStringPosition(), is("1f"));
  }

  @Test
  public void blackRunner_sameStartAndEndPosition_invalidMoveSameStartPosition() throws Exception {
    Runner blackRunner = new Runner(color.black, 2);

    boolean validMove = blackRunner.move("8f");

    assertThat(validMove, is(false));
    assertThat(blackRunner.startPosition.getStringPosition(), is("8f"));
  }

}
