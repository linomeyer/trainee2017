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
  public void square_createSquare_haveXAndYInNummber() throws Exception {
    Square square = new Square("f5");

    assertThat(square.x, is(6));
    assertThat(square.y, is(5));
  }

  @Test
  public void squareWithXAndY_getSquare_haveSquare() throws Exception {
    Square square = new Square(5, 3);

    assertThat(square.toString(), is("e3"));
  }

  @Test
  public void letter_letterNumberConverter_number() throws Exception {
    int number = Square.letterNumberConverter('D');

    assertThat(number, is(4));
  }

  @Test
  public void number_letterNumberConverter_letter() throws Exception {
    char letter = Square.letterNumberConverter(24);

    assertThat(letter, is('x'));
  }
}
