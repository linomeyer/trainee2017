import javax.swing.*;

public class Zahlraten {
	public static void main(String[] args) {
		
		//Variablen
		String eingabe;
		int zahl = 0;
		
		//Eingabe
		eingabe = JOptionPane.showInputDialog("Raten Sie eine ganze Zahl von 1 - 10");
		zahl = Integer.parseInt(eingabe);
		
		//Ausgabe
		switch (zahl) {
			case 6:
			JOptionPane.showMessageDialog(null, "Treffer!");
			break;
			
			case 4:
			case 5:
			case 7:
			case 8:
			JOptionPane.showMessageDialog(null, "Knapp daneben");
			break;
			
			case 0:
			case 1:
			case 2:
			case 3:
			case 9:
			case 10:
			JOptionPane.showMessageDialog(null, "Daneben!");
			break;
		}
		if((zahl < 0) || (zahl > 10)) {
				JOptionPane.showMessageDialog(null, "Die eingegebene Zahl liegt nicht zwischen 0 und 10");
		}
	}
}