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
    Long seconds = duration.getSeconds() - duration.toMinutes() * 60;

    if (input.equals(correctAnswer)) {
      JOptionPane.showMessageDialog(null,
          "Fehlerfrei! " + duration.toMinutes() + " Minuten, " + seconds + " Sekunden, " + millis + " Milisekunden");
    } else {
      JOptionPane.showMessageDialog(null, "Es hat noch " + mistakeCounter(input, correctAnswer) + " Fehler! "
          + duration.toMinutes() + " Minuten, " + seconds + " Sekunden, " + millis + " Milisekunden");
    }
  }

  public static int mistakeCounter(String input, String correctAnswer) {
    int amountOfMistakes = 0;
    for (int x = 0; x < input.length(); x++) {
      if (input.charAt(x) == correctAnswer.charAt(x) || input.charAt(x) == correctAnswer.charAt(x + 1)
          || input.charAt(x) == correctAnswer.charAt(x + 2)) {
      } else {
        amountOfMistakes++;
      }
    }
    // If input is shorter than the correctAnswer add mistakes
    amountOfMistakes += correctAnswer.length() - input.length();
    return amountOfMistakes;
  }
}
