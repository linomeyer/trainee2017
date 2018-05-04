package tech.bison.trainee2017.chess;

import static org.hamcrest.CoreMatchers.is;
import static org.junit.Assert.assertThat;

import org.junit.Rule;
import org.junit.Test;
import org.junit.rules.ExpectedException;

public class SquareTest {
  @Rule
  public ExpectedException thrown = ExpectedException.none();

  @Test
  public void chessSquare_createSquare_haveXAndYInNummber() throws Exception {
    Square square = new Square("f5");

    assertThat(square.x, is(6));
    assertThat(square.y, is(5));
  }

  @Test
  public void chessSquareWithXAndY_getSquare_haveSquare() throws Exception {
    Square square = new Square(5, 3);

    assertThat(square.getPosition(), is("E3"));
  }

  @Test
  public void charPositionOutOfField_createSquare_outOfFieldException() throws Exception {
    thrown.expect(InvalidSquareException.class);
    new Square("i9");
  }

  @Test
  public void numberSquareIsAChar_createSquare_throwsInvalidSquareException() throws Exception {
    thrown.expect(InvalidSquareException.class);
    new Square("ha");
  }

  @Test
  public void charSquareIsANumber_createSquare_throwsInvalidSquareException() throws Exception {
    thrown.expect(InvalidSquareException.class);
    new Square("79");
  }

  @Test
  public void numberSquareIsHigherThanEight_createSquare_throwsInvalidSquareException() throws Exception {
    thrown.expect(InvalidSquareException.class);
    new Square("h9");
  }

  @Test
  public void xSquareIsNotInField_createSquare_throwsInvalidSquareException() throws Exception {
    thrown.expect(InvalidSquareException.class);
    new Square(9, 3);
  }

  @Test
  public void ySquareIsNotInField_createSquare_throwsInvalidSquareException() throws Exception {
    thrown.expect(InvalidSquareException.class);
    new Square(7, -1);
  }
}
