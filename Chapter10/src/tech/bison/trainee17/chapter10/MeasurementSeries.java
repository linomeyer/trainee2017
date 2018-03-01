package tech.bison.trainee17.chapter10;

public class MeasurementSeries {
  double[] values;

  public MeasurementSeries(double[] values) {
    this.values = values;
  }

  public Evaluation evaluate() {
    return new Evaluation(highestValue(), lowestValue(), averageValue());
  }

  private double averageValue() {
    int length = values.length;
    double averageValue = 0;
    for (double value : values) {
      averageValue += value;
    }
    averageValue /= length;
    return averageValue;
  }

  private double highestValue() {
    double highestValue = values[0];
    for (double value : values) {
      if (value > highestValue)
        highestValue = value;
    }
    return highestValue;
  }

  private double lowestValue() {
    double lowestValue = values[0];
    for (double value : values) {
      if (value < lowestValue)
        lowestValue = value;
    }
    return lowestValue;
  }

  public double[] changeValue(int index, double replaceValue) {
    values[index] = replaceValue;
    return values;

  }
}
