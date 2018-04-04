package tech.bison.trainee2017.kata;

public class Position {
  final int x;
  final int y;

  public Position(String position) {
    x = Integer.parseInt(position.charAt(0) + "");
    y = letterConverter(position.charAt(1) + "");
  }

  public Position(int x, int y) {
    this.x = x;
    this.y = y;
  }

  private int letterConverter(String letter) {
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
      return 10; // 10 = invalid move
    }

  }

  private String numberConverter(int number) {
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
      return "*";
    }

  }

  public String getPosition() {
    String position = "";
    position += x;
    position += numberConverter(y);
    return position;
  }
}
