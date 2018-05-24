package tech.bison.trainee2017.chess;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.HashMap;

import tech.bison.trainee2017.chess.Game.GameState;
import tech.bison.trainee2017.chess.InputValidator.ValidationState;

public class ConsoleMain {
  static final HashMap<ValidationState, String> states = new HashMap<ValidationState, String>();

  public static void main(String[] args) throws IOException {
    initializeStates();
    boolean repeat = true;
    Game game = new Game();
    ValidationState validationState;
    GameState gameState;
    InputValidator inputValidator = new InputValidator();
    GameController gameController = new GameController();
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

    System.out.print("Wollen Sie ein normales oder ein custom Spiel starten [n, c]? ");
    String input = br.readLine();
    if (input.equals("c")) {
      while (repeat) {
        System.out.print("Wie gross soll das Spielfeld sein [z.B. x,y | max 26,26]? ");
        input = br.readLine();
        validationState = gameController.createCustomGame(input);
        if (ValidationState.OK == validationState) {
          repeat = false;
          game = gameController.game;
        } else {
          System.out.println(states.get(validationState));
        }
      }
    }
    repeat = true;
    while (repeat) {
      System.out.print("Zug ausführen: ");
      input = br.readLine();

      if (input.equals("quit")) {
        repeat = false;
      } else {
        ArrayList<ValidationState> state = inputValidator.validateMove(input);
        if (state.get(0).equals(ValidationState.OK)) {
          Square[] squares = gameController.getSquares(input);
          gameState = game.movePiece(new Movement(squares[0], squares[1]));
        } else {
          for (ValidationState s : state) {
            System.out.println(states.get(s));
          }
        }
      }
    }
  }

  private static void initializeStates() {
    states.put(ValidationState.OK, "Ihr Zug ist gültig");
    states.put(ValidationState.UNKNOWN_PIECE, "Ihre eingegebene Figur gibt es nicht");
    states.put(ValidationState.WRONG_LENGTH, "Ihre Eingabe hatte die falsche Länge");
    states.put(ValidationState.INVALID_POSITION_SYNTAX, "Für die Positionen wurde eine falsche Syntax angewendet");
    states.put(ValidationState.INVALID_CHESSBOARD_SIZE,
        "Es wurde eine falsche Grösse für das Schachbrett eingegeben. Es ist maximal eine Grösse von 26x26 erlaubt.");
    states.put(ValidationState.INVALID_CHESSBOARD_SYNTAX,
        "Für die initialisierung des Schachbretts wurde eine falsche Syntax benutzt.");
  }
}
