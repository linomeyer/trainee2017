import static org.hamcrest.CoreMatchers.is;
import static org.junit.Assert.assertThat;

import org.junit.Test;

public class NumberConverterTest {
  @Test
  public void number_convertToDifferentNumberSystems_numbersAsString() throws Exception {
    int number = 12;

    String[] convertedNumbers = NumberConverter.convert(number);

    assertThat(convertedNumbers[0], is("12"));
    assertThat(convertedNumbers[1], is("1100"));
    assertThat(convertedNumbers[2], is("C"));
  }

  @Test
  public void stringHexNumber_convertToDifferentNumberSystems_numbersAsString() throws Exception {
    String hexNumber = "C";

    String[] convertedNumbers = NumberConverter.convert(hexNumber);

    assertThat(convertedNumbers[0], is("12"));
    assertThat(convertedNumbers[1], is("1100"));
    assertThat(convertedNumbers[2], is("C"));
  }
}
