package tech.bison.trainee2017.chess;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.HashMap;

import tech.bison.trainee2017.chess.Game.GameState;
import tech.bison.trainee2017.chess.InputValidator.ValidationState;
import tech.bison.trainee2017.chess.Piece.Color;

public class ConsoleMain {
  static final HashMap<ValidationState, String> validationStates = new HashMap<ValidationState, String>();
  static final HashMap<GameState, String> gameStates = new HashMap<GameState, String>();

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
          System.out.println(validationStates.get(validationState));
        }
      }
    }
    repeat = true;
    while (repeat) {
      printChessboard(game);
      System.out.print("Zug ausführen: ");
      input = br.readLine();

      if (input.equals("quit")) {
        repeat = false;
      } else {
        ArrayList<ValidationState> state = inputValidator.validateMove(input);
        if (state.get(0).equals(ValidationState.OK)) {
          Square[] squares = gameController.getSquares(input);
          gameState = game.movePiece(new Movement(squares[0], squares[1]));
          System.out.println("\n" + gameStates.get(gameState));
        } else {
          for (ValidationState s : state) {
            System.out.println(validationStates.get(s));
          }
        }
      }
    }
  }

  private static void initializeStates() {
    validationStates.put(ValidationState.OK, "Ihr Zug ist gültig");
    validationStates.put(ValidationState.UNKNOWN_PIECE, "Ihre eingegebene Figur gibt es nicht");
    validationStates.put(ValidationState.WRONG_LENGTH, "Ihre Eingabe hatte die falsche Länge");
    validationStates.put(ValidationState.INVALID_POSITION_SYNTAX,
        "Für die Positionen wurde eine falsche Syntax angewendet");
    validationStates.put(ValidationState.INVALID_CHESSBOARD_SIZE,
        "Es wurde eine falsche Grösse für das Schachbrett eingegeben. Es ist maximal eine Grösse von 26x26 erlaubt.");
    validationStates.put(ValidationState.INVALID_CHESSBOARD_SYNTAX,
        "Für die initialisierung des Schachbretts wurde eine falsche Syntax benutzt.");
    gameStates.put(GameState.INVALID_MOVE, "Der Zug ist ungültig.");
    gameStates.put(GameState.INVALID_SQUARE, "Die Position gibt es auf dem Schachbrett nicht.");
    gameStates.put(GameState.PIECE_CAPTURED, "Es wurde eine Figur geschlagen.");
    gameStates.put(GameState.PIECE_MOVED, "Die figur wurde bewegt.");
  }

  private static void printChessboard(Game game) {

    Piece[][] chessboard = game.getChessboard().constituteAsArray();

    System.out.println();
    for (int y = chessboard[0].length - 1; y >= 0; y--) {
      System.out.print(y + 1 + "  |");
      for (int x = 0; x < chessboard.length; x++) {
        Piece piece = chessboard[x][y];
        try {
          if (piece.color.equals(Color.WHITE)) {
            if (piece.getClass() == new WhitePawn().getClass()) {
              System.out.print("WP|");
            } else if (piece.getClass() == new King().getClass()) {
              System.out.print("WK|");
            } else if (piece.getClass() == new Queen().getClass()) {
              System.out.print("WQ|");
            } else if (piece.getClass() == new Rook().getClass()) {
              System.out.print("WR|");
            } else if (piece.getClass() == new Bishop().getClass()) {
              System.out.print("WB|");
            } else if (piece.getClass() == new Knight().getClass()) {
              System.out.print("WN|");
            }
          } else if (piece.color.equals(Color.BLACK)) {
            if (piece.getClass() == new BlackPawn().getClass()) {
              System.out.print("BP|");
            } else if (piece.getClass() == new King().getClass()) {
              System.out.print("BK|");
            } else if (piece.getClass() == new Queen().getClass()) {
              System.out.print("BQ|");
            } else if (piece.getClass() == new Rook().getClass()) {
              System.out.print("BR|");
            } else if (piece.getClass() == new Bishop().getClass()) {
              System.out.print("BB|");
            } else if (piece.getClass() == new Knight().getClass()) {
              System.out.print("BN|");
            }
          }
        } catch (NullPointerException e) {
          System.out.print("  |");
        }
      }
      System.out.println();
    }
    System.out.print("    ");
    char width = 'A';
    for (int i = 0; i < chessboard.length; i++) {
      System.out.print(width++ + "  ");
    }
    System.out.println("\n");

  }
}
