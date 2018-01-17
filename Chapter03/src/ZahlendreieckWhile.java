import javax.swing.*;

public class ZahlendreieckWhile {
	public static void main(String[] args) {
		
		//Variablen
		String dreieck = "";
		int zaehler = 0;
		
		while(zaehler <= 9) {
			dreieck += zaehler++ + " ";
			System.out.println(dreieck);
		}
	}
}
