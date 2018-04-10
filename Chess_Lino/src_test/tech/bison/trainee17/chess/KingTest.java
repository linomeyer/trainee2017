package tech.bison.trainee17.chess;

import static org.hamcrest.CoreMatchers.is;
import static org.junit.Assert.assertThat;

import org.junit.Test;

import tech.bison.trainee17.chess.Figure.color;

public class KingTest {
  @Test
  public void whiteKing_moveToEndPostion_validMoveDifferentStartPosition() throws InvalidMovementException {
    King whiteKing = new King(color.white);

    boolean validMove = whiteKing.move("2e");

    assertThat(validMove, is(true));
    assertThat(whiteKing.startPosition.getStringPosition(), is("2e"));
  }

  @Test
  public void blackKing_moveIsOutOfRange_invalidMoveSameStartPosition() throws InvalidMovementException {
    King blackKing = new King(color.black);

    boolean validMove = blackKing.move("6d");

    assertThat(validMove, is(false));
    assertThat(blackKing.startPosition.getStringPosition(), is("8e"));
  }

  @Test
  public void whiteKing_moveIsOutOfField_invalidMoveSameStartPosition() throws InvalidMovementException {
    King whiteKing = new King(color.white);

    boolean validMove = whiteKing.move("0e");

    assertThat(validMove, is(false));
    assertThat(whiteKing.startPosition.getStringPosition(), is("1e"));
  }
}
