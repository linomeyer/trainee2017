package tech.bison.trainee2017.chess.console;

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

import tech.bison.trainee2017.chess.console.InputValidator;
import tech.bison.trainee2017.chess.console.InputValidator.ValidationState;

@RunWith(Enclosed.class)
public class InputValidatorTest {

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
      InputValidator moveValidator = new InputValidator();

      boolean validatedPiece = moveValidator.validatePiece(piece);

      assertThat(validatedPiece, is(isAValidPiece));

    }
  }

  @RunWith(Parameterized.class)
  public static class InputValidatorValidateMoveTest {
    @Parameters(name = "is {0} valid: {1}")
    public static List<Object[]> data() {
      return Arrays.asList(new Object[][] {
          { "Rf3-f5", new ValidationState[] { ValidationState.OK } },
          { "qf3-f5", new ValidationState[] { ValidationState.UNKNOWN_PIECE } },
          { "Rf3-f", new ValidationState[] { ValidationState.WRONG_LENGTH } },
          { "rf3-f",
              new ValidationState[] { ValidationState.WRONG_LENGTH } }
      });
    }

    @Parameter(0)
    public String input;

    @Parameter(1)
    public ValidationState[] state;

    @Test
    public void input_validateMove() throws Exception {
      InputValidator inputValidator = new InputValidator();

      ArrayList<ValidationState> validatedState = inputValidator.validateMove(input);
      ValidationState[] validatedStateAsArray = validatedState.toArray(new ValidationState[validatedState.size()]);

      assertArrayEquals(validatedStateAsArray, state);

    }
  }

  @RunWith(Parameterized.class)
  public static class InputValidatorValidateAddPieceTest {
    @Parameters(name = "is {0} valid: {1}")
    public static List<Object[]> data() {
      return Arrays.asList(new Object[][] {
          { "BRf5", new ValidationState[] { ValidationState.OK } },
          { "WPf", new ValidationState[] { ValidationState.WRONG_LENGTH } },
          { "BKf5-h5", new ValidationState[] { ValidationState.WRONG_LENGTH } },
          { "RMf4", new ValidationState[] { ValidationState.OK } },
          { "WAg1", new ValidationState[] { ValidationState.UNKNOWN_PIECE } },
          { "YKh4", new ValidationState[] { ValidationState.UNKNOWN_COLOR } },
          { "ZT9h",
              new ValidationState[] { ValidationState.UNKNOWN_PIECE, ValidationState.UNKNOWN_COLOR,
                  ValidationState.INVALID_SQUARE_SYNTAX } }
      });
    }

    @Parameter(0)
    public String input;

    @Parameter(1)
    public ValidationState[] states;

    @Test
    public void input_validateAddPiece() throws Exception {
      InputValidator inputValidator = new InputValidator();

      ArrayList<ValidationState> validatedState = inputValidator.validateAddPiece(input);
      ValidationState[] validatedStateAsArray = validatedState.toArray(new ValidationState[validatedState.size()]);

      assertThat(validatedStateAsArray, is(states));
    }
  }

  public static class InputValidatorNormalTest {
    @Test
    public void input_validateLength_true() throws Exception {
      InputValidator inputValidator = new InputValidator();
      String input = "PA2-A4";

      boolean isLengthValid = inputValidator.validateLength(input, 6);

      assertThat(isLengthValid, is(true));
    }
  }
}
