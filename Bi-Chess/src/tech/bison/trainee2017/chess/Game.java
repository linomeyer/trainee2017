package tech.bison.trainee2017.chess;

import java.util.ArrayList;

public class Game {
  private final Chessboard chessboard;
  private final ArrayList<Move> moves;

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

}
