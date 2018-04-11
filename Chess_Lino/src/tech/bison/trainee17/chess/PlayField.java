package tech.bison.trainee17.chess;

import tech.bison.trainee17.chess.Figure.color;

public class PlayField {
  // White figures
  public static Queen whiteQueen = new Queen(color.white);
  public static King whiteKing = new King(color.white);

  public static Runner whiteRunner1 = new Runner(color.white, 1);
  public static Runner whiteRunner2 = new Runner(color.white, 2);

  public static Jumper whiteJumper1 = new Jumper(color.white, 1);
  public static Jumper whiteJumper2 = new Jumper(color.white, 2);

  public static Tower whiteTower1 = new Tower(color.white, 1);
  public static Tower whiteTower2 = new Tower(color.white, 2);

  public static Pawn whitePawnA = new Pawn(color.white, 1);
  public static Pawn whitePawnB = new Pawn(color.white, 2);
  public static Pawn whitePawnC = new Pawn(color.white, 3);
  public static Pawn whitePawnD = new Pawn(color.white, 4);
  public static Pawn whitePawnE = new Pawn(color.white, 5);
  public static Pawn whitePawnF = new Pawn(color.white, 6);
  public static Pawn whitePawnG = new Pawn(color.white, 7);
  public static Pawn whitePawnH = new Pawn(color.white, 8);

  // Black figures
  public static Queen blackQueen = new Queen(color.black);
  public static King blackKing = new King(color.black);

  public static Runner blackRunner1 = new Runner(color.black, 1);
  public static Runner blackRunner2 = new Runner(color.black, 2);

  public static Jumper blackJumper1 = new Jumper(color.black, 1);
  public static Jumper blackJumper2 = new Jumper(color.black, 2);

  public static Tower blackTower1 = new Tower(color.black, 1);
  public static Tower blackTower2 = new Tower(color.black, 2);

  public static Pawn blackPawnA = new Pawn(color.black, 1);
  public static Pawn blackPawnB = new Pawn(color.black, 2);
  public static Pawn blackPawnC = new Pawn(color.black, 3);
  public static Pawn blackPawnD = new Pawn(color.black, 4);
  public static Pawn blackPawnE = new Pawn(color.black, 5);
  public static Pawn blackPawnF = new Pawn(color.black, 6);
  public static Pawn blackPawnG = new Pawn(color.black, 7);
  public static Pawn blackPawnH = new Pawn(color.black, 8);

}
