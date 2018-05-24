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

import tech.bison.trainee2017.chess.InputValidator.ValidationState;

@RunWith(Enclosed.class)
public class GameControllerTest {
  @RunWith(Parameterized.class)
  public static class GameControllerValidateCustomGameTest {
    @Parameters(name = "is {0} valid: {1}")
    public static List<Object[]> data() {
      return Arrays.asList(new Object[][] {
          { "28,32", ValidationState.INVALID_CHESSBOARD_SIZE },
          { "1-3", ValidationState.INVALID_CHESSBOARD_SYNTAX },
          { "a,b", ValidationState.INVALID_CHESSBOARD_SYNTAX },
          { "10,10", ValidationState.OK }
      });
    }

    @Parameter(0)
    public String input;

    @Parameter(1)
    public ValidationState state;

    @Test
    public void input_validateCustomGame() throws Exception {
      GameController inputValidator = new GameController();

      assertThat(inputValidator.createCustomGame(input), is(state));
    }
  }

  public static class GameControllerNormalTests {

  }
}
