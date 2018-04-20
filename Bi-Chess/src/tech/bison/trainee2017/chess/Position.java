package tech.bison.trainee2017.chess;

public class Position {
  final int x;
  final int y;

  public Position(String position) throws OutOfFieldException {
    try {
      y = Integer.parseInt(position.charAt(1) + "");
    } catch (NumberFormatException e) {
      throw new OutOfFieldException();
    }
    x = letterConverter(position.charAt(0) + "");
  }

  public Position(int x, int y) {
    this.x = x;
    this.y = y;
  }

  static int letterConverter(String letter) throws OutOfFieldException {
    switch (letter.toLowerCase()) {
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
      throw new OutOfFieldException(); // 10 = invalid move
    }

  }

  static String numberConverter(int number) throws OutOfFieldException {
    switch (number) {
    case 1:
      return "A";
    case 2:
      return "B";
    case 3:
      return "C";
    case 4:
      return "D";
    case 5:
      return "E";
    case 6:
      return "F";
    case 7:
      return "G";
    case 8:
      return "H";
    default:
      throw new OutOfFieldException();
    }

  }

  public String getPosition() throws OutOfFieldException {
    String position = "";
    position += numberConverter(x);
    position += y;
    return position;
  }

  @Override
  public String toString() {
    try {
      return getPosition();
    } catch (OutOfFieldException e) {
      return Integer.toString(x) + y;
    }
  }
}
