package tech.bison.trainee2017.chess;

import java.util.ArrayList;

public class Game {
  private final Chessboard chessboard;
  private final ArrayList<Move> moves;

  public enum State {
    PIECE_MOVED, PIECE_CATCHED, INVALID_MOVE, INVALID_SQUARE
  }

  public Game() {
    chessboard = new Chessboard();
    moves = new ArrayList<Move>();
  }

  public Game(Chessboard chessboard) {
    this.chessboard = chessboard;
    moves = new ArrayList<Move>();
  }

  public Chessboard getChessboard() {
    return chessboard;
  }

  public State movePiece(Movement movement) {
    try {
      moves.add(Move.movePiece(chessboard, movement));
      if (moves.get(moves.size() - 1).capturedPiece == null) {
        return State.PIECE_MOVED;
      } else {
        return State.PIECE_CATCHED;
      }
    } catch (InvalidMoveException e) {
      return State.INVALID_MOVE;
    } catch (InvalidSquareException e) {
      return State.INVALID_SQUARE;
    }
  }

  public Move getLastMove() {
    return moves.get(moves.size() - 1);
  }

  public Piece getPiece(Square square) {
    return chessboard.getPiece(square);
  }

}
