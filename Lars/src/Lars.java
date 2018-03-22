import javax.swing.JOptionPane;

public class Lars {
  public static void main(String[] args) throws InterruptedException {
    short lars = 500;
    int larsFrequenz = 1000;
    /**
     * larsisches W�rterbuch: Lars = Name und Synonym f�r viele beliebige Nomen, in
     * unserem Fall f�r "Fehler" larsen = Synonym f�r viele beliebige W�rter, in
     * unserem Fall zum einen f�r die Ausgabe und f�r die Pause
     */
    String eingabe = JOptionPane.showInputDialog("Wie lange soll Lars zwischen dem larsen larsen? xD (Frequenz in ms)");
    try {
      larsFrequenz = Integer.parseInt(eingabe);
    } catch (Exception e) {
      System.err.println("Es ist ein unerwarteter Lars aufgetreten!");
    }
    while (true) {
      System.out.println(lars++);
      Thread.sleep(larsFrequenz);
      System.out.println("System.safe()");
      Thread.sleep(larsFrequenz);
    }
  }
}
