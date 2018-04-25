package tech.bison.trainee2017.chess;

public class Movement {

  public final Position startPosition;
  public final Position endPosition;
  public final int x;
  public final int y;

  public Movement(Position startPosition, Position endPosition) {
    this.startPosition = startPosition;
    this.endPosition = endPosition;

    x = endPosition.x - startPosition.x;
    y = endPosition.y - startPosition.y;
  }

}
