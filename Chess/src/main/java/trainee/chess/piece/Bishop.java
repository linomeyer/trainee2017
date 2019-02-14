package trainee.chess.piece;

import trainee.chess.movement.Movement;

public class Bishop extends Piece {

  public Bishop(Color color) {
    super(color);
  }

  @Override
  protected boolean isAValidMoveOfPiece(Movement movement) {
    int x = movement.getXMovement();
    int y = movement.getYMovement();
    if (Math.abs(x) == Math.abs(y)) {
      return true;
    }
    return false;
  }

  @Override
  public String stringRepresentation() {
    return "Bishop";
  }
}
