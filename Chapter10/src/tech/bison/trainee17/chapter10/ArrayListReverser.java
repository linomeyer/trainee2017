package tech.bison.trainee17.chapter10;

import java.util.ArrayList;

public class ArrayListReverser {

  public static void reverse(ArrayList arrayList) {
    int length = arrayList.size();
    ArrayList reversedArrayList = arrayList;
    arrayList = new ArrayList(reversedArrayList);
    reversedArrayList.clear();
    for (int x = length - 1; x >= 0; x--) {
      reversedArrayList.add(arrayList.get(x));
    }
  }

}
