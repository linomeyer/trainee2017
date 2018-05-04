package tech.bison.trainee2017.chess;

import javax.swing.JOptionPane;

import org.junit.runner.notification.StoppedByUserException;

public class BiChess {
  static WhitePawn whitePawn = new WhitePawn();
  static BlackPawn blackPawn = new BlackPawn();
  static Rook rook = new Rook();
  static Knight knight = new Knight();
  static Bishop bishop = new Bishop();
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
          rook();
          break;
        case 1:
          knight();
          break;
        case 2:
          bishop();
          break;
        case 3:
          queen();
          break;
        case 4:
          king();
          break;
        case 5:
          pawn();
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

  private static void pawn() throws StoppedByUserException, InvalidSquareException {
    int collorOfFarmer = options("Farbe wählen", "Welche Farbe hat der Bauer?", new String[] { "Weiss", "Schwarz" });
    Movement movement;
    boolean validMove;
    switch (collorOfFarmer) {
    case 0:
      movement = getMovement();
      validMove = whitePawn.isAValidMove(movement.start, movement.end);
      output("Weisser Bauer", movement.start, movement.end, validMove);
      break;
    case 1:
      movement = getMovement();
      validMove = blackPawn.isAValidMove(getStartPosition(), getEndPosition());
      output("Schwarzer Bauer", movement.start, movement.end, validMove);
      break;
    default:
      if (!yesNoInput("Zurück zum Start?", "Wollen Sie zurück zum Start?"))
        pawn();
    }
  }

  private static void king() throws StoppedByUserException, InvalidSquareException {
    Movement movement = getMovement();
    boolean validMove = king.isAValidMove(movement.start, movement.end);
    output("König", movement.start, movement.end, validMove);
  }

  private static void queen() throws StoppedByUserException, InvalidSquareException {
    Movement movement = getMovement();
    boolean validMove = queen.isAValidMove(movement.start, movement.end);
    output("Königin", movement.start, movement.end, validMove);
  }

  private static void bishop() throws StoppedByUserException, InvalidSquareException {
    Movement movement = getMovement();
    boolean validMove = bishop.isAValidMove(movement.start, movement.end);
    output("Läufer", movement.start, movement.end, validMove);
  }

  private static void knight() throws StoppedByUserException, InvalidSquareException {
    Movement movement = getMovement();
    boolean validMove = knight.isAValidMove(movement.start, movement.end);
    output("Springer", movement.start, movement.end, validMove);
  }

  private static void rook() throws StoppedByUserException, InvalidSquareException {
    Movement movement = getMovement();
    boolean validMove = rook.isAValidMove(movement.start, movement.end);
    output("Turm", movement.start, movement.end, validMove);
  }

  private static Square getPosition(String positionName) {
    try {
      int x = 1 + options(positionName, "Geben Sie die " + positionName + " ein [z.B. C4]:",
          new String[] { "A", "B", "C", "D", "E", "F", "G", "H" });
      Square.numberConverter(x);
      int y = 1
          + options(positionName, "Geben Sie die " + positionName + " ein [z.B. C4]:\n" + Square.numberConverter(x),
              new String[] { "1", "2", "3", "4", "5", "6", "7", "8" });
      Square position = new Square(x, y);

      return position;

    } catch (InvalidSquareException e) {
      if (yesNoInput("Zurück zum Start?", "Wollen Sie zurück zum Start?")) {
        throw new StoppedByUserException();
      } else {
        return getPosition(positionName);
      }
    }

  }

  private static Square getStartPosition() {
    return getPosition("Startposition");
  }

  private static Square getEndPosition() {
    return getPosition("Endposition");
  }

  private static Movement getMovement() {
    return new Movement(getStartPosition(), getEndPosition());
  }

  private static void output(String figureName, Square start, Square end, boolean validMove)
      throws StoppedByUserException, InvalidSquareException {
    if (validMove) {
      JOptionPane.showMessageDialog(null, "Der Zug mit der Figur " + figureName + " vom Feld " + start.getSquare()
          + " auf das Feld " + end.getSquare() + " ist gültig.");
    } else {
      JOptionPane.showMessageDialog(null, "Der Zug mit der Figur " + figureName + " vom Feld " + start.getSquare()
          + " auf das Feld " + end.getSquare() + " ist nicht gültig.");
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
