package tech.bison.trainee2017.chess.pieces;

import tech.bison.trainee2017.chess.Movement;

public class Queen extends Piece {

  public Queen() {
  }

  public Queen(Color color) {
    this.color = color;
  }

  @Override
  public boolean isAValidMove(Movement movement) {
    if (!super.isAMove(movement.y, movement.x)) {
      return false;
    } else {
      if (movement.y != 0 && movement.x != 0) {
        return Math.abs(movement.y) == Math.abs(movement.x);
      }
    }
    return true;
  }

  @Override
  public char getSymbol() {
    if (color.equals(Color.WHITE)) {
      return '\u2655';
    } else {
      return '\u265B';
    }
  }
}
