package tech.bison.trainee17.bowling;

import static org.hamcrest.CoreMatchers.is;
import static org.junit.Assert.assertThat;

import org.junit.Test;

public class FrameTest {
  @Test
  public void frame_twoRolls_maximalTenBowledPins() throws Exception {
    Frame frame = new Frame();

    boolean isBowledPinsBetweenZeroAndTen = (frame.bowledPins >= 0 && frame.bowledPins <= 10);

    assertThat(isBowledPinsBetweenZeroAndTen, is(true));
  }
}
