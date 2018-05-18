package tech.bison.trainee2017.chess;

public class MoveValidator {
  public enum State {
    OK, WRONG_LENGTH, UNKNOWN_PIECE
  }

  public boolean validateLength(String input) {
    return input.length() == 6;
  }

  public boolean validatePiece(char piece) {
    switch (piece) {
    case 'R':
    case 'Q':
    case 'P':
    case 'K':
    case 'B':
    case 'N':
      return true;

    default:
      return false;
    }
  }

  public State validate(String input) {
    if (!validateLength(input)) {
      return State.WRONG_LENGTH;
    }
    if (!validatePiece(input.charAt(0))) {
      return State.UNKNOWN_PIECE;
    }
    return State.OK;
  }

}
