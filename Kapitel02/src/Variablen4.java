public class Variablen4{
	public static void main(String[] args){
		
		//Variablen zuweisen
		int a = 3;
		int b = 5;
		int c = 6;
		double x = 1.5;
		double y = 2.3;
		int int_ergebnis;
		double double_ergebnis;
			
			System.out.println("b + c * 6 = " + b + c * 6);				//536
			//System.out.println("b - c * 6 = " + b + c * 6);					- bad operand
			System.out.println("(x * c - a) = " + (x * c - a));			//6.0
			System.out.println("x +c * 6 = " + x + c * 6);				//1.536
			System.out.println("y - c / a = " + (y - c / a));			//0.299999999999998
			System.out.println("b + a * x + y = " + b + a * x + y);		//54.52.3
			System.out.println("b + a * x * y = " + b + a * x * y);		//510.35
			//System.out.println("b + a * x - y = " + b + a * x + y);			- bad operand
	}
}