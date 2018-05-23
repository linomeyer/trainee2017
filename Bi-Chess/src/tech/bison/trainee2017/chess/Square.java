package tech.bison.trainee2017.chess;

public class Square {
  final int x;
  final int y;

  public Square(String square) {
    x = letterNumberConverter(square.charAt(0));
    y = Integer.parseInt(Character.toString(square.charAt(1)));
  }

  public Square(int x, int y) {
    this.x = x;
    this.y = y;
  }

  static int letterNumberConverter(char letter) {
    return ((int) Character.toLowerCase(letter)) - 96;
  }

  static char letterNumberConverter(int number) {
    return (char) (number + 96);
  }

  @Override
  public String toString() {
    return Character.toString(letterNumberConverter(x)) + y;
  }

  @Override
  public int hashCode() {
    final int prime = 31;
    int result = 1;
    result = prime * result + x;
    result = prime * result + y;
    return result;
  }

  @Override
  public boolean equals(Object obj) {
    if (this == obj)
      return true;
    if (obj == null)
      return false;
    if (getClass() != obj.getClass())
      return false;
    Square other = (Square) obj;
    if (x != other.x)
      return false;
    if (y != other.y)
      return false;
    return true;
  }

}
