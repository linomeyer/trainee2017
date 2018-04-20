package tech.bison.trainee2017.chess;

public class Queen extends Figure {

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
      if (yMovement != 0 && xMovement != 0) {
        return Math.abs(yMovement) == Math.abs(xMovement);
      }
    }
    return true;
  }

}
