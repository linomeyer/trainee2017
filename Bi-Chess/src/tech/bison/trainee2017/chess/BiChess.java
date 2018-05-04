package tech.bison.trainee2017.chess;

import javax.swing.JOptionPane;

import org.junit.runner.notification.StoppedByUserException;

public class BiChess {
  static WhitePawn whiteFarmer = new WhitePawn();
  static BlackPawn blackFarmer = new BlackPawn();
  static Rook tower = new Rook();
  static Knight horse = new Knight();
  static Bishop runner = new Bishop();
  static Queen queen = new Queen();
  static King king = new King();
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

      } catch (StoppedByUserException e) {

      } catch (Exception e) {
        JOptionPane.showMessageDialog(null,
            "Es ist ein Fehler aufgetreten!\nEr wird bald behoben.\nBesten Dank für Ihr Verständnis.");
      }
    }

  }

  private static void farmer() throws StoppedByUserException, InvalidPositionException {
    int collorOfFarmer = options("Farbe wählen", "Welche Farbe hat der Bauer?", new String[] { "Weiss", "Schwarz" });
    Movement movement;
    boolean validMove;
    switch (collorOfFarmer) {
    case 0:
      movement = getMovement();
      validMove = whiteFarmer.isAValidMove(movement.start, movement.end);
      output("Weisser Bauer", movement.start, movement.end, validMove);
      break;
    case 1:
      movement = getMovement();
      validMove = blackFarmer.isAValidMove(getStartPosition(), getEndPosition());
      output("Schwarzer Bauer", movement.start, movement.end, validMove);
      break;
    default:
      if (!yesNoInput("Zurück zum Start?", "Wollen Sie zurück zum Start?"))
        farmer();
    }
  }

  private static void king() throws StoppedByUserException, InvalidPositionException {
    Movement movement = getMovement();
    boolean validMove = king.isAValidMove(movement.start, movement.end);
    output("König", movement.start, movement.end, validMove);
  }

  private static void queen() throws StoppedByUserException, InvalidPositionException {
    Movement movement = getMovement();
    boolean validMove = queen.isAValidMove(movement.start, movement.end);
    output("Königin", movement.start, movement.end, validMove);
  }

  private static void runner() throws StoppedByUserException, InvalidPositionException {
    Movement movement = getMovement();
    boolean validMove = runner.isAValidMove(movement.start, movement.end);
    output("Läufer", movement.start, movement.end, validMove);
  }

  private static void horse() throws StoppedByUserException, InvalidPositionException {
    Movement movement = getMovement();
    boolean validMove = horse.isAValidMove(movement.start, movement.end);
    output("Springer", movement.start, movement.end, validMove);
  }

  private static void tower() throws StoppedByUserException, InvalidPositionException {
    Movement movement = getMovement();
    boolean validMove = tower.isAValidMove(movement.start, movement.end);
    output("Turm", movement.start, movement.end, validMove);
  }

  private static Position getPosition(String positionName) {
    try {
      int x = 1 + options(positionName, "Geben Sie die " + positionName + " ein [z.B. C4]:",
          new String[] { "A", "B", "C", "D", "E", "F", "G", "H" });
      Position.numberConverter(x);
      int y = 1
          + options(positionName, "Geben Sie die " + positionName + " ein [z.B. C4]:\n" + Position.numberConverter(x),
              new String[] { "1", "2", "3", "4", "5", "6", "7", "8" });
      Position position = new Position(x, y);

      return position;

    } catch (InvalidPositionException e) {
      if (yesNoInput("Zurück zum Start?", "Wollen Sie zurück zum Start?")) {
        throw new StoppedByUserException();
      } else {
        return getPosition(positionName);
      }
    }

  }

  private static Position getStartPosition() {
    return getPosition("Startposition");
  }

  private static Position getEndPosition() {
    return getPosition("Endposition");
  }

  private static Movement getMovement() {
    return new Movement(getStartPosition(), getEndPosition());
  }

  private static void output(String figureName, Position start, Position end, boolean validMove)
      throws StoppedByUserException, InvalidPositionException {
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
