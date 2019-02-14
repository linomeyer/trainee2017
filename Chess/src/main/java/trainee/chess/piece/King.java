package trainee.chess.piece;

import trainee.chess.movement.Movement;

public class King extends Piece {

  public King(Color color) {
    super(color);
  }

  @Override
  public boolean isAValidMoveOfPiece(Movement movement) {
    int x = movement.getXMovement();
    int y = movement.getYMovement();
    if (Math.abs(y) <= 1 && Math.abs(x) <= 1) {
      if (Math.abs(x) == Math.abs(y)) {
        return true;
      } else if ((x != 0 && y == 0) || (y != 0 && x == 0)) {
        return true;
      }
    }
    return false;
  }

  @Override
  public String stringRepresentation() {
    return "King";
  }

}
