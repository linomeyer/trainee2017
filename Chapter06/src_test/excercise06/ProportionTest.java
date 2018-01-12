package excercise06;

import static org.junit.Assert.*;
import static org.hamcrest.CoreMatchers.is;
import org.junit.Test;

public class ProportionTest {

	@Test
	public void createFactureValueIs05() {
		Proportion fracture = new Proportion(3,9);
		assertThat(fracture.getCounter(), is(3));
		assertThat(fracture.getDenominator(), is (9));
	}
	
	//Fail
	@Test
	public void createProportionValueIsSmaller1() {
		Proportion proportion = new Proportion();
		proportion.setCounter(1);
		proportion.setDenominator(4);
		assertThat(Proportion.fracture.getCounter(), is(1));
		assertThat(Proportion.fracture.getDenominator(), is(4));
	}
	@Test
	public void createProportionValueIsBigger1() {
		Proportion proportion = new Proportion();
		proportion.setCounter(4);
		proportion.setDenominator(2);
		assertThat(Proportion.fracture.getCounter(), is(0));
		assertThat(Proportion.fracture.getDenominator(), is(1));
	}
	@Test
	public void  createProportionValueIs1() {
		Proportion proportion = new Proportion();
		proportion.setCounter(2);
		proportion.setDenominator(2);
		assertThat(Proportion.fracture.getCounter(), is(2));
		assertThat(Proportion.fracture.getDenominator(), is(2));
	}
}
