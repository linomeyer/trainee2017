package trainee.chess.piece;

import static org.junit.Assert.assertThat;

import org.junit.jupiter.api.Test;

import static org.hamcrest.CoreMatchers.is;

import trainee.chess.Square;
import trainee.chess.movement.Movement;
import trainee.chess.piece.Piece.Color;

public class RookTest {
  @Test
  void rook_horizontalMove_isAValidMoveOfPiece() throws Exception {
    Rook rook = new Rook(Color.WHITE);

    boolean isValidMoveOfRook = rook.isAValidMoveOfPiece(new Movement(new Square("A1"), new Square("H1")));

    assertThat(isValidMoveOfRook, is(true));
  }

  @Test
  void rook_verticalMove_isAValidMoveOfPiece() throws Exception {
    Rook rook = new Rook(Color.WHITE);

    boolean isValidMoveOfRook = rook.isAValidMoveOfPiece(new Movement(new Square("A1"), new Square("A5")));

    assertThat(isValidMoveOfRook, is(true));
  }

  @Test
  void rook_diagonalMove_isNotAValidMoveOfPiece() throws Exception {
    Rook rook = new Rook(Color.WHITE);

    boolean isValidMoveOfRook = rook.isAValidMoveOfPiece(new Movement(new Square("A1"), new Square("C3")));

    assertThat(isValidMoveOfRook, is(false));
  }
}
