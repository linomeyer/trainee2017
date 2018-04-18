package tech.bison.trainee2017.chess;

import javax.swing.JOptionPane;

import org.junit.runner.notification.StoppedByUserException;

public class GUI {
  static WhiteFarmer whiteFarmer = new WhiteFarmer();
  static BlackFarmer blackFarmer = new BlackFarmer();
  static Tower tower = new Tower();
  static Horse horse = new Horse();
  static Runner runner = new Runner();
  static Queen queen = new Queen();
  static King king = new King();
  static boolean validMove;
  static boolean repeat = true;

  public static void main(String[] args) {
    while (repeat) {
      int input = 10;
      input = options("Figur wählen", "Mit welcher Figur wollen Sie fahren?",
          new String[] { "Turm", "Springer", "Läufer", "Königin", "König", "Bauer" });

      try {
        switch (input) {
        case 0:
          tower();
          break;
        case 1:
          horse();
          break;
        case 2:
          runner();
          break;
        case 3:
          queen();
          break;
        case 4:
          king();
          break;
        case 5:
          farmer();
          break;
        default:
          repeat = !yesNoInput("Beenden?", "Wollen Sie das Programm wirklich beenden?");
          break;
        }

      }catch (StoppedByUserException e) {

      } catch (Exception e) {
        JOptionPane.showMessageDialog(null,
            "Es ist ein Fehler aufgetreten!\nEr wird bald behoben.\nBesten Dank für ihr Verständnis.");
      }
    }

  }

  private static void farmer() throws StoppedByUserException, OutOfFieldException {
    int collorOfFarmer = options("Farbe wählen", "Welche Farbe hat der Bauer?", new String[] { "Weiss", "Schwarz" });
    switch (collorOfFarmer) {
    case 0:
      validMove = whiteFarmer.move(getStartPosition(), getEndPosition());
      output("Weisser Bauer", whiteFarmer.start, whiteFarmer.end);
      break;
    case 1:
      validMove = blackFarmer.move(getStartPosition(), getEndPosition());
      output("Schwarzer Bauer", blackFarmer.start, blackFarmer.end);
      break;
    default:
      farmer();
    }
  }

  private static void king() throws StoppedByUserException, OutOfFieldException {
    validMove = king.move(getStartPosition(), getEndPosition());
    output("König", king.start, king.end);
  }

  private static void queen() throws StoppedByUserException, OutOfFieldException {
    validMove = queen.move(getStartPosition(), getEndPosition());
    output("Königin", queen.start, queen.end);
  }

  private static void runner() throws StoppedByUserException, OutOfFieldException {
    validMove = runner.move(getStartPosition(), getEndPosition());
    output("Läufer", runner.start, runner.end);
  }

  private static void horse() throws StoppedByUserException, OutOfFieldException {
    validMove = horse.move(getStartPosition(), getEndPosition());
    output("Springer", horse.start, horse.end);
  }

  private static void tower() throws StoppedByUserException, OutOfFieldException {
    validMove = tower.move(getStartPosition(), getEndPosition());
    output("Turm", tower.start, tower.end);
  }

  private static String getPosition(String positionName) {
    int x = 1 + options(positionName, "Geben Sie die " + positionName + " ein [z.B. C4]:",
        new String[] { "A", "B", "C", "D", "E", "F", "G", "H" });
    int y;
    try {
      y = 1 + options(positionName, "Geben Sie die " + positionName + " ein [z.B. C4]:\n" + Position.numberConverter(x),
          new String[] { "1", "2", "3", "4", "5", "6", "7", "8" });
      Position position = new Position(x, y);

      return position.getPosition();

    } catch (OutOfFieldException e) {
      if (yesNoInput("Zurück zum Start?", "Wollen Sie zurück zum Start?")) {
        throw new StoppedByUserException();
      } else {
        return getPosition(positionName);
      }
    }

  }

  private static String getStartPosition() {
    return getPosition("Startposition");
  }

  private static String getEndPosition() {
    return getPosition("Endposition");
  }

  private static void output(String figureName, Position start, Position end)
      throws StoppedByUserException, OutOfFieldException {
    if (validMove) {
      JOptionPane.showMessageDialog(null, "Der Zug mit der Figur " + figureName + " vom Feld " + start.getPosition()
          + " auf das Feld " + end.getPosition() + " ist gültig.");
    } else {
      JOptionPane.showMessageDialog(null, "Der Zug mit der Figur " + figureName + " vom Feld " + start.getPosition()
          + " auf das Feld " + end.getPosition() + " ist nicht gültig.");
    }

  }

  private static boolean yesNoInput(String screenTitle, String Message) {
    int input = JOptionPane.showOptionDialog(null, Message, screenTitle, 1, 3, null, new String[] { "Ja", "Nein" },
        null);
    return input == 0;
  }

  private static int options(String title, String message, String[] options) {
    return JOptionPane.showOptionDialog(null, message, title, 0, 3, null, options, options);
  }
}
