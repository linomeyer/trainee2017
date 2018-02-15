
public class VocalRemover {

  public static String remove(String sentence) {
    int length = sentence.length();
    StringBuilder vocalsRemoved = new StringBuilder(sentence);
    sentence = sentence.toLowerCase();

    for (int x = 0; x < length; x++) {
      switch (vocalsRemoved.charAt(x)) {
      case 'a':
      case 'e':
      case 'i':
      case 'o':
      case 'u':
      case 'ä':
      case 'ö':
      case 'ü':
        vocalsRemoved.deleteCharAt(x);
        length--;
        x--;
        break;
      default:
        break;
      }
    }
    return vocalsRemoved.toString();
  }
}
