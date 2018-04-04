package tech.bison.trainee2017.chess;

public class Horse extends Figure {
  public boolean move(String startPosition, String endPosition) {
    boolean move = super.move(startPosition, endPosition);
    return isAValidMove() && move;
  }

  private boolean isAValidMove() {
    if (!super.isAMove(xMovement, yMovement)) {
      return false;
    } else {
      if ((Math.abs(xMovement) == 2 && Math.abs(yMovement) == 1)
          || (Math.abs(xMovement) == 1 && Math.abs(yMovement) == 2)) {
        return true;
      }
    }
    return false;
  }
}
