
public class NumberConverter {

  /**
   * Return String with arrays in different number systems: [0] = dec [1] = bin
   * [2] = hex
   */
  public static String[] convert(int number) {
    String[] convertedNumbers = { "", "", "" };
    convertedNumbers[0] = Integer.toString(number);
    convertedNumbers[1] = Integer.toBinaryString(number);
    convertedNumbers[2] = Integer.toHexString(number);
    convertedNumbers[2] = convertedNumbers[2].toUpperCase();
    return convertedNumbers;
  }

  public static String[] convert(String hexNumber) {
    int decimalNumber = Integer.parseInt(hexNumber, 16);
    return convert(decimalNumber);
  }

}
