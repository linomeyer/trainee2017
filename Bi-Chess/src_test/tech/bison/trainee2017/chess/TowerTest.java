package tech.bison.trainee2017.chess;

import static org.hamcrest.CoreMatchers.is;
import static org.junit.Assert.assertThat;

import org.junit.Test;

public class TowerTest {
  @Test
  public void Tower_isAllowedToMoveOneUp_validMove() throws Exception {
    Tower Tower = new Tower();

    boolean validMove = Tower.isAValidMove("a2", "a3");

    assertThat(validMove, is(true));
  }

  @Test
  public void Tower_isAllowedToMoveOneDown_validMove() throws Exception {
    Tower Tower = new Tower();

    boolean validMove = Tower.isAValidMove("c3", "c2");

    assertThat(validMove, is(true));
  }

  @Test
  public void Tower_isAllowedToMoveOneRight_validMove() throws Exception {
    Tower Tower = new Tower();

    boolean validMove = Tower.isAValidMove("e5", "f5");

    assertThat(validMove, is(true));
  }

  @Test
  public void Tower_isAllowedToMoveOneLeft_validMove() throws Exception {
    Tower Tower = new Tower();

    boolean validMove = Tower.isAValidMove("e8", "d8");

    assertThat(validMove, is(true));
  }

  @Test
  public void Tower_isAllowedToMoveOneDiagonal_invalidMove() throws Exception {
    Tower Tower = new Tower();

    boolean validMove = Tower.isAValidMove("a2", "b3");

    assertThat(validMove, is(false));
  }

  @Test
  public void Tower_isAllowedToMoveSevenDiagonal_invalidMove() throws Exception {
    Tower Tower = new Tower();

    boolean validMove = Tower.isAValidMove("a1", "h8");

    assertThat(validMove, is(false));
  }

  @Test
  public void Tower_isAllowedToMoveSevenUp_validMove() throws Exception {
    Tower Tower = new Tower();

    boolean validMove = Tower.isAValidMove("d1", "d8");

    assertThat(validMove, is(true));
  }

  @Test
  public void Tower_isAllowedToMoveTwoLeft_validMove() throws Exception {
    Tower Tower = new Tower();

    boolean validMove = Tower.isAValidMove("h8", "a8");

    assertThat(validMove, is(true));
  }

  @Test
  public void Tower_isAllowedToMoveWetherHorizontalVerticalOrDiagonal_invalidMove() throws Exception {
    Tower Tower = new Tower();

    boolean validMove = Tower.isAValidMove("c2", "d4");

    assertThat(validMove, is(false));
  }
}
