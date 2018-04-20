package tech.bison.trainee2017.chess;

public class WhiteFarmer extends Farmer {
  public boolean isAValidMove(String startPosition, String endPosition) {
    try {
      boolean move = super.isAValidMove(startPosition, endPosition);
      return isAValidMove() && move;
    } catch (InvalidPositionException e) {
      return false;
    }
  }

  private boolean isAValidMove() {
    if (!super.isAMove(yMovement, xMovement)) {
      return false;
    } else {
      if (xMovement != 0) {
        return false;
      }
      if (start.y == 2 && end.y == 4) {
        return true;
      } else {
        if (yMovement == 1) {
          return true;
        }
      }
    }
    return false;
  }
}
