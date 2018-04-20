package tech.bison.trainee2017.chess;

import static org.hamcrest.CoreMatchers.is;
import static org.junit.Assert.assertThat;

import org.junit.Test;

import tech.bison.trainee2017.chess.King;

public class KingTest {
  @Test
  public void king_startAndEndPosition_validMove() throws Exception {
    King king = new King();

    boolean validMove = king.isAValidMove("c2", "d3");

    assertThat(validMove, is(true));
  }

  @Test
  public void king_startAndEndPositionAreSimilar_invalidMove() throws Exception {
    King king = new King();

    boolean validMove = king.isAValidMove("c2", "c2");

    assertThat(validMove, is(false));
  }

  @Test
  public void king_startAndEndPositionOutOfField_invalidMove() throws Exception {
    King king = new King();

    boolean validMove = king.isAValidMove("h8", "i9");

    assertThat(validMove, is(false));
  }
}
