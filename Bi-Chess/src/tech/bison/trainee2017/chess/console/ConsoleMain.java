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
    Game game = new Game();
    GameState gameState;
    InputValidator inputValidator = new InputValidator();
    GameController gameController = new GameController();

    try (BufferedReader br = new BufferedReader(new InputStreamReader(System.in))) {
      System.out.print(Messages.getString("createGame")); //$NON-NLS-1$
      String input = br.readLine();
      if (input.equals("c")) { //$NON-NLS-1$
        game = gameController.createCustomGame();
        while (repeat) {
          System.out.println(new ChessboardPrinter(game.getChessboard()).print());
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
      }
      repeat = true;
      while (repeat) {
        System.out.println(new ChessboardPrinter(game.getChessboard()).print());
        System.out.print(Messages.getString("executeMove")); //$NON-NLS-1$
        input = br.readLine();

        if (input.equals("quit")) { //$NON-NLS-1$
          repeat = false;
        } else {
          ArrayList<ValidationState> state = inputValidator.validateMove(input);
          if (state.get(0).equals(ValidationState.OK)) {
            Square[] squares = gameController.getSquares(input);
            gameState = game.movePiece(new Movement(squares[0], squares[1]));
            System.out.println("\n" + Messages.getString(gameState.toString())); //$NON-NLS-1$
          } else {
            for (ValidationState s : state) {
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
