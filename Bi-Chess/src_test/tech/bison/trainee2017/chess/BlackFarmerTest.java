package tech.bison.trainee2017.chess;

import static org.hamcrest.CoreMatchers.is;
import static org.junit.Assert.assertThat;

import org.junit.Test;

public class BlackFarmerTest {
  @Test
  public void BlackFarmer_isAllowedToMoveOneDown_validMove() throws Exception {
    BlackFarmer BlackFarmer = new BlackFarmer();

    boolean validMove = BlackFarmer.isAValidMove("a6", "a5");

    assertThat(validMove, is(true));
  }

  @Test
  public void BlackFarmer_isAllowedToMoveOneDownFromStartPosition_validMove() throws Exception {
    BlackFarmer BlackFarmer = new BlackFarmer();

    boolean validMove = BlackFarmer.isAValidMove("c7", "c6");

    assertThat(validMove, is(true));
  }

  @Test
  public void BlackFarmer_isAllowedToMoveTwoDownFromStartPosition_validMove() throws Exception {
    BlackFarmer BlackFarmer = new BlackFarmer();

    boolean validMove = BlackFarmer.isAValidMove("h7", "h5");

    assertThat(validMove, is(true));
  }

  @Test
  public void BlackFarmer_isAllowedToMoveOneLeft_invalidMove() throws Exception {
    BlackFarmer BlackFarmer = new BlackFarmer();

    boolean validMove = BlackFarmer.isAValidMove("d4", "c4");

    assertThat(validMove, is(false));
  }

  @Test
  public void BlackFarmer_isAllowedToMoveOneRight_invalidMove() throws Exception {
    BlackFarmer BlackFarmer = new BlackFarmer();

    boolean validMove = BlackFarmer.isAValidMove("g8", "h8");

    assertThat(validMove, is(false));
  }

  @Test
  public void BlackFarmer_isAllowedToMoveOneDiagonal_invalidMove() throws Exception {
    BlackFarmer BlackFarmer = new BlackFarmer();

    boolean validMove = BlackFarmer.isAValidMove("a5", "b4");

    assertThat(validMove, is(false));
  }

  @Test
  public void BlackFarmer_isAllowedToMoveTwoDown_invalidMove() throws Exception {
    BlackFarmer BlackFarmer = new BlackFarmer();

    boolean validMove = BlackFarmer.isAValidMove("d4", "d2");

    assertThat(validMove, is(false));
  }

  @Test
  public void BlackFarmer_isAllowedToMoveOneUp_invalidMove() throws Exception {
    BlackFarmer BlackFarmer = new BlackFarmer();

    boolean validMove = BlackFarmer.isAValidMove("d4", "d5");

    assertThat(validMove, is(false));
  }
}
