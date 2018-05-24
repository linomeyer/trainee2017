package tech.bison.trainee2017.chess;

import java.util.HashMap;

import tech.bison.trainee2017.chess.Piece.Color;

public class Chessboard {
  final int width;
  final int length;
  final private HashMap<Square, Piece> chessboard;

  public Chessboard() {
    width = 8;
    length = 8;
    chessboard = initializeChessboard();
  }

  public Chessboard(int width, int length) {
    this.width = width;
    this.length = length;
    chessboard = new HashMap<Square, Piece>();
  }

  public HashMap<Square, Piece> initializeChessboard() {
    HashMap<Square, Piece> board = new HashMap<Square, Piece>();

    board.put(new Square("H8"), new Rook(Color.BLACK));

    board.put(new Square("B8"), new Knight(Color.BLACK));
    board.put(new Square("G8"), new Knight(Color.BLACK));

    board.put(new Square("C8"), new Bishop(Color.BLACK));
    board.put(new Square("F8"), new Bishop(Color.BLACK));

    board.put(new Square("D8"), new Queen(Color.BLACK));

    board.put(new Square("E8"), new King(Color.BLACK));

    board.put(new Square("B7"), new BlackPawn());
    board.put(new Square("C7"), new BlackPawn());
    board.put(new Square("D7"), new BlackPawn());
    board.put(new Square("E7"), new BlackPawn());
    board.put(new Square("F7"), new BlackPawn());
    board.put(new Square("G7"), new BlackPawn());
    board.put(new Square("H7"), new BlackPawn());

    board.put(new Square("A1"), new Rook(Color.WHITE));
    board.put(new Square("H1"), new Rook(Color.WHITE));

    board.put(new Square("B1"), new Knight(Color.WHITE));
    board.put(new Square("G1"), new Knight(Color.WHITE));

    board.put(new Square("C1"), new Bishop(Color.WHITE));
    board.put(new Square("F1"), new Bishop(Color.WHITE));

    board.put(new Square("D1"), new Queen(Color.WHITE));

    board.put(new Square("E1"), new King(Color.WHITE));

    board.put(new Square("A2"), new WhitePawn());
    board.put(new Square("B2"), new WhitePawn());
    board.put(new Square("C2"), new WhitePawn());
    board.put(new Square("D2"), new WhitePawn());
    board.put(new Square("E2"), new WhitePawn());
    board.put(new Square("F2"), new WhitePawn());
    board.put(new Square("G2"), new WhitePawn());
    board.put(new Square("H2"), new WhitePawn());
    board.put(new Square("A7"), new WhitePawn());
    return board;
  }

  public HashMap<Square, Piece> getChessboard() {
    return chessboard;
  }

  public Piece getPiece(Square square) {
    return chessboard.get(square);
  }

  public Piece movePiece(Movement movement) throws InvalidMoveException, InvalidSquareException {
    if (isAValidSquare(movement.end)) {
      for (Square square : movement.getWay()) {
        if (chessboard.get(square) != null) {
          throw new InvalidMoveException();
        }
      }
      Piece piece = chessboard.get(movement.start);
      Piece capturedPiece = chessboard.get(movement.end);
      chessboard.remove(movement.start);
      chessboard.put(movement.end, piece);
      piece.incrementMoveCounter();
      return capturedPiece;
    } else {
      throw new InvalidSquareException();
    }
  }

  public void addPiece(Square square, Piece piece) throws OccupiedSquareException, InvalidSquareException {
    if (isAValidSquare(square)) {
      if (chessboard.get(square) == null) {
        chessboard.put(square, piece);
      } else {
        throw new OccupiedSquareException();
      }
    } else {
      throw new InvalidSquareException();
    }
  }

  public boolean isAValidSquare(Square square) {
    return square.x <= width && square.x > 0 && square.y <= length && square.y > 0;
  }

  @Override
  public boolean equals(Object obj) {
    if (this == obj)
      return true;
    if (obj == null)
      return false;
    if (getClass() != obj.getClass())
      return false;
    Chessboard other = (Chessboard) obj;
    if (chessboard == null) {
      if (other.chessboard != null)
        return false;
    } else if (!chessboard.equals(other.chessboard))
      return false;
    if (length != other.length)
      return false;
    if (width != other.width)
      return false;
    return true;
  }

  public Piece[][] constituteAsArray() {
    Piece[][] chessboard = new Piece[width][length];

    for (int x = 0; x < width; x++) {
      for (int y = 0; y < length; y++) {
        chessboard[x][y] = this.chessboard.get(new Square(x + 1, y + 1));
      }
    }
    return chessboard;
  }
}
