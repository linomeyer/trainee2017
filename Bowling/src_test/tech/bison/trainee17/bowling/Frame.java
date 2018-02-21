package tech.bison.trainee17.bowling;

public class Frame {
  public final Roll roll1;
  public final Roll roll2;
  public final int bowledPins;

  public Frame() {
    roll1 = new Roll();
    roll2 = new Roll(10 - roll1.bowledPins);
    bowledPins = roll1.bowledPins + roll2.bowledPins;
  }
}
