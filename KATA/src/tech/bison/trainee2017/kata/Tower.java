package tech.bison.trainee2017.kata;

public class Tower extends Figure {
  public boolean move(String startPosition, String endPosition) {
    boolean move = super.move(startPosition, endPosition);
    return isAValidMove() && move;
  }

  private boolean isAValidMove() {
    if (!super.isAMove(xMovement, yMovement)) {
      return false;
    } else {
      if (xMovement != 0 && yMovement != 0) {
        return false;
      }
    }
    return true;
  }

}
