package tech.bison.trainee2017.chess;

public class King extends Figure {

  public boolean isAValidMove(String startPosition, String endPosition) {
    try {
      Movement calculateMovement = calculateMovement(startPosition, endPosition);
      return isAValidMove(calculateMovement);
    } catch (OutOfFieldException e) {
      return false;
    }
  }

  private boolean isAValidMove(Movement calculateMovement) {
    if (!super.isAMove(calculateMovement.y, calculateMovement.x)) {
      return false;
    } else {
      if (calculateMovement.x <= 1 && calculateMovement.x >= -1 && calculateMovement.y <= 1
          && calculateMovement.y >= -1) {
        return true;
      }
    }
    return false;
  }

}
