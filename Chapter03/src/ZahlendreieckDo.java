import javax.swing.*;

public class ZahlendreieckDo {
	public static void main(String[] args) {
		
		//Variablen
		String dreieck = "";
		int zaehler = 0;
		
		do{
			dreieck += zaehler++ + " ";
			System.out.println(dreieck);
		} while(zaehler <= 9);
	}
}
