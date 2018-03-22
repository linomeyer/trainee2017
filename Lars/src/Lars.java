import javax.swing.JOptionPane;

public class Lars {
  public static void main(String[] args) throws InterruptedException {
    short lars = 500;
    int larsFrequenz = 1000;
    boolean falscheEingabe = false;
    String ausgabeText = "Wie lange soll Lars zwischen dem larsen larsen? xD (Frequenz in ms)";
    /**
     * larsisches Wörterbuch: Lars = Name und Synonym für viele beliebige Nomen, in
     * unserem Fall für "Fehler" larsen = Synonym für viele beliebige Wörter, in
     * unserem Fall zum einen für die Ausgabe und für die Pause
     */
    do {
      String eingabe = JOptionPane.showInputDialog(ausgabeText);
      try {
        falscheEingabe = false;
        larsFrequenz = Integer.parseInt(eingabe);
        while (true) {
          System.out.println(lars++);
          Thread.sleep(larsFrequenz);
          System.out.println("System.safe()");
          Thread.sleep(larsFrequenz);
        }
      } catch (Exception e) {
        if (eingabe.toLowerCase().equals("lars")) {
          ausgabeText = "Du hast voll larsisch gequatscht. Aber Lars braucht eine Angabe!\nWie lange soll Lars zwischen dem larsen larsen? xD (Frequenz in ms)";
        } else {
          System.err.println("Es ist ein unerwarteter Lars aufgetreten!");
          ausgabeText = "Es ist ein unerwarteter Lars aufgetreten!\nWie lange soll Lars zwischen dem larsen larsen? xD (Frequenz in ms)";
        }
        falscheEingabe = true;
      }
    } while (falscheEingabe);
  }
}
