package tech.bison.trainee2017.chess;

import static org.hamcrest.CoreMatchers.is;
import static org.junit.Assert.assertThat;

import org.junit.Test;

public class MovementTest {
  @Test
  public void startAndEndPosition_createMovement_haveXAndYMovement() throws Exception {
    Square start = new Square("A3");
    Square end = new Square("B5");

    Movement movement = new Movement(start, end);

    assertThat(movement.x, is(1));
    assertThat(movement.y, is(2));
    assertThat(movement.start, is(start));
    assertThat(movement.end, is(end));
  }
}
