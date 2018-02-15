public class StringSorter {

  public static String[] sort(String[] strings) {
    int lenght = strings.length;
    String[] sortedStrings = strings;

    for (int x = 0; x < lenght; x++) {
      for (int y = 0; y < lenght - 1; y++) {
        int z = y + 1;
        String stringOfY = sortedStrings[y];
        String stringOfZ = sortedStrings[z];
        if (stringOfY.compareTo(stringOfZ) > 0) {
          sortedStrings[y] = stringOfZ;
          sortedStrings[z] = stringOfY;
        }
      }

    }

    return sortedStrings;
  }

}
