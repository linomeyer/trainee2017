package cake;

import static org.hamcrest.CoreMatchers.is;
import static org.junit.Assert.*;

import org.junit.Test;

public class FractionTest {

  @Test
  public void createFactureValueIs0() {
    Fraction fracture = new Fraction();
    assertThat(fracture.getCounter(), is(0L));
    assertThat(fracture.getDenominator(), is(1L));
  }

  @Test
  public void createFactureValueIs1() {
    Fraction fracture = new Fraction(1);
    assertThat(fracture.getCounter(), is(1L));
    assertThat(fracture.getDenominator(), is(1L));
  }

  @Test
  public void createFactureValueIs1_2() {
    Fraction fracture = new Fraction(1, 2);
    assertThat(fracture.getCounter(), is(1L));
    assertThat(fracture.getDenominator(), is(2L));
    assertThat(fracture.toString(), is("1/2"));
  }

  @Test
  public void createFractionWithOtherFraction() throws Exception {
    Fraction value = new Fraction(1, 2);
    Fraction fraction = new Fraction(value);

    value.setDenominator(1);

    assertThat(fraction, is(new Fraction(1, 2)));
    assertThat(value, is(new Fraction(1)));
  }

  @Test
  public void setWithFraction() throws Exception {
    Fraction fraction = new Fraction(1, 4);
    Fraction value = new Fraction(3, 5);

    fraction.set(value);
    value.setDenominator(4);

    assertThat(fraction, is(new Fraction(3, 5)));
    assertThat(value, is(new Fraction(3, 4)));
  }

  @Test
  public void setWithCounterAndDenominator() throws Exception {
    Fraction fraction = new Fraction(1, 4);

    fraction.set(3, 5);

    assertThat(fraction, is(new Fraction(3, 5)));
  }

  @Test
  public void setCounterValueIs1() {
    Fraction fracture = new Fraction();
    fracture.setCounter(1);
    assertThat(fracture.decimal(), is(1.0));
  }

  @Test
  public void setDenominatorValueIs1_2() {
    Fraction fracture = new Fraction(1);
    fracture.setDenominator(2);
    assertThat(fracture.decimal(), is(0.5));
  }

  @Test
  public void factureToString() {
    Fraction fracture = new Fraction(1);
    assertThat(fracture.toString(), is("1/1"));
  }

  @Test
  public void addValueIs2() {
    Fraction fracture = new Fraction(1);
    Fraction add = new Fraction(1, 2);

    Fraction result = fracture.add(add);

    assertThat(result.getCounter(), is(3L));
    assertThat(result.getDenominator(), is(2L));
  }

  @Test
  public void expand() {
    Fraction fracture = new Fraction(3, 4);

    fracture.expand(3);

    assertThat(fracture.getCounter(), is(9L));
    assertThat(fracture.getDenominator(), is(12L));
  }

  @Test
  public void subtractValueIs0() {
    Fraction fracture = new Fraction(1);
    Fraction subtract = new Fraction(1);
    assertThat(fracture.subtract(subtract).toString(), is("0/1"));
  }

  @Test
  public void equalsValueIs0() {
    Fraction fracture = new Fraction(1);
    Fraction test = new Fraction(1);
    if (fracture.equals(test)) {
      assertThat(fracture.decimal(), is(1.0));
    } else {
      assertThat(fracture.decimal(), is(0.0));
    }
  }

  @Test
  public void shortValueIs1_2() {
    Fraction fracture = new Fraction(9, 12);
    fracture.shorten();
    assertThat(fracture.toString(), is("3/4"));
  }

}