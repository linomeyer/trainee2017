package excercise06;

import static org.hamcrest.CoreMatchers.is;
import static org.junit.Assert.*;
import org.junit.Test;


public class CheckingAccountTest {
	
	@Test
	public void createAccontBalanceIsMinus1000() {
		CheckingAccount caccount = new CheckingAccount("0000000001", 10000, 1000);
		caccount.payOut(11000);
		assertThat(caccount.getAccountBalance(), is(-1000L));
	}
	@Test
	public void createAccountBalanceIs1000() {
		CheckingAccount caccount = new CheckingAccount("0000000001", 10000, 1000);
		
		boolean successful = caccount.payOut(9000);
		
		assertThat(successful, is(true));		
		assertThat(caccount.getAccountBalance(), is(1000L));
	}
	@Test
	public void balanceAndLimit_payOutMoreThanLimitAllows_payOutDoesNotOccur() {
		CheckingAccount caccount = new CheckingAccount("0000000001", 10000, 1000);
		
		boolean successful = caccount.payOut(11001);
		
		assertThat(successful, is(false));
		assertThat(caccount.getAccountBalance(), is(10000L));
	}
} 

