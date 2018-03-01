package tech.bison.tranee17.chapter09;

import static org.hamcrest.CoreMatchers.is;
import static org.junit.Assert.assertThat;

import org.junit.Test;

public class TimeTest {
  @Test
  public void time_toString_timeFormat() throws Exception {
    Time time = new Time(0, 2);
    assertThat(time.toString(), is("00:02"));
  }

  @Test
  public void timeWithInvalidNumberOfHour_catchException_timeFormatException() throws Exception {
    String exceptionMessage = "";
    try {
      new Time(24, 05);
    } catch (TimeFormatException e) {
      exceptionMessage = e.getMessage();
    } catch (NumberFormatException e) {
      exceptionMessage = e.getMessage();
    } catch (Exception e) {
      exceptionMessage = e.getMessage();
    }
    assertThat(exceptionMessage, is("Ungültige Stundeneingabe!"));
  }

  @Test
  public void timeWithInvalidNumberOfMinute_catchException_timeFormatException() throws Exception {
    String exceptionMessage = "";
    try {
      new Time(23, -1);
    } catch (TimeFormatException e) {
      exceptionMessage = e.getMessage();
    } catch (NumberFormatException e) {
      exceptionMessage = e.getMessage();
    } catch (Exception e) {
      exceptionMessage = e.getMessage();
    }
    assertThat(exceptionMessage, is("Ungültige Minuteneingabe!"));
  }

  @Test
  public void timeWithInvalidNumbersOfMinuteAndHour_catchException_timeFormatException() throws Exception {
    String exceptionMessage = "";
    try {
      new Time(-3, 60);
    } catch (TimeFormatException e) {
      exceptionMessage = e.getMessage();
    } catch (NumberFormatException e) {
      exceptionMessage = e.getMessage();
    } catch (Exception e) {
      exceptionMessage = e.getMessage();
    }
    assertThat(exceptionMessage, is("Ungültige Zeiteingabe!"));
  }
}
