package tech.bison.trainee2017.chess.pieces;

public abstract class Pawn extends Piece {
  public Pawn(Color color) {
    super(color);
  }

  public static Pawn createPawn(Color color) {
    if (color.equals(Color.BLACK)) {
      return new BlackPawn();
    } else if (color.equals(Color.WHITE)) {
      return new WhitePawn();
    }
    return null;
  }
}
