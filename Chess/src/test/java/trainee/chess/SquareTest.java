package trainee.chess;

import static org.junit.Assert.assertThat;

import org.junit.Test;

import static org.hamcrest.CoreMatchers.is;

public class SquareTest {
  @Test
  public void squareAsString_newSquare_coordinates() throws Exception {
    String squareName = "A1";

    Square square = new Square(squareName);

    assertThat(square.getCoordinates(), is(new Coordinates(0, 0)));
  }

  @Test
  public void square_getName_squareName() throws Exception {
    String squareName = "A1";

    Square square = new Square(squareName);

    assertThat(square.getName(), is("A1"));
  }

}
