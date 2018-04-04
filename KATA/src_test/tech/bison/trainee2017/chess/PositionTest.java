package tech.bison.trainee2017.chess;

import static org.hamcrest.CoreMatchers.is;
import static org.junit.Assert.assertThat;

import org.junit.Test;

import tech.bison.trainee2017.chess.Position;

public class PositionTest {
  @Test
  public void chessPosition_createPosition_haveXAndYInNummber() throws Exception {
    Position position = new Position("5f");

    assertThat(position.x, is(5));
    assertThat(position.y, is(6));
  }

  @Test
  public void chessPositionWithXAndY_getPosition_havePosition() throws Exception {
    Position position = new Position(3, 5);

    assertThat(position.getPosition(), is("3E"));
  }
}
