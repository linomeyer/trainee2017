package trainee.chess;

public class Coordinates {
  private int x;
  private int y;

  public Coordinates(int x, int y) {
    this.x = x;
    this.y = y;
  }

  public int getX() {
    return x;
  }

  public int getY() {
    return y;
  }

  @Override
  public String toString() {
    String name = "";
    name += (char) (getX() + 65);
    name += String.valueOf(getY() + 1);
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
    Coordinates other = (Coordinates) obj;
    if (x != other.x)
      return false;
    if (y != other.y)
      return false;
    return true;
  }

}
