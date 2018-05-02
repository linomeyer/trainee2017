package tech.bison.trainee2017.chess;

public class ChessBoard {
  public String[][] board;

  public ChessBoard() {
    initializeBoard();
  }

  public void initializeBoard() {
    String[][] board = {
        /*- White                     Black-*/
        { "T", "A1" }, { "T", "H1" }, { "T", "A8" }, { "T", "H8" },
        { "H", "B1" }, { "H", "G1" }, { "H", "G8" }, { "H", "H8" },
        { "R", "C1" }, { "R", "F1" }, { "R", "C8" }, { "R", "F8" },

        /*- White      Black-*/
        { "K", "E1" }, { "K", "E8" },
        { "Q", "D1" }, { "Q", "D8" },

        // White
        { "F", "A2" }, { "F", "B2" }, { "F", "C2" }, { "F", "D2" },
        { "F", "E2" }, { "F", "F2" }, { "F", "G2" }, { "F", "H2" },
        // Black
        { "F", "A7" }, { "F", "B7" }, { "F", "C7" }, { "F", "D7" },
        { "F", "E7" }, { "F", "F7" }, { "F", "G7" }, { "F", "H7" },
    };
    this.board = board;
  }
}
