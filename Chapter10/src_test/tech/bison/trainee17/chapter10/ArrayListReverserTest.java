package tech.bison.trainee17.chapter10;

import static org.hamcrest.CoreMatchers.is;
import static org.junit.Assert.assertThat;

import java.util.ArrayList;

import org.junit.Test;

public class ArrayListReverserTest {
  @Test
  public void arrayList_reverse_reversedArrayList() throws Exception {
    ArrayList<Integer> arrayList = new ArrayList<Integer>();
    arrayList.add(69);
    arrayList.add(1686);
    arrayList.add(18);
    arrayList.add(38);
    arrayList.add(924);
    arrayList.add(83);
    arrayList.add(49);

    ArrayList<Integer> reversedArrayList = new ArrayList<Integer>();
    reversedArrayList.add(49);
    reversedArrayList.add(83);
    reversedArrayList.add(924);
    reversedArrayList.add(38);
    reversedArrayList.add(18);
    reversedArrayList.add(1686);
    reversedArrayList.add(69);

    ArrayListReverser.reverse(arrayList);

    assertThat(arrayList, is(reversedArrayList));
  }
}
