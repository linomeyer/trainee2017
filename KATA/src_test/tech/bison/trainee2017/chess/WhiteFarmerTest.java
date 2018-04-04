package tech.bison.trainee2017.chess;

import static org.hamcrest.CoreMatchers.is;
import static org.junit.Assert.assertThat;

import org.junit.Test;

public class WhiteFarmerTest {
  @Test
  public void whiteFarmer_horizontalMovement_validMove() throws Exception {
    Farmer farmer = new WhiteFarmer();

    boolean validMove = farmer.move("e3", "e4");

    assertThat(validMove, is(true));
  }

  @Test
  public void whiteFarmer_movementFromStartPosition_validMove() throws Exception {
    Farmer farmer = new WhiteFarmer();

    boolean validMove = farmer.move("a2", "a4");

    assertThat(validMove, is(true));
  }

  @Test
  public void whiteFarmer_movementFromStartPositionOfBlackFarmer_invalidMove() throws Exception {
    Farmer farmer = new WhiteFarmer();

    boolean validMove = farmer.move("f7", "f5");

    assertThat(validMove, is(false));
  }

  @Test
  public void whiteFarmer_verticalMovement_invalidMove() throws Exception {
    Farmer farmer = new WhiteFarmer();

    boolean validMove = farmer.move("c5", "d5");

    assertThat(validMove, is(false));
  }

  @Test
  public void whiteFarmer_horizontalMovementMoreThanAllowed_invalidMove() throws Exception {
    Farmer farmer = new WhiteFarmer();

    boolean validMove = farmer.move("c2", "c5");

    assertThat(validMove, is(false));
  }

  @Test
  public void whiteFarmer_diagonalMovement_invalidMove() throws Exception {
    Farmer farmer = new WhiteFarmer();

    boolean validMove = farmer.move("d3", "b5");

    assertThat(validMove, is(false));
  }

  @Test
  public void whiteFarmer_horizontalMovementInFalseDirection_invalidMove() throws Exception {
    Farmer farmer = new WhiteFarmer();

    boolean validMove = farmer.move("c5", "c4");

    assertThat(validMove, is(false));
  }
}
