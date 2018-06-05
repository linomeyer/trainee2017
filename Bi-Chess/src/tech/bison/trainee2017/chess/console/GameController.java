package tech.bison.trainee2017.chess.console;

import tech.bison.trainee2017.chess.Chessboard;
import tech.bison.trainee2017.chess.Game;
import tech.bison.trainee2017.chess.Square;
import tech.bison.trainee2017.chess.Game.GameState;
import tech.bison.trainee2017.chess.pieces.Bishop;
import tech.bison.trainee2017.chess.pieces.King;
import tech.bison.trainee2017.chess.pieces.Knight;
import tech.bison.trainee2017.chess.pieces.Pawn;
import tech.bison.trainee2017.chess.pieces.Piece;
import tech.bison.trainee2017.chess.pieces.Queen;
import tech.bison.trainee2017.chess.pieces.Rook;
import tech.bison.trainee2017.chess.pieces.Piece.Color;

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
    Color pieceColor;
    if (color == 'B') {
      pieceColor = Color.BLACK;
    } else if (color == 'W') {
      pieceColor = Color.WHITE;
    } else {
      return null;
    }

    switch (piece) {
    case 'P':
      return Pawn.createPawn(pieceColor);
    case 'R':
      return new Rook(pieceColor);
    case 'N':
      return new Knight(pieceColor);
    case 'B':
      return new Bishop(pieceColor);
    case 'Q':
      return new Queen(pieceColor);
    case 'K':
      return new King(pieceColor);
    default:
      return null;
    }

  }
}
