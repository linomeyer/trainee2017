package tech.bison.trainee17.chess;

import static org.hamcrest.CoreMatchers.is;
import static org.junit.Assert.assertThat;

import org.junit.Test;

import tech.bison.trainee17.chess.Figure.color;

public class TowerTest {

  @Test
  public void blackTowerWithStartPosition_moveToEndPosition_validMoveDifferentStartPosition() throws Exception {
    Tower blackTower = new Tower(color.black, 1);

    boolean validMove = blackTower.move("8h");

    assertThat(validMove, is(true));
    assertThat(blackTower.startPosition.getStringPosition(), is("8h"));
  }

  @Test
  public void whiteTower_moveDiagonal_invalidMoveSameStartPosition() throws Exception {
    Tower whiteTower = new Tower(color.white, 2);

    boolean validMove = whiteTower.move("2g");

    assertThat(validMove, is(false));
    assertThat(whiteTower.startPosition.getStringPosition(), is("1h"));
  }

  @Test
  public void blackTower_sameStartAndEndPosition_invalidMoveSameStartPosition() throws Exception {
    Tower blackTower = new Tower(color.black, 2);

    boolean validMove = blackTower.move("8h");

    assertThat(validMove, is(false));
    assertThat(blackTower.startPosition.getStringPosition(), is("8h"));
  }

}
