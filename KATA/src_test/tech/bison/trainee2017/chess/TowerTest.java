package tech.bison.trainee2017.chess;

import static org.hamcrest.CoreMatchers.is;
import static org.junit.Assert.assertThat;

import org.junit.Test;

public class TowerTest {

  @Test
  public void tower_verticalMovement_validMove() throws Exception {
    Tower tower = new Tower();

    boolean validMove = tower.move("c2", "e2");

    assertThat(validMove, is(true));
  }

  @Test
  public void tower_horizontalMovement_validMove() throws Exception {
    Tower tower = new Tower();

    boolean validMove = tower.move("c2", "c4");

    assertThat(validMove, is(true));
  }

  @Test
  public void tower_startAndEndPositionAreSimilar_invalidMove() throws Exception {
    Tower tower = new Tower();

    boolean validMove = tower.move("c2", "c2");

    assertThat(validMove, is(false));
  }

  @Test
  public void tower_startAndEndPositionOutOfField_invalidMove() throws Exception {
    Tower tower = new Tower();

    boolean validMove = tower.move("h8", "i9");

    assertThat(validMove, is(false));
  }

  @Test
  public void tower_movementIsDiagonal_invalidMove() throws Exception {
    Tower tower = new Tower();

    boolean validMove = tower.move("c2", "e4");

    assertThat(validMove, is(false));
  }
}
