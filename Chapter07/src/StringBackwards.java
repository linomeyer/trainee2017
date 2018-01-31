
public class StringBackwards {

  public static String reverse(String sentence) {
    int length = sentence.length();
    String backwardsSentence = "";

    for (int x = length - 1; x >= 0; x--) {
      backwardsSentence += sentence.charAt(x);
    }

    return backwardsSentence;
  }

}
