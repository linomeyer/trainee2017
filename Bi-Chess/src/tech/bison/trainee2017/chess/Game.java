package tech.bison.trainee2017.chess;

import java.util.ArrayList;

import tech.bison.trainee2017.chess.pieces.Piece;
import tech.bison.trainee2017.chess.pieces.Piece.Color;

public class Game {
  private final Chessboard chessboard;
  private final ArrayList<Move> moves;

  public enum GameState {
    PIECE_MOVED, PIECE_CAPTURED, INVALID_MOVE, INVALID_SQUARE, PIECE_ADDED, SQUARE_OCCUPIED, EMPTY_SQUARE, PIECE_REMOVED, WHITE_BEGINS, MOVE_ALTERNATELY, CANT_JUMP, FRIENDED_COLOR, CATCH_DIAGONAL, WHITE_WON_GAME, BLACK_WON_GAME, KING_IN_CHECK, KING_MOVES_IN_CHECK, CHECK, CHECKMATE
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

  public ArrayList<GameState> movePiece(Movement movement) {
    ArrayList<GameState> gameStates = new ArrayList<GameState>();
    try {
      Move move = Move.movePiece(chessboard, movement, getLastMove());
      moves.add(move);
      gameStates.add(GameState.PIECE_MOVED);
      if (move.capturedPiece != null) {
        gameStates.add(GameState.PIECE_CAPTURED);
      }
      if (move.kingInCheck) {
        if (move.kingInCheckMate) {
          gameStates.add(GameState.CHECKMATE);
          if (move.piece.color == Color.WHITE) {
            gameStates.add(GameState.WHITE_WON_GAME);
          } else {
            gameStates.add(GameState.BLACK_WON_GAME);
          }
        } else {
          gameStates.add(GameState.CHECK);
        }
      }
    } catch (InvalidMoveException e) {
      gameStates.add(e.state);
    } catch (InvalidSquareException e) {
      gameStates.add(GameState.INVALID_SQUARE);
    }
    return gameStates;
  }

  public Move getLastMove() {
    if (moves.size() != 0) {
      return moves.get(moves.size() - 1);
    }
    return null;
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
