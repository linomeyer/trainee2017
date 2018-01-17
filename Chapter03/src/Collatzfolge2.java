import javax.swing.*;

public class Collatzfolge2 {
	public static void main(String[] args) {
		
		//Variablen erstellen
		int x = 0;
		String eingabe = " ";
		int hoechsteZahl = 0;
		int anzahlElemente = 0;
		boolean zahlNegativ = false;
		
		//x einlesen
		eingabe = JOptionPane.showInputDialog("Collatzfolge:\nGeben Sie die Zahl fuer x ein:");
		x = Integer.parseInt(eingabe);
		zahlNegativ = x <= 0;
		
		while (zahlNegativ == true) {
			eingabe = JOptionPane.showInputDialog("Die eingegebene Zahl ist kleiner als 1,\nbitte geben Sie eine grössere Zahl ein:");
			x = Integer.parseInt(eingabe);
			zahlNegativ = x <= 0;
		}
		
		//Verarbeitung und Ausgabe
		System.out.print("\n\n* * * * * * * * * * * * * * * * * * * *\n\n" + x + ", ");
		hoechsteZahl = x;
		
		while(x != 1) {
			if(x > hoechsteZahl){
				hoechsteZahl = x;	
			}
			anzahlElemente++;
			if(x % 2 == 0) {
				x = x / 2;
			}else{
				x = 3 * x + 1;
			}
			System.out.print(x + ", ");
			
		
		}
		System.out.print("...\n\nDie hoechste Zahl der Folge ist " + hoechsteZahl + "\n\nAnzahl Elemente ohne 1: " + anzahlElemente + "\n\n* * * * * * * * * * * * * * * * * * * *\n");
	}
}