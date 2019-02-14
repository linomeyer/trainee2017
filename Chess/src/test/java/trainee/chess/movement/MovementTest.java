package trainee.chess.movement;

import static org.junit.Assert.assertThat;

import java.util.Arrays;
import java.util.List;

import org.junit.Test;

import static org.hamcrest.CoreMatchers.is;

import trainee.chess.Square;

public class MovementTest {
  @Test
  public void squares_newMovement_getMovements() throws Exception {
    Square startSquare = new Square("A1");
    Square endSquare = new Square("C3");

    Movement movement = new Movement(startSquare, endSquare);

    assertThat(movement.getXMovement(), is(2));
    assertThat(movement.getYMovement(), is(2));
  }

  @Test
  public void movement_getVerticalUpwardsWay_way() throws Exception {
    Movement movement = new Movement(new Square("A1"), new Square("A4"));

    List<Square> way = movement.getWay();

    assertThat(way, is(Arrays.asList(new Square("A2"), new Square("A3"))));
  }

  @Test
  public void movement_getVerticalDownwardsWay_way() throws Exception {
    Movement movement = new Movement(new Square("B7"), new Square("B4"));

    List<Square> way = movement.getWay();

    assertThat(way, is(Arrays.asList(new Square("B6"), new Square("B5"))));
  }

  @Test
  public void movement_getHorizontalRightwardsWay_way() throws Exception {
    Movement movement = new Movement(new Square("A1"), new Square("C1"));

    List<Square> way = movement.getWay();

    assertThat(way, is(Arrays.asList(new Square("B1"))));
  }

  @Test
  public void movement_getHorizontalLeftwardsWay_way() throws Exception {
    Movement movement = new Movement(new Square("D1"), new Square("A1"));

    List<Square> way = movement.getWay();

    assertThat(way, is(Arrays.asList(new Square("C1"), new Square("B1"))));
  }

  @Test
  public void movement_getDiagonalUpRightWay_way() throws Exception {
    Movement movement = new Movement(new Square("A1"), new Square("D4"));

    List<Square> way = movement.getWay();

    assertThat(way, is(Arrays.asList(new Square("B2"), new Square("C3"))));
  }

  @Test
  public void movement_getDiagonalUpLeftWay_way() throws Exception {
    Movement movement = new Movement(new Square("D1"), new Square("A4"));

    List<Square> way = movement.getWay();

    assertThat(way, is(Arrays.asList(new Square("C2"), new Square("B3"))));
  }

  @Test
  public void movement_getDiagonalDownRightWay_way() throws Exception {
    Movement movement = new Movement(new Square("A4"), new Square("D1"));

    List<Square> way = movement.getWay();

    assertThat(way, is(Arrays.asList(new Square("B3"), new Square("C2"))));
  }

  @Test
  public void movement_getDiagonalDownLeftWay_way() throws Exception {
    Movement movement = new Movement(new Square("D4"), new Square("A1"));

    List<Square> way = movement.getWay();

    assertThat(way, is(Arrays.asList(new Square("C3"), new Square("B2"))));
  }
}
