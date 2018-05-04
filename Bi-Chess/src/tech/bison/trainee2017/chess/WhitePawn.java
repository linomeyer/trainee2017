package tech.bison.trainee2017.chess;

public class WhitePawn extends Pawn {
  public WhitePawn() {
    color = colors.WHITE;
  }

  @Override
  protected boolean isAValidMove(Movement movement) {
    if (!super.isAMove(movement.y, movement.x)) {
      return false;
    } else {
      if (movement.x != 0) {
        return false;
      }
      if (movement.start.y == 2 && movement.end.y == 4) {
        return true;
      } else {
        if (movement.y == 1) {
          return true;
        }
      }
    }
    return false;
  }
}
