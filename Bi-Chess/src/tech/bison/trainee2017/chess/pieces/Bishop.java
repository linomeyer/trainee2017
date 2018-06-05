package tech.bison.trainee2017.chess.pieces;

import tech.bison.trainee2017.chess.Movement;

public class Bishop extends Piece {

  public Bishop() {
    super(Color.WHITE);
  }

  public Bishop(Color color) {
    super(color);
  }

  @Override
  public boolean isAValidMove(Movement movement) {
    if (!super.isAMove(movement.y, movement.x)) {
      return false;
    } else {
      if (movement.x != 0 && movement.y != 0) {
        return Math.abs(movement.y) == Math.abs(movement.x);
      }
    }
    return false;
  }

  @Override
  public char getSymbol() {
    if (color.equals(Color.WHITE)) {
      return '\u2657';
    } else {
      return '\u265D';
    }
  }
}