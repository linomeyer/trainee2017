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

import tech.bison.trainee2017.chess.pieces.Queen;

@RunWith(Enclosed.class)
public class QueenTest {

  @RunWith(Parameterized.class)
  public static class QueenValidTests {
    @Parameters(name = "{0}-{1}")
    public static List<String[]> data() {
      return Arrays.asList(new String[][] {
          { "e7", "e8" },
          { "h6", "h1" },
          { "g1", "c1" },
          { "e3", "g3" },
          { "c3", "f6" },
          { "b6", "e3" },
          { "f7", "a2" },
          { "c2", "b3" }
      });
    }

    @Parameter(0)
    public String startSquare;

    @Parameter(1)
    public String endSquare;

    @Test
    public void queen_isAllowedToMoveHorizontalVerticalAndDiagonal_validMove() throws Exception {
      Queen queen = new Queen();

      assertThat(queen.isAValidMove(startSquare, endSquare), is(true));
    }
  }

  public static class QueenInvalidTests {
    @Test
    public void queen_isAllowedToMoveWheterHorizontalVerticalorDiagonal_inValidMove() throws Exception {
      Queen queen = new Queen();

      boolean validMove = queen.isAValidMove("h8", "b1");

      assertThat(validMove, is(false));
    }
  }
}
