package tech.bison.trainee17.bowling;

import static org.hamcrest.CoreMatchers.is;
import static org.junit.Assert.assertThat;

import org.junit.Test;

public class GameTest {
  @Test
  public void game_runTenFrames_finalScoreBetweenZeroAndHundret() throws Exception {
    Player player1 = new Player("Lars");
    Player player2 = new Player("Lino");
    Player player3 = new Player("Luca");
    Player[] players = { player1, player2, player3 };

    Game game = new Game(players);

    int successful = 0;
    for (int player = 0; player < 3; player++) {
      if (game.finalScore[player] >= 0 && game.finalScore[player] <= 100) {
        successful++;
      }
    }
    assertThat(successful, is(3));
  }
}
