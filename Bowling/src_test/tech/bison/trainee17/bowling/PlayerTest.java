package tech.bison.trainee17.bowling;

import static org.hamcrest.CoreMatchers.is;
import static org.junit.Assert.assertThat;

import org.junit.Test;

public class PlayerTest {
  @Test
  public void player_giveName_getName() throws Exception {
    Player player1 = new Player("Lars");
    Player player2 = new Player("Lino");
    Player player3 = new Player("Luca");

    assertThat(player1.name, is("Lars"));
    assertThat(player2.name, is("Lino"));
    assertThat(player3.name, is("Luca"));
  }
}
