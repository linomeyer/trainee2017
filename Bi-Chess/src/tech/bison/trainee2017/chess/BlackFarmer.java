package tech.bison.trainee2017.chess;

public class BlackFarmer extends Farmer {
  public boolean isAValidMove(String startPosition, String endPosition) throws InvalidPositionException {
    boolean move = super.isAValidMove(startPosition, endPosition);
    return isAValidMove() && move;
  }

  private boolean isAValidMove() {
    if (!super.isAMove(yMovement, xMovement)) {
      return false;
    } else {
      if (xMovement != 0) {
        return false;
      }
      if (start.y == 7 && end.y == 5) {
        return true;
      } else {
        if (yMovement == -1) {
          return true;
        }
      }
    }
    return false;
  }
}
