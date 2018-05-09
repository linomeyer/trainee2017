package tech.bison.trainee2017.chess;

public abstract class Piece {
  colors color;

  public enum colors {
    WHITE, BLACK
  }

  public boolean isAValidMove(String startSquare, String endSquare) {
    try {
      return isAValidMove(new Square(startSquare), new Square(endSquare));
    } catch (InvalidSquareException e) {
      return false;
    }
  }

  public boolean isAValidMove(Square start, Square end) {
    Movement calculateMovement = new Movement(start, end);
    return isAValidMove(calculateMovement);
  }

  protected abstract boolean isAValidMove(Movement movement);

  protected boolean isAMove(int xMovement, int yMovement) {
    if (xMovement == 0 && yMovement == 0) {
      return false;
    }
    return true;
  }

  @Override
  public boolean equals(Object obj) {
    if (this == obj)
      return true;
    if (obj == null)
      return false;
    if (getClass() != obj.getClass())
      return false;
    Piece other = (Piece) obj;
    if (color != other.color)
      return false;
    return true;
  }

}
