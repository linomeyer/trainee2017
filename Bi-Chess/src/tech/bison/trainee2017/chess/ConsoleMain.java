package tech.bison.trainee2017.chess;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

import tech.bison.trainee2017.chess.MoveValidator.State;

public class ConsoleMain {

  public static void main(String[] args) throws IOException {
    boolean repeat = true;
    MoveValidator moveValidator = new MoveValidator();
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

    while (repeat) {
      System.out.print("Zug validieren: ");
      String input = br.readLine();

      if (input.equals("quit")) {
        repeat = false;
      } else {
        State state = moveValidator.validate(input);
        switch (state) {
        case OK:
          System.out.println("Ihr Zug ist gültig");
          break;
        case UNKNOWN_PIECE:
          System.out.println("Ihre eingegebene Figur gibt es nicht");
          break;
        case WRONG_LENGTH:
          System.out.println("Ihre Eingabe hatte die falsche Länge");
          break;
        }
      }
    }
  }
}
