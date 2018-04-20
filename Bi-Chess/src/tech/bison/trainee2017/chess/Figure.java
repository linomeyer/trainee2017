package tech.bison.trainee2017.chess;

public class Figure {
  Position start;
  Position end;
  int xMovement;
  int yMovement;

  @Deprecated
  protected boolean isAValidMove(String startPosition, String endPosition) throws InvalidPositionException {

    start = new Position(startPosition);
    end = new Position(endPosition);

    xMovement = end.x - start.x;
    yMovement = end.y - start.y;

    return true;
  }

  static boolean isAMove(int xMovement, int yMovement) {
    if (xMovement == 0 && yMovement == 0) {
      return false;
    }
    return true;
  }

  public Movement calculateMovement(String startPosition, String endPosition) throws InvalidPositionException {
    Position start = new Position(startPosition);
    Position end = new Position(endPosition);

    int xMovement = end.x - start.x;
    int yMovement = end.y - start.y;

    return new Movement(xMovement, yMovement);
  }

}
