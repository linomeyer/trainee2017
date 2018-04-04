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
      springer();
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
      break;
    }
  }

  private static void farmer() {
    String collorOfFarmer = JOptionPane
        .showInputDialog("Welche Farbe hat der Bauer?\n" + "w = weiss\n" + "s = schwarz");
    if (collorOfFarmer.toLowerCase() == "w") {
      validMove = whiteFarmer.move(getStartAndEndPosition()[0], getStartAndEndPosition()[1]);
    } else {
      if (collorOfFarmer.toLowerCase() == "s") {
        validMove = blackFarmer.move(getStartAndEndPosition()[0], getStartAndEndPosition()[1]);
      }
    }
  }

  private static void king() {
    getStartAndEndPosition();
  }

  private static void queen() {
    getStartAndEndPosition();
  }

  private static void runner() {
    getStartAndEndPosition();
  }

  private static void springer() {
    getStartAndEndPosition();
  }

  private static void tower() {
    getStartAndEndPosition();
  }

  private static String[] getStartAndEndPosition() {
    String[] position = new String[2];
    position[0] = JOptionPane.showInputDialog("Geben Sie die Startposition ein: ");
    position[1] = JOptionPane.showInputDialog("Geben Sie die Endposition ein: ");

    return position;
  }
}
