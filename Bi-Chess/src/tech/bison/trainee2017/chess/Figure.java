package tech.bison.trainee2017.chess;

public class Figure {
  public boolean isAValidMove(String startPostition, String endPosition) {
    try {
      return isAValidMove(new Position(startPostition), new Position(endPosition));
    } catch (InvalidPositionException e) {
      return false;
    }
  }

  public boolean isAValidMove(Position start, Position end) {
    Movement calculateMovement = new Movement(start, end);
    return isAValidMove(calculateMovement);
  }

  protected boolean isAValidMove(Movement movement) {
    return false;
  }

  protected static boolean isAMove(int xMovement, int yMovement) {
    if (xMovement == 0 && yMovement == 0) {
      return false;
    }
    return true;
  }

}
