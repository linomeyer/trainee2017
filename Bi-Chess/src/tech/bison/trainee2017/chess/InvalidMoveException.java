package tech.bison.trainee2017.chess;

import tech.bison.trainee2017.chess.Game.GameState;

public class InvalidMoveException extends Exception {
  private static final long serialVersionUID = 1L;
  public final GameState state;

  public InvalidMoveException(GameState state) {
    this.state = state;
  }
}
