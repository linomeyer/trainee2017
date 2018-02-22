package tech.bison.tranee17.chapter09;

import javax.swing.JOptionPane;

public class Time {
  public static void main(String[] args) {
    String time;
    int hours;
    int minutes;

    String strHours = JOptionPane.showInputDialog("Geben Sie die Stunde ein: ");
    String strMinutes = JOptionPane.showInputDialog("Geben Sie die Minute ein: ");

    try {
      hours = Integer.parseInt(strHours);
      minutes = Integer.parseInt(strMinutes);
      time = "Ihre Uhrzeit ist " + hours + ":" + minutes + " Uhr!";
      if (hours <= 0 && hours > 24 && minutes <= 0 && minutes > 60) {
        throw new TimeFormatException("Falsche Zeiteingabe!");
      }
    } catch (TimeFormatException e) {
      time = e.getMessage();
    } catch (NumberFormatException e) {
      time = "Die Eingabe war ungültig.";
    }
    JOptionPane.showMessageDialog(null, time);
  }
}
