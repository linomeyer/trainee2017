
public class NumberConverter {

  /**
   * Return String with arrays in different number systems: [0] = bin; [1] =
   * octal; [2] = decimal; [3] hex
   */
  public static String[] convert(int number) {
    String[] convertedNumbers = { "", "", "", "" };
    convertedNumbers[0] = Integer.toBinaryString(number);
    convertedNumbers[1] = Integer.toOctalString(number);
    convertedNumbers[2] = Integer.toString(number);
    convertedNumbers[3] = Integer.toHexString(number);
    convertedNumbers[3] = convertedNumbers[3].toUpperCase();
    return convertedNumbers;
  }

  /**
   * Return String with arrays in different number systems: [0] = bin; [1] =
   * octal; [2] = decimal; [3] hex
   */
  public static String[] convert(String number, int format) {
    int decimalNumber = Integer.parseInt(number, format);
    return convert(decimalNumber);
  }

}
