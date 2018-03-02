package tech.bison.tranee17.chapter09;

import java.time.LocalTime;

import javax.swing.JOptionPane;

public class TimeJOptionPane {
  public static void main(String[] args) {
    LocalTime time = LocalTime.now();
    String exceptionMessage = "";
    int hours;
    int minutes;

    String stringOfHours = JOptionPane.showInputDialog("Geben Sie die Stunde ein: ");
    String stringOfMinutes = JOptionPane.showInputDialog("Geben Sie die Minute ein: ");

    try {
      hours = Integer.parseInt(stringOfHours);
      minutes = Integer.parseInt(stringOfMinutes);
      time = LocalTime.of(hours, minutes);

      if (hours < 0 || hours > 24) {
        throw new TimeFormatException("Falsche Stundeneingabe!");
      } else {
        if (minutes < 0 || minutes > 60) {
          throw new TimeFormatException("Falsche Minuteneingabe!");
        }
      }
    } catch (TimeFormatException e) {
      exceptionMessage = e.getMessage();
      JOptionPane.showMessageDialog(null, exceptionMessage);

    } catch (NumberFormatException e) {
      exceptionMessage = "Falsches Zahlenformat: \n" + e.getMessage();
      JOptionPane.showMessageDialog(null, exceptionMessage);

    } catch (Exception e) {
      exceptionMessage = "Ungültige eingabe: \n" + e.getMessage();
      JOptionPane.showMessageDialog(null, exceptionMessage);
    }
    if (exceptionMessage.equals("")) {
      JOptionPane.showMessageDialog(null, "Ihre Zeit ist " + time.toString() + " Uhr");
    }
  }
}