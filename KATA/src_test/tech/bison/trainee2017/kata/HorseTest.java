package tech.bison.trainee2017.kata;

import static org.hamcrest.CoreMatchers.is;
import static org.junit.Assert.assertThat;

import org.junit.Test;

public class HorseTest {
  @Test
  public void knight_validMovement_validMove() throws Exception {
    Horse knight = new Horse();

    boolean validMove = knight.move("1b", "3c");

    assertThat(validMove, is(true));
  }

  @Test
  public void knight_validMovementWithMinusValue_validMove() throws Exception {
    Horse knight = new Horse();

    boolean validMove = knight.move("8b", "6a");

    assertThat(validMove, is(true));
  }

  @Test
  public void knight_horizontalMovement_invalidMove() throws Exception {
    Horse knight = new Horse();

    boolean validMove = knight.move("1b", "3b");

    assertThat(validMove, is(false));
  }

  @Test
  public void knight_verticalMovement_validMove() throws Exception {
    Horse knight = new Horse();

    boolean validMove = knight.move("2c", "2e");

    assertThat(validMove, is(false));
  }

}
