package tech.bison.trainee2017.kata;

public class Position {
  final int x;
  final int y;

  public Position(String position) {
    x = Integer.parseInt(position.charAt(0) + "");
    y = letterConverter(position.charAt(1) + "");
  }

  public int letterConverter(String letter) {
    String lowerCaseLetter = letter.toLowerCase();
    switch (lowerCaseLetter) {
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
      return 10;
    }
  }
}
