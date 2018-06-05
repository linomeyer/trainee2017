package tech.bison.trainee2017.chess.pieces;

import tech.bison.trainee2017.chess.Movement;

public class King extends Piece {

  public King() {
    super(Color.WHITE);
  }

  public King(Color color) {
    super(color);
  }

  @Override
  public boolean isAValidMove(Movement movement) {
    if (!super.isAMove(movement.y, movement.x)) {
      return false;
    } else {
      if (movement.x <= 1 && movement.x >= -1 && movement.y <= 1 && movement.y >= -1) {
        return true;
      }
    }
    return false;
  }

  @Override
  public char getSymbol() {
    if (color.equals(Color.WHITE)) {
      return '\u2654';
    } else {
      return '\u265A';
    }
  }
}
