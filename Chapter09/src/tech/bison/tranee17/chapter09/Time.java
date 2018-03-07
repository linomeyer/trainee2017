package tech.bison.tranee17.chapter09;

import java.time.LocalTime;

public class Time {
  private final LocalTime time;

  public Time(int hours, int minutes) throws Exception {
    if ((minutes < 0 || minutes > 59) && (hours < 0 || hours > 23))
      throw new TimeFormatException("Ung�ltige Stunden- und Minuteneingabe");
    if (hours < 0 || hours > 23)
      throw new TimeFormatException("Ung�ltige Stundeneingabe!");
    if (minutes < 0 || minutes > 59)
      throw new TimeFormatException("Ung�ltige Minuteneingabe!");

    time = LocalTime.of(hours, minutes);
  }

  public String toString() {
    return time.toString();
  }

}
