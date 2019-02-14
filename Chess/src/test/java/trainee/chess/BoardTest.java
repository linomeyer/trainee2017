package trainee.chess;

import static org.junit.Assert.assertThat;
import static org.junit.jupiter.api.Assertions.assertNull;

import org.junit.Test;

import static org.hamcrest.CoreMatchers.is;

import trainee.chess.movement.Movement;
import trainee.chess.piece.Knight;
import trainee.chess.piece.Piece.Color;
import trainee.chess.piece.Rook;

public class BoardTest {
  @Test
  public void board_getPiece_piece() throws Exception {
    Board board = new Board();
    assertThat(board.getPiece(new Square("A1")), is(new Rook(Color.WHITE)));
  }

  @Test
  public void board_addPiece_pieceAdded() throws Exception {
    Board board = new Board();

    board.addPiece(new Square("B4"), new Rook(Color.BLACK));

    assertThat(board.getPiece(new Square("B4")), is(new Rook(Color.BLACK)));
  }

  @Test
  public void board_removePiece_pieceRemoved() throws Exception {
    Board board = new Board();

    board.removePiece(new Square("A1"));

    assertNull(board.getPiece(new Square("A1")));
  }

  @Test
  public void board_isPieceInWay_true() throws Exception {
    Board board = new Board(8, 8);
    board.addPiece(new Square("A1"), new Rook(Color.WHITE));
    board.addPiece(new Square("A3"), new Rook(Color.BLACK));

    boolean isPieceInWay = board.isPieceInWay(new Movement(new Square("A1"), new Square("A6")));

    assertThat(isPieceInWay, is(true));
  }

  @Test
  public void board_isPieceInWay_false() throws Exception {
    Board board = new Board(8, 8);
    board.addPiece(new Square("A1"), new Rook(Color.WHITE));
    board.addPiece(new Square("B3"), new Rook(Color.BLACK));

    boolean isPieceInWay = board.isPieceInWay(new Movement(new Square("A1"), new Square("A6")));

    assertThat(isPieceInWay, is(false));
  }

  @Test
  public void board_isPieceInWay_falseBecausePieceMovingIsKnight() throws Exception {
    Board board = new Board(8, 8);
    board.addPiece(new Square("A1"), new Knight(Color.WHITE));
    board.addPiece(new Square("A3"), new Rook(Color.BLACK));

    boolean isPieceInWay = board.isPieceInWay(new Movement(new Square("A1"), new Square("B3")));

    assertThat(isPieceInWay, is(false));
  }
}
