package trainee.chess.movement;

import java.util.ArrayList;
import java.util.List;

import trainee.chess.Coordinates;
import trainee.chess.Square;

public class Movement {
  private final Square startSquare;
  private final Square endSquare;

  private final int xMovement;
  private final int yMovement;

  public Movement(Square startSquare, Square endSquare) {
    this.startSquare = startSquare;
    this.endSquare = endSquare;

    xMovement = endSquare.getCoordinates().getX() - startSquare.getCoordinates().getX();
    yMovement = endSquare.getCoordinates().getY() - startSquare.getCoordinates().getY();
  }

  public Square getStartSquare() {
    return startSquare;
  }

  public Square getEndSquare() {
    return endSquare;
  }

  public int getXMovement() {
    return xMovement;
  }

  public int getYMovement() {
    return yMovement;
  }

  public List<Square> getWay() {
    List<Square> squares = new ArrayList<>();
    if (yMovement != 0 && xMovement == 0) {
      squares.addAll(getVerticalWay());
    } else if (xMovement != 0 && yMovement == 0) {
      squares.addAll(getHorizontalWay());
    } else if (xMovement != 0 && yMovement != 0 && Math.abs(xMovement) == Math.abs(yMovement)) {
      squares.addAll(getDiagonalWay());
    }
    return squares;
  }

  private List<Square> getDiagonalWay() {
    List<Square> squares = new ArrayList<>();
    if (xMovement > 0 && yMovement > 0) {
      squares.addAll(getDiagonalUpRightWay());
    } else if (xMovement > 0 && yMovement < 0) {
      squares.addAll(getDiagonalDownRightWay());
    } else if (xMovement < 0 && yMovement > 0) {
      squares.addAll(getDiagonalUpLeftWay());
    } else {
      squares.addAll(getDiagonalDownLeftWay());
    }
    return squares;
  }

  private List<Square> getDiagonalUpRightWay() {
    List<Square> squares = new ArrayList<>();
    Coordinates coordinates = startSquare.getCoordinates();
    for (int i = 1; i < xMovement; i++) {
      squares.add(new Square(new Coordinates(coordinates.getX() + i, coordinates.getY() + i)));
    }
    return squares;
  }

  private List<Square> getDiagonalUpLeftWay() {
    List<Square> squares = new ArrayList<>();
    Coordinates coordinates = startSquare.getCoordinates();
    for (int i = 1; i < yMovement; i++) {
      squares.add(new Square(new Coordinates(coordinates.getX() - i, coordinates.getY() + i)));
    }
    return squares;
  }

  private List<Square> getDiagonalDownRightWay() {
    List<Square> squares = new ArrayList<>();
    Coordinates coordinates = startSquare.getCoordinates();
    for (int i = 1; i < xMovement; i++) {
      squares.add(new Square(new Coordinates(coordinates.getX() + i, coordinates.getY() - i)));
    }
    return squares;
  }

  private List<Square> getDiagonalDownLeftWay() {
    List<Square> squares = new ArrayList<>();
    Coordinates coordinates = startSquare.getCoordinates();
    for (int i = 1; i < Math.abs(xMovement); i++) {
      squares.add(new Square(new Coordinates(coordinates.getX() - i, coordinates.getY() - i)));
    }
    return squares;
  }

  private List<Square> getHorizontalWay() {
    List<Square> squares = new ArrayList<>();
    if (xMovement > 0) {
      squares.addAll(getHorizontalRightwardsWay());
    } else {
      squares.addAll(getHorizontalLeftwardsWay());
    }
    return squares;
  }

  private List<Square> getHorizontalRightwardsWay() {
    List<Square> squares = new ArrayList<>();
    Coordinates coordinates = startSquare.getCoordinates();
    for (int x = 1; x < xMovement; x++) {
      squares.add(new Square(new Coordinates(coordinates.getX() + x, coordinates.getY())));
    }
    return squares;
  }

  private List<Square> getHorizontalLeftwardsWay() {
    List<Square> squares = new ArrayList<>();
    Coordinates coordinates = startSquare.getCoordinates();
    for (int x = 1; x < Math.abs(xMovement); x++) {
      squares.add(new Square(new Coordinates(coordinates.getX() - x, coordinates.getY())));
    }
    return squares;
  }

  private List<Square> getVerticalWay() {
    List<Square> squares = new ArrayList<>();
    if (yMovement > 0) {
      squares.addAll(getVerticalUpwardsWay());
    } else if (yMovement < 0) {
      squares.addAll(getVerticalDownwardsWay());
    }
    return squares;
  }

  private List<Square> getVerticalDownwardsWay() {
    List<Square> squares = new ArrayList<>();
    Coordinates coordinates = startSquare.getCoordinates();
    for (int y = 1; y < Math.abs(yMovement); y++) {
      squares.add(new Square(new Coordinates(coordinates.getX(), coordinates.getY() - y)));
    }
    return squares;
  }

  private List<Square> getVerticalUpwardsWay() {
    List<Square> squares = new ArrayList<>();
    Coordinates coordinates = startSquare.getCoordinates();
    for (int y = 1; y < yMovement; y++) {
      squares.add(new Square(new Coordinates(coordinates.getX(), coordinates.getY() + y)));
    }
    return squares;
  }

}
