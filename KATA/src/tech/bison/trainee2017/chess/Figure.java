package tech.bison.trainee2017.chess;

public abstract class Figure {
  Position start;
  Position end;
  int xMovement;
  int yMovement;

  protected boolean move(String startPosition, String endPosition) {

    start = new Position(startPosition);
    end = new Position(endPosition);

    if (!isInField(end) || !isInField(start)) {
      return false;
    }

    xMovement = end.x - start.x;
    yMovement = end.y - start.y;

    return true;
  }

  static boolean isInField(Position position) {
    if (position.x < 1 || position.x > 8 || position.y == 10) {
      return false;
    }
    return true;
  }

  static boolean isAMove(int xMovement, int yMovement) {
    if (xMovement == 0 && yMovement == 0) {
      return false;
    }
    return true;
  }

}
