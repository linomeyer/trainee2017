package tech.bison.trainee17.chapter10;

import org.junit.Test;

public class ContactTest {
  @Test
  public void contact_toString_ContactInAddressFormat() throws Exception {
    Contact lino = new Contact("Lino", "Meyer", "Eichenstrasse 11", "6023", "Rothenburg", "lino.meyer@bluewin.ch",
        "+41 76 558 20 90");
    System.out.println(lino.toString());
  }
}
