package tech.bison.trainee2017.chess;

import static org.hamcrest.CoreMatchers.is;
import static org.junit.Assert.assertThat;

import org.junit.Rule;
import org.junit.Test;
import org.junit.rules.ExpectedException;

public class PositionTest {
  @Rule
  public ExpectedException thrown = ExpectedException.none();

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

  @Test
  public void charPositionOutOfField_createPosition_outOfFieldException() throws Exception {
    thrown.expect(InvalidPositionException.class);
    new Position("i9");
  }

  @Test
  public void numberPositionIsAChar_createPosition_throwsInvalidPositionException() throws Exception {
    thrown.expect(InvalidPositionException.class);
    new Position("ha");
  }

  @Test
  public void charPositionIsANumber_createPosition_throwsInvalidPositionException() throws Exception {
    thrown.expect(InvalidPositionException.class);
    new Position("79");
  }

  @Test
  public void numberPositionIsHigherThanEight_createPosition_throwsInvalidPositionException() throws Exception {
    thrown.expect(InvalidPositionException.class);
    new Position("h9");
  }
}
