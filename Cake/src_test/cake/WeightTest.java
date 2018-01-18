package cake;

import static org.junit.Assert.*;
import static org.hamcrest.CoreMatchers.is; 

import org.junit.Test;

public class WeightTest {

	@Test
	public void weightAndUnit_getWeightWithUnit() {
		Weight weight = new Weight(500, "g");
		
		assertThat(weight, is(new Weight(500,"g")));
	}
	
	@Test
	public void weightWithUnit_addWeightWithUnit() throws Exception {
		Weight weightKg = new Weight(1, "kg");
		Weight weightG = new Weight(500,"g");
		
		Weight res = weightKg.add(weightG);
		
		assertThat(res, is(new Weight(1500, "g")));
	}

	@Test
	public void weightWithUnit_subtractWeightWithUnit() throws Exception {
		Weight weightKg = new Weight(1, "kg");
		Weight weightG = new Weight(500,"g");
		
		Weight res = weightKg.subtract(weightG);
		
		assertThat(res, is(new Weight(500, "g")));
	}
	
	@Test
	public void twoSimilarWeights_compareThem_booleanTrue() throws Exception {
		Weight weightA = new Weight(500, "g");
		Weight weightB = new Weight(500, "g");
		
		boolean areTheyTheSame = weightA.equals(weightB);
		
		assertThat(areTheyTheSame, is(true));
	}
}
