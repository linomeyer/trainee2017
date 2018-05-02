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
public class KingTest {

  @RunWith(Parameterized.class)
  public static class KingParameterTests {
    @Parameters
    public static List<String[]> data() {
      return Arrays.asList(new String[][] {
          // One Up
          { "a2", "a3" },
          // One Down
          { "c3", "c2" },
          // One Right
          { "e5", "f5" },
          // One Left
          { "e8", "d8" },
          // One Diagonal
          { "a2", "b3" },
      });
    }

    @Parameter(0)
    public String startPosition;

    @Parameter(1)
    public String endPosition;

    @Test
    public void king_isAllowedToMoveOneVerticalHorizontalOrDiagonal_validMove() {
      King king = new King();

      assertThat(king.isAValidMove(startPosition, endPosition), is(true));
    }
  }

  public class KingNormalTests {
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
