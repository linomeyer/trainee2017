package tech.bison.trainee2017.chess.pieces;

import tech.bison.trainee2017.chess.Movement;

public class WhitePawn extends Pawn {
  public WhitePawn() {
    super(Color.WHITE);
  }

  @Override
  public boolean isAValidMove(Movement movement) {
    if (!super.isAMove(movement.y, movement.x)) {
      return false;
    } else {
      if (movement.x != 0) {
        return false;
      }
      if (!hasMoved() && movement.y == 2) {
        return true;
      } else {
        if (movement.y == 1) {
          return true;
        }
      }
    }
    return false;
  }

  @Override
  public char getSymbol() {
    return '\u2659';
  }
}
