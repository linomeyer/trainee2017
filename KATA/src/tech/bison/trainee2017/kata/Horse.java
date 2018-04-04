package tech.bison.trainee2017.kata;

public class Horse extends Figure {
  public boolean move(String startPosition, String endPosition) {

    Position start = new Position(startPosition);
    Position end = new Position(endPosition);

    if (!super.isInField(end) || !super.isInField(start))
      return false;

    int xMovement = end.x - start.x;
    int yMovement = end.y - start.y;

    return isAValidMove(xMovement, yMovement);
  }

  private boolean isAValidMove(int xMovement, int yMovement) {
    if (!super.isAMove(xMovement, yMovement)) {
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
