
public class StringReverser {

  public static String reverse(String sentence) {
    StringBuilder reversedString = new StringBuilder(sentence);
    reversedString.reverse();
    return reversedString.toString();
  }
}
