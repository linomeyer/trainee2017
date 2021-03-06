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

import tech.bison.trainee2017.chess.pieces.King;

@RunWith(Enclosed.class)
public class KingTest {

  @RunWith(Parameterized.class)
  public static class KingValidTests {
    @Parameters(name = "{0}-{1}")
    public static List<String[]> data() {
      return Arrays.asList(new String[][] {
          { "e1", "e2" },
          { "b3", "c4" },
          { "a8", "b8" },
          { "g6", "h5" },
          { "f5", "f4" },
          { "d4", "c3" },
          { "c4", "b4" },
          { "e6", "d7" },
      });
    }

    @Parameter(0)
    public String startSquare;

    @Parameter(1)
    public String endSquare;

    @Test
    public void king_isAllowedToMoveOneVerticalHorizontalOrDiagonal_validMove() {
      King king = new King();

      assertThat(king.isAValidMove(startSquare, endSquare), is(true));
    }
  }

  public static class KingInvalidTests {
    @Test
    public void king_isAllowedToMoveTwoDiagonal_invalidMove() throws Exception {
      King king = new King();

      boolean validMove = king.isAValidMove("a2", "c4");

      assertThat(validMove, is(false));
    }

    @Test
    public void king_isAllowedToMoveTwoUp_invalidMove() throws Exception {
      King king = new King();

      boolean validMove = king.isAValidMove("d5", "d7");

      assertThat(validMove, is(false));
    }

    @Test
    public void king_isAllowedToMoveTwoLeft_invalidMove() throws Exception {
      King king = new King();

      boolean validMove = king.isAValidMove("f8", "d8");

      assertThat(validMove, is(false));
    }

    @Test
    public void king_isAllowedToMoveWetherHorizontalVerticalOrDiagonal_invalidMove() throws Exception {
      King king = new King();

      boolean validMove = king.isAValidMove("c2", "d4");

      assertThat(validMove, is(false));
    }
  }
}
