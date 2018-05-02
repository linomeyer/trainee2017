package tech.bison.trainee2017.chess;

import static org.hamcrest.CoreMatchers.is;
import static org.junit.Assert.assertThat;

import org.junit.Test;

public class QueenTest {
  @Test
  public void queen_isAllowedToMoveUp_validMove() throws Exception {
    Queen queen = new Queen();

    boolean validMove = queen.isAValidMove("e7", "e8");

    assertThat(validMove, is(true));
  }

  @Test
  public void queen_isAllowedToMoveDown_validMove() throws Exception {
    Queen queen = new Queen();

    boolean validMove = queen.isAValidMove("h6", "h1");

    assertThat(validMove, is(true));
  }

  @Test
  public void queen_isAllowedToMoveLeft_validMove() throws Exception {
    Queen queen = new Queen();

    boolean validMove = queen.isAValidMove("g1", "c1");

    assertThat(validMove, is(true));
  }

  @Test
  public void queen_isAllowedToMoveRight_validMove() throws Exception {
    Queen queen = new Queen();

    boolean validMove = queen.isAValidMove("e3", "g3");

    assertThat(validMove, is(true));
  }

  @Test
  public void queen_isAllowedToMoveDiagonalUpAndRight_validMove() throws Exception {
    Queen queen = new Queen();

    boolean validMove = queen.isAValidMove("c3", "f6");

    assertThat(validMove, is(true));
  }

  @Test
  public void queen_isAllowedToMoveDiagonalDownAndRight_validMove() throws Exception {
    Queen queen = new Queen();

    boolean validMove = queen.isAValidMove("b6", "e3");

    assertThat(validMove, is(true));
  }

  @Test
  public void queen_isAllowedToMoveDiagonalDownAndLeft_validMove() throws Exception {
    Queen queen = new Queen();

    boolean validMove = queen.isAValidMove("f7", "a2");

    assertThat(validMove, is(true));
  }

  @Test
  public void queen_isAllowedToMoveDiagonalUpAndLeft_validMove() throws Exception {
    Queen queen = new Queen();

    boolean validMove = queen.isAValidMove("c2", "b3");

    assertThat(validMove, is(true));
  }

  @Test
  public void queen_isAllowedToMoveWheterHorizontalVerticalorDiagonal_validMove() throws Exception {
    Queen queen = new Queen();

    boolean validMove = queen.isAValidMove("h8", "b1");

    assertThat(validMove, is(false));
  }
}
