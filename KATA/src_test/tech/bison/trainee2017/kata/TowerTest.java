package tech.bison.trainee2017.kata;

import static org.hamcrest.CoreMatchers.is;
import static org.junit.Assert.assertThat;

import org.junit.Test;

public class TowerTest {

  @Test
  public void tower_verticalMovement_validMove() throws Exception {
    Tower tower = new Tower();

    boolean validMove = tower.move("2c", "2e");

    assertThat(validMove, is(true));
  }

  @Test
  public void tower_horizontalMovement_validMove() throws Exception {
    Tower tower = new Tower();

    boolean validMove = tower.move("2c", "4c");

    assertThat(validMove, is(true));
  }

  @Test
  public void tower_startAndEndPositionAreSimilar_invalidMove() throws Exception {
    Tower tower = new Tower();

    boolean validMove = tower.move("2c", "2c");

    assertThat(validMove, is(false));
  }

  @Test
  public void tower_startAndEndPositionOutOfField_invalidMove() throws Exception {
    Tower tower = new Tower();

    boolean validMove = tower.move("8h", "9i");

    assertThat(validMove, is(false));
  }

  @Test
  public void tower_movementIsDiagonal_invalidMove() throws Exception {
    Tower tower = new Tower();

    boolean validMove = tower.move("2c", "4e");

    assertThat(validMove, is(false));
  }
}
