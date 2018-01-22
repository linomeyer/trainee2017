
public class Lars {
	public static void main(String[] args) throws InterruptedException {
		short lars = 500;
		while(true) {
			System.out.println(lars++);
			Thread.sleep(1000);
			System.out.println("System.safe()");
			Thread.sleep(1000);
		}
	}
}
