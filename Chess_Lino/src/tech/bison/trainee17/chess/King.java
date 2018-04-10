package tech.bison.trainee17.chess;

public class King extends Figure {

  public King(color colors) {
    super();
    if (colors == color.white) {
      startPosition = new Position("1e");
    } else if (colors == color.black) {
      startPosition = new Position("8e");
    }
  }

  public boolean move(String endPosition) {
    try {
      boolean move = super.move(endPosition);
      if (isAValidMove() && move) {
        startPosition = this.endPosition;
        return true;
      }
      return false;
    } catch (InvalidMovementException e) {
      return false;
    }
  }

  private boolean isAValidMove() {
    if (super.isAMove(yMovement, xMovement) == false) {
      return false;
    } else {
      if (xMovement <= 1 && xMovement >= -1 && yMovement <= 1 && yMovement >= -1) {
        return true;
      }
    }
    return false;
  }
}
