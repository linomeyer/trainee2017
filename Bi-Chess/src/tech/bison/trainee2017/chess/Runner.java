package tech.bison.trainee2017.chess;

public class Runner extends Figure {
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
      if (xMovement != 0 && yMovement != 0) {
        return Math.abs(yMovement) == Math.abs(xMovement);
      }
    }
    return false;
  }

}