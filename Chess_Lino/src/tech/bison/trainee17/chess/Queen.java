package tech.bison.trainee17.chess;

public class Queen extends Figure {

  public Queen(color colors) {
    super();
    if (colors == color.white) {
      startPosition = new Position("1d");
    } else if (colors == color.black) {
      startPosition = new Position("8d");
    }
  }

  /**
   * {@value #startPosition}
   */
  public boolean move(String endPosition) {
    try {
      boolean move = super.move(endPosition);
      if (isAValidMove() && move) {
        startPosition = this.endPosition;
        return true;
      }
      return false;
    } catch (Exception e) {
      return false;
    }
  }

  private boolean isAValidMove() {
    if (super.isAMove(yMovement, xMovement) == false) {
      return false;
    } else {
      if (yMovement != 0 && xMovement != 0) {
        return Math.abs(yMovement) == Math.abs(xMovement);
      }
    }
    return true;
  }
}
