package tech.bison.trainee2017.chess;

import static org.hamcrest.CoreMatchers.is;
import static org.junit.Assert.assertThat;

import org.junit.Test;

public class FigureTest {
  @Test
  public void figur_calcuateMovementWithStartAndEndPosition_haveXAndYMovement() throws Exception {
    Figure figure = new Figure();

    Movement movement = figure.calculateMovement("a3", "b5");

    assertThat(movement.x, is(1));
    assertThat(movement.y, is(2));
  }
}
