package trainee.chess.piece;

import static org.junit.Assert.assertThat;

import org.junit.Test;

import static org.hamcrest.CoreMatchers.is;

import trainee.chess.Square;
import trainee.chess.movement.Movement;
import trainee.chess.piece.Piece.Color;

public class KingTest {
  @Test
  public void king_moveOneDiagonal_isAValidMoveOfPiece() throws Exception {
    assertThat(new King(Color.WHITE).isAValidMoveOfPiece(new Movement(new Square("A1"), new Square("B2"))),
        is(true));
  }

  @Test
  public void king_moveOneHorizontal_isAValidMoveOfPiece() throws Exception {
    assertThat(new King(Color.WHITE).isAValidMoveOfPiece(new Movement(new Square("A1"), new Square("B1"))),
        is(true));
  }

  @Test
  public void king_moveTwoVertical_isNotAValidMoveOfPiece() throws Exception {
    assertThat(new King(Color.WHITE).isAValidMoveOfPiece(new Movement(new Square("A1"), new Square("A3"))),
        is(false));
  }
}
