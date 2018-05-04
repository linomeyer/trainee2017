package tech.bison.trainee2017.chess;

public class Movement {

  public final Square start;
  public final Square end;
  public final int x;
  public final int y;

  public Movement(Square startPosition, Square endPosition) {
    this.start = startPosition;
    this.end = endPosition;

    x = endPosition.x - startPosition.x;
    y = endPosition.y - startPosition.y;
  }

}
