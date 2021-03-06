package tech.bison.trainee2017.chess;

import java.util.HashMap;
import java.util.Set;

import tech.bison.trainee2017.chess.Game.GameState;
import tech.bison.trainee2017.chess.pieces.Bishop;
import tech.bison.trainee2017.chess.pieces.BlackPawn;
import tech.bison.trainee2017.chess.pieces.King;
import tech.bison.trainee2017.chess.pieces.Knight;
import tech.bison.trainee2017.chess.pieces.Piece;
import tech.bison.trainee2017.chess.pieces.Piece.Color;
import tech.bison.trainee2017.chess.pieces.Queen;
import tech.bison.trainee2017.chess.pieces.Rook;
import tech.bison.trainee2017.chess.pieces.WhitePawn;

public class Chessboard {
  public final int width;
  public final int length;
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
    board.put(new Square("A8"), new Rook(Color.BLACK));

    board.put(new Square("B8"), new Knight(Color.BLACK));
    board.put(new Square("G8"), new Knight(Color.BLACK));

    board.put(new Square("C8"), new Bishop(Color.BLACK));
    board.put(new Square("F8"), new Bishop(Color.BLACK));

    board.put(new Square("D8"), new Queen(Color.BLACK));

    board.put(new Square("E8"), new King(Color.BLACK));

    board.put(new Square("A7"), new BlackPawn());
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
    return board;
  }

  public HashMap<Square, Piece> getChessboard() {
    return chessboard;
  }

  public Piece getPiece(Square square) throws InvalidSquareException {
    if (isAValidSquare(square)) {
      return chessboard.get(square);
    } else {
      throw new InvalidSquareException();
    }
  }

  public boolean isWayEmpty(Movement movement) {
    for (Square square : movement.getWay()) {
      if (chessboard.get(square) != null) {
        return false;
      }
    }
    return true;
  }

  public boolean isWayEmpty(Movement movement, Square exception) {
    for (Square square : movement.getWay()) {
      if (!square.equals(exception)) {
        if (chessboard.get(square) != null) {
          return false;
        }
      }
    }
    return true;
  }

  public boolean isAValidMove(Movement movement) {
    return isAValidSquare(movement.end) && isWayEmpty(movement);
  }

  public Piece movePiece(Movement movement) throws InvalidMoveException, InvalidSquareException {
    if (isAValidSquare(movement.start) && isAValidSquare(movement.end)) {
      if (isWayEmpty(movement)) {
        Piece piece = chessboard.get(movement.start);
        Piece capturedPiece = chessboard.get(movement.end);
        chessboard.remove(movement.start);
        chessboard.put(movement.end, piece);
        piece.incrementMoveCounter();
        return capturedPiece;
      } else {
        throw new InvalidMoveException(GameState.CANT_JUMP);
      }
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

  public Square getSquareOfKing(Color color) {
    Set<Square> keySet = chessboard.keySet();
    for (Square square : keySet) {
      if (chessboard.get(square).equals(new King(color))) {
        return square;
      }
    }
    return null;
  }

  public Set<Square> getSquares() {
    return chessboard.keySet();
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

  public Piece removePiece(Square square) {
    Piece pieceToRemove = chessboard.get(square);

    if (pieceToRemove != null) {
      chessboard.remove(square);
    }
    return pieceToRemove;
  }
}
