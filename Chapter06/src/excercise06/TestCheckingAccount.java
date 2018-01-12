package excercise06;

public class TestCheckingAccount {
	public static void main(String [] args) {
		CheckingAccount caccount = new CheckingAccount("0000000001" , 10000, 1000);
		caccount.payOut(11000);
		System.out.println("Kontostand: " + caccount.getAccountBalance());
		caccount.payIn(11000);
		caccount.payOut(11001);
		System.out.println("Kontostand: " + caccount.getAccountBalance());
	}
}
