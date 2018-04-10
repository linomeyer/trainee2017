package tech.bison.trainee17.chess;

public class Figure {
  public enum color {
    black, white
  }

  public Position startPosition;
  public Position endPosition;
  int xMovement;
  int yMovement;

  public boolean move(String endPos) throws InvalidMovementException {
    endPosition = new Position(endPos);

    if (isInField(endPosition) == false) {
      return false;
    }
    xMovement = endPosition.x - startPosition.x;
    yMovement = endPosition.y - startPosition.y;

    return true;
  }

  public boolean isAMove(int xMovement, int yMovement) {
    if (xMovement == 0 && yMovement == 0) {
      return false;
    } else {
      return true;
    }
  }

  public boolean isInField(Position position) {
    if (position.y < 1 || position.y > 8 || position.x < 1 || position.x > 8) {
      return false;
    } else {
      return true;
    }
  }
}
