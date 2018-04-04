package tech.bison.trainee2017.chess;

public class King extends Figure {

  public boolean move(String startPosition, String endPosition) {
    boolean move = super.move(startPosition, endPosition);
    return isAValidMove() && move;
  }

  private boolean isAValidMove() {
    if (!super.isAMove(xMovement, yMovement)) {
      return false;
    } else {
      if (xMovement <= 1 && xMovement >= -1 && yMovement <= 1 && yMovement >= -1) {
        return true;
      }
    }
    return false;
  }

}
