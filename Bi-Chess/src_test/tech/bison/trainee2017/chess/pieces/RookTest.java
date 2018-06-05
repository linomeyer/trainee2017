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

import tech.bison.trainee2017.chess.pieces.Rook;

@RunWith(Enclosed.class)
public class RookTest {

  @RunWith(Parameterized.class)
  public static class RookValidTest {
    @Parameters(name = "{0}-{1}")
    public static List<String[]> data() {
      return Arrays.asList(new String[][] {
          { "e2", "e8" },
          { "c7", "c4" },
          { "b3", "c3" },
          { "h8", "a8" }
      });
    }

    @Parameter(0)
    public String startSquare;

    @Parameter(1)
    public String endSquare;

    @Test
    public void rook_isAllowedToMoveHorizontalAndvertical_validMove() throws Exception {
      Rook rook = new Rook();

      assertThat(rook.isAValidMove(startSquare, endSquare), is(true));
    }
  }

  public static class RookInvalidTests {
    @Test
    public void rook_isAllowedToMoveDiagonal_invalidMove() throws Exception {
      Rook rook = new Rook();

      boolean validMove = rook.isAValidMove("a2", "b3");

      assertThat(validMove, is(false));
    }

    @Test
    public void rook_isAllowedToMoveWetherHorizontalVerticalOrDiagonal_invalidMove() throws Exception {
      Rook rook = new Rook();

      boolean validMove = rook.isAValidMove("c2", "d4");

      assertThat(validMove, is(false));
    }
  }
}
