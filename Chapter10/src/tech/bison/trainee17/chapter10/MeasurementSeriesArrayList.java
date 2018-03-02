package tech.bison.trainee17.chapter10;

import java.util.ArrayList;

public class MeasurementSeriesArrayList extends ArrayList<Double> {

  private static final long serialVersionUID = 1L;

  public MeasurementSeriesArrayList() {
    super();
  }

  public Evaluation evaluate() {
    return new Evaluation(highestValue(), lowestValue(), averageValue());
  }

  private double averageValue() {
    int length = this.size();
    double averageValue = 0;
    for (int x = length - 1; x >= 0; x--) {
      averageValue += this.get(x);
    }
    return averageValue / length;
  }

  private double highestValue() {
    double highestValue = this.get(0);
    int length = this.size();
    for (int x = 0; x < length; x++) {
      if (this.get(x) > highestValue)
        highestValue = this.get(x);
    }
    return highestValue;
  }

  private double lowestValue() {
    double lowestValue = this.get(0);
    int length = this.size();
    for (int x = 0; x < length; x++) {
      if (this.get(x) < lowestValue)
        lowestValue = this.get(x);
    }
    return lowestValue;
  }
}
