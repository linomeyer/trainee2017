
public class StringReverser {

  public static String reverse(String sentence) {
    StringBuilder stringBuilder = new StringBuilder(sentence);
    stringBuilder.reverse();
    return stringBuilder.toString();
  }
}
