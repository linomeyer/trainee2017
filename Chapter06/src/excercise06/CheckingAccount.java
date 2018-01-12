
package excercise06;

public class CheckingAccount extends Account {
	private long limit;

	CheckingAccount(String accountNumber, long accountBalance, long limit) {
		super(accountNumber, accountBalance);
		this.limit = limit;
	}

	long getLimit() {
		return limit;
	}

	void setLimit(long limit) {
		this.limit = limit;
	}

	boolean payOut(long payOut) {
		if ((super.getAccountBalance() - payOut) >= (-(limit))) {
			super.payOut(payOut);
			return true;
		} else {
			System.out.println("Fehler limit überschritten!");
			return false;
		}
	}
}
