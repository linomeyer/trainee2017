package tech.bison.trainee17.chess;

public class Runner extends Figure {

  public Runner(color colors, int numberOfFigure) {
    if (colors == color.white) {
      if (numberOfFigure == 1) {
        startPosition = new Position("1c");
      } else if (numberOfFigure == 2) {
        startPosition = new Position("1f");
      }
    } else if (colors == color.black) {
      if (numberOfFigure == 1) {
        startPosition = new Position("8c");
      } else if (numberOfFigure == 2) {
        startPosition = new Position("8f");
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
      if (xMovement != 0 && yMovement != 0) {
        return Math.abs(yMovement) == Math.abs(xMovement);
      }
    }
    return false;
  }
}
