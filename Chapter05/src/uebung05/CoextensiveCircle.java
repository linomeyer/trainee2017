package uebung05;

import java.text.DecimalFormat;

import javax.swing.JOptionPane;

public class CoextensiveCircle {
	public static void main(String [] args) {
		
		String input;
		circleClass c = new circleClass();
		Rectangle r = new Rectangle();
		DecimalFormat f = new DecimalFormat("#0.00");
		
		input = JOptionPane.showInputDialog("Geben Sie die Länge des Rechtecks ein: ");
		r.laenge = Double.parseDouble(input);
		input = JOptionPane.showInputDialog("Geben Sie die Breite des Rechtecks ein: ");
		r.breite = Double.parseDouble(input);
		
		c.setFlaeche(r.getFlaeche());
		
		System.out.println("Rechtecklänge: " + f.format(r.getLaenge()));
		System.out.println("Rechteckbreite: " + f.format(r.getBreite()));
		System.out.println("Rechteckflaeche: " + f.format(r.getFlaeche()));
		
		System.out.println("Radius: " + f.format (c.getRadius()));
		System.out.println("Kreisflaeche: " + f.format(c.flaeche()));
	}
}
