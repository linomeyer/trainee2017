package tech.bison.trainee2017.chess;

public class Position {
  final int x;
  final int y;

  public Position(String position) throws InvalidPositionException {
    y = yPositionConverter(position.charAt(1));
    try {
    } catch (NumberFormatException e) {
      throw new InvalidPositionException();
    }
    x = letterConverter(position.charAt(0));
  }

  public Position(int x, int y) {
    this.x = x;
    this.y = y;
  }

  private int yPositionConverter(char letter) throws InvalidPositionException {
    try {
      int y = Integer.parseInt(String.valueOf(letter));
      if (y > 0 && y < 9) {
        return y;
      } else {
        throw new InvalidPositionException();
      }
    } catch (NumberFormatException e) {
      throw new InvalidPositionException();
    }
  }

  static int letterConverter(char letter) throws InvalidPositionException {
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
      throw new InvalidPositionException(); // 10 = invalid move
    }

  }

  static char numberConverter(int number) throws InvalidPositionException {
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
      throw new InvalidPositionException();
    }

  }

  public String getPosition() throws InvalidPositionException {
    String position = "";
    position += numberConverter(x);
    position += y;
    return position;
  }

  @Override
  public String toString() {
    try {
      return getPosition();
    } catch (InvalidPositionException e) {
      return Integer.toString(x) + y;
    }
  }
}
