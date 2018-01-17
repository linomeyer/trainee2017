public class Variablen5{
	public static void main(String[] args){
		
		//Variablen zuweisen
		int a = 3;
		int b = 5;
		int c = 6;
		double x = 1.5;
		double y = 2.3;
		int int_ergebnis;
		double double_ergebnis;
			
			System.out.println("a++: " + a++);					//3
			System.out.println("a: " + a);						//4
			System.out.println("++a: " + ++a);					//5
			System.out.println("a: " + a);						//5
			System.out.println("b + a--: " + b + a--);			//55
			System.out.println("a: " + a + " b: " + b);			//5
			System.out.println("b + a--: " + (b + a--));		//9
			System.out.println("a: " + a + " b: " + b); 		//5
			System.out.println("b + a--: " + (b + --a));		//7
			System.out.println("a: " + a + " b: " + b);			//5md
			//System.out.println("a**: " + a**);						ERROR
	}		
}