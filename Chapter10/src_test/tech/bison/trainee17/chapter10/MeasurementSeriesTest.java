package tech.bison.trainee17.chapter10;

import static org.hamcrest.CoreMatchers.is;
import static org.junit.Assert.assertThat;

import org.junit.Test;

public class MeasurementSeriesTest {
  // Evaluation = Auswertung
  @Test
  public void measurementSeries_evaluate_averageHighestAndLowestValue() throws Exception {
    MeasurementSeries values = new MeasurementSeries(new double[] { 12.6, 50.2, 89.4, 78.2, 18.8 });
    Evaluation result = values.evaluate();
    assertThat(Math.round(result.averageValue * 100) / 100.0, is(49.84));
    assertThat(Math.round(result.highestValue * 100) / 100.0, is(89.4));
    assertThat(Math.round(result.lowestValue * 100) / 100.0, is(12.6));
  }
}
