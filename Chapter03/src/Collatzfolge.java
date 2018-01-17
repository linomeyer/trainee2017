import javax.swing.*;

public class Collatzfolge {
	public static void main(String[] args) {
		
		//Variablen erstellen
		int x = 0;
		byte zaehler = 0;
		String eingabe = " ";
		
		//x einlesen
		eingabe = JOptionPane.showInputDialog("Collatzfolge: \n\nGeben Sie die Zahl fuer x ein:");
		x = Integer.parseInt(eingabe);
		
		//Verarbeitung und ausgabe
		System.out.print("\n\n* * * * * * * * * * * * * * * * * * * *\n\n" + x + ", ");
		
		while(zaehler != 11) {
		if(x % 2 == 0) {
			x = x / 2;
		}else{
			x = 3 * x + 1;
		}
		System.out.print(x + ", ");
		zaehler += 1;
		}
		System.out.print("...\n\n* * * * * * * * * * * * * * * * * * * *\n\n");
	}
}