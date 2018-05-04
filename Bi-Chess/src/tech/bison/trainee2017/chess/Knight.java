package tech.bison.trainee2017.chess;

public class Knight extends Piece {

  public Knight() {
  }

  public Knight(colors color) {
    this.color = color;
  }

  @Override
  protected boolean isAValidMove(Movement movement) {
    if (!super.isAMove(movement.y, movement.x)) {
      return false;
    } else {
      if ((Math.abs(movement.x) == 2 && Math.abs(movement.y) == 1)
          || (Math.abs(movement.x) == 1 && Math.abs(movement.y) == 2)) {
        return true;
      }
    }
    return false;
  }
}
