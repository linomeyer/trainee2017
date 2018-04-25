package tech.bison.trainee2017.chess;

import static org.hamcrest.CoreMatchers.is;
import static org.junit.Assert.assertThat;

import org.junit.Test;

public class WhiteFarmerTest {
  @Test
  public void WhiteFarmer_isAllowedToMoveOneUp_validMove() throws Exception {
    WhiteFarmer WhiteFarmer = new WhiteFarmer();

    boolean validMove = WhiteFarmer.isAValidMove("a4", "a5");

    assertThat(validMove, is(true));
  }

  @Test
  public void WhiteFarmer_isAllowedToMoveOneUpFromStartPosition_validMove() throws Exception {
    WhiteFarmer WhiteFarmer = new WhiteFarmer();

    boolean validMove = WhiteFarmer.isAValidMove("c2", "c3");

    assertThat(validMove, is(true));
  }

  @Test
  public void WhiteFarmer_isAllowedToMoveTwoUpFromStartPosition_validMove() throws Exception {
    WhiteFarmer WhiteFarmer = new WhiteFarmer();

    boolean validMove = WhiteFarmer.isAValidMove("h2", "h4");

    assertThat(validMove, is(true));
  }

  @Test
  public void WhiteFarmer_isAllowedToMoveOneLeft_invalidMove() throws Exception {
    WhiteFarmer WhiteFarmer = new WhiteFarmer();

    boolean validMove = WhiteFarmer.isAValidMove("d4", "c4");

    assertThat(validMove, is(false));
  }

  @Test
  public void WhiteFarmer_isAllowedToMoveOneRight_invalidMove() throws Exception {
    WhiteFarmer WhiteFarmer = new WhiteFarmer();

    boolean validMove = WhiteFarmer.isAValidMove("g8", "h8");

    assertThat(validMove, is(false));
  }

  @Test
  public void WhiteFarmer_isAllowedToMoveOneDiagonal_invalidMove() throws Exception {
    WhiteFarmer WhiteFarmer = new WhiteFarmer();

    boolean validMove = WhiteFarmer.isAValidMove("a3", "b4");

    assertThat(validMove, is(false));
  }

  @Test
  public void WhiteFarmer_isAllowedToMoveTwoUp_invalidMove() throws Exception {
    WhiteFarmer WhiteFarmer = new WhiteFarmer();

    boolean validMove = WhiteFarmer.isAValidMove("d5", "d7");

    assertThat(validMove, is(false));
  }

  @Test
  public void WhiteFarmer_isAllowedToMoveOneDown_invalidMove() throws Exception {
    WhiteFarmer WhiteFarmer = new WhiteFarmer();

    boolean validMove = WhiteFarmer.isAValidMove("d4", "d3");

    assertThat(validMove, is(false));
  }

}
