package excercise06;

class Account {
	
	private String accountNumber;
	private long accountBalance;
	
	Account (String accountNumber, long accountBalance) {
		this.accountNumber = accountNumber;
		this.accountBalance = accountBalance;
	}
	long getAccountBalance() {
		return accountBalance;
	}
	String getAccountNumber() {
		return accountNumber;
	}
	void payIn(long payIn) {
		accountBalance += payIn;
	}
	boolean payOut(long payOut) {
		accountBalance -= payOut;
		return true;
	}
}
