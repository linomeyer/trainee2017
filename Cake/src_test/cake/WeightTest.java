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
	public void weightInGramm_decideUnit_weightInKG() throws Exception {
		Weight weightGramm = new WeightGramm(5000L);
		
		Weight weightKG = weightGramm.decideUnit();
		
		assertThat(weightKG.getUnit(), is("kg"));
		assertThat(weightKG.getAmount(), is(5L));
		assertThat(weightKG.getFactorToMiliGramm(), is(1_000_000L));
	}
	
	@Test
	public void weightInMiliGramm_decideUnit_weightInTonns() throws Exception {
		Weight weightMiliGramm = new WeightMiliGramm(5_000_000_000L);
		
		Weight weightGramm = weightMiliGramm.decideUnit();
		
		assertThat(weightGramm.getUnit(), is("t"));
		assertThat(weightGramm.getAmount(), is(5L));
		assertThat(weightGramm.getFactorToMiliGramm(), is(1_000_000_000L));
	}
	
	@Test
	public void weightInGramm_decideUnit_weightInGramm() throws Exception {
		Weight weightInGramm1 = new WeightGramm(500L);
		
		Weight weightInGramm2 = weightInGramm1.decideUnit();
		
		assertThat(weightInGramm2.getUnit(), is("g"));
		assertThat(weightInGramm2.getAmount(), is(500L));
		assertThat(weightInGramm2.getFactorToMiliGramm(), is(1_000L));
	}
	
	@Test
	public void weightInMiligramm_decideUnit_weightInPound() throws Exception {
		Weight weightInMiliGramm = new WeightMiliGramm(907_184);
		
		Weight weightInPound = weightInMiliGramm.decideUnit();
		
		assertThat(weightInPound.getUnit(), is("lb"));
		assertThat(weightInPound.getAmount(), is(2L));
		assertThat(weightInPound.getFactorToMiliGramm(), is(453_592L));
	}
}
