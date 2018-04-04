package tech.bison.trainee2017.kata;

import static org.hamcrest.CoreMatchers.is;
import static org.junit.Assert.assertThat;

import org.junit.Test;

import tech.bison.trainee2017.kata.Farmer;

public class BlackFarmerTest {

  @Test
  public void blackFarmer_horizontalMovement_validMove() throws Exception {
    Farmer farmer = new BlackFarmer();

    boolean validMove = farmer.move("b5", "b4");

    assertThat(validMove, is(true));
  }

  @Test
  public void blackFarmer_movementFromStartPosition_validMove() throws Exception {
    Farmer farmer = new BlackFarmer();

    boolean validMove = farmer.move("d7", "d5");

    assertThat(validMove, is(true));
  }

  @Test
  public void blackFarmer_movementFromStartPositionOfWhiteFarmer_invalidMove() throws Exception {
    Farmer farmer = new BlackFarmer();

    boolean validMove = farmer.move("b2", "b4");

    assertThat(validMove, is(false));
  }

  @Test
  public void blackFarmer_verticalMovement_invalidMove() throws Exception {
    Farmer farmer = new BlackFarmer();

    boolean validMove = farmer.move("c5", "d5");

    assertThat(validMove, is(false));
  }

  @Test
  public void blackFarmer_horizontalMovementMoreThanAllowed_invalidMove() throws Exception {
    Farmer farmer = new BlackFarmer();

    boolean validMove = farmer.move("c5", "c2");

    assertThat(validMove, is(false));
  }

  @Test
  public void blackFarmer_diagonalMovement_invalidMove() throws Exception {
    Farmer farmer = new BlackFarmer();

    boolean validMove = farmer.move("d3", "b5");

    assertThat(validMove, is(false));
  }

  @Test
  public void blackFarmer_horizontalMovementInFalseDirection_invalidMove() throws Exception {
    Farmer farmer = new BlackFarmer();

    boolean validMove = farmer.move("c3", "c4");

    assertThat(validMove, is(false));
  }
}
