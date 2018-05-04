package tech.bison.trainee2017.chess;

import static org.hamcrest.CoreMatchers.is;
import static org.junit.Assert.assertThat;

import org.junit.Test;

public class BishopTest {
  @Test
  public void runner_isAllowedToMoveDiagonalUpAndRight_validMove() throws Exception {
    Bishop bishop = new Bishop();

    boolean validMove = bishop.isAValidMove("d3", "h7");

    assertThat(validMove, is(true));
  }

  @Test
  public void runner_isAllowedToMoveDiagonalDownAndRight_validMove() throws Exception {
    Bishop bishop = new Bishop();

    boolean validMove = bishop.isAValidMove("a8", "h1");

    assertThat(validMove, is(true));
  }

  @Test
  public void runner_isAllowedToMoveDiagonalDownAndLeft_validMove() throws Exception {
    Bishop bishop = new Bishop();

    boolean validMove = bishop.isAValidMove("b4", "a3");

    assertThat(validMove, is(true));
  }

  @Test
  public void runner_isAllowedToMoveDiagonalUpAndLeft_validMove() throws Exception {
    Bishop bishop = new Bishop();

    boolean validMove = bishop.isAValidMove("g5", "e7");

    assertThat(validMove, is(true));
  }

  @Test
  public void runner_isAllowedToMoveOneUp_invalidMove() throws Exception {
    Bishop bishop = new Bishop();

    boolean validMove = bishop.isAValidMove("c2", "c3");

    assertThat(validMove, is(false));
  }

  @Test
  public void runner_isAllowedToMoveOneDown_invalidMove() throws Exception {
    Bishop bishop = new Bishop();

    boolean validMove = bishop.isAValidMove("h3", "h2");

    assertThat(validMove, is(false));
  }

  @Test
  public void runner_isAllowedToMoveOneRight_invalidMove() throws Exception {
    Bishop bishop = new Bishop();

    boolean validMove = bishop.isAValidMove("e5", "f5");

    assertThat(validMove, is(false));
  }

  @Test
  public void runner_isAllowedToMoveOneLeft_invalidMove() throws Exception {
    Bishop bishop = new Bishop();

    boolean validMove = bishop.isAValidMove("e8", "d8");

    assertThat(validMove, is(false));
  }

  @Test
  public void runner_isAllowedToMoveWetherHorizontalVerticalOrDiagonal_invalidMove() throws Exception {
    Bishop bishop = new Bishop();

    boolean validMove = bishop.isAValidMove("c2", "d4");

    assertThat(validMove, is(false));
  }
}
