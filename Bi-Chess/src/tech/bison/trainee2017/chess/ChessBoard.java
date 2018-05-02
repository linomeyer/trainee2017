package tech.bison.trainee2017.chess;

import java.util.HashMap;

import tech.bison.trainee2017.chess.Figure.colors;

public class ChessBoard {
  public Object[][] board;

  public ChessBoard() {
    initializeBoard();
  }

  public void initializeBoard() {

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
    board.put(new Position("A2"), new WhiteFarmer());
    board.put(new Position("B2"), new WhiteFarmer());
    board.put(new Position("C2"), new WhiteFarmer());
    board.put(new Position("D2"), new WhiteFarmer());
    board.put(new Position("E2"), new WhiteFarmer());
    board.put(new Position("F2"), new WhiteFarmer());
    board.put(new Position("G2"), new WhiteFarmer());
    board.put(new Position("A7"), new WhiteFarmer());
    board.put(new Position("B7"), new BlackFarmer());
    board.put(new Position("C7"), new BlackFarmer());
    board.put(new Position("D7"), new BlackFarmer());
    board.put(new Position("E7"), new BlackFarmer());
    board.put(new Position("F7"), new BlackFarmer());
    board.put(new Position("G7"), new BlackFarmer());
    board.put(new Position("H7"), new BlackFarmer());
  }
}
