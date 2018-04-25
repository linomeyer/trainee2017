package tech.bison.trainee2017.chess;

import static org.hamcrest.CoreMatchers.is;
import static org.junit.Assert.assertThat;

import org.junit.Test;

public class QueenTest {
  @Test
  public void queen_isAllowedToMoveSevenUp_validMove() throws Exception {
    Queen queen = new Queen();

    boolean validMove = queen.isAValidMove("a1", "a8");

    assertThat(validMove, is(true));
  }

  @Test
  public void queen_isAllowedToMoveSevenDown_validMove() throws Exception {
    Queen queen = new Queen();

    boolean validMove = queen.isAValidMove("h8", "h1");

    assertThat(validMove, is(true));
  }

  @Test
  public void queen_isAllowedToMoveSevenLeft_validMove() throws Exception {
    Queen queen = new Queen();

    boolean validMove = queen.isAValidMove("h5", "a5");

    assertThat(validMove, is(true));
  }

  @Test
  public void queen_isAllowedToMoveSevenRight_validMove() throws Exception {
    Queen queen = new Queen();

    boolean validMove = queen.isAValidMove("a2", "h2");

    assertThat(validMove, is(true));
  }

  @Test
  public void queen_isAllowedToMoveSevenDiagonal_validMove() throws Exception {
    Queen queen = new Queen();

    boolean validMove = queen.isAValidMove("a1", "h8");

    assertThat(validMove, is(true));
  }

  @Test
  public void queen_isAllowedToMoveOneUp_validMove() throws Exception {
    Queen queen = new Queen();

    boolean validMove = queen.isAValidMove("a1", "a2");

    assertThat(validMove, is(true));
  }

  @Test
  public void queen_isAllowedToMoveOneLeft_validMove() throws Exception {
    Queen queen = new Queen();

    boolean validMove = queen.isAValidMove("c3", "b3");

    assertThat(validMove, is(true));
  }

  @Test
  public void queen_isAllowedToMoveOneDiagonal_validMove() throws Exception {
    Queen queen = new Queen();

    boolean validMove = queen.isAValidMove("b3", "c4");

    assertThat(validMove, is(true));
  }

  @Test
  public void queen_isAllowedToMoveWheterHorizontalVerticalorDiagonal_validMove() throws Exception {
    Queen queen = new Queen();

    boolean validMove = queen.isAValidMove("h8", "b1");

    assertThat(validMove, is(false));
  }
}
