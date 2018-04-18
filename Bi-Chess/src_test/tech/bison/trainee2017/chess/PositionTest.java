package tech.bison.trainee2017.chess;

import static org.hamcrest.CoreMatchers.is;
import static org.junit.Assert.assertThat;

import org.junit.Test;

public class PositionTest {
  @Test
  public void chessPosition_createPosition_haveXAndYInNummber() throws Exception {
    Position position = new Position("f5");

    assertThat(position.x, is(6));
    assertThat(position.y, is(5));
  }

  @Test
  public void chessPositionWithXAndY_getPosition_havePosition() throws Exception {
    Position position = new Position(5, 3);

    assertThat(position.getPosition(), is("E3"));
  }
}
