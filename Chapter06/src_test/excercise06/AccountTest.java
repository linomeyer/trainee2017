package excercise06;

import static org.junit.Assert.*;
import static org.hamcrest.CoreMatchers.is;
import org.junit.Test;

public class AccountTest {

	@Test
	public void createAccAcountNumberIsValue() {
		Account acc = new Account("0000000001", 100000);
		assertThat(acc.getAccountNumber(), is("0000000001"));
	}

	@Test
	public void accountBalanceIsValue() {
		Account acc = new Account("0000000001", 100000);
		assertThat(acc.getAccountBalance(), is(100000L));
	}
	
	@Test
	public void payInIsAccountBalanceValuePlusPayIn() {
		Account acc = new Account("0000000001", 100000);
		acc.payIn(50000);
		assertThat(acc.getAccountBalance(), is(150000L));
	}
	
	@Test
	public void payOutIsAccountBalanceValueMinusPayOut() {
		Account acc = new Account("0000000001", 100000);
		acc.payOut(75000);
		assertThat(acc.getAccountBalance(), is(25000L));
	}
}
