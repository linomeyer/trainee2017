package tech.bison.trainee2017.chess;

public class WhiteFarmer extends Farmer {
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
      if (movement.x != 0) {
        return false;
      }
      if (movement.startPosition.y == 2 && movement.endPosition.y == 4) {
        return true;
      } else {
        if (movement.y == 1) {
          return true;
        }
      }
    }
    return false;
  }
}
