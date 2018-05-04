package tech.bison.trainee2017.chess;

import static org.hamcrest.CoreMatchers.is;
import static org.junit.Assert.assertThat;

import org.junit.Test;

public class KnightTest {
  @Test
  public void knight_isAllowedToMoveTwoUpAndOneRight_validMove() throws Exception {
    Knight knight = new Knight();

    boolean validMove = knight.isAValidMove("f2", "g4");

    assertThat(validMove, is(true));
  }

  @Test
  public void knight_isAllowedToMoveTwoUpAndOneLeft_validMove() throws Exception {
    Knight knight = new Knight();

    boolean validMove = knight.isAValidMove("d4", "c6");

    assertThat(validMove, is(true));
  }

  @Test
  public void knight_isAllowedToMoveTwoRightAndOneUp_validMove() throws Exception {
    Knight knight = new Knight();

    boolean validMove = knight.isAValidMove("c5", "e6");

    assertThat(validMove, is(true));
  }

  @Test
  public void knight_isAllowedToMoveTwoRightAndOneDown_validMove() throws Exception {
    Knight knight = new Knight();

    boolean validMove = knight.isAValidMove("b8", "d7");

    assertThat(validMove, is(true));
  }

  @Test
  public void knight_isAllowedToMoveTwoDownAndOneRight_validMove() throws Exception {
    Knight knight = new Knight();

    boolean validMove = knight.isAValidMove("b5", "c3");

    assertThat(validMove, is(true));
  }

  @Test
  public void knight_isAllowedToMoveTwoDownAndOneLeft_validMove() throws Exception {
    Knight knight = new Knight();

    boolean validMove = knight.isAValidMove("g3", "f1");

    assertThat(validMove, is(true));
  }

  @Test
  public void knight_isAllowedToMoveTwoLeftAndOneUp_validMove() throws Exception {
    Knight knight = new Knight();

    boolean validMove = knight.isAValidMove("g1", "e2");

    assertThat(validMove, is(true));
  }

  @Test
  public void knight_isAllowedToMoveTwoLeftAndOneDown_validMove() throws Exception {
    Knight knight = new Knight();

    boolean validMove = knight.isAValidMove("h5", "f4");

    assertThat(validMove, is(true));
  }

  @Test
  public void knight_isAllowedToMoveTwoUpAndTwoRight_invalidMove() throws Exception {
    Knight knight = new Knight();

    boolean validMove = knight.isAValidMove("D5", "F7");

    assertThat(validMove, is(false));
  }

  @Test
  public void knight_isAllowedToMoveTwoDownAndTwoRight_invalidMove() throws Exception {
    Knight knight = new Knight();

    boolean validMove = knight.isAValidMove("D5", "F3");

    assertThat(validMove, is(false));
  }

  @Test
  public void knight_isAllowedToMoveOneDownAndOneLeft_invalidMove() throws Exception {
    Knight knight = new Knight();

    boolean validMove = knight.isAValidMove("D5", "C4");

    assertThat(validMove, is(false));
  }
}
