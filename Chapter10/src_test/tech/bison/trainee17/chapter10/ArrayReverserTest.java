package tech.bison.trainee17.chapter10;

import static org.hamcrest.CoreMatchers.is;
import static org.junit.Assert.assertThat;

import org.junit.Test;

public class ArrayReverserTest {

  @Test
  public void array_reverse_reversedArray() {
    int[] reversedArray = ArrayReverser.reverse(new int[] { 1, 5, 98, 85, 4, 96, 974, 257, 18, 2465 });

    assertThat(reversedArray, is(new int[] { 2465, 18, 257, 974, 96, 4, 85, 98, 5, 1 }));
  }

}
