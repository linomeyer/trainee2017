package tech.bison.trainee2017.kata;

public class Farmer extends Figure {
  public boolean move(String startPosition, String endPosition) {

    Position start = new Position(startPosition);
    Position end = new Position(endPosition);

    if (!super.isInField(end) || !super.isInField(start))
      return false;

    int xMovement = end.x - start.x;
    int yMovement = end.y - start.y;

    return isAValidMove(xMovement, yMovement, start, end);
  }

  private boolean isAValidMove(int xMovement, int yMovement, Position start, Position end) {
    if (!super.isAMove(xMovement, yMovement)) {
      return false;
    } else {
      if (yMovement != 0) {
        return false;
      }
      if ((start.x == 2 && end.x == 4) || (start.x == 7 && end.y == 5)) {
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
