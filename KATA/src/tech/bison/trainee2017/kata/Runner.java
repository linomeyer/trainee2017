package tech.bison.trainee2017.kata;

public class Runner extends Figure {
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
      if (xMovement != 0 && yMovement != 0) {
        return Math.abs(xMovement) == Math.abs(yMovement);
      }
    }
    return false;
  }

}