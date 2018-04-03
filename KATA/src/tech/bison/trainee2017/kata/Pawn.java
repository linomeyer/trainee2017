package tech.bison.trainee2017.kata;

public class Pawn extends Figure {
  public boolean move(String startPosition, String endPosition) {

    Position start = new Position(startPosition);
    Position end = new Position(endPosition);

    if (!super.isInField(end) || !super.isInField(start))
      return false;

    int xMovement = end.x - start.x;
    int yMovement = end.y - start.y;

    return isAValidMove(xMovement, yMovement, start.x, end.x);
  }

  private boolean isAValidMove(int xMovement, int yMovement, int xOfStartPosition, int xOfEndPosition) {
    if (!super.isAMove(xMovement, yMovement)) {
      return false;
    } else {
      if (yMovement != 0) {
        return false;
      }
      if ((xOfStartPosition == 2 && xOfEndPosition == 4) || (xOfStartPosition == 7 && xOfEndPosition == 5)) {
        return true;
      } else {
        if (Math.abs(xMovement) == 1) {
          return true;
        }
      }
    }
    return false;
  }
}
