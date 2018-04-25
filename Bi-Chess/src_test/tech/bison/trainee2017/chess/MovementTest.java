package tech.bison.trainee2017.chess;

import static org.hamcrest.CoreMatchers.is;
import static org.junit.Assert.assertThat;

import org.junit.Test;

public class MovementTest {
  @Test
  public void startAndEndPosition_createMovement_haveXAndYMovement() throws Exception {
    Position start = new Position("A3");
    Position end = new Position("B5");

    Movement movement = new Movement(start, end);

    assertThat(movement.x, is(1));
    assertThat(movement.y, is(2));
    assertThat(movement.start, is(start));
    assertThat(movement.end, is(end));
  }
}
