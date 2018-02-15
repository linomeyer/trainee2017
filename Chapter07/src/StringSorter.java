public class StringSorter {

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

}
