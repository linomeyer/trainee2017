 import javax.swing.*;
public class Zahlentest{
	public static void main(String[] args){
		
		double zahl;
		String eingabe;
		eingabe = JOptionPane.showInputDialog("Geben Sie eine Zahl ein: ");
		zahl = Double.parseDouble(eingabe);
		if(zahl < 0) {
			JOptionPane.showMessageDialog(null, "Die Zahl ist negativ");
		} else {
			JOptionPane.showMessageDialog(null, "Die Zahl ist positiv");
		}
	}
}