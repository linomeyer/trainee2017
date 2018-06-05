package tech.bison.trainee2017.chess.pieces;

import static org.hamcrest.CoreMatchers.is;
import static org.junit.Assert.assertThat;

import org.junit.Test;

import tech.bison.trainee2017.chess.Movement;
import tech.bison.trainee2017.chess.pieces.Piece.Color;

public class PieceTest {
  @Test
  public void piece_moveOneUp_isAMove() throws Exception {
    Piece piece = new TestPiece();

    boolean isAMove = piece.isAMove(1, 0);

    assertThat(isAMove, is(true));
  }

  @Test
  public void piece_moveOneRight_isAMove() throws Exception {
    Piece piece = new TestPiece();

    boolean isAMove = piece.isAMove(0, 1);

    assertThat(isAMove, is(true));
  }

  @Test
  public void piece_dontMove_isNotAMove() throws Exception {
    Piece piece = new TestPiece();

    boolean isAMove = piece.isAMove(0, 0);

    assertThat(isAMove, is(false));
  }

  @Test
  public void piece_moveOutOfField_invalidMove() throws Exception {
    Piece piece = new TestPiece();

    boolean isAValidMove = piece.isAValidMove("h8", "h9");

    assertThat(isAValidMove, is(false));
  }

  @Test
  public void twoPieces_hasSameColor_true() throws Exception {
    Piece piece1 = new TestPiece(Color.WHITE);

    Piece piece2 = new TestPiece(Color.WHITE);

    boolean hasSameColor = piece1.hasSameColor(piece2);

    assertThat(hasSameColor, is(true));
  }

  @Test
  public void twoPieces_hasSameColor_false() throws Exception {
    Piece piece1 = new TestPiece(Color.WHITE);

    Piece piece2 = new TestPiece(Color.BLACK);

    boolean hasSameColor = piece1.hasSameColor(piece2);

    assertThat(hasSameColor, is(false));
  }

  class TestPiece extends Piece {

    public TestPiece() {
      super(Color.WHITE);
    }

    public TestPiece(Color color) {
      super(color);
    }

    @Override
    public boolean isAValidMove(Movement movement) {
      return false;
    }

    @Override
    public char getSymbol() {
      return '0';
    }
  }

}
