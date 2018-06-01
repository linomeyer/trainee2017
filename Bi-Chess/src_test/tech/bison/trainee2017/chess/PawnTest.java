package tech.bison.trainee2017.chess;

import static org.hamcrest.CoreMatchers.is;
import static org.junit.Assert.assertThat;

import org.junit.Test;

import tech.bison.trainee2017.chess.Piece.Color;

public class PawnTest {
  @Test
  public void color_createPawnWithColor_WhitePawn() throws Exception {
    Color color = Color.WHITE;

    Pawn pawn = Pawn.createPawn(color);

    assertThat(pawn, is(new WhitePawn()));
  }

  @Test
  public void color_createPawnWithColor_BlackPawn() throws Exception {
    Color color = Color.BLACK;

    Pawn pawn = Pawn.createPawn(color);

    assertThat(pawn, is(new BlackPawn()));
  }
}
