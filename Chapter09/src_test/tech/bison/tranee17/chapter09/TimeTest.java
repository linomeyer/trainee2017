package tech.bison.tranee17.chapter09;

import static org.hamcrest.CoreMatchers.is;
import static org.junit.Assert.assertThat;

import org.junit.Rule;
import org.junit.Test;
import org.junit.rules.ExpectedException;

public class TimeTest {
  @Rule
  public ExpectedException thrown = ExpectedException.none();

  @Test
  public void validTime_toString_inTimeFormat() throws Exception {
    Time time = new Time(23, 59);

    assertThat(time.toString(), is("23:59"));
  }

  @Test
  public void validTime_catchException_noException() throws Exception {
    Time time = new Time(0, 0);
    assertThat(time.toString(), is("00:00"));

  }

  @Test
  public void timeWithInvalidNumberOfHour_catchException_timeFormatException() throws Exception {
    thrown.expect(TimeFormatException.class);
    thrown.expectMessage("Ungültige Stundeneingabe!");
    new Time(24, 35);
  }

  @Test
  public void timeWithInvalidNumberOfMinute_catchException_timeFormatException() throws Exception {
    thrown.expect(TimeFormatException.class);
    thrown.expectMessage("Ungültige Minuteneingabe!");
    new Time(23, -1);

  }

  @Test
  public void timeWithInvalidNumbersOfMinuteAndHour_catchException_timeFormatException() throws Exception {
    thrown.expect(TimeFormatException.class);
    thrown.expectMessage("Ungültige Stunden- und Minuteneingabe");
    new Time(-12, 78);
  }
}
