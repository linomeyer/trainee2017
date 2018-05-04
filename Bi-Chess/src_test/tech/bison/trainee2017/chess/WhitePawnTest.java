package tech.bison.trainee2017.chess;

import static org.hamcrest.CoreMatchers.is;
import static org.junit.Assert.assertThat;

import org.junit.Test;

public class WhitePawnTest {

  @Test
  public void whitePawn_isAllowedToMoveOneUp_validMove() throws Exception {
    WhitePawn whitePawn = new WhitePawn();

    boolean validMove = whitePawn.isAValidMove("f7", "f8");

    assertThat(validMove, is(true));
  }

  @Test
  public void whitePawn_isAllowedToMoveTwoUpFromStartPosition_validMove() throws Exception {
    WhitePawn whitePawn = new WhitePawn();

    boolean validMove = whitePawn.isAValidMove("a2", "a4");

    assertThat(validMove, is(true));
  }

  @Test
  public void whitePawn_isAllowedToMoveOneLeft_invalidMove() throws Exception {
    WhitePawn whitePawn = new WhitePawn();

    boolean validMove = whitePawn.isAValidMove("d4", "c4");

    assertThat(validMove, is(false));
  }

  @Test
  public void whitePawn_isAllowedToMoveOneRight_invalidMove() throws Exception {
    WhitePawn whitePawn = new WhitePawn();

    boolean validMove = whitePawn.isAValidMove("g8", "h8");

    assertThat(validMove, is(false));
  }

  @Test
  public void whitePawn_isAllowedToMoveOneDiagonal_invalidMove() throws Exception {
    WhitePawn whitePawn = new WhitePawn();

    boolean validMove = whitePawn.isAValidMove("a3", "b4");

    assertThat(validMove, is(false));
  }

  @Test
  public void whitePawn_isAllowedToMoveTwoUp_invalidMove() throws Exception {
    WhitePawn whitePawn = new WhitePawn();

    boolean validMove = whitePawn.isAValidMove("d5", "d7");

    assertThat(validMove, is(false));
  }

  @Test
  public void whitePawn_isAllowedToMoveOneDown_invalidMove() throws Exception {
    WhitePawn whitePawn = new WhitePawn();

    boolean validMove = whitePawn.isAValidMove("d4", "d3");

    assertThat(validMove, is(false));
  }

}
