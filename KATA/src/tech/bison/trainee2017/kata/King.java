package tech.bison.trainee2017.kata;

public class King extends Figures {

  public boolean move(String startPosition, String endPosition) {
    int xStart = Integer.parseInt(startPosition.charAt(0) + "");
    int yStart = letterConverter(startPosition.charAt(1) + "");
    int xEnd = Integer.parseInt(endPosition.charAt(0) + "");
    int yEnd = letterConverter(endPosition.charAt(1) + "");

    if (xStart > 8 || yStart == 10 || xEnd > 8 || yEnd == 10 || xStart < 0 || xEnd < 0)
      return false;

    int xMovement = xEnd - xStart;
    int yMovement = yEnd - yStart;

    return isAMove(xMovement, yMovement) && isAValidMove(xMovement, yMovement);
  }

  private boolean isAValidMove(int xMovement, int yMovement) {
    if (xMovement <= 1 && xMovement >= -1 && yMovement <= 1 && yMovement >= -1) {
      return true;
    }
    return false;
  }

  private boolean isAMove(int xMovement, int yMovement) {
    if (xMovement == 0 && yMovement == 0) {
      return false;
    }
    return true;
  }

  public int letterConverter(String letter) {
    String lowerCaseLetter = letter.toLowerCase();
    switch (lowerCaseLetter) {
    case "a":
      return 1;
    case "b":
      return 2;
    case "c":
      return 3;
    case "d":
      return 4;
    case "e":
      return 5;
    case "f":
      return 6;
    case "g":
      return 7;
    case "h":
      return 8;
    default:
      return 10;
    }
  }

}
