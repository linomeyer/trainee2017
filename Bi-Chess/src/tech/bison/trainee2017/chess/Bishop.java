package tech.bison.trainee2017.chess;

public class Bishop extends Piece {

  public Bishop() {
  }

  public Bishop(Color color) {
    this.color = color;
  }

  @Override
  protected boolean isAValidMove(Movement movement) {
    if (!super.isAMove(movement.y, movement.x)) {
      return false;
    } else {
      if (movement.x != 0 && movement.y != 0) {
        return Math.abs(movement.y) == Math.abs(movement.x);
      }
    }
    return false;
  }

}