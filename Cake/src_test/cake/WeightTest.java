package cake;

import static org.junit.Assert.*;
import static org.hamcrest.CoreMatchers.is;

import org.junit.Test;

public class WeightTest {

  @Test
  public void weightAndUnit_getWeightWithUnit() {
    Weight weight = new WeightGramm(500);

    assertThat(weight, is(new WeightGramm(500)));
  }

  @Test
  public void weightWithUnit_addWeightWithUnit() throws Exception {
    Weight weightKg = new WeightKG(1);
    Weight weightG = new WeightGramm(500);

    Weight res = weightKg.add(weightG);

    assertThat(res, is(new WeightGramm(1500)));
  }

  @Test
  public void weightWithUnit_subtractWeightWithUnit() throws Exception {
    Weight weightKg = new WeightKG(1);
    Weight weightG = new WeightGramm(500);

    Weight res = weightKg.subtract(weightG);

    assertThat(res, is(new WeightGramm(500)));
  }

  @Test
  public void twoSimilarWeights_compareThem_booleanTrue() throws Exception {
    Weight weightA = new WeightGramm(500);
    Weight weightB = new WeightGramm(500);

    boolean areTheyTheSame = weightA.equals(weightB);

    assertThat(areTheyTheSame, is(true));
  }

  @Test
  public void weightInKg_toMiliGramm_weightInGramm() throws Exception {
    Weight weightKg = new WeightKG(5);

    Weight weightG = weightKg.toMiliGramm();

    assertThat(weightG.getUnit(), is("mg"));
    assertThat(weightG.getAmount(), is(5_000_000L));
    assertThat(weightG.getFactorToMiliGramm(), is(1L));
  }

  @Test
  public void weightInGramm_convertIntoHighestPossibleUnit_weightInKG() throws Exception {
    Weight weight = new WeightGramm(5000L);

    Weight convertedWeight = weight.convertIntoHighestPossibleUnit();

    assertThat(convertedWeight.getUnit(), is("kg"));
    assertThat(convertedWeight.getAmount(), is(5L));
    assertThat(convertedWeight.getFactorToMiliGramm(), is(1_000_000L));
  }

  @Test
  public void weightInMiliGramm_convertIntoHighestPossibleUnit_weightInTonns() throws Exception {
    Weight weight = new WeightMiliGramm(5_000_000_000L);

    Weight convertedWeight = weight.convertIntoHighestPossibleUnit();

    assertThat(convertedWeight.getUnit(), is("t"));
    assertThat(convertedWeight.getAmount(), is(5L));
    assertThat(convertedWeight.getFactorToMiliGramm(), is(1_000_000_000L));
  }

  @Test
  public void weightInGramm_convertIntoHighestPossibleUnit_weightInGramm() throws Exception {
    Weight weight = new WeightGramm(500L);

    Weight convertedWeight = weight.convertIntoHighestPossibleUnit();

    assertThat(convertedWeight.getUnit(), is("g"));
    assertThat(convertedWeight.getAmount(), is(500L));
    assertThat(convertedWeight.getFactorToMiliGramm(), is(1_000L));
  }

  @Test
  public void weightInMiligramm_convertIntoHighestPossibleUnit_weightInPound() throws Exception {
    Weight weight = new WeightMiliGramm(907_184);

    Weight convertedWeight = weight.convertIntoHighestPossibleUnit();

    assertThat(convertedWeight.getUnit(), is("lb"));
    assertThat(convertedWeight.getAmount(), is(2L));
    assertThat(convertedWeight.getFactorToMiliGramm(), is(453_592L));
  }
}
