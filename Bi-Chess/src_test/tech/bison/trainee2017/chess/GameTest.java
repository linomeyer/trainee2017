package tech.bison.trainee2017.chess;

import static org.hamcrest.CoreMatchers.is;
import static org.hamcrest.CoreMatchers.nullValue;
import static org.junit.Assert.assertThat;

import org.junit.Test;

import tech.bison.trainee2017.chess.Game.GameState;
import tech.bison.trainee2017.chess.pieces.Bishop;
import tech.bison.trainee2017.chess.pieces.BlackPawn;
import tech.bison.trainee2017.chess.pieces.King;
import tech.bison.trainee2017.chess.pieces.Piece.Color;
import tech.bison.trainee2017.chess.pieces.Rook;
import tech.bison.trainee2017.chess.pieces.WhitePawn;

public class GameTest {
  @Test
  public void game_createDefaultChessGame_gameWithChessboardAndPieces() throws Exception {
    Game game = new Game();

    assertThat(game.getChessboard(), is(new Chessboard()));
  }

  @Test
  public void chessboard_createCustomGameWithChessboard_gameWithCustomChessboard() throws Exception {
    Chessboard chessboard = new Chessboard(3, 9);
    chessboard.addPiece(new Square("c8"), new King(Color.WHITE));

    Game game = new Game(chessboard);

    assertThat(game.getChessboard(), is(chessboard));
  }

  @Test
  public void defaultChessGame_movePiece_moveWasGeneratedAndPieceHasMoved() throws Exception {
    Game game = new Game();

    GameState state = game.movePiece(new Movement(new Square("b2"), new Square("b4")));

    assertThat(game.getPiece(new Square("b4")), is(new WhitePawn()));
    assertThat(game.getPiece(new Square("b2")), is(nullValue()));
    assertThat(state, is(GameState.PIECE_MOVED));
  }

  @Test
  public void customChessGame_whiteBishopCatchesBlackRook_getCapturedPiece() throws Exception {
    Chessboard chessboard = new Chessboard(6, 6);
    chessboard.addPiece(new Square("a1"), new Bishop(Color.WHITE));
    chessboard.addPiece(new Square("b2"), new Rook(Color.BLACK));

    Game game = new Game(chessboard);

    GameState state = game.movePiece(new Movement(new Square("a1"), new Square("b2")));

    assertThat(game.getLastMove().capturedPiece, is(new Rook(Color.BLACK)));
    assertThat(state, is(GameState.PIECE_CAPTURED));
  }

  @Test
  public void customChessGame_addPieces_customChessGameWithPieces() throws Exception {
    Game game = new Game(new Chessboard(8, 8));

    GameState gameState = game.addPiece(new Square("a2"), new BlackPawn());

    assertThat(gameState, is(GameState.PIECE_ADDED));
  }

  @Test
  public void game_moveWhitePieceTwice_InvalidMoveException_MOVE_ALTERNATELY() throws Exception {
    Game game = new Game();

    Movement movement = new Movement(new Square("e2"), new Square("e4"));
    game.movePiece(movement);

    movement = new Movement(new Square("f2"), new Square("f4"));
    GameState state = game.movePiece(movement);

    assertThat(state, is(GameState.MOVE_ALTERNATELY));
  }

  @Test
  public void game_captureBlackKing_whiteWon() throws Exception {
    Game game = new Game(new Chessboard(8, 8));

    game.addPiece(new Square("A1"), new King(Color.BLACK));
    game.addPiece(new Square("A2"), new Rook(Color.WHITE));

    GameState state = game.movePiece(new Movement(new Square("A2"), new Square("A1")));

    assertThat(state, is(GameState.WHITE_WON_GAME));
  }
}
