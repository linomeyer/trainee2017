package trainee.chess.piece;

import trainee.chess.movement.Movement;

public abstract class Piece {
  private final Color color;
  private int moveCount;

  public enum Color {
    BLACK, WHITE
  }

  public Piece(Color color) {
    this.color = color;
    moveCount = 0;
  }

  public Color getColor() {
    return color;
  }

  public void incrementMoveCount() {
    moveCount++;
  }

  public boolean hasMoved() {
    if (moveCount > 0) {
      return true;
    }
    return false;
  }

  protected abstract boolean isAValidMoveOfPiece(Movement movement);

  public boolean isAValidMove(Movement movement) {
    return isAValidMoveOfPiece(movement) && isMoving(movement);
  }

  public boolean isMoving(Movement movement) {
    if (movement.getYMovement() == 0 && movement.getXMovement() == 0) {
      return false;
    } else {
      return true;
    }
  }

  public abstract String stringRepresentation();

  @Override
  public String toString() {
    return stringRepresentation();
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
    if (moveCount != other.moveCount)
      return false;
    return true;
  }
}
