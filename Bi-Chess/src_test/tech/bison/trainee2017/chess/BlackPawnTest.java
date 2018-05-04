package tech.bison.trainee2017.chess;

import static org.hamcrest.CoreMatchers.is;
import static org.junit.Assert.assertThat;

import org.junit.Test;

public class BlackPawnTest {
  @Test
  public void blackFarmer_isAllowedToMoveOneDown_validMove() throws Exception {
    BlackPawn blackPawn = new BlackPawn();

    boolean validMove = blackPawn.isAValidMove("c5", "c4");

    assertThat(validMove, is(true));
  }

  @Test
  public void blackFarmer_isAllowedToMoveTwoDownFromStartPosition_validMove() throws Exception {
    BlackPawn blackPawn = new BlackPawn();

    boolean validMove = blackPawn.isAValidMove("h7", "h5");

    assertThat(validMove, is(true));
  }

  @Test
  public void blackFarmer_isAllowedToMoveOneLeft_invalidMove() throws Exception {
    BlackPawn blackPawn = new BlackPawn();

    boolean validMove = blackPawn.isAValidMove("d4", "c4");

    assertThat(validMove, is(false));
  }

  @Test
  public void blackFarmer_isAllowedToMoveOneRight_invalidMove() throws Exception {
    BlackPawn blackPawn = new BlackPawn();

    boolean validMove = blackPawn.isAValidMove("g8", "h8");

    assertThat(validMove, is(false));
  }

  @Test
  public void blackFarmer_isAllowedToMoveOneDiagonal_invalidMove() throws Exception {
    BlackPawn blackPawn = new BlackPawn();

    boolean validMove = blackPawn.isAValidMove("a5", "b4");

    assertThat(validMove, is(false));
  }

  @Test
  public void blackFarmer_isAllowedToMoveTwoDown_invalidMove() throws Exception {
    BlackPawn blackPawn = new BlackPawn();

    boolean validMove = blackPawn.isAValidMove("d4", "d2");

    assertThat(validMove, is(false));
  }

  @Test
  public void blackFarmer_isAllowedToMoveOneUp_invalidMove() throws Exception {
    BlackPawn blackPawn = new BlackPawn();

    boolean validMove = blackPawn.isAValidMove("d4", "d5");

    assertThat(validMove, is(false));
  }
}