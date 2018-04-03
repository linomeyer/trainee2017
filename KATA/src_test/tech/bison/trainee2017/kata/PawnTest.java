package tech.bison.trainee2017.kata;

import static org.hamcrest.CoreMatchers.is;
import static org.junit.Assert.assertThat;

import org.junit.Test;

public class PawnTest {
  @Test
  public void Pawn_movementFromStartPosition_validMove() throws Exception {
    Pawn pawn = new Pawn();

    boolean validMove = pawn.move("2b", "4b");

    assertThat(validMove, is(true));
  }

  @Test
  public void Pawn_horizontalMovement_validMove() throws Exception {
    Pawn pawn = new Pawn();

    boolean validMove = pawn.move("3b", "4b");

    assertThat(validMove, is(true));
  }

  @Test
  public void Pawn_verticalMovement_invalidMove() throws Exception {
    Pawn pawn = new Pawn();

    boolean validMove = pawn.move("5c", "5d");

    assertThat(validMove, is(false));
  }

  @Test
  public void Pawn_horizontalMovementMoreThanAllowed_invalidMove() throws Exception {
    Pawn pawn = new Pawn();

    boolean validMove = pawn.move("2c", "5c");

    assertThat(validMove, is(false));
  }

  @Test
  public void Pawn_diagonalMovement_invalidMove() throws Exception {
    Pawn pawn = new Pawn();

    boolean validMove = pawn.move("3d", "5b");

    assertThat(validMove, is(false));
  }
}
