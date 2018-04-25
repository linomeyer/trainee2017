package tech.bison.trainee2017.chess;

public class Figure {
  protected boolean isAValidMove(String startPostition, String endPosition) {
    try {
      return isAValidMove(new Position(startPostition), new Position(endPosition));
    } catch (InvalidPositionException e) {
      return false;
    }
  }

  protected boolean isAValidMove(Position start, Position end) {
    Movement calculateMovement = new Movement(start, end);
    return isAValidMove(calculateMovement);
  }

  protected static boolean isAMove(int xMovement, int yMovement) {
    if (xMovement == 0 && yMovement == 0) {
      return false;
    }
    return true;
  }

  protected boolean isAValidMove(Movement movement) {
    return false;
  }

}
