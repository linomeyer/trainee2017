package trainee.chess.piece;

import trainee.chess.movement.Movement;

public class Queen extends Piece {

  public Queen(Color color) {
    super(color);
  }

  @Override
  public boolean isAValidMoveOfPiece(Movement movement) {
    int x = movement.getXMovement();
    int y = movement.getYMovement();

    if (Math.abs(x) == Math.abs(y)) {
      return true;
    } else if ((x != 0 && y == 0) || (y != 0 && x == 0)) {
      return true;
    }
    return false;
  }

  @Override
  public String stringRepresentation() {
    return "Queen";
  }

}
