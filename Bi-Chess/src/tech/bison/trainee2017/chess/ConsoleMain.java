package tech.bison.trainee2017.chess;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.HashMap;

import tech.bison.trainee2017.chess.Game.GameState;
import tech.bison.trainee2017.chess.InputValidator.ValidationState;

public class ConsoleMain {
  static final HashMap<ValidationState, String> validationStates = new HashMap<ValidationState, String>();
  static final HashMap<GameState, String> gameStates = new HashMap<GameState, String>();

  public static void main(String[] args) {
    initializeStates();
    boolean repeat = true;
    Game game = new Game();
    ValidationState validationState;
    GameState gameState;
    InputValidator inputValidator = new InputValidator();
    GameController gameController = new GameController();

    try (BufferedReader br = new BufferedReader(new InputStreamReader(System.in))) {
      System.out.print(Messages.getString("createGame")); //$NON-NLS-1$
      String input = br.readLine();
      if (input.equals("c")) { //$NON-NLS-1$
        while (repeat) {
          System.out.print(Messages.getString("createChessboard")); //$NON-NLS-1$
          input = br.readLine();
          validationState = gameController.createCustomGame(input);
          if (ValidationState.OK == validationState) {
            repeat = false;
            game = gameController.game;
          } else {
            System.out.println(validationStates.get(validationState));
          }
        }
      }
      repeat = true;
      while (repeat) {
        System.out.print(Chessboard.printChessboard(game.getChessboard()));
        System.out.print(Messages.getString("executeMove")); //$NON-NLS-1$
        input = br.readLine();

        if (input.equals("quit")) { //$NON-NLS-1$
          repeat = false;
        } else {
          ArrayList<ValidationState> state = inputValidator.validateMove(input);
          if (state.get(0).equals(ValidationState.OK)) {
            Square[] squares = gameController.getSquares(input);
            gameState = game.movePiece(new Movement(squares[0], squares[1]));
            System.out.println("\n" + gameStates.get(gameState)); //$NON-NLS-1$
          } else {
            for (ValidationState s : state) {
              System.out.println(validationStates.get(s));
            }
          }
        }
      }
    } catch (IOException e) {
      e.printStackTrace();
    }
  }

  private static void initializeStates() {
    validationStates.put(ValidationState.OK, Messages.validMove()); // $NON-NLS-1$
    validationStates.put(ValidationState.UNKNOWN_PIECE, Messages.getString("unknownPiece")); //$NON-NLS-1$
    validationStates.put(ValidationState.WRONG_LENGTH, Messages.getString("invalidInputLength")); //$NON-NLS-1$
    validationStates.put(ValidationState.INVALID_POSITION_SYNTAX,
        Messages.getString("invalidPositionSyntax")); //$NON-NLS-1$
    validationStates.put(ValidationState.INVALID_CHESSBOARD_SIZE,
        Messages.getString("invalidChessboardSize")); //$NON-NLS-1$
    validationStates.put(ValidationState.INVALID_CHESSBOARD_SYNTAX,
        Messages.getString("invalidChessboardSyntax")); //$NON-NLS-1$
    gameStates.put(GameState.INVALID_MOVE, Messages.getString("invalidMove")); //$NON-NLS-1$
    gameStates.put(GameState.INVALID_SQUARE, Messages.getString("invalidSquare")); //$NON-NLS-1$
    gameStates.put(GameState.PIECE_CAPTURED, Messages.getString("pieceCaptured")); //$NON-NLS-1$
    gameStates.put(GameState.PIECE_MOVED, Messages.getString("piecemoved")); //$NON-NLS-1$
  }
}
