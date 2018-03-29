package tech.bison.trainee2017.kata;

import static org.hamcrest.CoreMatchers.is;
import static org.junit.Assert.assertThat;

import org.junit.Test;

public class QueenTest {
  @Test
  public void queen_startAndEndPosition_validMove() throws Exception {
    Queen queen = new Queen();

    boolean validMove = queen.move("2c", "3d");

    assertThat(validMove, is(true));
  }

  @Test
  public void queen_startAndEndPositionAreSimilar_invalidMove() throws Exception {
    Queen queen = new Queen();

    boolean validMove = queen.move("2c", "2c");

    assertThat(validMove, is(false));
  }

  @Test
  public void queen_startAndEndPositionOutOfField_invalidMove() throws Exception {
    Queen queen = new Queen();

    boolean validMove = queen.move("8h", "9i");

    assertThat(validMove, is(false));
  }

  @Test
  public void queen_movementIsntHorizontalVerticalOrDiagonal_invalidMove() throws Exception {
    Queen queen = new Queen();

    boolean validMove = queen.move("2c", "8d");

    assertThat(validMove, is(false));
  }
}
