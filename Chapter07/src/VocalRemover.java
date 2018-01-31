
public class VocalRemover {

  public static String remove(String sentence) {
    int length = sentence.length();
    StringBuilder vocalsRemoved = new StringBuilder(sentence);
    sentence = sentence.toLowerCase();

    for (int x = 0; x < length; x++) {
      switch (sentence.charAt(x)) {
      case 'a':
      case 'e':
      case 'i':
      case 'o':
      case 'u':
      case '�':
      case '�':
      case '�':
        vocalsRemoved.setCharAt(x, '_');
        break;
      default:
        break;
      }
    }
    return vocalsRemoved.toString();
  }

}
