package trainee.chess.movement;

import static org.junit.Assert.assertThat;

import org.junit.Test;

import static org.hamcrest.CoreMatchers.is;

import trainee.chess.Board;
import trainee.chess.Square;
import trainee.chess.movement.Move.MoveState;
import trainee.chess.piece.Bishop;
import trainee.chess.piece.Pawn;
import trainee.chess.piece.Piece.Color;
import trainee.chess.piece.Queen;
import trainee.chess.piece.Rook;

public class MoveTest {
  @Test
  public void boardWithPieces_movePiece_pieceMoved() throws Exception {
    Board board = new Board(8, 8);
    board.addPiece(new Square("A1"), new Rook(Color.WHITE));

    MoveState moveState = Move.movePiece(board, new Movement(new Square("A1"), new Square("A4")));

    assertThat(board.getPiece(new Square("A4")), is(new Rook(Color.WHITE)));
    assertThat(moveState, is(MoveState.OK));
  }

  @Test
  public void board_movePiece_startSquareWasEmpty() throws Exception {
    Board board = new Board(8, 8);

    MoveState moveState = Move.movePiece(board, new Movement(new Square("A2"), new Square("A5")));

    assertThat(moveState, is(MoveState.EMPTY_START_SQUARE));
  }

  @Test
  public void board_movePiece_enemyPieceCaptured() throws Exception {
    Board board = new Board(8, 8);
    board.addPiece(new Square("A1"), new Bishop(Color.WHITE));
    board.addPiece(new Square("C3"), new Queen(Color.BLACK));

    MoveState moveState = Move.movePiece(board, new Movement(new Square("A1"), new Square("C3")));

    assertThat(moveState, is(MoveState.PIECE_CAPTURED));
  }

  @Test
  public void board_movePiece_friendlyPieceNotCapturable() throws Exception {
    Board board = new Board(8, 8);
    board.addPiece(new Square("A1"), new Bishop(Color.WHITE));
    board.addPiece(new Square("C3"), new Queen(Color.WHITE));

    MoveState moveState = Move.movePiece(board, new Movement(new Square("A1"),
        new Square("C3")));

    assertThat(moveState, is(MoveState.FRIENDLY_PIECE_NOT_CAPTURABLE));
  }

  @Test
  public void board_movePiece_invalidMoveOfPiece() throws Exception {
    Board board = new Board(8, 8);
    board.addPiece(new Square("A1"), new Bishop(Color.WHITE));

    MoveState moveState = Move.movePiece(board, new Movement(new Square("A1"), new Square("A8")));

    assertThat(moveState, is(MoveState.INVALID_MOVE_OF_PIECE));
  }

  @Test
  public void board_movePiece_pieceWasInWay() throws Exception {
    Board board = new Board(8, 8);
    board.addPiece(new Square("A1"), new Rook(Color.WHITE));
    board.addPiece(new Square("A4"), new Pawn(Color.BLACK));

    MoveState moveState = Move.movePiece(board, new Movement(new Square("A1"), new Square("A8")));

    assertThat(moveState, is(MoveState.PIECE_IN_WAY));
  }

  @Test
  public void board_movePiece_capturePieceAsWhitePawn() throws Exception {
    Board board = new Board(8, 8);
    board.addPiece(new Square("A1"), new Pawn(Color.WHITE));
    board.addPiece(new Square("B2"), new Pawn(Color.BLACK));

    MoveState moveState = Move.movePiece(board, new Movement(new Square("A1"), new Square("B2")));

    assertThat(moveState, is(MoveState.PIECE_CAPTURED));
  }

  @Test
  public void board_movePiece_capturePieceAsBlackPawn() throws Exception {
    Board board = new Board(8, 8);
    board.addPiece(new Square("B2"), new Pawn(Color.BLACK));
    board.addPiece(new Square("A1"), new Pawn(Color.WHITE));

    MoveState moveState = Move.movePiece(board, new Movement(new Square("B2"), new Square("A1")));

    assertThat(moveState, is(MoveState.PIECE_CAPTURED));
  }
}
