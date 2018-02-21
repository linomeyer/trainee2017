package tech.bison.trainee17.bowling;

public class Roll {

  public final int bowledPins;

  public Roll() {
    bowledPins = randomRoll(10);
  }

  public Roll(int availablePins) {
    bowledPins = randomRoll(availablePins);
  }

  private int randomRoll(int availablePins) {
    int bowledPins = (int) Math.random() * (availablePins + 1);
    return bowledPins;
  }
}
