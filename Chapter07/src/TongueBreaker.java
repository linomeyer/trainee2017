import java.time.Duration;
import java.time.Instant;

import javax.swing.JOptionPane;

public class TongueBreaker {
  public static void main(String[] args) {
    Instant startTimeOfProgramm = Instant.now();
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
      long millis = duration.toMillis() - duration.getSeconds() * 1000;
      long seconds = duration.getSeconds() - duration.toMinutes() * 60;

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
    Instant endTimeOfProgramm = Instant.now();
    Duration durationOfProgramm = Duration.between(startTimeOfProgramm, endTimeOfProgramm);
    long millisOfProgramm = durationOfProgramm.toMillis() - durationOfProgramm.getSeconds() * 1000;
    long secondsOfProgramm = durationOfProgramm.getSeconds() - durationOfProgramm.toMinutes() * 60;

    if (durationOfProgramm.toMinutes() <= 1 && durationOfProgramm.getSeconds() <= 20 && addedMistakes <= 5) {
      JOptionPane.showMessageDialog(null,
          "Wow!!!, du hast für alle Wortwitze zusammen nur " + durationOfProgramm.toMinutes() + " Minuten, "
              + secondsOfProgramm + " Sekunden und " + millisOfProgramm + " Milisekunden gebraucht!");
    } else if (durationOfProgramm.toMinutes() < 2 && addedMistakes <= 10) {
      JOptionPane.showMessageDialog(null,
          "Nicht schlecht, du hast für alle Wortwitze zusammen " + durationOfProgramm.toMinutes() + " Minuten, "
              + secondsOfProgramm + " Sekunden und " + millisOfProgramm + " Milisekunden gebraucht.");
    } else {
      JOptionPane.showMessageDialog(null,
          "Das kannst du besser, du hast für alle Wortwitze zusammen ganze " + durationOfProgramm.toMinutes()
              + " Minuten, " + secondsOfProgramm + " Sekunden und " + millisOfProgramm + " Milisekunden gebraucht...");
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
