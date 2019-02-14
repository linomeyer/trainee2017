package trainee.chess.piece;

import static org.junit.Assert.assertThat;

import org.junit.Test;

import static org.hamcrest.CoreMatchers.is;

import trainee.chess.Square;
import trainee.chess.movement.Movement;
import trainee.chess.piece.Piece.Color;

public class PieceTest {
  @Test
  public void piece_isMoving_true() throws Exception {
    Pawn pawn = new Pawn(Color.WHITE);
    boolean isMoving = pawn.isMoving(new Movement(new Square("A1"), new Square("A2")));
    assertThat(isMoving, is(true));
  }

  @Test
  public void piece_isMoving_false() throws Exception {
    Pawn pawn = new Pawn(Color.WHITE);

    boolean isMoving = pawn.isMoving(new Movement(new Square("A1"), new Square("A1")));

    assertThat(isMoving, is(false));
  }
}
