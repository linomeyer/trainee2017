package tech.bison.trainee2017.chess;

public class GameController {

  public Game createCustomGame() {
    Chessboard chessboard = new Chessboard(8, 8);
    return new Game(chessboard);
  }

  public Square[] getSquares(String input) {
    Square[] squares = new Square[2];
    squares[0] = new Square(input.substring(1, 3));
    squares[1] = new Square(input.substring(4, 6));
    return squares;
  }
}
