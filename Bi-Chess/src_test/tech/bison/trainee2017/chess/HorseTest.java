package tech.bison.trainee2017.chess;

import static org.hamcrest.CoreMatchers.is;
import static org.junit.Assert.assertThat;

import org.junit.Test;

public class HorseTest {
  @Test
  public void horse_isAllowedToMoveTwoUpAndOneRight_validMove() throws Exception {
    Horse horse = new Horse();

    boolean validMove = horse.isAValidMove("D5", "E7");

    assertThat(validMove, is(true));
  }

  @Test
  public void horse_isAllowedToMoveTwoUpAndOneLeft_validMove() throws Exception {
    Horse horse = new Horse();

    boolean validMove = horse.isAValidMove("D5", "C7");

    assertThat(validMove, is(true));
  }

  @Test
  public void horse_isAllowedToMoveTwoRightAndOneUp_validMove() throws Exception {
    Horse horse = new Horse();

    boolean validMove = horse.isAValidMove("D5", "F6");

    assertThat(validMove, is(true));
  }

  @Test
  public void horse_isAllowedToMoveTwoRightAndOneDown_validMove() throws Exception {
    Horse horse = new Horse();

    boolean validMove = horse.isAValidMove("D5", "F4");

    assertThat(validMove, is(true));
  }

  @Test
  public void horse_isAllowedToMoveTwoDownAndOneRight_validMove() throws Exception {
    Horse horse = new Horse();

    boolean validMove = horse.isAValidMove("D5", "E3");

    assertThat(validMove, is(true));
  }

  @Test
  public void horse_isAllowedToMoveTwoDownAndOneLeft_validMove() throws Exception {
    Horse horse = new Horse();

    boolean validMove = horse.isAValidMove("D5", "C3");

    assertThat(validMove, is(true));
  }

  @Test
  public void horse_isAllowedToMoveTwoLeftAndOneUp_validMove() throws Exception {
    Horse horse = new Horse();

    boolean validMove = horse.isAValidMove("D5", "B6");

    assertThat(validMove, is(true));
  }

  @Test
  public void horse_isAllowedToMoveTwoLeftAndOneDown_validMove() throws Exception {
    Horse horse = new Horse();

    boolean validMove = horse.isAValidMove("D5", "B4");

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
}
