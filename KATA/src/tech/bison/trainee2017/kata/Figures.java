package tech.bison.trainee2017.kata;

public class Figures {
  static boolean isInField(Position position) {
    if (position.x < 1 || position.x > 8 || position.y == 10) {
      return false;
    }
    return true;
  }

  static boolean isAMove(int xMovement, int yMovement) {
    if (xMovement == 0 && yMovement == 0) {
      return false;
    }
    return true;
  }
}
