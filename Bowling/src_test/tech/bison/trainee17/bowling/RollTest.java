package tech.bison.trainee17.bowling;

import static org.hamcrest.CoreMatchers.is;
import static org.junit.Assert.assertThat;

import org.junit.Test;

public class RollTest {
  @Test
  public void roll_getRandomNumber_isBetweenZeroAndTen() throws Exception {
    Roll roll = new Roll();

    boolean isRollBetweenZeroAndOne = (roll.bowledPins >= 0 && roll.bowledPins <= 10);

    assertThat(isRollBetweenZeroAndOne, is(true));
  }

  @Test
  public void rollWithSixAvailablePins_getRandomNumber_isBetweenZeroAndSix() throws Exception {
    Roll roll = new Roll(6);

    boolean isRollBetweenZeroAndOne = (roll.bowledPins >= 0 && roll.bowledPins <= 6);

    assertThat(isRollBetweenZeroAndOne, is(true));
  }
}
