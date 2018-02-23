package tech.bison.tranee17.chapter09;

import java.time.LocalTime;

import javax.swing.JOptionPane;

public class TimeJOptionPane {
  public static void main(String[] args) {
    LocalTime time = LocalTime.now();
    String message = "";
    int hours;
    int minutes;

    String strHours = JOptionPane.showInputDialog("Geben Sie die Stunde ein: ");
    String strMinutes = JOptionPane.showInputDialog("Geben Sie die Minute ein: ");

    try {
      hours = Integer.parseInt(strHours);
      minutes = Integer.parseInt(strMinutes);
      time = LocalTime.of(hours, minutes);
      if (hours < 0 || hours > 24 || minutes < 0 || minutes > 60) {
        throw new TimeFormatException("Falsche Zeiteingabe!");
      }
    } catch (TimeFormatException e) {
      message = e.getMessage();
      JOptionPane.showMessageDialog(null, message);
    } catch (NumberFormatException e) {
      message = "Etwas stimmt mit den Zahlen nicht: \n" + e.getMessage();
      JOptionPane.showMessageDialog(null, message);
    } catch (Exception e) {
      message = "Etwas stimmt nicht: \n" + e.getMessage();
      JOptionPane.showMessageDialog(null, message);
    }
    if (message.equals("")) {
      JOptionPane.showMessageDialog(null, "Ihre Zeit ist " + time.toString() + " Uhr");
    }
  }
}