package tech.bison.trainee17.chess;

import javax.swing.JOptionPane;

public class GUI {
  static boolean repeater = true;
  static boolean validMove;
  static int color;
  static int numberOfOption = 10; // to trigger default in switch

  public static void main(String[] args) {

    while (repeater) {
      color = optionDialog("Farbe wählen", "Welche Farbe wollen Sie spielen?", new String[] { "Schwarz", "Weiss" });
      numberOfOption = optionDialog("Figur wählen", "Mit welcher Figur wolle Sie fahren?",
          new String[] { "König", "Dame", "Läufer", "Springer", "Turm", "Bauer" });
      switch (numberOfOption) {
      case 0:
        moveKing();
        break;
      case 1:
        moveQueen();
        break;
      case 2:
        moveRunner();
        break;
      case 3:
        moveJumper();
        break;
      case 4:
        moveTower();
        break;
      case 5:
        movePawn();
        break;
      default:
        repeater = endProgramm();
        break;
      }
    }
  }

  private static void movePawn() {
    if (color == 0) {
      numberOfOption = optionDialog("Figur wählen", "Mit dem Bauer auf welchem Feld wollen Sie einen Zug ausführen?",
          new String[] { PlayField.blackPawnA.startPosition.getStringPosition(),
              PlayField.blackPawnB.startPosition.getStringPosition(),
              PlayField.blackPawnC.startPosition.getStringPosition(),
              PlayField.blackPawnD.startPosition.getStringPosition(),
              PlayField.blackPawnE.startPosition.getStringPosition(),
              PlayField.blackPawnF.startPosition.getStringPosition(),
              PlayField.blackPawnG.startPosition.getStringPosition(),
              PlayField.blackPawnH.startPosition.getStringPosition() });
      validateMoveAsPawn(numberOfOption);
    } else if (color == 1) {
      numberOfOption = optionDialog("Figur wählen", "Mit dem Bauer auf welchem Feld wollen Sie einen Zug ausführen?",
          new String[] { PlayField.whitePawnA.startPosition.getStringPosition(),
              PlayField.whitePawnB.startPosition.getStringPosition(),
              PlayField.whitePawnC.startPosition.getStringPosition(),
              PlayField.whitePawnD.startPosition.getStringPosition(),
              PlayField.whitePawnE.startPosition.getStringPosition(),
              PlayField.whitePawnF.startPosition.getStringPosition(),
              PlayField.whitePawnG.startPosition.getStringPosition(),
              PlayField.whitePawnH.startPosition.getStringPosition() });
      validateMoveAsPawn(numberOfOption);
    } else {
      repeater = endProgramm();
    }
  }

  private static void moveTower() {
    if (color == 0) {
      numberOfOption = optionDialog("Figur wählen", "Mit dem Turm auf welchem Feld wollen Sie einen zug ausführen?",
          new String[] { PlayField.blackTower1.startPosition.getStringPosition(),
              PlayField.blackTower2.startPosition.getStringPosition() });
      if (numberOfOption == 0) {
        validMove = PlayField.blackTower1.move(getEndPosition(PlayField.blackTower1.startPosition));
        isMoveValid("Turm", PlayField.blackTower1.endPosition);

      } else if (numberOfOption == 1) {
        validMove = PlayField.blackTower2.move(getEndPosition(PlayField.blackTower2.startPosition));
        isMoveValid("Turm", PlayField.blackTower2.endPosition);
      } else {
        repeater = endProgramm();
      }
    }
    if (color == 1) {
      numberOfOption = optionDialog("Figur wählen", "Mit dem Turm auf welchem Feld wollen Sie einen Zug ausführen?",
          new String[] { PlayField.whiteTower1.startPosition.getStringPosition(),
              PlayField.whiteTower2.startPosition.getStringPosition() });
      if (numberOfOption == 0) {
        validMove = PlayField.whiteTower1.move(getEndPosition(PlayField.whiteTower1.startPosition));
        isMoveValid("Turm", PlayField.whiteTower1.endPosition);
      } else if (numberOfOption == 1) {
        validMove = PlayField.whiteTower2.move(getEndPosition(PlayField.whiteTower2.startPosition));
        isMoveValid("Turm", PlayField.whiteTower2.endPosition);
      } else {
        repeater = endProgramm();
      }
    }
  }

