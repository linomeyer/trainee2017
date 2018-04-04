package tech.bison.trainee2017.chess;

public class WhiteFarmer extends Farmer {
  public boolean move(String startPosition, String endPosition) {
    boolean move = super.move(startPosition, endPosition);
    return isAValidMove() && move;
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
