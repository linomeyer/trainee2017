package uebung05;

import javax.swing.*;

public class RectangleTest {
	public static void main(String[] args) {
		Rectangle r = new Rectangle();
		String eingabe;
		
		eingabe = JOptionPane.showInputDialog("Geben Sie die Laenge des Rechtecks ein:");
		r.setLaenge(Double.parseDouble(eingabe));
		eingabe = JOptionPane.showInputDialog("Geben Sie die Breite des Rechtecks ein:");
		r.setBreite(Double.parseDouble(eingabe));
		
		System.out.println("Lange Seite: " + r.getLangeSeite());
		System.out.println("Kurze Seite: " + r.getKurzeSeite());
		System.out.println("Diagonale: " + r.getDiagonale());
		System.out.println("Flaeche: " + r.getFlaeche());
		System.out.println("Umfang: " + r.getUmfang());
		r.laengeAusgeben(); //Es wird immer der Wert der lokalen Varible laenge ausgegeben, sprich 5.4
		
		r.laengeVergroessern(1);
		r.outLaenge();
		r.laengeVerkleinern(2);
		r.outLaenge();
		
		r.breiteVergroessern(1);
		r.outBreite();
		r.breiteVerkleinern(2);
		r.outBreite();
	}
}
