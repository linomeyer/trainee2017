package tech.bison.trainee2017.chess;

public class King extends Figure {

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
      if (movement.x <= 1 && movement.x >= -1 && movement.y <= 1 && movement.y >= -1) {
        return true;
      }
    }
    return false;
  }

}
