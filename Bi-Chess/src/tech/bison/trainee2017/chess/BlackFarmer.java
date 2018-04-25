package tech.bison.trainee2017.chess;

public class BlackFarmer extends Farmer {

  @Override
  protected boolean isAValidMove(Movement movement) {
    if (!super.isAMove(movement.y, movement.x)) {
      return false;
    } else {
      if (movement.x != 0) {
        return false;
      }
      if (movement.startPosition.y == 7 && movement.endPosition.y == 5) {
        return true;
      } else {
        if (movement.y == -1) {
          return true;
        }
      }
    }
    return false;
  }
}
