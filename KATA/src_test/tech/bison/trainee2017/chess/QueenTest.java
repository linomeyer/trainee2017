package tech.bison.trainee2017.chess;

import static org.hamcrest.CoreMatchers.is;
import static org.junit.Assert.assertThat;

import org.junit.Test;

public class QueenTest {
  @Test
  public void queen_startAndEndPosition_validMove() throws Exception {
    Queen queen = new Queen();

    boolean validMove = queen.move("c2", "d3");

    assertThat(validMove, is(true));
  }

  @Test
  public void queen_startAndEndPositionAreSimilar_invalidMove() throws Exception {
    Queen queen = new Queen();

    boolean validMove = queen.move("c3", "c2");

    assertThat(validMove, is(false));
  }

  @Test
  public void queen_startAndEndPositionOutOfField_invalidMove() throws Exception {
    Queen queen = new Queen();

    boolean validMove = queen.move("h8", "i9");

    assertThat(validMove, is(false));
  }

  @Test
  public void queen_movementIsntHorizontalVerticalOrDiagonal_invalidMove() throws Exception {
    Queen queen = new Queen();

    boolean validMove = queen.move("c2", "d8");

    assertThat(validMove, is(false));
  }
}
