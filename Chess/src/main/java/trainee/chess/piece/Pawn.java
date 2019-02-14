package trainee.chess.piece;

import trainee.chess.movement.Movement;

public class Pawn extends Piece {

  public Pawn(Color color) {
    super(color);
  }

  @Override
  public boolean isAValidMoveOfPiece(Movement movement) {
    return getColor() == Color.BLACK ? isAValidMoveOfBlackPawn(movement) : isAValidMoveOfWhitePawn(movement);

  }

  private boolean isAValidMoveOfWhitePawn(Movement movement) {
    if (movement.getYMovement() > 0
        && movement.getYMovement() <= (!hasMoved() ? 2 : 1)
        && movement.getXMovement() == 0) {
      return true;
    }
    return false;
  }

  private boolean isAValidMoveOfBlackPawn(Movement movement) {
    if (movement.getYMovement() < 0
        && movement.getYMovement() >= (!hasMoved() ? -2 : -1)
        && movement.getXMovement() == 0) {
      return true;
    }
    return false;
  }

  @Override
  public String stringRepresentation() {
    return "Pawn";
  }
}
