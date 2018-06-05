package tech.bison.trainee2017.chess.console;

import java.util.ArrayList;

import tech.bison.trainee2017.chess.Game;

public class InputValidator {
  public Game game;

  public enum ValidationState {
    OK, WRONG_LENGTH, UNKNOWN_PIECE, UNKNOWN_COLOR, INVALID_SQUARE_SYNTAX
  }

  public boolean validateLength(String input, int length) {
    return input.length() == length;
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
    if (!validateLength(input, 6)) {
      states.add(ValidationState.WRONG_LENGTH);
    }
    if (states.isEmpty()) {
      if (!validatePiece(input.charAt(0))) {
        states.add(ValidationState.UNKNOWN_PIECE);
      }
      String startPosition = input.substring(1, 3);
      String endPosition = input.substring(4, 6);
      if (!validateSquare(startPosition) || !validateSquare(endPosition)) {
        states.add(ValidationState.INVALID_SQUARE_SYNTAX);
      }
    }
    if (states.isEmpty()) {
      states.add(ValidationState.OK);
    }
    return states;

  }

  public boolean validateSquare(String square) {
    try {
      Integer.parseInt(Character.toString(square.charAt(1)));
      return square.charAt(0) >= 'a' && square.charAt(0) <= 'z';
    } catch (Exception e) {
      return false;
    }
  }

  public ArrayList<ValidationState> validateAddPiece(String input) {
    ArrayList<ValidationState> states = new ArrayList<ValidationState>();
    if (!validateLength(input, 4)) {
      states.add(ValidationState.WRONG_LENGTH);
    }
    if (states.isEmpty()) {
      if (!input.substring(0, 2).equals("RM")) {
        if (!validatePiece(input.charAt(1))) {
          states.add(ValidationState.UNKNOWN_PIECE);
        }
        if (!validateColor(input.charAt(0))) {
          states.add(ValidationState.UNKNOWN_COLOR);
        }
      }
      String square = input.substring(2, 4);
      if (!validateSquare(square)) {
        states.add(ValidationState.INVALID_SQUARE_SYNTAX);
      }
    }
    if (states.isEmpty()) {
      states.add(ValidationState.OK);
    }
    return states;
  }

  private boolean validateColor(char color) {
    return color == 'W' || color == 'B';
  }
}
