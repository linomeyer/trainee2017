public class StringEdit {
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

  public static String reverse(String sentence) {
    int length = sentence.length();
    String backwardsSentence = "";

    for (int x = length - 1; x >= 0; x--) {
      backwardsSentence += sentence.charAt(x);
    }

    return backwardsSentence;
  }

  public static String[] sort(String x, String y, String z) {
    String[] sortedString = { "", "", "" };

    if (x.compareTo(y) < 0 && x.compareTo(z) < 0) {
      sortedString[0] = x;
    } else {
      if (x.compareTo(y) < 0 || x.compareTo(z) < 0) {
        sortedString[1] = x;
      } else {
        sortedString[2] = x;
      }
    }

    if (y.compareTo(x) < 0 && y.compareTo(z) < 0) {
      sortedString[0] = y;
    } else {
      if (y.compareTo(x) < 0 || y.compareTo(z) < 0) {
        sortedString[1] = y;
      } else {
        sortedString[2] = y;
      }
    }

    if (z.compareTo(y) < 0 && z.compareTo(x) < 0) {
      sortedString[0] = z;
    } else {
      if (z.compareTo(y) < 0 || z.compareTo(x) < 0) {
        sortedString[1] = z;
      } else {
        sortedString[2] = z;
      }
    }

    return sortedString;
  }

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
      case 'ä':
      case 'ö':
      case 'ü':
        vocalsRemoved.setCharAt(x, '_');
        break;
      default:
        break;
      }
    }
    return vocalsRemoved.toString();
  }
}
