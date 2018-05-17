package tech.bison.trainee2017.chess;

import static org.hamcrest.CoreMatchers.is;
import static org.hamcrest.CoreMatchers.nullValue;
import static org.junit.Assert.assertThat;

import org.junit.Rule;
import org.junit.Test;
import org.junit.experimental.runners.Enclosed;
import org.junit.rules.ExpectedException;
import org.junit.runner.RunWith;
import org.junit.runners.Parameterized;
import org.junit.runners.Parameterized.Parameter;
import org.junit.runners.Parameterized.Parameters;

import tech.bison.trainee2017.chess.Piece.colors;

@RunWith(Enclosed.class)
public class ChessboardTest {

  @RunWith(Parameterized.class)
  public static class ChessBoardJumpBehaviourTest {
    @Rule
    public ExpectedException thrown = ExpectedException.none();

    @Parameters(name = "{0}")
    public static Movement[] data() throws InvalidSquareException {
      return new Movement[] {
          new Movement(new Square("A1"), new Square("A5")),
          new Movement(new Square("C1"), new Square("E3")),
          new Movement(new Square("D1"), new Square("D3")),
      };
    }

    @Parameter(0)
    public Movement movement;

    @Test
    public void chessBoard_movePiece_pieceCanNotJump() throws Exception {
      thrown.expect(InvalidMoveException.class);
      Chessboard chessboard = new Chessboard();
      chessboard.movePiece(movement);
    }
  }

  public static class ChessboardNormalTest {
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

    @Test
    public void chessBoard_movePiece_whitePawnCanNotJump() throws Exception {
      thrown.expect(InvalidMoveException.class);
      Chessboard chessboard = new Chessboard();

      Movement movement = new Movement(new Square("B1"), new Square("C3"));
      chessboard.movePiece(movement);
      movement = new Movement(new Square("C2"), new Square("C4"));
      chessboard.movePiece(movement);
    }

    @Test
    public void chessBoard_movePiece_blackPawnCanNotJump() throws Exception {
      thrown.expect(InvalidMoveException.class);
      Chessboard chessboard = new Chessboard();

      Movement movement = new Movement(new Square("g8"), new Square("f6"));
      chessboard.movePiece(movement);
      movement = new Movement(new Square("f7"), new Square("f5"));
      chessboard.movePiece(movement);
    }

    @Test
    public void chessBoard_movePawn_whitePawnCaptureBlackPawn() throws Exception {
      Chessboard chessboard = new Chessboard();

      Movement movement = new Movement(new Square("A2"), new Square("A4"));
      chessboard.movePiece(movement);
      movement = new Movement(new Square("B7"), new Square("B5"));
      chessboard.movePiece(movement);
      movement = new Movement(new Square("A4"), new Square("B5"));
      Piece capturedPiece = chessboard.movePiece(movement);

      assertThat(chessboard.getPiece(movement.start), is(nullValue()));
      assertThat(chessboard.getPiece(movement.end), is(new WhitePawn()));
      assertThat(capturedPiece, is(new BlackPawn()));
    }
  }
}
