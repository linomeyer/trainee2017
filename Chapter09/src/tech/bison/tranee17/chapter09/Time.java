package tech.bison.tranee17.chapter09;

import javax.swing.JOptionPane;

public class Time {
  public static void main(String[] args) {
    int hours;
    int minutes;
    String time;

    String strHours = JOptionPane.showInputDialog("Geben Sie die Stunde ein: ");
    String strMinutes = JOptionPane.showInputDialog("Geben Sie die Minute ein: ");
    hours = Integer.parseInt(strHours);
    minutes = Integer.parseInt(strMinutes);

    time = toTime(hours, minutes);

    JOptionPane.showMessageDialog(null, time);
  }

  public static String toTime(int hours, int minutes) {
    String time;
    try {
      time = "Ihre Uhrzeit ist " + hours + ":" + minutes + "Uhr";
    } catch (NumberFormatException e) {
      time = "Die eingegebenen Zahlen sind ungültig!";
    }
    return time;

  }
}
