package tech.bison.tranee17.chapter09;

import static org.hamcrest.CoreMatchers.is;
import static org.junit.Assert.assertThat;

import org.junit.Test;

public class TimeTest {
  @Test
  public void validTime_toString_inTimeFormat() throws Exception {
    Time time = new Time(23, 59);

    assertThat(time.toString(), is("23:59"));
  }

  @Test
  public void validTime_catchException_noException() throws Exception {
    String exceptionMessage = "";
    try {
      Time time = new Time(0, 0);
      assertThat(time.toString(), is("00:00"));

    } catch (TimeFormatException e) {
      exceptionMessage = e.getMessage();
    } catch (NumberFormatException e) {
      exceptionMessage = e.getMessage();
    } catch (Exception e) {
      exceptionMessage = e.getMessage();
    }

    assertThat(exceptionMessage, is(""));
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
