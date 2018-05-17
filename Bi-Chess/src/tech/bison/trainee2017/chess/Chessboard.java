package tech.bison.trainee2017.chess;

import java.util.HashMap;

import tech.bison.trainee2017.chess.Piece.colors;

public class Chessboard {
  private HashMap<Square, Piece> chessboard;

  public Chessboard() {
    initializeChessboard();
  }

  public void initializeChessboard() {
    HashMap<Square, Piece> board = new HashMap<Square, Piece>();

    try {
      board.put(new Square("A8"), new Rook(colors.BLACK));
      board.put(new Square("H8"), new Rook(colors.BLACK));

      board.put(new Square("B8"), new Knight(colors.BLACK));
      board.put(new Square("G8"), new Knight(colors.BLACK));

      board.put(new Square("C8"), new Bishop(colors.BLACK));
      board.put(new Square("F8"), new Bishop(colors.BLACK));

      board.put(new Square("D8"), new Queen(colors.BLACK));

      board.put(new Square("E8"), new King(colors.BLACK));

      board.put(new Square("B7"), new BlackPawn());
      board.put(new Square("C7"), new BlackPawn());
      board.put(new Square("D7"), new BlackPawn());
      board.put(new Square("E7"), new BlackPawn());
      board.put(new Square("F7"), new BlackPawn());
      board.put(new Square("G7"), new BlackPawn());
      board.put(new Square("H7"), new BlackPawn());

      board.put(new Square("A1"), new Rook(colors.WHITE));
      board.put(new Square("H1"), new Rook(colors.WHITE));

      board.put(new Square("B1"), new Knight(colors.WHITE));
      board.put(new Square("G1"), new Knight(colors.WHITE));

      board.put(new Square("C1"), new Bishop(colors.WHITE));
      board.put(new Square("F1"), new Bishop(colors.WHITE));

      board.put(new Square("D1"), new Queen(colors.WHITE));

      board.put(new Square("E1"), new King(colors.WHITE));

      board.put(new Square("A2"), new WhitePawn());
      board.put(new Square("B2"), new WhitePawn());
      board.put(new Square("C2"), new WhitePawn());
      board.put(new Square("D2"), new WhitePawn());
      board.put(new Square("E2"), new WhitePawn());
      board.put(new Square("F2"), new WhitePawn());
      board.put(new Square("G2"), new WhitePawn());
      board.put(new Square("H2"), new WhitePawn());
      board.put(new Square("A7"), new WhitePawn());
      chessboard = board;
    } catch (InvalidSquareException e) {
    }
  }

  public HashMap<Square, Piece> getChessboard() {
    return chessboard;
  }

  /* Gets a Piece from Chessboard map with the Square as key */
  public Piece getPiece(Square square) {
    return chessboard.get(square);
  }

  public Piece movePiece(Movement movement) throws InvalidMoveException {
    for (Square square : movement.getWay()) {
      if (chessboard.get(square) != null) {
        throw new InvalidMoveException();
      }
    }
    Piece piece = chessboard.get(movement.start);
    Piece capturedPiece = chessboard.get(movement.end);
    chessboard.remove(movement.start);
    chessboard.put(movement.end, piece);
    return capturedPiece;
  }
}
