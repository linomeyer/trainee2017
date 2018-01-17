package uebung05;

import java.text.DecimalFormat;
import javax.swing.JOptionPane;

public class CircleTable {
	
		public static void main(String[] args) {
			String eingabe;
			circleClass r = new circleClass();
			double startwert;
			double erhoehung;
			DecimalFormat f = new DecimalFormat("#0.00"); 
			
			eingabe = JOptionPane.showInputDialog("Geben Sie den Startradius ein:");
			startwert = Double.parseDouble(eingabe);
			eingabe = JOptionPane.showInputDialog("Geben Sie die Erhoehung ein:");
			erhoehung = Double.parseDouble(eingabe);
			
			System.out.println("Radius:\t\t\t\t\tUmfang:\t\t\t\t\tFlaeche:");
			for(int x = 0; x < 30; x++) {
				r.radius = startwert;
				System.out.println(f.format(r.getRadius()) + "\t\t\t\t\t" + f.format(r.umfang()) + "\t\t\t\t\t" + f.format(r.flaeche()));
				startwert += erhoehung;
			}
		}
	}
