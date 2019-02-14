package trainee.chess;

import static org.junit.Assert.assertThat;

import org.junit.Test;

import static org.hamcrest.CoreMatchers.is;

public class CoordinatesTest {
  @Test
  public void coordinates_toString_stringRepresentationOfCoordinates() throws Exception {
    Coordinates coordinates = new Coordinates(0, 0);
    assertThat(coordinates.toString(), is("A1"));
  }
}
