package trainee.chess.piece;

import static org.junit.Assert.assertThat;

import org.junit.Test;

import static org.hamcrest.CoreMatchers.is;

import trainee.chess.Square;
import trainee.chess.movement.Movement;
import trainee.chess.piece.Piece.Color;

public class QueenTest {
  @Test
  public void queen_horizontalMovement_isAValidMoveOfPiece() throws Exception {
    assertThat(new Queen(Color.WHITE).isAValidMoveOfPiece(new Movement(new Square("A1"), new Square("C1"))),
        is(true));
  }

  @Test
  public void queen_diagonalMovement_isAValidMoveOfPiece() throws Exception {
    assertThat(new Queen(Color.WHITE).isAValidMoveOfPiece(new Movement(new Square("A1"), new Square("C1"))),
        is(true));
  }

  @Test
  public void queen_knightJumpMovement_isNotAValidMoveOfPiece() throws Exception {
    assertThat(new Queen(Color.WHITE).isAValidMoveOfPiece(new Movement(new Square("A1"), new Square("C2"))),
        is(false));
  }
}
