package tech.bison.trainee2017.chess;

import static org.hamcrest.CoreMatchers.is;
import static org.junit.Assert.assertThat;

import org.junit.Test;

import tech.bison.trainee2017.chess.Horse;

public class HorseTest {
  @Test
  public void knight_validMovement_validMove() throws Exception {
    Horse knight = new Horse();

    boolean validMove = knight.isAValidMove("b1", "c3");

    assertThat(validMove, is(true));
  }

  @Test
  public void knight_validMovementWithMinusValue_validMove() throws Exception {
    Horse knight = new Horse();

    boolean validMove = knight.isAValidMove("b8", "a6");

    assertThat(validMove, is(true));
  }

  @Test
  public void knight_horizontalMovement_invalidMove() throws Exception {
    Horse knight = new Horse();

    boolean validMove = knight.isAValidMove("b1", "b3");

    assertThat(validMove, is(false));
  }

  @Test
  public void knight_verticalMovement_validMove() throws Exception {
    Horse knight = new Horse();

    boolean validMove = knight.isAValidMove("c2", "e2");

    assertThat(validMove, is(false));
  }

}
