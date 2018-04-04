package tech.bison.trainee2017.kata;

import static org.hamcrest.CoreMatchers.is;
import static org.junit.Assert.assertThat;

import org.junit.Test;

public class WhiteFarmerTest {
  @Test
  public void whiteFarmer_horizontalMovement_validMove() throws Exception {
    Farmer farmer = new WhiteFarmer();

    boolean validMove = farmer.move("3e", "4e");

    assertThat(validMove, is(true));
  }

  @Test
  public void whiteFarmer_movementFromStartPosition_validMove() throws Exception {
    Farmer farmer = new WhiteFarmer();

    boolean validMove = farmer.move("2a", "4a");

    assertThat(validMove, is(true));
  }

  @Test
  public void whiteFarmer_movementFromStartPositionOfBlackFarmer_invalidMove() throws Exception {
    Farmer farmer = new WhiteFarmer();

    boolean validMove = farmer.move("7f", "5f");

    assertThat(validMove, is(false));
  }

  @Test
  public void whiteFarmer_verticalMovement_invalidMove() throws Exception {
    Farmer farmer = new WhiteFarmer();

    boolean validMove = farmer.move("5c", "5d");

    assertThat(validMove, is(false));
  }

  @Test
  public void whiteFarmer_horizontalMovementMoreThanAllowed_invalidMove() throws Exception {
    Farmer farmer = new WhiteFarmer();

    boolean validMove = farmer.move("2c", "5c");

    assertThat(validMove, is(false));
  }

  @Test
  public void whiteFarmer_diagonalMovement_invalidMove() throws Exception {
    Farmer farmer = new WhiteFarmer();

    boolean validMove = farmer.move("3d", "5b");

    assertThat(validMove, is(false));
  }

  @Test
  public void whiteFarmer_horizontalMovementInFalseDirection_invalidMove() throws Exception {
    Farmer farmer = new WhiteFarmer();

    boolean validMove = farmer.move("5c", "4c");

    assertThat(validMove, is(false));
  }
}
