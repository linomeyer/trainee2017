package tech.bison.trainee2017.chess;

public abstract class Figure {
  colors color;

  public enum colors {
    WHITE, BLACK
  }

  public boolean isAValidMove(String startPosition, String endPosition) {
    try {
      return isAValidMove(new Position(startPosition), new Position(endPosition));
    } catch (InvalidPositionException e) {
      return false;
    }
  }

  public boolean isAValidMove(Position start, Position end) {
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
