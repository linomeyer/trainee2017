package trainee.chess.piece;

import static org.junit.Assert.assertThat;

import org.junit.Test;

import static org.hamcrest.CoreMatchers.is;

import trainee.chess.Square;
import trainee.chess.movement.Movement;
import trainee.chess.piece.Piece.Color;

public class KnightTest {
  @Test
  public void knight_knightJumpMovement_isAValidMoveOfPiece() throws Exception {
    assertThat(new Knight(Color.WHITE).isAValidMoveOfPiece(new Movement(new Square("C5"), new Square("A4"))),
        is(true));
  }

  @Test
  public void knight_horziontalMovement_isNotAValdidMoveOfPiece() throws Exception {
    assertThat(new Knight(Color.WHITE).isAValidMoveOfPiece(new Movement(new Square("C5"), new Square("H5"))),
        is(false));
  }

  @Test
  public void knight_diagonalMovement_isNotAValdidMoveOfPiece() throws Exception {
    assertThat(new Knight(Color.WHITE).isAValidMoveOfPiece(new Movement(new Square("C5"), new Square("D4"))),
        is(false));
  }
}
