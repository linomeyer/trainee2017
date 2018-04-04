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

    String eingabe = JOptionPane.showInputDialog("Mit welcher Figur wollen Sie fahren?\n" + "t = Turm\n"
        + "s = Springer\n" + "l = Läufer\n" + "q = Königin\n" + "k = König\n" + "b = Bauer");

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
    default:
      main(null);
      break;
    }
  }

  private static void farmer() {
    String collorOfFarmer = JOptionPane
        .showInputDialog("Welche Farbe hat der Bauer?\n" + "w = weiss\n" + "s = schwarz");
    if (collorOfFarmer.toLowerCase() == "w") {
      validMove = whiteFarmer.move(getStartPosition(), getEndPosition());
      output("Weisser Bauer", whiteFarmer.start, whiteFarmer.end);
    } else {
      if (collorOfFarmer.toLowerCase() == "s") {
        validMove = blackFarmer.move(getStartPosition(), getEndPosition());
        output("Schwarzer Bauer", blackFarmer.start, blackFarmer.end);
      } else {
        farmer();
      }
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
    return JOptionPane.showInputDialog("Geben Sie die Startposition ein: ");
  }

  private static String getEndPosition() {
    return JOptionPane.showInputDialog("Geben Sie die Endposition ein: ");
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
