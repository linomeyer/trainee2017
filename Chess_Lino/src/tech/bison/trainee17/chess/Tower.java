package tech.bison.trainee17.chess;

public class Tower extends Figure {

  public Tower(color colors, int numberOfFigure) throws InvalidMovementException {
    if (colors == color.white) {
      if (numberOfFigure == 1) {
        startPosition = new Position("1a");
      } else if (numberOfFigure == 2) {
        startPosition = new Position("1h");
      } else {
        throw new InvalidMovementException();
      }
    } else if (colors == color.black) {
      if (numberOfFigure == 1) {
        startPosition = new Position("8a");
      } else if (numberOfFigure == 2) {
        startPosition = new Position("8h");
      } else {
        throw new InvalidMovementException();
      }
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
    } catch (Exception e) {
      return false;
    }
  }

  private boolean isAValidMove() {
    if (super.isAMove(yMovement, xMovement) == false) {
      return false;
    } else {
      if (yMovement != 0 && xMovement != 0) {
        return false;
      }
    }
    return true;
  }
}
