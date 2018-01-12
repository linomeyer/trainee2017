package excercise06;

import static org.hamcrest.CoreMatchers.is;
import static org.junit.Assert.*;

import org.junit.Test;
public class BreakTest {

	@Test
	public void createFactureValueIs0() {
	Fracture fracture = new Fracture();
	assertThat(fracture.getCounter(), is(0));
	assertThat(fracture.getDenominator(), is(1));
	}

	@Test
	public void createFactureValueIs1() {
	Fracture facture = new Fracture(1);
	assertThat(facture.getCounter(), is(1));
	assertThat(facture.getDenominator(), is(1));
	}

	@Test
	public void createFactureValueIs1_2() {
	Fracture facture = new Fracture(1, 2);
	assertThat(facture.getCounter(), is(1));
	assertThat(facture.getDenominator(), is(2));
	}

	@Test
	public void setCounterValueIs1() {
	Fracture facture = new Fracture();
	facture.setCounter(1);
	assertThat(facture.decimal(), is(1.0));
	}

	@Test
	public void setDenominatorValueIs1_2() {
	Fracture facture = new Fracture(1);
	facture.setDenominator(2);
	assertThat(facture.decimal(), is(0.5));
	}

	@Test
	public void factureToString() {
	Fracture facture = new Fracture(1);
	assertThat(facture.fractureToString(), is("1/1"));
	}

	@Test
	public void addValueIs2() {
	Fracture facture = new Fracture(1);
	Fracture add = new Fracture(1);
	assertThat(facture.add(add).fractureToString(), is("2/1"));
	}

	@Test
	public void subtractValueIs0() {
	Fracture facture = new Fracture(1);
	Fracture subtract = new Fracture(1);
	assertThat(facture.subtract(subtract).fractureToString(), is("0/1"));
	}

	@Test
	public void equalsValueIs0() {
	Fracture facture = new Fracture(1);
	Fracture test = new Fracture(1);
	if(facture.equals(test)) {
	assertThat(facture.decimal(), is(1.0));
	} else {
	assertThat(facture.decimal(), is(0.0));
	}
	}

}