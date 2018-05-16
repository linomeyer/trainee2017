package tech.bison.trainee2017.chess;

import static org.hamcrest.CoreMatchers.is;
import static org.hamcrest.CoreMatchers.nullValue;
import static org.junit.Assert.assertThat;

import org.junit.Rule;
import org.junit.Test;
import org.junit.rules.ExpectedException;

import tech.bison.trainee2017.chess.Piece.colors;

public class ChessboardTest {
  @Rule
  public ExpectedException thrown = ExpectedException.none();

  @Test
  public void chessboard_getPieceWithSquare_piece() throws Exception {
    Chessboard chessboard = new Chessboard();

    Piece gettedPiece = chessboard.getPiece(new Square("A1"));

    assertThat(gettedPiece, is(new Rook(colors.WHITE)));
  }

  @Test
  public void chessboard_movePiece_pieceIsOnNewSquare() throws Exception {
    Chessboard chessboard = new Chessboard();

    Movement movement = new Movement(new Square("A2"), new Square("A4"));

    Piece capturedPiece = chessboard.movePiece(movement);

    assertThat(chessboard.getPiece(movement.start), is(nullValue()));
    assertThat(capturedPiece, is(nullValue()));
    assertThat(chessboard.getPiece(movement.end), is(new WhitePawn()));
  }

  /* Parameterisierter Test für jede Figur die Theoretisch springen kann */
  @Test
  public void chessboard_movePiece_towerCanNotJump() throws Exception {
    thrown.expect(InvalidMoveException.class);
    Chessboard chessboard = new Chessboard();

    Movement movement = new Movement(new Square("A1"), new Square("A5"));

    chessboard.movePiece(movement);
  }

  @Test
  public void chessBoard_movePiece_knightCanJump() throws Exception {
    Chessboard chessboard = new Chessboard();

    Movement movement = new Movement(new Square("B1"), new Square("A3"));

    Piece capturedPiece = chessboard.movePiece(movement);

    assertThat(chessboard.getPiece(movement.start), is(nullValue()));
    assertThat(chessboard.getPiece(movement.end), is(new Knight(colors.WHITE)));
    assertThat(capturedPiece, is(nullValue()));
  }

  @Test
  public void chessBoard_movePiece_whiteRookCapturesBlackPawn() throws Exception {
    Chessboard chessboard = new Chessboard();

    Movement movement = new Movement(new Square("A2"), new Square("A4"));
    chessboard.movePiece(movement);
    movement = new Movement(new Square("A1"), new Square("A3"));
    chessboard.movePiece(movement);
    movement = new Movement(new Square("A3"), new Square("B3"));
    chessboard.movePiece(movement);
    movement = new Movement(new Square("B3"), new Square("B7"));
    Piece capturedPiece = chessboard.movePiece(movement);

    assertThat(capturedPiece, is(new BlackPawn()));
  }

  @Test
  public void chessBoard_movePiece_whiteRookCapturesWhitePawn() throws Exception {
    thrown.expect(InvalidMoveException.class);
    Chessboard chessboard = new Chessboard();

    Movement movement = new Movement(new Square("A1"), new Square("A2"));
    chessboard.movePiece(movement);
  }
}
