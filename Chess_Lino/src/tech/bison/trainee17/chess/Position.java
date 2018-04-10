package tech.bison.trainee17.chess;

public class Position {
  public int x;
  public int y;

  public Position(String position) {
    try {
      x = Integer.parseInt(String.valueOf(position.charAt(0)));
      y = convertToInt(String.valueOf(position.charAt(1)));
    } catch (Exception e) {
      /* GUI Methode */
    }
  }

  public String getStringPosition() {
    return x + convertToString(y);
  }

  private static int convertToInt(String y) throws InvalidMovementException {
    switch (y.toLowerCase()) {
    case "a":
      return 1;
    case "b":
      return 2;
    case "c":
      return 3;
    case "d":
      return 4;
    case "e":
      return 5;
    case "f":
      return 6;
    case "g":
      return 7;
    case "h":
      return 8;
    default:
      throw new InvalidMovementException();
    }
  }

  public static String convertToString(int y) {
    switch (y) {
    case 1:
      return "a";
    case 2:
      return "b";
    case 3:
      return "c";
    case 4:
      return "d";
    case 5:
      return "e";
    case 6:
      return "f";
    case 7:
      return "g";
    case 8:
      return "h";
    default:
      return "";
    }
  }
}
