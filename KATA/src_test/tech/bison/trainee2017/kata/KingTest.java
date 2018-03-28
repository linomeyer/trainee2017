package tech.bison.trainee2017.kata;

import static org.hamcrest.CoreMatchers.is;
import static org.junit.Assert.assertThat;

import org.junit.Test;

public class KingTest {
  @Test
  public void king_startAndEndPosition_validMove() throws Exception {
    King king = new King();

    boolean validMove = king.move("2c", "3d");

    assertThat(validMove, is(true));
  }

  @Test
  public void king_startAndEndPositionAreSimilar_invalidMove() throws Exception {
    King king = new King();

    boolean validMove = king.move("2c", "2c");

    assertThat(validMove, is(false));
  }

  @Test
  public void king_startAndEndPositionOutOfField_invalidMove() throws Exception {
    King king = new King();

    boolean validMove = king.move("8h", "9i");

    assertThat(validMove, is(false));
  }
}
