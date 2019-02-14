package trainee.chess;

public class Square {
  private final Coordinates coordinates;
  private final String name;

  public Square(String name) {
    this.name = name;

    int x = calculateX(name.charAt(0));
    int y = Integer.parseInt(String.valueOf(name.charAt(1))) - 1;
    coordinates = new Coordinates(x, y);
  }

  public Square(Coordinates coordinates) {
    this.coordinates = coordinates;
    name = coordinates.toString();
  }

  private int calculateX(char x) {
    return x - 65;
  }

  public Coordinates getCoordinates() {
    return coordinates;
  }

  public String getName() {
    return name;
  }

  @Override
  public String toString() {
    return name;
  }

  @Override
  public boolean equals(Object obj) {
    if (this == obj)
      return true;
    if (obj == null)
      return false;
    if (getClass() != obj.getClass())
      return false;
    Square other = (Square) obj;
    if (coordinates == null) {
      if (other.coordinates != null)
        return false;
    } else if (!coordinates.equals(other.coordinates))
      return false;
    if (name == null) {
      if (other.name != null)
        return false;
    } else if (!name.equals(other.name))
      return false;
    return true;
  }

}
