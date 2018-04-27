package tech.bison.trainee2017.chess;

import static org.hamcrest.CoreMatchers.is;
import static org.junit.Assert.assertThat;

import org.junit.Test;

public class TowerTest {
  @Test
  public void tower_isAllowedToMoveOneUp_validMove() throws Exception {
    Tower tower = new Tower();

    boolean validMove = tower.isAValidMove("a2", "a3");

    assertThat(validMove, is(true));
  }

  @Test
  public void tower_isAllowedToMoveOneDown_validMove() throws Exception {
    Tower tower = new Tower();

    boolean validMove = tower.isAValidMove("c3", "c2");

    assertThat(validMove, is(true));
  }

  @Test
  public void tower_isAllowedToMoveOneRight_validMove() throws Exception {
    Tower tower = new Tower();

    boolean validMove = tower.isAValidMove("e5", "f5");

    assertThat(validMove, is(true));
  }

  @Test
  public void tower_isAllowedToMoveOneLeft_validMove() throws Exception {
    Tower tower = new Tower();

    boolean validMove = tower.isAValidMove("e8", "d8");

    assertThat(validMove, is(true));
  }

  @Test
  public void tower_isAllowedToMoveOneDiagonal_invalidMove() throws Exception {
    Tower tower = new Tower();

    boolean validMove = tower.isAValidMove("a2", "b3");

    assertThat(validMove, is(false));
  }

  @Test
  public void tower_isAllowedToMoveSevenDiagonal_invalidMove() throws Exception {
    Tower tower = new Tower();

    boolean validMove = tower.isAValidMove("a1", "h8");

    assertThat(validMove, is(false));
  }

  @Test
  public void tower_isAllowedToMoveSevenUp_validMove() throws Exception {
    Tower tower = new Tower();

    boolean validMove = tower.isAValidMove("d1", "d8");

    assertThat(validMove, is(true));
  }

  @Test
  public void tower_isAllowedToMoveTwoLeft_validMove() throws Exception {
    Tower tower = new Tower();

    boolean validMove = tower.isAValidMove("h8", "a8");

    assertThat(validMove, is(true));
  }

  @Test
  public void tower_isAllowedToMoveWetherHorizontalVerticalOrDiagonal_invalidMove() throws Exception {
    Tower tower = new Tower();

    boolean validMove = tower.isAValidMove("c2", "d4");

    assertThat(validMove, is(false));
  }
}
