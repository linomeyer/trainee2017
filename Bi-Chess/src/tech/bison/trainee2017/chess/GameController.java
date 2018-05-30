package tech.bison.trainee2017.chess;

import tech.bison.trainee2017.chess.Game.GameState;
import tech.bison.trainee2017.chess.Piece.Color;

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

  public GameState editPieces(Game game, String input) {

    if (input.substring(0, 2).equals("RM")) {
      return game.removePiece(new Square(input.substring(2, 4)));
    } else {
      char piece = input.charAt(1);
      char color = input.charAt(0);
      String square = input.substring(2, 4);

      return game.addPiece(new Square(square), getPiece(color, piece));
    }
  }

  private Piece getPiece(char color, char piece) {
    if (color == 'B') {
      switch (piece) {
      case 'P':
        return new BlackPawn();
      case 'R':
        return new Rook(Color.BLACK);
      case 'N':
        return new Knight(Color.BLACK);
      case 'B':
        return new Bishop(Color.BLACK);
      case 'Q':
        return new Queen(Color.BLACK);
      case 'K':
        return new King(Color.BLACK);
      }
    } else if (color == 'W') {
      switch (piece) {
      case 'P':
        return new WhitePawn();
      case 'R':
        return new Rook(Color.WHITE);
      case 'N':
        return new Knight(Color.WHITE);
      case 'B':
        return new Bishop(Color.WHITE);
      case 'Q':
        return new Queen(Color.WHITE);
      case 'K':
        return new King(Color.WHITE);
      }
    }
    return null;
  }
}
