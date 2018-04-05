package tech.bison.trainee2017.chess;

import javax.swing.JOptionPane;

public class GUI {
  static WhiteFarmer whiteFarmer = new WhiteFarmer();
  static BlackFarmer blackFarmer = new BlackFarmer();
  static Tower tower = new Tower();
  static Horse horse = new Horse();
  static Runner runner = new Runner();
  static Queen queen = new Queen();
  static King king = new King();
  static boolean validMove;

  public static void main(String[] args) {
    boolean repeat = true;

    String eingabe = JOptionPane.showInputDialog("Mit welcher Figur wollen Sie fahren?\n" + "t = Turm\n"
        + "s = Springer\n" + "l = Läufer\n" + "q = Königin\n" + "k = König\n" + "b = Bauer\n" + "c = Programm beenden");
    try {
      switch (eingabe.toLowerCase()) {
      case "t":
        tower();
        break;
      case "s":
        horse();
        break;
      case "l":
        runner();
        break;
      case "q":
        queen();
        break;
      case "k":
        king();
        break;
      case "b":
        farmer();
        break;
      case "c":
        repeat = false;
        break;
      default:
        break;
      }

    } catch (NullPointerException e) {
      JOptionPane.showMessageDialog(null,
          "Bitte schliessen Sie nicht das Fenster.\nGeben Sie \"c\" in das Eingabefeld ein und drücken Sie ENTER");
    } catch (NumberFormatException e) {
      JOptionPane.showMessageDialog(null,
          "Es wurde ein ungültiger Wert eingegeben!\nAchten sie darauf, dass sie bei der Position,zuerst\nden Buchstaben und dann die Zahl eingeben! Beispiel: c4");
    } catch (StringIndexOutOfBoundsException e) {
      JOptionPane.showMessageDialog(null,
          "Es wurden keine Werte eingegebn.\nBitte geben Sie in alle Felder Werte ein.");
    } catch (Exception e) {
      JOptionPane.showMessageDialog(null,
          "Es ist ein Fehler aufgetreten!\nEr wird bald behoben.\nBesten Dank für ihr Verständnis.");
    }

    if (repeat) {
      main(null);
    }
  }

  private static void farmer() {
    String collorOfFarmer = JOptionPane
        .showInputDialog("Welche Farbe hat der Bauer?\n" + "w = weiss\n" + "s = schwarz");
    switch (collorOfFarmer.toLowerCase()) {
    case "w":
      validMove = whiteFarmer.move(getStartPosition(), getEndPosition());
      output("Weisser Bauer", whiteFarmer.start, whiteFarmer.end);
      break;
    case "s":
      validMove = blackFarmer.move(getStartPosition(), getEndPosition());
      output("Schwarzer Bauer", blackFarmer.start, blackFarmer.end);
      break;
    default:
      farmer();
    }
  }

  private static void king() {
    validMove = king.move(getStartPosition(), getEndPosition());
    output("König", king.start, king.end);
  }

  private static void queen() {
    validMove = queen.move(getStartPosition(), getEndPosition());
    output("Königin", queen.start, queen.end);
  }

  private static void runner() {
    validMove = runner.move(getStartPosition(), getEndPosition());
    output("Läufer", runner.start, runner.end);
  }

  private static void horse() {
    validMove = horse.move(getStartPosition(), getEndPosition());
    output("Springer", horse.start, horse.end);
  }

  private static void tower() {
    validMove = tower.move(getStartPosition(), getEndPosition());
    output("Turm", tower.start, tower.end);
  }

  private static String getStartPosition() {
    return JOptionPane.showInputDialog(
        "Geben Sie die Startposition ein [z.B. c4]:\nEs werden nur die ersten beiden Stellen beachtet! ");
  }

  private static String getEndPosition() {
    return JOptionPane.showInputDialog(
        "Geben Sie die Endposition ein [z.B. d6]:\nEs werden nur die ersten beiden Stellen beachtet! ");
  }

  private static void output(String figureName, Position start, Position end) {
    if (validMove) {
      JOptionPane.showMessageDialog(null, "Der Zug mit der Figur " + figureName + " vom Feld " + start.getPosition()
          + " auf das Feld " + end.getPosition() + " ist gültig.");
    } else {
      JOptionPane.showMessageDialog(null, "Der Zug mit der Figur " + figureName + " vom Feld " + start.getPosition()
          + " auf das Feld " + end.getPosition() + " ist nicht gültig.");
    }

  }
}
