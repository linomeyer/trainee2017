package tech.bison.trainee2017.chess;

public abstract class Piece {
  Color color;
  private int moveCounter = 0;

  public enum Color {
    WHITE, BLACK
  }

  public boolean isAValidMove(String startSquare, String endSquare) {
    // Test basierte auf InvalidSquareException ...neu machen
    return isAValidMove(new Square(startSquare), new Square(endSquare));
  }

  public boolean isAValidMove(Square start, Square end) {
    Movement calculateMovement = new Movement(start, end);
    return isAValidMove(calculateMovement);
  }

  protected abstract boolean isAValidMove(Movement movement);

  public abstract char getSymbol();

  protected boolean isAMove(int xMovement, int yMovement) {
    if (xMovement == 0 && yMovement == 0) {
      return false;
    }
    return true;
  }

  public void incrementMoveCounter() {
    moveCounter++;
  }

  public int getMoveCounter() {
    return moveCounter;
  }

  public boolean hasMoved() {
    return moveCounter > 0;
  }

  @Override
  public boolean equals(Object obj) {
    if (this == obj)
      return true;
    if (obj == null)
      return false;
    if (getClass() != obj.getClass())
      return false;
    Piece other = (Piece) obj;
    if (color != other.color)
      return false;
    return true;
  }

}
