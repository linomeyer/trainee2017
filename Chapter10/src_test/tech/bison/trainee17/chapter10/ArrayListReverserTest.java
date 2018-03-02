package tech.bison.trainee17.chapter10;

import static org.hamcrest.CoreMatchers.is;
import static org.junit.Assert.assertThat;

import java.util.ArrayList;
import java.util.Arrays;

import org.junit.Test;

public class ArrayListReverserTest {
  @Test
  public void arrayList_reverse_reversedArrayList() throws Exception {
    ArrayList<Integer> arrayList = new ArrayList<Integer>();
    arrayList.addAll(Arrays.asList(69, 1686, 18, 38, 924, 49));

    ArrayList<Integer> reversedArrayList = new ArrayList<Integer>();
    reversedArrayList.addAll(Arrays.asList(49, 924, 38, 18, 1686, 69));

    ArrayListReverser.reverse(arrayList);

    assertThat(arrayList, is(reversedArrayList));
  }
}
