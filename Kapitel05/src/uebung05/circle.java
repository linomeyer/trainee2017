package uebung05;

import javax.swing.JOptionPane;

public class circle {
	public static void main(String [] args) {
		
		String eingabe = null;
		
		//Kreis 1
		System.out.println("Kreis 1:");
		eingabe = JOptionPane.showInputDialog("Geben Sie den Radius des Kreises ein:");
		circleClass r = new circleClass(Double.parseDouble(eingabe));
		
		System.out.println("Radius: " + r.radius + "\nUmfang: " + r.umfang() + "\nFlaeche: " + r.flaeche());
		
		//Kreis 2
		System.out.println("\nKreis 2:");
		eingabe = JOptionPane.showInputDialog("Geben Sie die Flaeche des Kreises ein:");
		r.setFlaeche(Double.parseDouble(eingabe));
		
		System.out.println("Radius: " + r.radius + "\nUmfang: " + r.umfang() + "\nFlaeche: " + r.flaeche());
		
		//Kreis 3
		System.out.println("\nKreis 3:");
		eingabe = JOptionPane.showInputDialog("Geben Sie den Umfang des Kreises ein:");
		r.setUmfang(Double.parseDouble(eingabe));
		
		System.out.println("Radius: " + r.radius);
		System.out.println("Umfang: " + r.umfang());
		System.out.println("Flaeche: " + r.flaeche());
	}
}
