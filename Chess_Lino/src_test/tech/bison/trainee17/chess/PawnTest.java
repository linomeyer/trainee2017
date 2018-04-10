package tech.bison.trainee17.chess;

import static org.hamcrest.CoreMatchers.is;
import static org.junit.Assert.assertThat;

import org.junit.Test;

import tech.bison.trainee17.chess.Figure.color;

public class PawnTest {
  @Test
  public void whitePawn_horizontalMove_validMoveChangedStartPosition() throws Exception {
    Pawn whitePawn = new Pawn(color.white, 7);

    boolean validMove = whitePawn.move("3g");

    assertThat(validMove, is(true));
    assertThat(whitePawn.startPosition.getStringPosition(), is("3g"));
  }

  @Test
  public void blackPawn_specialMoveFromStartPosition_validMoveChangedStartPosition() throws Exception {
    Pawn blackPawn = new Pawn(color.black, 2);

    boolean validMove = blackPawn.move("5b");

    assertThat(validMove, is(true));
    assertThat(blackPawn.startPosition.getStringPosition(), is("5b"));
    assertThat(blackPawn.endPosition.getStringPosition(), is("5b"));
  }

  @Test
  public void whitePawn_vertivalMove_invalidMoveSameStartPosition() throws Exception {
    Pawn whitePawn = new Pawn(color.white, 4);

    boolean validMove = whitePawn.move("2e");

    assertThat(validMove, is(false));
    assertThat(whitePawn.startPosition.getStringPosition(), is("2d"));
  }

  @Test
  public void whitePawn_diagonalMove_invalidMoveSameStartPosition() throws Exception {
    Pawn whitePawn = new Pawn(color.white, 3);

    boolean validMove = whitePawn.move("3b");

    assertThat(validMove, is(false));
    assertThat(whitePawn.startPosition.getStringPosition(), is("2c"));
  }

  @Test
  public void blackPawn_specialMoveNotFromStartPosition_invalidMoveSameStartPosition() throws Exception {
    Pawn blackPawn = new Pawn(color.black, 6);

    boolean validMove = blackPawn.move("6f");

    assertThat(blackPawn.startPosition.getStringPosition(), is("6f"));
    assertThat(validMove, is(true));

    validMove = blackPawn.move("4f");

    assertThat(validMove, is(false));
    assertThat(blackPawn.startPosition.getStringPosition(), is("6f"));
  }
}
