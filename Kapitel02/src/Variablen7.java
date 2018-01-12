public class Variablen7{
	public static void main(String[] args){
		
		//Variablen zuweisen
		int a = 3;
		int b = 5;
		int c = 6;
		double x = 1.5;
		double y = 2.3;
		int int_ergebnis;
		double double_ergebnis;
		
			boolean b_wert;
			b_wert = a == c;
			
			System.out.println("a == b = " + (a == c));					//false
			System.out.println(b_wert);									//false
			System.out.println(!b_wert);								//true
			
			b_wert = a == b && c > b;
			System.out.println("a == b && C > b = " + b_wert);			//false
			
			//b_wert == b < c & a++ == 4;									ERROR not a statement
			//System.out.println("b < c & a++ == 4 = " + b_wert);
			
			b_wert = b < c & ++a == 5;
			System.out.println("b < c & ++a == 5 = " + b_wert);			//false
			
			a = 3;
			b_wert = b < c & ++a == 4;
			System.out.println("b < c & ++a == 4 = " +b_wert);			//true
			
			a = 3;
			b_wert = a > b && c++ == 6;
			System.out.println("a > b && c++ == 6 = " +b_wert);			//false
			System.out.println("c = " + c);								//6
			
			b_wert = !(y > x);												
			System.out.println("!(y > x) = " + !(y > x));								
			
			//b_wert = !y > x;												ERROR bad operand type
			//System.out.println("!y > x = " + !y > x);						ERROR bad operand type
			
			b_wert = a > b & c++ == 6;
			System.out.println("a > b & c++ == 6 = " + b_wert);			//false
			System.out.println("c = " + c);								//7
			
			c = 6;
			b_wert = a < b || c++ == 6;
			System.out.println("a < b || c++ == 6 = " +b_wert);			//true
			System.out.println("c = " + c);								//6
			
			b_wert = a < b | c++ == 6;
			System.out.println("a < b | c++ == 6 = " +b_wert);			//true
			System.out.println("c = " + c);								//7
			
			c = 6; 
			//b_wert = a > b | c++;											ERROR bad operand type
			//System.out.println("a > b | c++ = " + b_wert);					ERROR bad operand type
	}
}	
			