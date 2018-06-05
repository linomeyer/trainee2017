package tech.bison.trainee2017.chess.pieces;

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

import tech.bison.trainee2017.chess.pieces.Knight;

@RunWith(Enclosed.class)
public class KnightTest {

  @RunWith(Parameterized.class)
  public static class KnightValidTest {
    @Parameters(name = "{0}-{1}")
    public static List<String[]> data() {
      return Arrays.asList(new String[][] {
          { "f2", "g4" },
          { "d4", "c6" },
          { "c5", "e6" },
          { "b8", "d7" },
          { "b5", "c3" },
          { "g3", "f1" },
          { "g1", "e2" },
          { "h5", "f4" }
      });
    }

    @Parameter(0)
    public String startSquare;

    @Parameter(1)
    public String endSquare;

    @Test
    public void knight_isAllowedToMoveTwoAndOneInEachDirection_validMove() throws Exception {
      Knight knight = new Knight();

      assertThat(knight.isAValidMove(startSquare, endSquare), is(true));
    }
  }

  public static class KnightInvalidTests {
    @Test
    public void knight_isAllowedToMoveTwoUpAndTwoRight_invalidMove() throws Exception {
      Knight knight = new Knight();

      boolean validMove = knight.isAValidMove("D5", "F7");

      assertThat(validMove, is(false));
    }

    @Test
    public void knight_isAllowedToMoveTwoDownAndTwoRight_invalidMove() throws Exception {
      Knight knight = new Knight();

      boolean validMove = knight.isAValidMove("D5", "F3");

      assertThat(validMove, is(false));
    }

    @Test
    public void knight_isAllowedToMoveOneDownAndOneLeft_invalidMove() throws Exception {
      Knight knight = new Knight();

      boolean validMove = knight.isAValidMove("D5", "C4");

      assertThat(validMove, is(false));
    }
  }
}
