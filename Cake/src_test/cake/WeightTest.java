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
		assertThat(weightG.getAmount(), is(5_000_000));
		assertThat(weightG.getFactorToMiliGramm(), is(1));
	}
	
	@Test
	public void weightInKg_decideUnit_weightInTonnes() throws Exception {
		Weight weightKg = new WeightKG(5000);
		
		Weight weightTonnes = weightKg.decideUnit();
		
		assertThat(weightTonnes.getUnit(), is("t"));
		assertThat(weightTonnes.getAmount(), is(5));
		assertThat(weightTonnes.getFactorToMiliGramm(), is(1_000_000_000));
	}
	
	@Test
	public void weightInGramm_decideUnit_weightInGramm() throws Exception {
		Weight weightInGramm1 = new WeightGramm(500);
		
		Weight weightInGramm2 = weightInGramm1.decideUnit();
		
		assertThat(weightInGramm2.getUnit(), is("g"));
		assertThat(weightInGramm2.getAmount(), is(500));
		assertThat(weightInGramm2.getFactorToMiliGramm(), is(1_000));
	}
}
