package cake;

import static org.junit.Assert.*;
import static org.hamcrest.CoreMatchers.is; 

import org.junit.Test;

public class WeightTest {

	@Test
	public void weightAndUnit_getWeightWithUnit() {
		Weight weight = new Weight(500, "g");
		
		assertThat(weight.toString(), is("500g"));
	}
	
	@Test
	public void weightWithUnit_addWeightWithUnit() throws Exception {
		Weight weightKg = new Weight(1, "kg");
		Weight weightG = new Weight(500,"g");
		
		Weight res = weightKg.add(weightG);
		
		assertThat(res.toString(), is("1500g"));
	}

	@Test
	public void weightWithUnit_subtractWeightWithUnit() throws Exception {
		Weight weightKg = new Weight(1, "kg");
		Weight weightG = new Weight(500,"g");
		
		Weight res = weightKg.subtract(weightG);
		
		assertThat(res.toString(), is("500g"));
	}
}
