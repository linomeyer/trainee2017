package tech.bison.trainee2017.chess;

public class Runner extends Figure {
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
      if (movement.x != 0 && movement.y != 0) {
        return Math.abs(movement.y) == Math.abs(movement.x);
      }
    }
    return false;
  }

}