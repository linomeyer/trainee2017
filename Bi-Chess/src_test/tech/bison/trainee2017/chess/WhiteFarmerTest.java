package tech.bison.trainee2017.chess;

import static org.hamcrest.CoreMatchers.is;
import static org.junit.Assert.assertThat;

import org.junit.Test;

public class WhiteFarmerTest {
  @Test
  public void whiteFarmer_isAllowedToMoveOneUp_validMove() throws Exception {
    WhiteFarmer whiteFarmer = new WhiteFarmer();

    boolean validMove = whiteFarmer.isAValidMove("a4", "a5");

    assertThat(validMove, is(true));
  }

  @Test
  public void whiteFarmer_isAllowedToMoveOneUpFromStartPosition_validMove() throws Exception {
    WhiteFarmer whiteFarmer = new WhiteFarmer();

    boolean validMove = whiteFarmer.isAValidMove("c2", "c3");

    assertThat(validMove, is(true));
  }

  @Test
  public void whiteFarmer_isAllowedToMoveTwoUpFromStartPosition_validMove() throws Exception {
    WhiteFarmer whiteFarmer = new WhiteFarmer();

    boolean validMove = whiteFarmer.isAValidMove("h2", "h4");

    assertThat(validMove, is(true));
  }

  @Test
  public void whiteFarmer_isAllowedToMoveOneLeft_invalidMove() throws Exception {
    WhiteFarmer whiteFarmer = new WhiteFarmer();

    boolean validMove = whiteFarmer.isAValidMove("d4", "c4");

    assertThat(validMove, is(false));
  }

  @Test
  public void whiteFarmer_isAllowedToMoveOneRight_invalidMove() throws Exception {
    WhiteFarmer whiteFarmer = new WhiteFarmer();

    boolean validMove = whiteFarmer.isAValidMove("g8", "h8");

    assertThat(validMove, is(false));
  }

  @Test
  public void whiteFarmer_isAllowedToMoveOneDiagonal_invalidMove() throws Exception {
    WhiteFarmer whiteFarmer = new WhiteFarmer();

    boolean validMove = whiteFarmer.isAValidMove("a3", "b4");

    assertThat(validMove, is(false));
  }

  @Test
  public void whiteFarmer_isAllowedToMoveTwoUp_invalidMove() throws Exception {
    WhiteFarmer whiteFarmer = new WhiteFarmer();

    boolean validMove = whiteFarmer.isAValidMove("d5", "d7");

    assertThat(validMove, is(false));
  }

  @Test
  public void whiteFarmer_isAllowedToMoveOneDown_invalidMove() throws Exception {
    WhiteFarmer whiteFarmer = new WhiteFarmer();

    boolean validMove = whiteFarmer.isAValidMove("d4", "d3");

    assertThat(validMove, is(false));
  }

}
