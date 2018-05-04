package tech.bison.trainee2017.chess;

import java.util.HashMap;

import tech.bison.trainee2017.chess.Figure.colors;

public class ChessBoard {
  public HashMap<Position, Figure> board;

  public ChessBoard() {
    initializeBoard();
  }

  public void initializeBoard() {

    try {
      HashMap<Position, Figure> board = new HashMap<Position, Figure>();
      board.put(new Position("A1"), new Rook(colors.WHITE));
      board.put(new Position("H1"), new Rook(colors.WHITE));
      board.put(new Position("A8"), new Rook(colors.BLACK));
      board.put(new Position("H8"), new Rook(colors.BLACK));

      board.put(new Position("B1"), new Knight(colors.WHITE));
      board.put(new Position("G1"), new Knight(colors.WHITE));
      board.put(new Position("B8"), new Knight(colors.BLACK));
      board.put(new Position("G8"), new Knight(colors.BLACK));

      board.put(new Position("C1"), new Bishop(colors.WHITE));
      board.put(new Position("F1"), new Bishop(colors.WHITE));
      board.put(new Position("C8"), new Bishop(colors.BLACK));
      board.put(new Position("F8"), new Bishop(colors.BLACK));

      board.put(new Position("D1"), new Queen(colors.WHITE));
      board.put(new Position("D8"), new Queen(colors.BLACK));

      board.put(new Position("E1"), new King(colors.WHITE));
      board.put(new Position("E8"), new King(colors.BLACK));

      board.put(new Position("A2"), new WhitePawn());
      board.put(new Position("B2"), new WhitePawn());
      board.put(new Position("C2"), new WhitePawn());
      board.put(new Position("D2"), new WhitePawn());
      board.put(new Position("E2"), new WhitePawn());
      board.put(new Position("F2"), new WhitePawn());
      board.put(new Position("G2"), new WhitePawn());
      board.put(new Position("H2"), new WhitePawn());
      board.put(new Position("A7"), new WhitePawn());
      board.put(new Position("B7"), new BlackPawn());
      board.put(new Position("C7"), new BlackPawn());
      board.put(new Position("D7"), new BlackPawn());
      board.put(new Position("E7"), new BlackPawn());
      board.put(new Position("F7"), new BlackPawn());
      board.put(new Position("G7"), new BlackPawn());
      board.put(new Position("H7"), new BlackPawn());

      this.board = board;
    } catch (InvalidPositionException e) {
    }

  }
}
