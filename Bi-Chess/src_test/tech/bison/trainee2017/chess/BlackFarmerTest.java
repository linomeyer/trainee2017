package tech.bison.trainee2017.chess;

import static org.hamcrest.CoreMatchers.is;
import static org.junit.Assert.assertThat;

import org.junit.Test;

public class BlackFarmerTest {
  @Test
  public void blackFarmer_isAllowedToMoveOneDown_validMove() throws Exception {
    BlackFarmer blackFarmer = new BlackFarmer();

    boolean validMove = blackFarmer.isAValidMove("c5", "c4");

    assertThat(validMove, is(true));
  }

  @Test
  public void blackFarmer_isAllowedToMoveTwoDownFromStartPosition_validMove() throws Exception {
    BlackFarmer blackFarmer = new BlackFarmer();

    boolean validMove = blackFarmer.isAValidMove("h7", "h5");

    assertThat(validMove, is(true));
  }

  @Test
  public void blackFarmer_isAllowedToMoveOneLeft_invalidMove() throws Exception {
    BlackFarmer blackFarmer = new BlackFarmer();

    boolean validMove = blackFarmer.isAValidMove("d4", "c4");

    assertThat(validMove, is(false));
  }

  @Test
  public void blackFarmer_isAllowedToMoveOneRight_invalidMove() throws Exception {
    BlackFarmer blackFarmer = new BlackFarmer();

    boolean validMove = blackFarmer.isAValidMove("g8", "h8");

    assertThat(validMove, is(false));
  }

  @Test
  public void blackFarmer_isAllowedToMoveOneDiagonal_invalidMove() throws Exception {
    BlackFarmer blackFarmer = new BlackFarmer();

    boolean validMove = blackFarmer.isAValidMove("a5", "b4");

    assertThat(validMove, is(false));
  }

  @Test
  public void blackFarmer_isAllowedToMoveTwoDown_invalidMove() throws Exception {
    BlackFarmer blackFarmer = new BlackFarmer();

    boolean validMove = blackFarmer.isAValidMove("d4", "d2");

    assertThat(validMove, is(false));
  }

  @Test
  public void blackFarmer_isAllowedToMoveOneUp_invalidMove() throws Exception {
    BlackFarmer blackFarmer = new BlackFarmer();

    boolean validMove = blackFarmer.isAValidMove("d4", "d5");

    assertThat(validMove, is(false));
  }
}
