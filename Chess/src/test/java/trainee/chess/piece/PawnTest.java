package trainee.chess.piece;

import static org.junit.Assert.assertThat;

import org.junit.Test;

import static org.hamcrest.CoreMatchers.is;

import trainee.chess.Square;
import trainee.chess.movement.Movement;
import trainee.chess.piece.Piece.Color;

public class PawnTest {
  @Test
  public void whitePawn_upwardsMovement_isAValidMoveOfPiece() throws Exception {
    Pawn pawn = new Pawn(Color.WHITE);

    boolean aValidMoveOfPiece = pawn.isAValidMoveOfPiece(new Movement(new Square("A2"), new Square("A3")));

    assertThat(aValidMoveOfPiece, is(true));
  }

  @Test
  public void whitePawn_downwardsMovement_isNotAValidMoveOfPiece() throws Exception {
    Pawn pawn = new Pawn(Color.WHITE);

    boolean aValidMoveOfPiece = pawn.isAValidMoveOfPiece(new Movement(new Square("A2"), new Square("A1")));

    assertThat(aValidMoveOfPiece, is(false));
  }

  @Test
  public void blackPawn_upwardsMovement_isNotAValidMoveOfPiece() throws Exception {
    Pawn pawn = new Pawn(Color.BLACK);

    boolean aValidMoveOfPiece = pawn.isAValidMoveOfPiece(new Movement(new Square("A2"), new Square("A3")));

    assertThat(aValidMoveOfPiece, is(false));
  }

  @Test
  public void blackPawn_downwardsMovement_isAValidMoveOfPiece() throws Exception {
    Pawn pawn = new Pawn(Color.BLACK);

    boolean aValidMoveOfPiece = pawn.isAValidMoveOfPiece(new Movement(new Square("A2"), new Square("A1")));

    assertThat(aValidMoveOfPiece, is(true));
  }

  @Test
  public void pawnFirstMove_2upwards_isAValidMoveOfPiece() throws Exception {
    Pawn pawn = new Pawn(Color.WHITE);

    boolean aValidMove = pawn.isAValidMoveOfPiece(new Movement(new Square("A1"), new Square("A3")));

    assertThat(aValidMove, is(true));
  }

  @Test
  public void pawnSecondMove_2upwards_isNotAValidMoveOfPiece() throws Exception {
    Pawn pawn = new Pawn(Color.BLACK);

    pawn.incrementMoveCount();
    boolean aValidMoveOfPiece = pawn.isAValidMoveOfPiece(new Movement(new Square("A1"), new Square("A3")));

    assertThat(aValidMoveOfPiece, is(false));
  }
}
