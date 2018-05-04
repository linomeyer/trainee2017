package tech.bison.trainee2017.chess;

public abstract class Figure {
  colors color;

  public enum colors {
    WHITE, BLACK
  }

  public boolean isAValidMove(String startPosition, String endPosition) {
    try {
      return isAValidMove(new Square(startPosition), new Square(endPosition));
    } catch (InvalidPositionException e) {
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

}
