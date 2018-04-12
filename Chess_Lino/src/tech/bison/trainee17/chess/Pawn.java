package tech.bison.trainee17.chess;

public class Pawn extends Figure {
  public color colors;

  public Pawn(color colors, int numberOfFigure) {
    positionOfPawn(colors, numberOfFigure);
    this.colors = colors;
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
      if (yMovement != 0) {
        return false;
      }
      if (startPosition.x == 2 && endPosition.x == 4 || startPosition.x == 7 && endPosition.x == 5) {
        return true;
      }
      if (colors == color.black && xMovement == -1) {
        return true;
      } else if (colors == color.white && xMovement == 1) {
        return true;
      }
    }
    return false;
  }

  private void positionOfPawn(color colors, int numberOfFigure) {
    if (colors == color.white) {
      switch (numberOfFigure) {
      case 1:
        startPosition = new Position("2a");
        break;
      case 2:
        startPosition = new Position("2b");
        break;
      case 3:
        startPosition = new Position("2c");
        break;
      case 4:
        startPosition = new Position("2d");
        break;
      case 5:
        startPosition = new Position("2e");
        break;
      case 6:
        startPosition = new Position("2f");
        break;
      case 7:
        startPosition = new Position("2g");
        break;
      case 8:
        startPosition = new Position("2h");
        break;
      default:
        System.err.println("falsche Position");
        break;
      }

    } else if (colors == color.black) {
      switch (numberOfFigure) {
      case 1:
        startPosition = new Position("7a");
        break;
      case 2:
        startPosition = new Position("7b");
        break;
      case 3:
        startPosition = new Position("7c");
        break;
      case 4:
        startPosition = new Position("7d");
        break;
      case 5:
        startPosition = new Position("7e");
        break;
      case 6:
        startPosition = new Position("7f");
        break;
      case 7:
        startPosition = new Position("7g");
        break;
      case 8:
        startPosition = new Position("7h");
        break;
      default:
        System.err.println("falsche Position");
        break;
      }
    }
  }
}
