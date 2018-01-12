package excercise06;

import static org.hamcrest.CoreMatchers.is;
import static org.junit.Assert.*;

import org.junit.Test;

public class FractureWithSerialNumberTest {

	@Test
	public void test() {
	FractureWithSerialNumber facture = new FractureWithSerialNumber();
	assertThat(facture.getSerialNumber(), is(1));
	FractureWithSerialNumber facture2 = new FractureWithSerialNumber();
	assertThat(facture2.getSerialNumber(), is(2));
	FractureWithSerialNumber facture3 = new FractureWithSerialNumber();
	assertThat(facture3.getSerialNumber(), is(3));
	}

}