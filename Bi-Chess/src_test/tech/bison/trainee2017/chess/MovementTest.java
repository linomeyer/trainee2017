package tech.bison.trainee2017.chess;

import static org.hamcrest.CoreMatchers.is;
import static org.junit.Assert.assertThat;

import java.util.Arrays;
import java.util.List;

import org.junit.Test;
import org.junit.experimental.runners.Enclosed;
import org.junit.runner.RunWith;
import org.junit.runners.Parameterized;
import org.junit.runners.Parameterized.Parameter;
import org.junit.runners.Parameterized.Parameters;

@RunWith(Enclosed.class)
public class MovementTest {

  @RunWith(Parameterized.class)
  public static class MovementGetWayTest {

    @Parameters(name = "{0} | Weg = {1}")
    public static List<Object[]> data() throws InvalidSquareException {
      return Arrays.asList(new Object[][] {

          { new Movement(new Square("A1"), new Square("A3")),
              Arrays.asList(new Square[] { new Square("A2") }) },

          { new Movement(new Square("E5"), new Square("H8")),
              Arrays.asList(new Square[] { new Square("F6"), new Square("G7") }) },

          { new Movement(new Square("C7"), new Square("E7")),
              Arrays.asList(new Square[] { new Square("D7") }) },

          { new Movement(new Square("H8"), new Square("H7")),
              Arrays.asList(new Square[] {}) },

          { new Movement(new Square("G7"), new Square("E5")),
              Arrays.asList(new Square[] { new Square("F6") }) },

          { new Movement(new Square("H5"), new Square("D5")),
              Arrays.asList(new Square[] { new Square("G5"), new Square("F5"), new Square("E5") }) },
      });
    }

    @Parameter(0)
    public Movement movement;

    @Parameter(1)
    public List<Square> squares;

    @Test
    public void movement_getWay_correctWay() throws Exception {
      assertThat(movement.getWay(), is(squares));
    }

  }

  public static class MovementNormalTest {
    @Test
    public void startAndEndSquare_newMovement_haveXAndYMovement() throws Exception {
      Square start = new Square("A3");
      Square end = new Square("B5");

      Movement movement = new Movement(start, end);

      assertThat(movement.x, is(1));
      assertThat(movement.y, is(2));
      assertThat(movement.start, is(start));
      assertThat(movement.end, is(end));
    }
  }
}
