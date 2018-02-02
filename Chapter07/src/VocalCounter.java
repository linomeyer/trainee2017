
public class VocalCounter {

  public static int count(String sentence) {
    int length = sentence.length();
    int vocalCounter = 0;
    sentence = sentence.toLowerCase();

    for (int x = 0; x < length; x++) {
      switch (sentence.charAt(x)) {
      case 'a':
      case 'e':
      case 'i':
      case 'o':
      case 'u':
      case 'ä':
      case 'ö':
      case 'ü':
        vocalCounter++;
        break;
      default:
        break;
      }
    }
    return vocalCounter;
  }
}
