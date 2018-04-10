package tech.bison.trainee17.chess;

public class Jumper extends Figure {

  public Jumper(color colors, int numberOfFigure) throws InvalidMovementException {
    if (colors == color.white) {
      if (numberOfFigure == 1) {
        startPosition = new Position("1b");
      } else if (numberOfFigure == 2) {
        startPosition = new Position("1g");
      } else {
        throw new InvalidMovementException();
      }
    } else if (colors == color.black) {
      if (numberOfFigure == 1) {
        startPosition = new Position("8b");
      } else if (numberOfFigure == 2) {
        startPosition = new Position("8g");
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
      if ((Math.abs(xMovement) == 2 && Math.abs(yMovement) == 1)
          || (Math.abs(xMovement) == 1 && Math.abs(yMovement) == 2)) {
        return true;
      }
    }
    return false;
  }
}
