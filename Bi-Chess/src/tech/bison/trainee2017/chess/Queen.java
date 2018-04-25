package tech.bison.trainee2017.chess;

public class Queen extends Figure {

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
      if (movement.y != 0 && movement.x != 0) {
        return Math.abs(movement.y) == Math.abs(movement.x);
      }
    }
    return true;
  }

}
