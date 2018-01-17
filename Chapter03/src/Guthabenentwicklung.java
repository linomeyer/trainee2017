import javax.swing.*;

public class Guthabenentwicklung {
	public static void main(String[] args) {
		
		//Variablen
		String eingabe;
		double zins = 0;
		long guthaben = 0;
		byte zaehler = 0;
		
		//Eingabe
		eingabe = JOptionPane.showInputDialog("Geben Sie Ihr momentanes Guthaben in Rappen ein:");
		guthaben = Long.parseLong(eingabe);
		
		eingabe = JOptionPane.showInputDialog("Geben Sie den Zins ein: \n(1% = 0.01)");
		zins = Double.parseDouble(eingabe);
		
		//Verarbeitung
		while(zaehler < 10) {
			guthaben = (long)((double)guthaben * (1 + zins));
			System.out.println("Guthaben nach " + ++zaehler + " Jahr/en ist " + ((double)guthaben/100) + " Fr.");
		}
		
		//Ausgabe
		
	}
}