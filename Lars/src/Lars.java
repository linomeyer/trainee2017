import javax.swing.JOptionPane;

public class Lars {
  public static void main(String[] args) throws InterruptedException {
    short lars = 500;
    int larsFrequenz = 1000;
    /**
     * larsisches Wörterbuch: Lars = Name und Synonym für viele beliebige Nomen, in
     * unserem Fall für "Fehler" larsen = Synonym für viele beliebige Wörter, in
     * unserem Fall zum einen für die Ausgabe und für die Pause
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
