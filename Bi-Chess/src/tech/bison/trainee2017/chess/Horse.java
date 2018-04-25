package tech.bison.trainee2017.chess;

public class Horse extends Figure {
  public boolean isAValidMove(String startPosition, String endPosition) {
    try {
      Movement calculateMovement = calculateMovement(startPosition, endPosition);
      return isAValidMove(calculateMovement);
    } catch (InvalidPositionException e) {
      return false;
    }
  }

  private boolean isAValidMove(Movement movement) {
    if (!super.isAMove(movement.y, movement.x)) {
      return false;
    } else {
      if ((Math.abs(movement.x) == 2 && Math.abs(movement.y) == 1)
          || (Math.abs(movement.x) == 1 && Math.abs(movement.y) == 2)) {
        return true;
      }
    }
    return false;
  }
}
