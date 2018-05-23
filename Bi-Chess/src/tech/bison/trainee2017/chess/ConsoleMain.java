package tech.bison.trainee2017.chess;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.HashMap;

import tech.bison.trainee2017.chess.MoveValidator.State;

public class ConsoleMain {
  static final HashMap<State, String> states = new HashMap<State, String>();

  public static void main(String[] args) throws IOException {
    initializeStates();
    boolean repeat = true;
    MoveValidator moveValidator = new MoveValidator();
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

    while (repeat) {
      System.out.print("Zug validieren: ");
      String input = br.readLine();

      if (input.equals("quit")) {
        repeat = false;
      } else {
        ArrayList<State> state = moveValidator.validate(input);
        for (State s : state) {
          System.out.println(states.get(s));
        }
      }
    }
  }

  private static void initializeStates() {
    states.put(State.OK, "Ihr Zug ist gültig");
    states.put(State.UNKNOWN_PIECE, "Ihre eingegebene Figur gibt es nicht");
    states.put(State.WRONG_LENGTH, "Ihre Eingabe hatte die falsche Länge");
    states.put(State.INVALID_POSITION_SYNTAX, "Für die Positionen wurde eine falsche Syntax angewendet");
  }
}
