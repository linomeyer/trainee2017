package tech.bison.trainee17.chapter10;

import java.util.ArrayList;

public class ArrayListReverser {

  public static <E> void reverse(ArrayList<E> arrayList) {
    int length = arrayList.size();
    ArrayList<E> reversedArrayList = arrayList;
    arrayList = new ArrayList<E>(reversedArrayList);
    reversedArrayList.clear();
    for (int x = length - 1; x >= 0; x--) {
      reversedArrayList.add(arrayList.get(x));
    }
  }

}
