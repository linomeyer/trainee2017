package tech.bison.trainee2017.chess.console;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;

import tech.bison.trainee2017.chess.Game;
import tech.bison.trainee2017.chess.Game.GameState;
import tech.bison.trainee2017.chess.Movement;
import tech.bison.trainee2017.chess.Square;
import tech.bison.trainee2017.chess.console.InputValidator.ValidationState;

public class ConsoleMain {

  public static void main(String[] args) {
    boolean repeat = true;
    Game game;
    GameState gameState;
    InputValidator inputValidator = new InputValidator();
    GameController gameController = new GameController();
    ChessboardPrinter chessboardPrinter;

    try (BufferedReader br = new BufferedReader(new InputStreamReader(System.in))) {
      System.out.print(Messages.getString("createGame")); //$NON-NLS-1$
      String input = br.readLine();
      if (input.equals("c")) { //$NON-NLS-1$
        game = gameController.createCustomGame();
        chessboardPrinter = new ChessboardPrinter(game.getChessboard());
        while (repeat) {
          System.out.println(chessboardPrinter.print());
          System.out.print(Messages.getString("editPieces"));
          input = br.readLine();
          ArrayList<ValidationState> states = inputValidator.validateAddPiece(input);
          if (input.equals("start")) {
            repeat = false;
          } else if (states.get(0).equals(ValidationState.OK)) {
            gameState = gameController.editPieces(game, input);
            System.out.println(Messages.getString(gameState.toString()));
          } else {
            for (ValidationState validationState : states) {
              System.out.println(Messages.getString(validationState.toString()));
            }
          }
        }
      } else {
        game = new Game();
        chessboardPrinter = new ChessboardPrinter(game.getChessboard());
      }
      repeat = true;
      while (repeat) {
        System.out.println(chessboardPrinter.print());
        System.out.print(Messages.getString("executeMove")); //$NON-NLS-1$
        input = br.readLine();

        if (input.equals("quit")) { //$NON-NLS-1$
          repeat = false;
        } else {
          ArrayList<ValidationState> states = inputValidator.validateMove(input);
          if (states.get(0).equals(ValidationState.OK)) {
            Square[] squares = gameController.getSquares(input);
            ArrayList<GameState> gameStates = game.movePiece(new Movement(squares[0], squares[1]));
            if (gameStates.contains(GameState.WHITE_WON_GAME) || gameStates.contains(GameState.BLACK_WON_GAME)) {
              repeat = false;
            }
            System.out.println();
            for (GameState state : gameStates) {
              System.out.println(Messages.getString(state.toString()));
            }
          } else {
            for (ValidationState s : states) {
              System.out.println(Messages.getString(s.toString()));
            }
          }
        }
      }
    } catch (IOException e) {
      e.printStackTrace();
    }
  }

}
