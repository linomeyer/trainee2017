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

    int amountOfMistakes = 0;
    for (int x = 0; x < input.length(); x++) {
      if (input.charAt(x) == correctAnswer.charAt(x)) {
      } else {
        amountOfMistakes++;
      }
    }
    // If input is shorter than the correctAnswer add mistakes
    amountOfMistakes += correctAnswer.length() - input.length();

    if (input.equals(correctAnswer)) {
      JOptionPane.showMessageDialog(null, "Fehlerfrei! " + duration.toMinutes() + " Minuten, " + duration.getSeconds()
          + " Sekunden, " + millis + " Milisekunden");
    } else {
      JOptionPane.showMessageDialog(null, "Es hat noch " + amountOfMistakes + " Fehler! " + duration.toMinutes()
          + " Minuten, " + duration.getSeconds() + " Sekunden, " + millis + " Milisekunden");
    }
  }
}
