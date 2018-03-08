
/*Kreisberechnung; Der Radius für einen Kreis und die Einheit werden über die Tastatur eingegeben.
 *Anschliessend werden der Umfang und der Flächeninhalt berechnet. */

import javax.swing.JOptionPane;

public class Kreisberechnung4 {
  public static void main(String[] args) {
    double radius, umfang, flaeche;
    String einheit, eingabe = "";
    eingabe = JOptionPane.showInputDialog("Geben Sie den Kreisradius ein: ");
    try {
      radius = Double.parseDouble(eingabe);
    } catch (NumberFormatException e) {
      System.out.println("Der eingegebene Wert " + eingabe + " ist keine g�ltige Zahl");
      return;
    }
    eingabe = JOptionPane.showInputDialog("Geben Sie die Einheit ein: ");
    einheit = eingabe;
    umfang = 2.0 * 3.1415926 * radius;
    flaeche = 3.1415926 * radius * radius;
    System.out.print("Umfang: ");
    System.out.print(umfang);
    System.out.println(" " + einheit);
    System.out.print("Flaeche: ");
    System.out.print(flaeche);
    System.out.println(" " + einheit + '\u00b2');
  }
}