  private static void moveJumper() {
    if (color == 0) {
      numberOfOption = optionDialog("Figur wählen", "Mit dem Springer auf welchem Feld wollen Sie einen zug ausführen?",
          new String[] { PlayField.blackJumper1.startPosition.getStringPosition(),
              PlayField.blackJumper1.startPosition.getStringPosition() });
      if (numberOfOption == 0) {
        validMove = PlayField.blackJumper1.move(getEndPosition(PlayField.blackJumper1.startPosition));
        isMoveValid("Springer", PlayField.blackJumper1.endPosition);
      } else if (numberOfOption == 1) {
        validMove = PlayField.blackJumper2.move(getEndPosition(PlayField.blackJumper2.startPosition));
        isMoveValid("Springer", PlayField.blackJumper2.endPosition);
      } else {
        repeater = endProgramm();
      }
    }
    if (color == 1) {
      numberOfOption = optionDialog("Figur wählen", "Mit dem Springer auf welchem Feld wollen Sie einen Zug ausführen?",
          new String[] { PlayField.whiteJumper1.startPosition.getStringPosition(),
              PlayField.whiteJumper1.startPosition.getStringPosition() });
      if (numberOfOption == 0) {
        validMove = PlayField.whiteJumper1.move(getEndPosition(PlayField.whiteJumper1.startPosition));
        isMoveValid("Springer", PlayField.whiteJumper1.endPosition);
      } else if (numberOfOption == 1) {
        validMove = PlayField.whiteJumper2.move(getEndPosition(PlayField.whiteJumper2.startPosition));
        isMoveValid("Springer", PlayField.whiteJumper2.endPosition);
      } else {
        repeater = endProgramm();
      }
    }
  }

  private static void moveRunner() {
    if (color == 0) {
      numberOfOption = optionDialog("Figur wählen", "Mit dem Läufer auf welchem Feld wollen Sie einen zug ausführen?",
          new String[] { PlayField.blackRunner1.startPosition.getStringPosition(),
              PlayField.blackRunner1.startPosition.getStringPosition() });
      if (numberOfOption == 0) {
        validMove = PlayField.blackRunner1.move(getEndPosition(PlayField.blackRunner1.startPosition));
        isMoveValid("Läufer", PlayField.blackRunner1.endPosition);
      } else if (numberOfOption == 1) {
        validMove = PlayField.blackRunner2.move(getEndPosition(PlayField.blackRunner2.startPosition));
        isMoveValid("Läufer", PlayField.blackRunner2.endPosition);
      } else {
        repeater = endProgramm();
      }
    }
    if (color == 1) {
      numberOfOption = optionDialog("Figur wählen", "Mit dem Läufer auf welchem Feld wollen Sie einen Zug ausführen?",
          new String[] { PlayField.whiteRunner1.startPosition.getStringPosition(),
              PlayField.whiteRunner1.startPosition.getStringPosition() });
      if (numberOfOption == 0) {
        validMove = PlayField.whiteRunner1.move(getEndPosition(PlayField.whiteRunner1.startPosition));
        isMoveValid("Läufer", PlayField.whiteRunner1.endPosition);
      } else if (numberOfOption == 1) {
        validMove = PlayField.whiteRunner2.move(getEndPosition(PlayField.whiteRunner2.startPosition));
        isMoveValid("Läufer", PlayField.whiteRunner2.endPosition);
      } else {
        repeater = endProgramm();
      }
    }
  }

  private static void moveQueen() {
    if (color == 0) {
      validMove = PlayField.blackQueen.move(getEndPosition(PlayField.blackQueen.startPosition));
      isMoveValid("Königin", PlayField.blackQueen.endPosition);
    } else if (color == 1) {
      validMove = PlayField.whiteQueen.move(getEndPosition(PlayField.whiteQueen.startPosition));
      isMoveValid("Königin", PlayField.whiteQueen.endPosition);
    }
  }

  private static void moveKing() {
    if (color == 0) {
      validMove = PlayField.blackKing.move(getEndPosition(PlayField.blackKing.startPosition));
      isMoveValid("König", PlayField.blackKing.endPosition);
    } else if (color == 1) {
      validMove = PlayField.whiteKing.move(getEndPosition(PlayField.whiteKing.startPosition));
      isMoveValid("König", PlayField.whiteKing.endPosition);
    }
  }

  private static int optionDialog(String title, String input, String[] options) {
    return JOptionPane.showOptionDialog(null, input, title, 0, 3, null, options, options);
  }

  private static boolean endProgramm() {
    int input = JOptionPane.showOptionDialog(null, "Wollen Sie da Programm beenden?", "Beenden?", 1, 3, null,
        new String[] { "Ja", "Nein" }, null);
    return input != 0;
  }

  private static boolean yesNoInput(String screenTitle, String Message) {
    int input = JOptionPane.showOptionDialog(null, Message, screenTitle, 1, 3, null, new String[] { "Ja", "Nein" },
        null);
    return input == 0;
  }

