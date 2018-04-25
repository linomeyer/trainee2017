package tech.bison.trainee2017.chess;

import static org.hamcrest.CoreMatchers.is;
import static org.junit.Assert.assertThat;

import org.junit.Test;

public class KingTest {
  @Test
  public void king_isAllowedToMoveOneUp_validMove() throws Exception {
    King king = new King();

    boolean validMove = king.isAValidMove("a2", "a3");

    assertThat(validMove, is(true));
  }

  @Test
  public void king_isAllowedToMoveOneDown_validMove() throws Exception {
    King king = new King();

    boolean validMove = king.isAValidMove("c3", "c2");

    assertThat(validMove, is(true));
  }

  @Test
  public void king_isAllowedToMoveOneRight_validMove() throws Exception {
    King king = new King();

    boolean validMove = king.isAValidMove("e5", "f5");

    assertThat(validMove, is(true));
  }

  @Test
  public void king_isAllowedToMoveOneLeft_validMove() throws Exception {
    King king = new King();

    boolean validMove = king.isAValidMove("e8", "d8");

    assertThat(validMove, is(true));
  }

  @Test
  public void king_isAllowedToMoveOneDiagonal_validMove() throws Exception {
    King king = new King();

    boolean validMove = king.isAValidMove("a2", "b3");

    assertThat(validMove, is(true));
  }

  @Test
  public void king_isAllowedToMoveTwoDiagonal_invalidMove() throws Exception {
    King king = new King();

    boolean validMove = king.isAValidMove("a2", "c4");

    assertThat(validMove, is(false));
  }

  @Test
  public void king_isAllowedToMoveTwoUp_invalidMove() throws Exception {
    King king = new King();

    boolean validMove = king.isAValidMove("d5", "d7");

    assertThat(validMove, is(false));
  }

  @Test
  public void king_isAllowedToMoveTwoLeft_invalidMove() throws Exception {
    King king = new King();

    boolean validMove = king.isAValidMove("f8", "d8");

    assertThat(validMove, is(false));
  }

  @Test
  public void king_isAllowedToMoveWetherHorizontalVerticalOrDiagonal_invalidMove() throws Exception {
    King king = new King();

    boolean validMove = king.isAValidMove("c2", "d4");

    assertThat(validMove, is(false));
  }
}
