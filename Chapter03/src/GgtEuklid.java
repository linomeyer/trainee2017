import javax.swing.*;

public class GgtEuklid {
	public static void main(String[] args) {
		
		//Variablen
		String eingabe;
		int m, n, r;
		
		//Eingabe
		eingabe = JOptionPane.showInputDialog("Geben Sie die Zahl fuer m ein:");
		m = Integer.parseInt(eingabe);
		
		eingabe = JOptionPane.showInputDialog("Geben Sie die Zahl fuer n ein:");
		n = Integer.parseInt(eingabe);
		
		int me = m;
		int ne = n;
		//Verarbeitung
		
		r = m%n;
		
		while(r > 0) {
			m = n;
			n = r;
			r = m%n;
		}
		
		//Ausgabe
		JOptionPane.showMessageDialog(null, "Der ggt von " + me + " und " + ne +" ist " + n + ".");
	}
}