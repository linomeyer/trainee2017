package tech.bison.trainee2017.chess;

import static org.hamcrest.CoreMatchers.is;
import static org.junit.Assert.assertThat;

import org.junit.Test;

public class RookTest {
  @Test
  public void rook_isAllowedToMoveUp_validMove() throws Exception {
    Rook rook = new Rook();

    boolean validMove = rook.isAValidMove("e2", "e8");

    assertThat(validMove, is(true));
  }

  @Test
  public void rook_isAllowedToMoveDown_validMove() throws Exception {
    Rook rook = new Rook();

    boolean validMove = rook.isAValidMove("c7", "c4");

    assertThat(validMove, is(true));
  }

  @Test
  public void rook_isAllowedToMoveRight_validMove() throws Exception {
    Rook rook = new Rook();

    boolean validMove = rook.isAValidMove("b3", "c3");

    assertThat(validMove, is(true));
  }

  @Test
  public void rook_isAllowedToMoveLeft_validMove() throws Exception {
    Rook rook = new Rook();

    boolean validMove = rook.isAValidMove("h8", "a8");

    assertThat(validMove, is(true));
  }

  @Test
  public void rook_isAllowedToMoveDiagonal_invalidMove() throws Exception {
    Rook rook = new Rook();

    boolean validMove = rook.isAValidMove("a2", "b3");

    assertThat(validMove, is(false));
  }

  @Test
  public void rook_isAllowedToMoveWetherHorizontalVerticalOrDiagonal_invalidMove() throws Exception {
    Rook rook = new Rook();

    boolean validMove = rook.isAValidMove("c2", "d4");

    assertThat(validMove, is(false));
  }
}
