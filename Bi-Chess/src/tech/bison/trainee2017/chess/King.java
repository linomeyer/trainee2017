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

  private boolean isAValidMove(Movement calculatedMovement) {
    if (!super.isAMove(calculatedMovement.y, calculatedMovement.x)) {
      return false;
    } else {
      if (calculatedMovement.x <= 1 && calculatedMovement.x >= -1 && calculatedMovement.y <= 1
          && calculatedMovement.y >= -1) {
        return true;
      }
    }
    return false;
  }

}
