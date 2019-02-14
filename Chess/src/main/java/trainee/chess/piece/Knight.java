package trainee.chess.piece;

import trainee.chess.movement.Movement;

public class Knight extends Piece {

  public Knight(Color color) {
    super(color);
  }

  @Override
  public boolean isAValidMoveOfPiece(Movement movement) {
    int xPositive = Math.abs(movement.getXMovement());
    int yPositive = Math.abs(movement.getYMovement());

    if ((xPositive == 2 && yPositive == 1) || (xPositive == 1 && yPositive == 2)) {
      return true;
    }
    return false;
  }

  @Override
  public String stringRepresentation() {
    return "Knight";
  }

}
