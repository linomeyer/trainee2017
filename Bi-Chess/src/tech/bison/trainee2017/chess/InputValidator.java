package tech.bison.trainee2017.chess;

import java.util.ArrayList;

public class InputValidator {
  public Game game;

  public enum ValidationState {
    OK, WRONG_LENGTH, UNKNOWN_PIECE, INVALID_POSITION_SYNTAX, INVALID_CHESSBOARD_SIZE, INVALID_CHESSBOARD_SYNTAX
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

  public ArrayList<ValidationState> validateMove(String input) {
    ArrayList<ValidationState> states = new ArrayList<ValidationState>();
    if (!validateLength(input)) {
      states.add(ValidationState.WRONG_LENGTH);
    }
    if (!validatePiece(input.charAt(0))) {
      states.add(ValidationState.UNKNOWN_PIECE);
    }
    if (!validatePositions(input)) {
      states.add(ValidationState.INVALID_POSITION_SYNTAX);
    }

    if (states.isEmpty()) {
      states.add(ValidationState.OK);
    }
    return states;

  }

  public boolean validatePositions(String input) {
    try {
      String startPosition = input.substring(1, 3);
      String endPosition = input.substring(4, 6);

      Integer.parseInt(Character.toString(startPosition.charAt(1)));
      Integer.parseInt(Character.toString(endPosition.charAt(1)));
      boolean checkPositions = startPosition.charAt(0) >= 'a' && startPosition.charAt(0) <= 'z'
          && endPosition.charAt(0) >= 'a' && endPosition.charAt(0) <= 'z';

      if (checkPositions) {
        return true;
      } else {
        return false;
      }
    } catch (Exception e) {
      return false;
    }

  }

}
