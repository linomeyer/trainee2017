package tech.bison.trainee2017.chess;

import tech.bison.trainee2017.chess.InputValidator.ValidationState;

public class GameController {
  Game game = new Game();

  public ValidationState createCustomGame(String input) {
    try {
      int indexOfComma = input.indexOf(',');
      int x = Integer.parseInt(input.substring(0, indexOfComma));
      int y = Integer.parseInt(input.substring(indexOfComma + 1, input.length()));
      if (x > 26 || y > 26 || x < 1 || y < 1) {
        return ValidationState.INVALID_CHESSBOARD_SIZE;
      }
      game = new Game(new Chessboard(x, y));
      return ValidationState.OK;
    } catch (Exception e) {
      return ValidationState.INVALID_CHESSBOARD_SYNTAX;
    }
  }

  public Square[] getSquares(String input) {
    Square[] squares = new Square[2];
    squares[0] = new Square(input.substring(1, 3));
    squares[1] = new Square(input.substring(4, 6));
    return squares;
  }
}
