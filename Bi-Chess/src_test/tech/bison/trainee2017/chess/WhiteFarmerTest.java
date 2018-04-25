package tech.bison.trainee2017.chess;

import static org.hamcrest.CoreMatchers.is;
import static org.junit.Assert.assertThat;

import org.junit.Test;

public class WhiteFarmerTest {
  @Test
  public void whiteFarmer_horizontalMovement_validMove() throws Exception {
    WhiteFarmer farmer = new WhiteFarmer();

    boolean validMove = farmer.isAValidMove("e3", "e4");

    assertThat(validMove, is(true));
  }

  @Test
  public void whiteFarmer_movementFromStartPosition_validMove() throws Exception {
    WhiteFarmer farmer = new WhiteFarmer();

    boolean validMove = farmer.isAValidMove("a2", "a4");

    assertThat(validMove, is(true));
  }

  @Test
  public void whiteFarmer_movementFromStartPositionOfBlackFarmer_invalidMove() throws Exception {
    WhiteFarmer farmer = new WhiteFarmer();

    boolean validMove = farmer.isAValidMove("f7", "f5");

    assertThat(validMove, is(false));
  }

  @Test
  public void whiteFarmer_verticalMovement_invalidMove() throws Exception {
    WhiteFarmer farmer = new WhiteFarmer();

    boolean validMove = farmer.isAValidMove("c5", "d5");

    assertThat(validMove, is(false));
  }

  @Test
  public void whiteFarmer_horizontalMovementMoreThanAllowed_invalidMove() throws Exception {
    WhiteFarmer farmer = new WhiteFarmer();

    boolean validMove = farmer.isAValidMove("c2", "c5");

    assertThat(validMove, is(false));
  }

  @Test
  public void whiteFarmer_diagonalMovement_invalidMove() throws Exception {
    WhiteFarmer farmer = new WhiteFarmer();

    boolean validMove = farmer.isAValidMove("d3", "b5");

    assertThat(validMove, is(false));
  }

  @Test
  public void whiteFarmer_horizontalMovementInFalseDirection_invalidMove() throws Exception {
    WhiteFarmer farmer = new WhiteFarmer();

    boolean validMove = farmer.isAValidMove("c5", "c4");

    assertThat(validMove, is(false));
  }
}
