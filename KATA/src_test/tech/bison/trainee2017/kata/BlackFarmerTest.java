package tech.bison.trainee2017.kata;

import static org.hamcrest.CoreMatchers.is;
import static org.junit.Assert.assertThat;

import org.junit.Test;

public class BlackFarmerTest {

  @Test
  public void blackFarmer_horizontalMovement_validMove() throws Exception {
    Farmer farmer = new BlackFarmer();

    boolean validMove = farmer.move("5b", "4b");

    assertThat(validMove, is(true));
  }

  @Test
  public void blackFarmer_movementFromStartPosition_validMove() throws Exception {
    Farmer farmer = new BlackFarmer();

    boolean validMove = farmer.move("7d", "5d");

    assertThat(validMove, is(true));
  }

  @Test
  public void blackFarmer_movementFromStartPositionOfWhiteFarmer_invalidMove() throws Exception {
    Farmer farmer = new BlackFarmer();

    boolean validMove = farmer.move("2b", "4b");

    assertThat(validMove, is(false));
  }

  @Test
  public void blackFarmer_verticalMovement_invalidMove() throws Exception {
    Farmer farmer = new BlackFarmer();

    boolean validMove = farmer.move("5c", "5d");

    assertThat(validMove, is(false));
  }

  @Test
  public void blackFarmer_horizontalMovementMoreThanAllowed_invalidMove() throws Exception {
    Farmer farmer = new BlackFarmer();

    boolean validMove = farmer.move("5c", "2c");

    assertThat(validMove, is(false));
  }

  @Test
  public void blackFarmer_diagonalMovement_invalidMove() throws Exception {
    Farmer farmer = new BlackFarmer();

    boolean validMove = farmer.move("3d", "5b");

    assertThat(validMove, is(false));
  }

  @Test
  public void blackFarmer_horizontalMovementInFalseDirection_invalidMove() throws Exception {
    Farmer farmer = new BlackFarmer();

    boolean validMove = farmer.move("3c", "4c");

    assertThat(validMove, is(false));
  }
}
