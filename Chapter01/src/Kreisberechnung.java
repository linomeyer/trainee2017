/*Kreisberechnung: Für einen Kreis mit dem Radius 5 cm wrden der Umfang und die Fläche berechnet*/

public class Kreisberechnung {
	public static void main(String[] args ) {
		double radius, umfang, inhalt;
		radius = 5.0;
		umfang =2.0 * 3.1415926 * radius;
		inhalt = 3.1415926 * radius * radius;
		System.out.print("Umfang: ");
		System.out.println(umfang);
		System.out.print("Flaeche: ");
		System.out.println(inhalt);
	}
}