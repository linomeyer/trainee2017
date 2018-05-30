// package tech.bison.trainee2017.chess;
//
// import static org.hamcrest.CoreMatchers.is;
// import static org.junit.Assert.assertThat;
//
// import java.util.Arrays;
// import java.util.List;
//
// import org.junit.Test;
// import org.junit.experimental.runners.Enclosed;
// import org.junit.runner.RunWith;
// import org.junit.runners.Parameterized;
// import org.junit.runners.Parameterized.Parameter;
// import org.junit.runners.Parameterized.Parameters;
//
// import tech.bison.trainee2017.chess.InputValidator.ValidationState;
//
// @RunWith(Enclosed.class)
// public class GameControllerTest {
//// @RunWith(Parameterized.class)
//// public static class GameControllerValidateCustomGameTest {
//// @Parameters(name = "is {0} valid: {1}")
//// public static List<Object[]> data() {
//// return Arrays.asList(new Object[][] {
//// { "WRd4", ValidationState.OK },
//// { "Pa3", ValidationState.WRONG_LENGTH },
//// { "CNg8", ValidationState.UNKNOWN_COLOR },
//// { "WGe3", ValidationState.UNKNOWN_PIECE },
//// { "BKu7", ValidationState.INVALID_SQUARE_SYNTAX }
//// });
//// }
////
//// @Parameter(0)
//// public String input;
////
//// @Parameter(1)
//// public ValidationState state;
////
//// @Test
//// public void input_validateCustomGame() throws Exception {
//// GameController inputValidator = new GameController();
////
//// assertThat(inputValidator.createCustomGame(), is(state));
//// }
//// }
//
// }
