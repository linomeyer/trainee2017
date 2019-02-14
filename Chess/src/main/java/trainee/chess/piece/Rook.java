package trainee.chess.piece;

import trainee.chess.movement.Movement;

public class Rook extends Piece {

  public Rook(Color color) {
    super(color);
  }

  @Override
  public boolean isAValidMoveOfPiece(Movement movement) {
    if (movement.getXMovement() != 0 && movement.getYMovement() == 0) {
      return true;
    } else if (movement.getXMovement() == 0 && movement.getYMovement() != 0) {
      return true;
    }
    return false;
  }

  @Override
  public String stringRepresentation() {
    return "Rook";
  }
}
