package tech.bison.trainee2017.chess;

import java.util.ArrayList;

import tech.bison.trainee2017.chess.pieces.King;
import tech.bison.trainee2017.chess.pieces.Piece;
import tech.bison.trainee2017.chess.pieces.Piece.Color;

public class Game {
  private final Chessboard chessboard;
  private final ArrayList<Move> moves;

  public enum GameState {
    PIECE_MOVED, PIECE_CAPTURED, INVALID_MOVE, INVALID_SQUARE, PIECE_ADDED, SQUARE_OCCUPIED, EMPTY_SQUARE, PIECE_REMOVED, WHITE_BEGINS, MOVE_ALTERNATELY, CANT_JUMP, FRIENDED_COLOR, CATCH_DIAGONAL, WHITE_WON_GAME, BLACK_WON_GAME
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

  public GameState movePiece(Movement movement) {
    try {
      if (moves.size() == 0) {
        moves.add(Move.movePiece(chessboard, movement));
      } else {
        moves.add(Move.movePiece(chessboard, movement, moves.get(moves.size() - 1)));
      }
      if (moves.get(moves.size() - 1).capturedPiece == null) {
        return GameState.PIECE_MOVED;
      } else {
        if (moves.get(moves.size() - 1).capturedPiece.equals(new King(Color.WHITE))) {
          return GameState.BLACK_WON_GAME;
        } else if (moves.get(moves.size() - 1).capturedPiece.equals(new King(Color.BLACK))) {
          return GameState.WHITE_WON_GAME;
        }
        return GameState.PIECE_CAPTURED;
      }
    } catch (InvalidMoveException e) {
      return e.state;
    } catch (InvalidSquareException e) {
      return GameState.INVALID_SQUARE;
    }
  }

  public Move getLastMove() {
    return moves.get(moves.size() - 1);
  }

  public Piece getPiece(Square square) {
    return chessboard.getPiece(square);
  }

  public GameState addPiece(Square square, Piece piece) {
    try {
      chessboard.addPiece(square, piece);
    } catch (OccupiedSquareException e) {
      return GameState.SQUARE_OCCUPIED;
    } catch (InvalidSquareException e) {
      return GameState.INVALID_SQUARE;
    }
    return GameState.PIECE_ADDED;
  }

  public GameState removePiece(Square square) {
    Piece removedPiece = chessboard.removePiece(square);

    if (removedPiece == null) {
      return GameState.EMPTY_SQUARE;
    }
    return GameState.PIECE_REMOVED;
  }

}
