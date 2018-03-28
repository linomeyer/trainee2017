package tech.bison.trainee17.collections;

import static org.hamcrest.CoreMatchers.is;
import static org.junit.Assert.assertThat;

import org.junit.Test;

public class ArrayBowlingTest {
  @Test
  public void scoreOfRounds_addToArray_arrayWithScoreOfRounds() throws Exception {
    int[] rounds = { 0, 2, 7, 5, 10, 5, 7, 4, 5, 7 };

    assertThat(rounds[4], is(10));
    assertThat(rounds[5], is(5));
  }

  @Test
  public void scoreOfRounds_changeValue_arrayWithChangedScoreOfRounds() throws Exception {
    int[] rounds = { 0, 2, 7, 5, 10, 5, 7, 4, 5, 7 };

    rounds[5] = 25;

    assertThat(rounds[5], is(25));
  }
}
