import java.time.Duration;
import java.time.Instant;

import javax.swing.JOptionPane;

public class InputTimer {
  public static void main(String[] args) {
    int addedMistakes = 0;
    for (int x = 0; x < 5; x++) {
      String[] correctAnswer = { "Fischers Fritz fischt frische Fische",
          "Wenn Schnecken an Schnecken schlecken, merken Schnecken zu ihrem Schrecken, dass Schnecken nicht schmecken",
          "Es ist verboten einem toten auf dem boden liegenden Kojoten mit den Pfoten die Hoden zu verknoten",
          "Esel essen Nesseln nicht, Nesseln essen Esel nicht",
          "Blaukraut bleibt Blaukraut und Brautkleid bleibt Brautkleid" };

      Instant startTime = Instant.now();
      String input = JOptionPane.showInputDialog(correctAnswer[x]);
      Instant endTime = Instant.now();

      Duration duration = Duration.between(startTime, endTime);
      Long millis = duration.toMillis() - duration.getSeconds() * 1000;
      Long seconds = duration.getSeconds() - duration.toMinutes() * 60;

      if (input.equals(correctAnswer[x])) {
        JOptionPane.showMessageDialog(null,
            "Fehlerfrei! " + duration.toMinutes() + " Minuten, " + seconds + " Sekunden, " + millis + " Milisekunden");
      } else {
        JOptionPane.showMessageDialog(null, "Es hat noch " + mistakeCounter(input, correctAnswer[x]) + " Fehler! "
            + duration.toMinutes() + " Minuten, " + seconds + " Sekunden, " + millis + " Milisekunden");
      }
      addedMistakes += mistakeCounter(input, correctAnswer[x]);
    }
    JOptionPane.showMessageDialog(null, "Fehler insgesammt: " + addedMistakes);
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
