package tech.bison.trainee2017.chess;

import static org.hamcrest.CoreMatchers.is;
import static org.junit.Assert.assertThat;

import org.junit.Test;

public class TowerTest {
  @Test
  public void tower_isAllowedToMoveUp_validMove() throws Exception {
    Tower tower = new Tower();

    boolean validMove = tower.isAValidMove("e2", "e8");

    assertThat(validMove, is(true));
  }

  @Test
  public void tower_isAllowedToMoveDown_validMove() throws Exception {
    Tower tower = new Tower();

    boolean validMove = tower.isAValidMove("c7", "c4");

    assertThat(validMove, is(true));
  }

  @Test
  public void tower_isAllowedToMoveRight_validMove() throws Exception {
    Tower tower = new Tower();

    boolean validMove = tower.isAValidMove("b3", "c3");

    assertThat(validMove, is(true));
  }

  @Test
  public void tower_isAllowedToMoveLeft_validMove() throws Exception {
    Tower tower = new Tower();

    boolean validMove = tower.isAValidMove("h8", "a8");

    assertThat(validMove, is(true));
  }

  @Test
  public void tower_isAllowedToMoveDiagonal_invalidMove() throws Exception {
    Tower tower = new Tower();

    boolean validMove = tower.isAValidMove("a2", "b3");

    assertThat(validMove, is(false));
  }

  @Test
  public void tower_isAllowedToMoveWetherHorizontalVerticalOrDiagonal_invalidMove() throws Exception {
    Tower tower = new Tower();

    boolean validMove = tower.isAValidMove("c2", "d4");

    assertThat(validMove, is(false));
  }
}
