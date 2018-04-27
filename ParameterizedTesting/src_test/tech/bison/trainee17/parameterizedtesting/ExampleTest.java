package tech.bison.trainee17.parameterizedtesting;

import static org.hamcrest.CoreMatchers.is;
import static org.junit.Assert.assertThat;

import java.util.Arrays;
import java.util.Collection;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.Parameterized;
import org.junit.runners.Parameterized.Parameters;

@RunWith(Parameterized.class)
public class ExampleTest {
  @Parameters
  public static Collection<Object[]> data() {
    return Arrays.asList(new Object[][] { { 1, 2 }, { 2, 3 }, { 3, 4 }, { 4, 5 } });
  }

  /*
   * Es gibt zwei Varianten wie man das mit Parametern testen kann, die eine
   * Möglichkeit ist die Werte mit einem Konstruktor zuzuweisen.
   */
  private int input;
  private int expected;

  public ExampleTest(int input, int expected) {
    this.input = input;
    this.expected = expected;
  }

  /*
   * Die andere Möglichkeit ist es die Parameter mit einer Notation
   * Parameter(Index) zuzuweisen.
   */

  // @Parameter(0)
  // public int input;
  //
  // @Parameter(1)
  // public int expected;

  @Test
  public void number_addOne_numberPlusOne() throws Exception {
    assertThat(Example.numberPlusOne(input), is(expected));
  }
}