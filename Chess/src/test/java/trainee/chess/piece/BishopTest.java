package trainee.chess.piece;

import static org.junit.Assert.assertThat;

import org.junit.Test;

import static org.hamcrest.CoreMatchers.is;

import trainee.chess.Square;
import trainee.chess.movement.Movement;
import trainee.chess.piece.Piece.Color;

public class BishopTest {
  @Test
  public void bishop_upLeftDiagonalMovement_isAValidMoveOfPiece() throws Exception {
    Bishop bishop = new Bishop(Color.BLACK);

    assertThat(bishop.isAValidMoveOfPiece(new Movement(new Square("C1"), new Square("A3"))), is(true));
  }

  @Test
  public void bishop_horizontalMovement_isNotAValidMoveOfPiece() throws Exception {
    assertThat(new Bishop(Color.WHITE).isAValidMoveOfPiece(new Movement(new Square("A1"), new Square("B1"))),
        is(false));
  }

  @Test
  public void bishop_knightJumpMovement_isNotAValidMoveOfPiece() throws Exception {
    assertThat(new Bishop(Color.WHITE).isAValidMoveOfPiece(new Movement(new Square("A1"), new Square("B3"))),
        is(false));
  }
}
