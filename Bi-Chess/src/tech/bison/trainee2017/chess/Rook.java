package tech.bison.trainee2017.chess;

public class Rook extends Piece {

  public Rook() {
  }

  public Rook(Color color) {
    this.color = color;
  }

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

  @Override
  public char getSymbol() {
    if (color.equals(Color.WHITE)) {
      return '♖';
    } else {
      return '♜';
    }
  }

}
