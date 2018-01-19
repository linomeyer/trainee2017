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
	
	@Test
	public void weightInKg_toGramm_weightInGramm() throws Exception {
		Weight weightKg = new Weight(5, "kg");
		
		Weight weightG = weightKg.toGramm(); 
		
		assertThat(weightG.getUnit(), is("g"));
		assertThat(weightG.getAmount(), is(5000));
		assertThat(weightG.getFactorToGramm(), is(1));
	}
	
	@Test
	public void weightInKg_decideUnit_weightInTonnes() throws Exception {
		Weight weightKg = new Weight(5000, "kg");
		
		Weight weightTonnes = weightKg.decideUnit();
		
		assertThat(weightTonnes.getUnit(), is("t"));
		assertThat(weightTonnes.getAmount(), is(5));
		assertThat(weightTonnes.getFactorToGramm(), is(1_000_000));
	}
	
	@Test
	public void weightInGramm_decideUnit_weightInGramm() throws Exception {
		Weight weightInGramm1 = new Weight(500, "g");
		
		Weight weightInGramm2 = weightInGramm1.decideUnit();
		
		assertThat(weightInGramm2.getUnit(), is("g"));
		assertThat(weightInGramm2.getAmount(), is(500));
		assertThat(weightInGramm2.getFactorToGramm(), is(1));
	}
}
