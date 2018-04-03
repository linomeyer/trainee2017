package tech.bison.trainee2017.kata;

import static org.hamcrest.CoreMatchers.is;
import static org.junit.Assert.assertThat;

import org.junit.Test;

public class KnightTest {
  @Test
  public void knight_validMovement_validMove() throws Exception {
    Knight knight = new Knight();

    boolean validMove = knight.move("1b", "3c");

    assertThat(validMove, is(true));
  }

  @Test
  public void knight_invalidMovement_invalidMove() throws Exception {
    Knight knight = new Knight();

    boolean validMove = knight.move("1b", "3b");

    assertThat(validMove, is(false));
  }

  @Test
  public void knight_validMovement2_validMove() throws Exception {
    Knight knight = new Knight();

    boolean validMove = knight.move("8b", "6a");

    assertThat(validMove, is(true));
  }
}
