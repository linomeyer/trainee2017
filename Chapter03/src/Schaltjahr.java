import javax.swing.*;

public class Schaltjahr {
	public static void main(String[] args) {
		
		//Variablen
		String eingabe;
		int jahr;
		
		//Eingabe
		eingabe = JOptionPane.showInputDialog("Geben Sie eine Jahreszahl ein:");
		jahr = Integer.parseInt(eingabe);
		
		//Ausgabe
		if(jahr % 4 == 0) {
			if(jahr % 100 == 0) {
				if(jahr % 400 == 0) {
					JOptionPane.showMessageDialog(null, "Das Jahr " + jahr + " ist ein Schaltjahr!");
				} else {
					JOptionPane.showMessageDialog(null, "DasJahr " + jahr + " ist kein Schaltjahr!");
				}
			}else{
				JOptionPane.showMessageDialog(null, "Das Jahr " + jahr + " ist ein Schaltjahr!");
			}
		} else {
			JOptionPane.showMessageDialog(null, "Das Jahr " + jahr + " ist kein Schaltjahr!");
		}
	}
}