package tech.bison.trainee2017.chess;

public class Square {
  final int x;
  final int y;

  public Square(String square) throws InvalidSquareException {
    this(letterConverter(square.charAt(0)), yPositionConverter(square.charAt(1)));
  }

  public Square(int x, int y) throws InvalidSquareException {
    if (x > 0 && x < 9 && y > 0 && y < 9) {
      this.x = x;
      this.y = y;
    } else {
      throw new InvalidSquareException();
    }
  }

  private static int yPositionConverter(char letter) throws InvalidSquareException {
    try {
      return Integer.parseInt(String.valueOf(letter));
    } catch (NumberFormatException e) {
      throw new InvalidSquareException();
    }
  }

  static int letterConverter(char letter) throws InvalidSquareException {
    switch (Character.toLowerCase(letter)) {
    case 'a':
      return 1;
    case 'b':
      return 2;
    case 'c':
      return 3;
    case 'd':
      return 4;
    case 'e':
      return 5;
    case 'f':
      return 6;
    case 'g':
      return 7;
    case 'h':
      return 8;
    default:
      throw new InvalidSquareException(); // 10 = invalid move
    }

  }

  static char numberConverter(int number) throws InvalidSquareException {
    switch (number) {
    case 1:
      return 'A';
    case 2:
      return 'B';
    case 3:
      return 'C';
    case 4:
      return 'D';
    case 5:
      return 'E';
    case 6:
      return 'F';
    case 7:
      return 'G';
    case 8:
      return 'H';
    default:
      throw new InvalidSquareException();
    }

  }

  public String getSquare() throws InvalidSquareException {
    String position = "";
    position += numberConverter(x);
    position += y;
    return position;
  }

  @Override
  public String toString() {
    try {
      return getSquare();
    } catch (InvalidSquareException e) {
      return Integer.toString(x) + y;
    }
  }
}
