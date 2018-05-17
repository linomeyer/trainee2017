package tech.bison.trainee2017.chess;

import static org.hamcrest.CoreMatchers.is;
import static org.hamcrest.CoreMatchers.nullValue;
import static org.junit.Assert.assertThat;

import org.junit.Rule;
import org.junit.Test;
import org.junit.rules.ExpectedException;

import tech.bison.trainee2017.chess.Piece.colors;

public class MoveTest {

  @Rule
  public ExpectedException thrown = ExpectedException.none();

  @Test
  public void piece_move_pieceIsOnANewSquare() throws Exception {
    Chessboard chessboard = new Chessboard();
    Move.movePiece(chessboard, new Movement(new Square("A2"), new Square("A4")));

    assertThat(chessboard.getPiece(new Square("A4")), is(new WhitePawn()));
  }

  @Test
  public void chessBoard_movePiece_whiteRookCapturesWhitePawn() throws Exception {
    thrown.expect(InvalidMoveException.class);
    Chessboard chessboard = new Chessboard();

    Movement movement = new Movement(new Square("A1"), new Square("A2"));
    Move.movePiece(chessboard, movement);
  }

  @Test
  public void chessBoard_movePiece_knightCanJump() throws Exception {
    Chessboard chessboard = new Chessboard();

    Movement movement = new Movement(new Square("B1"), new Square("A3"));

    Move move = Move.movePiece(chessboard, movement);

    assertThat(chessboard.getPiece(movement.start), is(nullValue()));
    assertThat(chessboard.getPiece(movement.end), is(new Knight(colors.WHITE)));
    assertThat(move.capturedPiece, is(nullValue()));
  }

  @Test
  public void chessBoard_movePiece_whiteRookCapturesBlackPawn() throws Exception {
    Chessboard chessboard = new Chessboard();

    Movement movement = new Movement(new Square("A2"), new Square("A4"));
    Move.movePiece(chessboard, movement);
    movement = new Movement(new Square("A1"), new Square("A3"));
    Move.movePiece(chessboard, movement);
    movement = new Movement(new Square("A3"), new Square("B3"));
    Move.movePiece(chessboard, movement);
    movement = new Movement(new Square("B3"), new Square("B7"));
    Move move = Move.movePiece(chessboard, movement);

    assertThat(move.capturedPiece, is(new BlackPawn()));
  }

  @Test
  public void chessBoard_movePiece_whitePawnCanNotJump() throws Exception {
    thrown.expect(InvalidMoveException.class);
    Chessboard chessboard = new Chessboard();

    Movement movement = new Movement(new Square("B1"), new Square("C3")); // Knight is in the Way of the white Pawn
    Move.movePiece(chessboard, movement);
    movement = new Movement(new Square("C2"), new Square("C4"));
    Move.movePiece(chessboard, movement);
  }

  @Test
  public void chessBoard_movePiece_blackPawnCanNotJump() throws Exception {
    thrown.expect(InvalidMoveException.class);
    Chessboard chessboard = new Chessboard();

    Movement movement = new Movement(new Square("g8"), new Square("f6")); // Move Knight in the Way of the black Pawn
    Move.movePiece(chessboard, movement);
    movement = new Movement(new Square("f7"), new Square("f5"));
    Move.movePiece(chessboard, movement);
  }

  @Test
  public void chessBoard_movePiece_rookCanNotJump() throws Exception {
    thrown.expect(InvalidMoveException.class);
    Chessboard chessboard = new Chessboard();

    Movement movement = new Movement(new Square("A1"), new Square("A5"));
    Move.movePiece(chessboard, movement);
  }

  @Test
  public void chessBoard_movePiece_bishopCanNotJump() throws Exception {
    thrown.expect(InvalidMoveException.class);
    Chessboard chessboard = new Chessboard();

    Movement movement = new Movement(new Square("C1"), new Square("E3"));
    Move.movePiece(chessboard, movement);
  }

  @Test
  public void chessBoard_movePiece_queenCanNotJump() throws Exception {
    thrown.expect(InvalidMoveException.class);
    Chessboard chessboard = new Chessboard();

    Movement movement = new Movement(new Square("D8"), new Square("D2"));
    Move.movePiece(chessboard, movement);
  }
  /*
   * next gamerule to implement: Pawn can capture Pieces only diagonal
   * 
   * @Test public void chessBoard_movePawn_whitePawnCaptureBlackPawn() throws
   * Exception { Chessboard chessboard = new Chessboard();
   * 
   * Movement movement = new Movement(new Square("A2"), new Square("A4"));
   * Move.movePiece(chessboard, movement, null); movement = new Movement(new
   * Square("B7"), new Square("B5")); Move.movePiece(chessboard, movement, null);
   * movement = new Movement(new Square("A4"), new Square("B5")); Move move =
   * Move.movePiece(chessboard, movement, null);
   * 
   * assertThat(chessboard.getPiece(movement.start), is(nullValue()));
   * assertThat(chessboard.getPiece(movement.end), is(new WhitePawn()));
   * assertThat(move.capturedPiece, is(new BlackPawn())); }
   */
}
