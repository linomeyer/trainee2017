import java.time.Duration;
import java.time.Instant;

import javax.swing.JOptionPane;

public class InputTimer {
  public static void main(String[] args) {
    String correctAnswer = "Fischers Fritz fischt frische Fische";
    Instant startTime = Instant.now();
    String input = JOptionPane.showInputDialog("Geben Sie folgenden Satz ein: \n Fischers Fritz fischt frische Fische");
    Instant endTime = Instant.now();
    Duration duration = Duration.between(startTime, endTime);
    Long millis = duration.toMillis() - duration.getSeconds() * 1000;

    if (input.equals(correctAnswer)) {
      JOptionPane.showMessageDialog(null, "Fehlerfrei! " + duration.toMinutes() + " Minuten, " + duration.getSeconds()
          + " Sekunden, " + millis + " Milisekunden");
    } else {
      JOptionPane.showMessageDialog(null, "Es hat noch Fehler! " + duration.toMinutes() + " Minuten, "
          + duration.getSeconds() + " Sekunden, " + millis + " Milisekunden");
    }
  }
}
