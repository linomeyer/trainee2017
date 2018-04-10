package tech.bison.trainee17.chess;

import static org.hamcrest.CoreMatchers.is;
import static org.junit.Assert.assertThat;

import org.junit.Test;

public class PositionTest {
  @Test
  public void position_convertToIntOnXAndY_getXAndY() throws Exception {
    Position position = new Position("8c");

    assertThat(position.x, is(8));
    assertThat(position.y, is(3));
  }

  @Test
  public void position_convertXAndYToPosition_getPosition() throws Exception {
    Position position = new Position("3B");

    assertThat(position.getStringPosition(), is("3b"));
  }
}
