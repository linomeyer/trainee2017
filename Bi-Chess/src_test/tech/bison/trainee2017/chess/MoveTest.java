package tech.bison.trainee2017.chess;

import static org.hamcrest.CoreMatchers.is;
import static org.hamcrest.CoreMatchers.nullValue;
import static org.junit.Assert.assertThat;

import org.junit.Test;

import tech.bison.trainee2017.chess.Game.GameState;
import tech.bison.trainee2017.chess.pieces.BlackPawn;
import tech.bison.trainee2017.chess.pieces.Knight;
import tech.bison.trainee2017.chess.pieces.Piece.Color;
import tech.bison.trainee2017.chess.pieces.WhitePawn;

public class MoveTest {

  @Test
  public void piece_move_pieceIsOnANewSquare() throws Exception {
    Chessboard chessboard = new Chessboard();
    Move.movePiece(chessboard, new Movement(new Square("A2"), new Square("A4")));

    assertThat(chessboard.getPiece(new Square("A4")), is(new WhitePawn()));
  }

  @Test
  public void chessBoard_movePiece_whiteRookCapturesWhitePawn() throws Exception {
    Chessboard chessboard = new Chessboard();

    Movement movement = new Movement(new Square("A1"), new Square("A2"));
    try {
      Move.movePiece(chessboard, movement);
    } catch (InvalidMoveException e) {
      assertThat(e.state, is(GameState.FRIENDED_COLOR));
    }
  }

  @Test
  public void chessBoard_movePiece_knightCanJump() throws Exception {
    Chessboard chessboard = new Chessboard();

    Movement movement = new Movement(new Square("B1"), new Square("A3"));

    Move move = Move.movePiece(chessboard, movement);

    assertThat(chessboard.getPiece(movement.start), is(nullValue()));
    assertThat(chessboard.getPiece(movement.end), is(new Knight(Color.WHITE)));
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
  public void chessBoard_movePiece_pawnCanNotJump() throws Exception {
    Chessboard chessboard = new Chessboard();

    Movement movement = new Movement(new Square("B1"), new Square("C3")); // Knight is in the Way of the white Pawn
    Move.movePiece(chessboard, movement);
    movement = new Movement(new Square("c2"), new Square("c4"));
    try {
      Move.movePiece(chessboard, movement);
    } catch (InvalidMoveException e) {
      assertThat(e.state, is(GameState.CANT_JUMP));
    }
  }

  @Test
  public void chessBoard_movePiece_rookCanNotJump() throws Exception {
    Chessboard chessboard = new Chessboard();

    Movement movement = new Movement(new Square("A1"), new Square("A5"));
    try {
      Move.movePiece(chessboard, movement);
    } catch (InvalidMoveException e) {
      assertThat(e.state, is(GameState.CANT_JUMP));
    }
  }

  @Test
  public void chessBoard_movePiece_bishopCanNotJump() throws Exception {
    Chessboard chessboard = new Chessboard();

    Movement movement = new Movement(new Square("C1"), new Square("E3"));
    try {
      Move.movePiece(chessboard, movement);
    } catch (InvalidMoveException e) {
      assertThat(e.state, is(GameState.CANT_JUMP));
    }
  }

  @Test
  public void chessBoard_movePiece_queenCanNotJump() throws Exception {
    Chessboard chessboard = new Chessboard();

    Movement movement = new Movement(new Square("D1"), new Square("D4"));
    try {
      Move.movePiece(chessboard, movement);
    } catch (InvalidMoveException e) {
      assertThat(e.state, is(GameState.CANT_JUMP));
    }
  }

  @Test
  public void chessboard_moveBlackPiece_WhiteBeginsException() throws Exception {
    try {
      Chessboard chessboard = new Chessboard();

      Movement movement = new Movement(new Square("d7"), new Square("d5"));

      Move.movePiece(chessboard, movement);
    } catch (InvalidMoveException e) {
      assertThat(e.state, is(GameState.WHITE_BEGINS));
    }
  }

  @Test
  public void chessboard_moveWhitePieceTwice_MoveAlternatelyException() throws Exception {
    try {
      Chessboard chessboard = new Chessboard();

      Movement movement = new Movement(new Square("e2"), new Square("e4"));
      Move.movePiece(chessboard, movement);

      movement = new Movement(new Square("f2"), new Square("f4"));
      Move.movePiece(chessboard, movement);

    } catch (InvalidMoveException e) {
      assertThat(e.state, is(GameState.WHITE_BEGINS));
    }
  }

  // next gamerule to implement: Pawn can capture Pieces only diagonal

  @Test
  public void chessBoard_movePawn_whitePawnCaptureBlackPawn() throws Exception {
    Chessboard chessboard = new Chessboard();

    Movement movement = new Movement(new Square("A2"), new Square("A4"));
    Move move = Move.movePiece(chessboard, movement, null);

    movement = new Movement(new Square("B7"), new Square("B5"));
    move = Move.movePiece(chessboard, movement, move);

    movement = new Movement(new Square("A4"), new Square("B5"));
    move = Move.movePiece(chessboard, movement, move);

    assertThat(chessboard.getPiece(movement.start), is(nullValue()));
    assertThat(chessboard.getPiece(movement.end), is(new WhitePawn()));
    assertThat(move.capturedPiece, is(new BlackPawn()));
  }

  @Test
  public void chessBoard_movePawn_InvalidMoveException_CATCH_DIAGONAL() throws Exception {
    Chessboard chessboard = new Chessboard();

    Movement movement = new Movement(new Square("A2"), new Square("A4"));
    Move move = Move.movePiece(chessboard, movement, null);

    movement = new Movement(new Square("A7"), new Square("A5"));
    move = Move.movePiece(chessboard, movement, move);

    try {

      movement = new Movement(new Square("A4"), new Square("A5"));
      move = Move.movePiece(chessboard, movement, move);

    } catch (InvalidMoveException e) {
      assertThat(e.state, is(GameState.CATCH_DIAGONAL));
    }
  }

}
