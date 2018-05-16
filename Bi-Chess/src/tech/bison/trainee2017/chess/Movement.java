package tech.bison.trainee2017.chess;

import java.util.ArrayList;

public class Movement {

  public final Square start;
  public final Square end;
  public final int x;
  public final int y;

  public Movement(Square startSquare, Square endSquare) {
    this.start = startSquare;
    this.end = endSquare;

    x = endSquare.x - startSquare.x;
    y = endSquare.y - startSquare.y;
  }

  public ArrayList<Square> getWay() {
    ArrayList<Square> arrayList = new ArrayList<Square>();
    int xABS = Math.abs(x);
    int yABS = Math.abs(y);

    if (x != 0 && y != 0 && x != y)
      return arrayList;

    try {
      if (x > 0 && y == 0) {
        for (int i = 1; i < x; i++) {
          arrayList.add(new Square(start.x + i, start.y));
        }
      } else if (x < 0 && y == 0) {
        for (int i = 1; i < xABS; i++) {
          arrayList.add(new Square(start.x - i, start.y));
        }
      }

      if (y > 0 && x == 0) {
        for (int i = 1; i < y; i++) {
          arrayList.add(new Square(start.x, start.y + i));
        }
      } else if (y < 0 && x == 0) {
        for (int i = 1; i < yABS; i++) {
          arrayList.add(new Square(start.x, start.y - i));
        }
      }

      if (xABS == yABS) {
        if (x > 0 && y > 0) {
          for (int i = 1; i < xABS; i++) {
            arrayList.add(new Square(start.x + i, start.y + i));
          }
        } else if (x < 0 && y < 0) {
          for (int i = 1; i < xABS; i++) {
            arrayList.add(new Square(start.x - i, start.y - i));
          }
        } else if (x > 0 && y < 0) {
          for (int i = 1; i < xABS; i++) {
            arrayList.add(new Square(start.x + i, start.y - i));
          }
        } else if (x < 0 && y > 0) {
          for (int i = 1; i < xABS; i++) {
            arrayList.add(new Square(start.x - i, start.y + i));
          }
        }
      }

    } catch (Exception e) {
    }
    return arrayList;
  }

  @Override
  public String toString() {
    return "[" + start.toString() + "-" + end.toString() + "]";
  }
}
