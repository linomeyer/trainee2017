package tech.bison.trainee2017.chess;

public class Movement {

  public final Square start;
  public final Square end;
  public final int x;
  public final int y;

  public Movement(Square startSquare, Square endSquare) {
    this.start = startSquare;
    this.end = endSquare;

    x = endSquare.x - startSquare.x;
    y = endSquare.y - startSquare.y;
  }

}
