package tech.bison.trainee2017.chess;

public class BlackFarmer extends Farmer {
  public boolean move(String startPosition, String endPosition) {
    boolean move = super.move(startPosition, endPosition);
    return isAValidMove() && move;
  }

  private boolean isAValidMove() {
    if (!super.isAMove(xMovement, yMovement)) {
      return false;
    } else {
      if (yMovement != 0) {
        return false;
      }
      if (start.x == 7 && end.x == 5) {
        return true;
      } else {
        if (xMovement == -1) {
          return true;
        }
      }
    }
    return false;
  }
}
