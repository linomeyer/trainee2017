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
public class BishopTest {

  @RunWith(Parameterized.class)
  public static class BishopValidTests {
    @Parameters(name = "{0}-{1}")
    public static List<String[]> data() {
      return Arrays.asList(new String[][] {
          { "d3", "h7" },
          { "a8", "h1" },
          { "b4", "a3" },
          { "g5", "e7" }
      });
    }

    @Parameter(0)
    public String startSquare;

    @Parameter(1)
    public String endSquare;

    @Test
    public void bishop_isAllowedToMoveDiagonalinAllDirections_validMove() {
      Bishop bishop = new Bishop();

      assertThat(bishop.isAValidMove(startSquare, endSquare), is(true));
    }
  }

  public static class BishopInvalidTests {
    @Test
    public void bishop_isAllowedToMoveOneUp_invalidMove() throws Exception {
      Bishop bishop = new Bishop();

      boolean validMove = bishop.isAValidMove("c2", "c3");

      assertThat(validMove, is(false));
    }

    @Test
    public void bishop_isAllowedToMoveOneDown_invalidMove() throws Exception {
      Bishop bishop = new Bishop();

      boolean validMove = bishop.isAValidMove("h3", "h2");

      assertThat(validMove, is(false));
    }

    @Test
    public void bishop_isAllowedToMoveOneRight_invalidMove() throws Exception {
      Bishop bishop = new Bishop();

      boolean validMove = bishop.isAValidMove("e5", "f5");

      assertThat(validMove, is(false));
    }

    @Test
    public void bishop_isAllowedToMoveOneLeft_invalidMove() throws Exception {
      Bishop bishop = new Bishop();

      boolean validMove = bishop.isAValidMove("e8", "d8");

      assertThat(validMove, is(false));
    }

    @Test
    public void bishop_isAllowedToMoveWetherHorizontalVerticalOrDiagonal_invalidMove() throws Exception {
      Bishop bishop = new Bishop();

      boolean validMove = bishop.isAValidMove("c2", "d4");

      assertThat(validMove, is(false));
    }
  }
}
