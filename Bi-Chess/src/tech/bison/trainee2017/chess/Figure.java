package tech.bison.trainee2017.chess;

public class Figure {
  Position start;
  Position end;
  int xMovement;
  int yMovement;

  static boolean isAMove(int xMovement, int yMovement) {
    if (xMovement == 0 && yMovement == 0) {
      return false;
    }
    return true;
  }

  public Movement calculateMovement(String startPosition, String endPosition) throws InvalidPositionException {
    Position start = new Position(startPosition);
    Position end = new Position(endPosition);

    return new Movement(start, end);
  }

}
