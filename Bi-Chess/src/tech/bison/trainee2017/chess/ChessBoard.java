package tech.bison.trainee2017.chess;

import java.util.HashMap;

import tech.bison.trainee2017.chess.Figure.colors;

public class ChessBoard {
  public Object[][] board;

  public ChessBoard() {
    initializeBoard();
  }

  public void initializeBoard() {
    try {

      HashMap<Position, Figure> board = new HashMap<Position, Figure>();
      board.put(new Position("A1"), new Tower(colors.WHITE));
      board.put(new Position("H1"), new Tower(colors.WHITE));
      board.put();
      board.put();
      board.put();
      board.put();
      board.put();
      board.put();
      board.put();
      board.put();
      board.put();
      board.put();
      board.put();
      board.put();
      board.put();
      board.put();
      board.put();
      board.put();
      board.put();
      board.put();
      board.put();
      board.put();
      board.put();
      board.put();
      board.put();
      board.put();
      board.put();
      board.put();
      board.put();
      board.put();
      board.put();
      board.put();

      Object[][] old_board = {

          { new Tower(colors.WHITE), new Position("A1") }, { new Tower(colors.WHITE), new Position("H1") },
          { new Tower(colors.BLACK), new Position("A8") }, { new Tower(colors.BLACK), new Position("H8") },
          { new Horse(colors.WHITE), new Position("B1") }, { new Horse(colors.WHITE), new Position("G1") },
          { "H", "G8" }, { "H", "H8" },
          { "R", "C1" }, { "R", "F1" }, { "R", "C8" }, { "R", "F8" },

          { "K", "E1" }, { "K", "E8" },
          { "Q", "D1" }, { "Q", "D8" },

          { "F", "A2" }, { "F", "B2" }, { "F", "C2" }, { "F", "D2" },
          { "F", "E2" }, { "F", "F2" }, { "F", "G2" }, { "F", "H2" },

          { "F", "A7" }, { "F", "B7" }, { "F", "C7" }, { "F", "D7" },
          { "F", "E7" }, { "F", "F7" }, { "F", "G7" }, { "F", "H7" },
      };

      this.board = old_board;
    } catch (InvalidPositionException e) {
    }
  }
}
