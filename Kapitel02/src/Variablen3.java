public class Variablen3{
	public static void main(String[] args){
	
		//Variablen zuweisen
		int a = 3;
		int b = 5;
		int c = 6;
		double x = 1.5;
		double y = 2.3;
		int int_ergebnis;
		double double_ergebnis;
		
			int_ergebnis = a * b + c; 		//21
			int_ergebnis = c + a * b; 		//21
			int_ergebnis = c - a * 3; 		//- 3
			int_ergebnis = c / a; 			//2
			int_ergebnis = c / b; 			//1
			int_ergebnis = a + b / c;		//3
			double_ergebnis = c / b;		//1
			double_ergebnis = c + a / b;	//7
			double_ergebnis = x + y * b;	//11.5
			double_ergebnis = (x + y) * b;	//19
			double_ergebnis = y - x * b;	//5.2
	}
}