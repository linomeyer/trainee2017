package tech.bison.trainee2017.chess;

public class King extends Piece {

  public King() {
  }

  public King(Color color) {
    this.color = color;
  }

  @Override
  protected boolean isAValidMove(Movement movement) {
    if (!super.isAMove(movement.y, movement.x)) {
      return false;
    } else {
      if (movement.x <= 1 && movement.x >= -1 && movement.y <= 1 && movement.y >= -1) {
        return true;
      }
    }
    return false;
  }

}
