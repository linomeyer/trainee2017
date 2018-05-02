package tech.bison.trainee2017.chess;

import tech.bison.trainee2017.chess.Figure.colors;

public class ChessBoard {
  public Object[][] board;

  public ChessBoard() {
    initializeBoard();
  }

  public void initializeBoard() {
    Object[][] board = {

        { new Tower(colors.WHITE), "A1" }, { new Tower(colors.WHITE), "H1" }, { new Tower(colors.BLACK), "A8" },
        { new Tower(colors.BLACK), "H8" },
        { "H", "B1" }, { "H", "G1" }, { "H", "G8" }, { "H", "H8" },
        { "R", "C1" }, { "R", "F1" }, { "R", "C8" }, { "R", "F8" },

        { "K", "E1" }, { "K", "E8" },
        { "Q", "D1" }, { "Q", "D8" },

        { "F", "A2" }, { "F", "B2" }, { "F", "C2" }, { "F", "D2" },
        { "F", "E2" }, { "F", "F2" }, { "F", "G2" }, { "F", "H2" },

        { "F", "A7" }, { "F", "B7" }, { "F", "C7" }, { "F", "D7" },
        { "F", "E7" }, { "F", "F7" }, { "F", "G7" }, { "F", "H7" },
    };
    this.board = board;
  }
}
