package tech.bison.trainee17.chapter10;

import static org.hamcrest.CoreMatchers.is;
import static org.junit.Assert.assertThat;

import java.util.Arrays;

import org.junit.Test;

public class MeasurementSeriesArrayListTest {
  @Test
  public void arrayList_addValues_EvaluatedValues() throws Exception {
    MeasurementSeriesArrayList arrayList = new MeasurementSeriesArrayList();

    arrayList.addAll(Arrays.asList(12.0, 45.3, 78.2, 45.8, 56.6));

    Evaluation result = arrayList.evaluate();

    assertThat(Math.round(result.averageValue * 100) / 100.0, is(47.58));
    assertThat(Math.round(result.highestValue * 100) / 100.0, is(78.2));
    assertThat(Math.round(result.lowestValue * 100) / 100.0, is(12.0));
  }

  @Test
  public void arrayList_removeValues_arrayWithoutRemovedObjects() throws Exception {
    MeasurementSeriesArrayList arrayList = new MeasurementSeriesArrayList();

    arrayList.addAll(Arrays.asList(12.56, 45.2, 78.6, 15.3, 89.6));
    arrayList.remove(0);
    arrayList.remove(3);

    MeasurementSeriesArrayList arrayListWithoutRemovedObjects = new MeasurementSeriesArrayList();
    arrayListWithoutRemovedObjects.addAll(Arrays.asList(45.2, 78.6, 15.3));

    assertThat(arrayList, is(arrayListWithoutRemovedObjects));
  }

}
