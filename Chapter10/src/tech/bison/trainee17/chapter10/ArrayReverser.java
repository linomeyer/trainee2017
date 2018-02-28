package tech.bison.trainee17.chapter10;

public class ArrayReverser {

  public static int[] reverse(int[] array) {
    int length = array.length;
    int[] output = new int[length];
    int y = 0;
    for (int x = length - 1; x >= 0; x--) {
      output[y] = array[x];
      y++;
    }
    return output;
  }

}
