package tech.bison.trainee17.bowling;

public class Game {

  public final int[] finalScore;
  final Frame[][] finalFrames;
  Player[] players;

  public Game(Player[] players) {
    Frame[][] frames;
    frames = new Frame[players.length][10];
    int[] score = new int[players.length];

    for (int player = 0; player < players.length; player++) {

      for (int x = 0; x < 10; x++) {

        frames[player][x] = new Frame();
        score[player] += frames[player][x].bowledPins;
      }
    }
    finalScore = score;
    finalFrames = frames;
  }

}
