package tech.bison.trainee2017.chess;

public class Tower extends Figure {

  @Override
  protected boolean isAValidMove(Movement movement) {
    if (!super.isAMove(movement.y, movement.x)) {
      return false;
    } else {
      if (movement.y != 0 && movement.x != 0) {
        return false;
      }
    }
    return true;
  }

}
