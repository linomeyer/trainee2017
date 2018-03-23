package tech.bison.trainee17.ArrayListSetMap;

import static org.hamcrest.CoreMatchers.is;
import static org.junit.Assert.assertThat;

import org.junit.Test;

public class ArrayBowlingTest {
  @Test
  public void scoreOfRounds_addToArray_arrayWithScoreOfRounds() throws Exception {

    int[] rounds = { 0, 2, 7, 5, 10, 5, 7, 4, 5, 7 };

    assertThat(rounds[4], is(10));
  }
}
