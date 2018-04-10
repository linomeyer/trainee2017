package tech.bison.trainee17.chess;

import static org.hamcrest.CoreMatchers.is;
import static org.junit.Assert.assertThat;

import org.junit.Test;

public class QueenTest extends Figure {
  @Test
  public void blackQueenWithStartPosition_moveToEndPosition_validMoveDifferentStartPosition() throws Exception {
    Queen blackQueen = new Queen(color.black);

    boolean validMove = blackQueen.move("5a");

    assertThat(validMove, is(true));
    assertThat(blackQueen.startPosition.getStringPosition(), is("5a"));
  }

  @Test
  public void whiteQueen_invalidStringInput_invalidMoveSameStartPosition() throws Exception {
    Queen whiteQueen = new Queen(color.white);

    boolean validMove = whiteQueen.move("$");

    assertThat(validMove, is(false));
    assertThat(whiteQueen.startPosition.getStringPosition(), is("1d"));
  }

  @Test
  public void blackQueen_moveIsWhetherDiagonalVerticalOrHorizontal_invalidMoveSameStartPosition() throws Exception {
    Queen blackQueen = new Queen(color.black);

    boolean validMove = blackQueen.move("8d");

    assertThat(validMove, is(false));
    assertThat(blackQueen.startPosition.getStringPosition(), is("8d"));
  }

  @Test
  public void whiteQueen_moveIsOutOfField__invalidMoveSameStartPosition() throws InvalidMovementException {
    Queen whiteQueen = new Queen(color.white);

    boolean validMove = whiteQueen.move("1i");

    assertThat(validMove, is(false));
    assertThat(whiteQueen.startPosition.getStringPosition(), is("1d"));
  }
}
