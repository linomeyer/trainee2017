package tech.bison.trainee2017.chess.pieces;

import tech.bison.trainee2017.chess.Movement;

public class Knight extends Piece {

  public Knight() {
    super(Color.WHITE);
  }

  public Knight(Color color) {
    super(color);
  }

  @Override
  public boolean isAValidMove(Movement movement) {
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

  @Override
  public char getSymbol() {
    if (color.equals(Color.WHITE)) {
      return '\u2658';
    } else {
      return '\u265E';
    }
  }
}
