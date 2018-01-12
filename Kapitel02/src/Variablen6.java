public class Variablen6{
	public static void main(String[] args){
		
		//Variablen zuweisen
		int a = 3;
		int b = 5;
		int c = 6;
		double x = 1.5;
		double y = 2.3;
		int int_ergebnis;
		double double_ergebnis;
		
		//System.out.println("c > b = " + c > b); 					ERROR
		System.out.println("c > b = " + (c > b));			//true
		System.out.println("b < a = " + (b < a));			//false
		System.out.println("c == b = " + (c == b));			//false
		//System.out.println("c > a < b = " + (c > a < b)); 		ERROR
		System.out.println("a = b = " + (a = b));			//5
		System.out.println("a = " + a + " b = " + b);		//5
		System.out.println("x > y = " + (x > y));			//false
		
		y = y + 0.1;										
		y = y + 0.1;
		
		System.out.println("y == 2.5 = " + (y == 2.5));		//true
		System.out.println("y = " + y);						//2.5
		
		double z = 1.0;
		z = z + 0.1;
		z = z + 0.1;
		
		System.out.println("z == 2.5 = " + (z == 1.2));		//false
		System.out.println("z = " + z);						//1.200000000000002
	}
}