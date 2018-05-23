package tech.bison.trainee2017.chess;

import static org.hamcrest.CoreMatchers.is;
import static org.junit.Assert.assertThat;

import org.junit.Test;

import tech.bison.trainee2017.chess.Piece.Color;

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

}
