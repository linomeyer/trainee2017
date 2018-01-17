import javax.swing.*;

public class WasSollDas {
	public static void main(String[] args) {
		
		//Variablen
		String eingabe;
		int m = 0;
		int n = 0;
		
		//Eingabe
		eingabe = JOptionPane.showInputDialog("Geben Sie die Zahl fuer m ein:");
		m = Integer.parseInt(eingabe);
		
		eingabe = JOptionPane.showInputDialog("Geben Sie die Zahl fuer n ein:");
		n = Integer.parseInt(eingabe);
		
		//Verarbeitung
		
		while(m != n) {
			if(m > n) {
				m -= n;
			} else  {
				n -= m;
			}
		}
		
		//Ausgabe
		JOptionPane.showMessageDialog(null, "Der Wert von m ist " + m);
	}
}