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
    } catch (NumberFormatException e) {
      time = "Die Eingabe war ungültig.";
    }

    JOptionPane.showMessageDialog(null, time);
  }
}
