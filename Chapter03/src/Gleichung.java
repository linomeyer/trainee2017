import javax.swing.*;

public class Gleichung {
	public static void main(String[] args) {
		
		//Variablen
		String eingabe;
		double a;
		double b;
		double c;
		double ergebnis;
		
		//Meldung
		JOptionPane.showMessageDialog(null, "Wie viele Ergebnisse gibt es bei folgender Rechnung:\nax\u00b2 + bx + c");
		
		//Eingabe
		eingabe = JOptionPane.showInputDialog("Wie viele Ergebnisse gibt es bei folgender Rechnung:\nax\u00b2 + bx + c\nGeben Sie die Zahl fuer a ein:");
		a = Double.parseDouble(eingabe);
		
		eingabe = JOptionPane.showInputDialog("Wie viele Ergebnisse gibt es bei folgender Rechnung:\nax\u00b2 + bx + c\nGeben Sie die Zahl fuer b ein:");
		b = Double.parseDouble(eingabe);
		
		eingabe = JOptionPane.showInputDialog("Wie viele Ergebnisse gibt es bei folgender Rechnung:\nax\u00b2 + bx + c\nGeben Sie die Zahl fuer c ein:");
		c = Double.parseDouble(eingabe);
		
		//Verarbeitung
		ergebnis = b * b - 4 * a * c;
		
		//Ausgabe
		if(ergebnis > 0) {
			JOptionPane.showMessageDialog(null, "Es gibt eine Loesungen.");
		}else{
			if(ergebnis == 0) {
				JOptionPane.showMessageDialog(null, "Es gibt eine Loesung.");
			}else{
				if(ergebnis < 0) {
					JOptionPane.showMessageDialog(null, "Es gibt keine Loesung");
				}
			}
		}
	}
}