import static org.hamcrest.CoreMatchers.is;
import static org.junit.Assert.assertThat;

import org.junit.Test;

public class NumberConverterTest {
  @Test
  public void number_convertToDifferentNumberSystems_numbersAsString() throws Exception {
    int number = 10;

    String[] convertedNumbers = NumberConverter.convert(number);

    assertThat(convertedNumbers[0], is("1010"));
    assertThat(convertedNumbers[1], is("12"));
    assertThat(convertedNumbers[2], is("10"));
    assertThat(convertedNumbers[3], is("A"));
  }

  @Test
  public void stringHexNumber_convertToDifferentNumberSystems_numbersAsString() throws Exception {
    String hexNumber = "10";

    String[] convertedNumbers = NumberConverter.convert(hexNumber, 16);

    assertThat(convertedNumbers[0], is("10000"));
    assertThat(convertedNumbers[1], is("20"));
    assertThat(convertedNumbers[2], is("16"));
    assertThat(convertedNumbers[3], is("10"));
  }

  @Test
  public void stringBinaryNumber_convertToDifferentNumberSystems_numbersAsString() throws Exception {
    String binaryNumber = "10";

    String[] convertedNumbers = NumberConverter.convert(binaryNumber, 2);

    assertThat(convertedNumbers[0], is("10"));
    assertThat(convertedNumbers[1], is("2"));
    assertThat(convertedNumbers[2], is("2"));
    assertThat(convertedNumbers[3], is("2"));
  }

  @Test
  public void stringOctalNumber_convertToDifferentNumberSystems_numbersAsString() throws Exception {
    String octalNumber = "10";

    String[] convertedNumbers = NumberConverter.convert(octalNumber, 8);

    assertThat(convertedNumbers[0], is("1000"));
    assertThat(convertedNumbers[1], is("10"));
    assertThat(convertedNumbers[2], is("8"));
    assertThat(convertedNumbers[3], is("8"));
  }
}