  private static String getEndPosition(Position startPosition) {
    int x = 1 + optionDialog("Endposition",
        "Geben Sie die Endposition ein [ihre Position: " + startPosition.getStringPosition() + "]",
        new String[] { "1", "2", "3", "4", "5", "6", "7", "8" });
    int y;
    y = 1 + optionDialog("Endposition", "Geben Sie die Endposition ein [Ihre Position: "
        + startPosition.getStringPosition() + "]\n" + Position.getStringNumber(x),
        new String[] { "A", "B", "C", "D", "E", "F", "G", "H" });
    Position position = new Position(x, y);

    return position.getStringPosition();
  }

  private static void isMoveValid(String figureName, Position end) {
    if (validMove) {
      JOptionPane.showMessageDialog(null,
          "Der Zug mit der Figur " + figureName + "auf das Feld " + end.getStringPosition() + " ist gültig.");
    } else {
      JOptionPane.showMessageDialog(null,
          "Der Zug mit der Figur " + figureName + " auf das Feld " + end.getStringPosition() + " ist nicht gültig.");
    }
  }

  private static void validateMoveAsPawn(int numberOfOption) {
    if (color == 0) {
      switch (numberOfOption) {
      case 0:
        validMove = PlayField.blackPawnA.move(getEndPosition(PlayField.blackPawnA.startPosition));
        isMoveValid("Bauer", PlayField.blackPawnA.endPosition);
        break;
      case 1:
        validMove = PlayField.blackPawnB.move(getEndPosition(PlayField.blackPawnB.startPosition));
        isMoveValid("Bauer", PlayField.blackPawnB.endPosition);
        break;
      case 2:
        validMove = PlayField.blackPawnC.move(getEndPosition(PlayField.blackPawnC.startPosition));
        isMoveValid("Bauer", PlayField.blackPawnC.endPosition);
        break;
      case 3:
        validMove = PlayField.blackPawnD.move(getEndPosition(PlayField.blackPawnD.startPosition));
        isMoveValid("Bauer", PlayField.blackPawnD.endPosition);
        break;
      case 4:
        validMove = PlayField.blackPawnE.move(getEndPosition(PlayField.blackPawnE.startPosition));
        isMoveValid("Bauer", PlayField.blackPawnE.endPosition);
        break;
      case 5:
        validMove = PlayField.blackPawnF.move(getEndPosition(PlayField.blackPawnF.startPosition));
        isMoveValid("Bauer", PlayField.blackPawnF.endPosition);
        break;
      case 6:
        validMove = PlayField.blackPawnG.move(getEndPosition(PlayField.blackPawnG.startPosition));
        isMoveValid("Bauer", PlayField.blackPawnH.endPosition);
        break;
      case 7:
        validMove = PlayField.blackPawnH.move(getEndPosition(PlayField.blackPawnH.startPosition));
        isMoveValid("Bauer", PlayField.blackPawnH.endPosition);
        break;
      default:
        repeater = endProgramm();
        break;
      }
    } else if (color == 1) {
      switch (numberOfOption) {
      case 0:
        validMove = PlayField.whitePawnA.move(getEndPosition(PlayField.whitePawnA.startPosition));
        isMoveValid("Bauer", PlayField.whitePawnA.endPosition);
        break;
      case 1:
        validMove = PlayField.whitePawnB.move(getEndPosition(PlayField.whitePawnB.startPosition));
        isMoveValid("Bauer", PlayField.whitePawnB.endPosition);
        break;
      case 2:
        validMove = PlayField.whitePawnC.move(getEndPosition(PlayField.whitePawnC.startPosition));
        isMoveValid("Bauer", PlayField.whitePawnC.endPosition);
        break;
      case 3:
        validMove = PlayField.whitePawnD.move(getEndPosition(PlayField.whitePawnD.startPosition));
        isMoveValid("Bauer", PlayField.whitePawnD.endPosition);
        break;
      case 4:
        validMove = PlayField.whitePawnE.move(getEndPosition(PlayField.whitePawnE.startPosition));
        isMoveValid("Bauer", PlayField.whitePawnE.endPosition);
        break;
      case 5:
        validMove = PlayField.whitePawnF.move(getEndPosition(PlayField.whitePawnF.startPosition));
        isMoveValid("Bauer", PlayField.whitePawnF.endPosition);
        break;
      case 6:
        validMove = PlayField.whitePawnG.move(getEndPosition(PlayField.whitePawnG.startPosition));
        isMoveValid("Bauer", PlayField.whitePawnG.endPosition);
        break;
      case 7:
        validMove = PlayField.whitePawnH.move(getEndPosition(PlayField.whitePawnH.startPosition));
        isMoveValid("Bauer", PlayField.whitePawnH.endPosition);
        break;
      default:
        repeater = endProgramm();
        break;
      }
    }
  }

}
