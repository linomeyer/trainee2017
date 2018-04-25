package tech.bison.trainee2017.chess;

public class Movement {

  public final Position start;
  public final Position end;
  public final int x;
  public final int y;

  public Movement(Position startPosition, Position endPosition) {
    this.start = startPosition;
    this.end = endPosition;

    x = endPosition.x - startPosition.x;
    y = endPosition.y - startPosition.y;
  }

}
