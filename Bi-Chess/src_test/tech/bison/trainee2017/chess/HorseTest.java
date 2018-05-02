package tech.bison.trainee2017.chess;

import static org.hamcrest.CoreMatchers.is;
import static org.junit.Assert.assertThat;

import org.junit.Test;

public class HorseTest {
  @Test
  public void horse_isAllowedToMoveTwoUpAndOneRight_validMove() throws Exception {
    Horse horse = new Horse();

    boolean validMove = horse.isAValidMove("f2", "g4");

    assertThat(validMove, is(true));
  }

  @Test
  public void horse_isAllowedToMoveTwoUpAndOneLeft_validMove() throws Exception {
    Horse horse = new Horse();

    boolean validMove = horse.isAValidMove("d4", "c6");

    assertThat(validMove, is(true));
  }

  @Test
  public void horse_isAllowedToMoveTwoRightAndOneUp_validMove() throws Exception {
    Horse horse = new Horse();

    boolean validMove = horse.isAValidMove("c5", "e6");

    assertThat(validMove, is(true));
  }

  @Test
  public void horse_isAllowedToMoveTwoRightAndOneDown_validMove() throws Exception {
    Horse horse = new Horse();

    boolean validMove = horse.isAValidMove("b8", "d7");

    assertThat(validMove, is(true));
  }

  @Test
  public void horse_isAllowedToMoveTwoDownAndOneRight_validMove() throws Exception {
    Horse horse = new Horse();

    boolean validMove = horse.isAValidMove("b5", "c3");

    assertThat(validMove, is(true));
  }

  @Test
  public void horse_isAllowedToMoveTwoDownAndOneLeft_validMove() throws Exception {
    Horse horse = new Horse();

    boolean validMove = horse.isAValidMove("g3", "f1");

    assertThat(validMove, is(true));
  }

  @Test
  public void horse_isAllowedToMoveTwoLeftAndOneUp_validMove() throws Exception {
    Horse horse = new Horse();

    boolean validMove = horse.isAValidMove("g1", "e2");

    assertThat(validMove, is(true));
  }

  @Test
  public void horse_isAllowedToMoveTwoLeftAndOneDown_validMove() throws Exception {
    Horse horse = new Horse();

    boolean validMove = horse.isAValidMove("h5", "f4");

    assertThat(validMove, is(true));
  }

  @Test
  public void horse_isAllowedToMoveTwoUpAndTwoRight_invalidMove() throws Exception {
    Horse horse = new Horse();

    boolean validMove = horse.isAValidMove("D5", "F7");

    assertThat(validMove, is(false));
  }

  @Test
  public void horse_isAllowedToMoveTwoDownAndTwoRight_invalidMove() throws Exception {
    Horse horse = new Horse();

    boolean validMove = horse.isAValidMove("D5", "F3");

    assertThat(validMove, is(false));
  }

  @Test
  public void horse_isAllowedToMoveOneDownAndOneLeft_invalidMove() throws Exception {
    Horse horse = new Horse();

    boolean validMove = horse.isAValidMove("D5", "C4");

    assertThat(validMove, is(false));
  }
}
