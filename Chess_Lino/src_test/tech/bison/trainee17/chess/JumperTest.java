package tech.bison.trainee17.chess;

import static org.hamcrest.CoreMatchers.is;
import static org.junit.Assert.assertThat;

import org.junit.Test;

import tech.bison.trainee17.chess.Figure.color;

public class JumperTest {
  @Test
  public void blackJumperWithStartPosition_moveToEndPosition_validMoveDifferentStartPosition() throws Exception {
    Jumper blackJumper = new Jumper(color.black, 1);

    boolean validMove = blackJumper.move("6c");

    assertThat(validMove, is(true));
    assertThat(blackJumper.startPosition.getStringPosition(), is("6c"));
  }

  @Test
  public void whiteJumper_invalidMovement_invalidMoveSameStartPosition() throws Exception {
    Jumper whiteJumper = new Jumper(color.white, 2);

    boolean validMove = whiteJumper.move("3e");

    assertThat(validMove, is(false));
    assertThat(whiteJumper.startPosition.getStringPosition(), is("1g"));
  }

  @Test
  public void blackJumper_sameStartAndEndPosition_invalidMoveSameStartPosition() throws Exception {
    Jumper blackJumper = new Jumper(color.black, 2);

    boolean validMove = blackJumper.move("8g");

    assertThat(validMove, is(false));
    assertThat(blackJumper.startPosition.getStringPosition(), is("8g"));
  }
}
