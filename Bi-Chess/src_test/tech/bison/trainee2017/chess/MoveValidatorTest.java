package tech.bison.trainee2017.chess;

import static org.hamcrest.CoreMatchers.is;
import static org.junit.Assert.assertArrayEquals;
import static org.junit.Assert.assertThat;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import org.junit.Test;
import org.junit.experimental.runners.Enclosed;
import org.junit.runner.RunWith;
import org.junit.runners.Parameterized;
import org.junit.runners.Parameterized.Parameter;
import org.junit.runners.Parameterized.Parameters;

import tech.bison.trainee2017.chess.MoveValidator.State;

@RunWith(Enclosed.class)
public class MoveValidatorTest {

  @RunWith(Parameterized.class)
  public static class MoveValidatorPieceTest {
    @Parameters(name = "is {0} valid: {1}")
    public static List<Object[]> data() {
      return Arrays.asList(new Object[][] {
          { 'R', true },
          { 'P', true },
          { 'Q', true },
          { 'K', true },
          { 'B', true },
          { 'N', true },
          { 'r', false },
          { 'p', false },
          { 'q', false },
          { 'k', false },
          { 'b', false },
          { 'n', false }
      });
    }

    @Parameter(0)
    public char piece;

    @Parameter(1)
    public boolean isAValidPiece;

    @Test
    public void input_validatePiece() throws Exception {
      MoveValidator moveValidator = new MoveValidator();

      boolean validatedPiece = moveValidator.validatePiece(piece);

      assertThat(validatedPiece, is(isAValidPiece));

    }
  }

  @RunWith(Parameterized.class)
  public static class MoveValidatorValidateTest {
    @Parameters(name = "is {0} valid: {1}")
    public static List<Object[]> data() {
      return Arrays.asList(new Object[][] {
          { "Rf3-f5", new State[] { State.OK } },
          { "qf3-f5", new State[] { State.UNKNOWN_PIECE } },
          { "Rf3-f", new State[] { State.WRONG_LENGTH, State.INVALID_POSITION_SYNTAX } },
          { "rf3-f", new State[] { State.WRONG_LENGTH, State.UNKNOWN_PIECE, State.INVALID_POSITION_SYNTAX } }
      });
    }

    @Parameter(0)
    public String input;

    @Parameter(1)
    public State[] state;

    @Test
    public void input_validate() throws Exception {
      MoveValidator moveValidator = new MoveValidator();

      ArrayList<State> validatedState = moveValidator.validate(input);
      State[] validatedStateAsArray = validatedState.toArray(new State[validatedState.size()]);

      assertArrayEquals(validatedStateAsArray, state);

    }
  }

  public static class MoveValidatorNormalTest {
    @Test
    public void input_validateLength_true() throws Exception {
      MoveValidator moveValidator = new MoveValidator();
      String input = "PA2-A4";

      boolean isLengthValid = moveValidator.validateLength(input);

      assertThat(isLengthValid, is(true));
    }
  }
}
