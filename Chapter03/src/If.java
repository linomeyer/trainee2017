public class If{
	public static void main(String[] args){
		
		//Variablen erstellen
		int zahl = 0;
		
		//Ausgabe
		while (zahl < 42) {
			
			//Vergrössern
			zahl += 1;
			
			//Vergleichen
			if (zahl % 3 == 0) {
				if (zahl % 5 == 0) {
					System.out.println("FizzBuzz");
				} else {
					System.out.println("Fizz");
				}
			} else {
				if (zahl % 5 == 0) {
					System.out.println("Buzz");
				} else {
					System.out.println(zahl);
				}
			}
		}
	}
}