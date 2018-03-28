package tech.bison.trainee17.collections;

import static org.hamcrest.CoreMatchers.is;
import static org.junit.Assert.assertThat;

import java.util.HashMap;

import org.junit.Test;

public class MapContactListTest {

  @Test
  public void contactList_addContactsToContactList_ContactListWithContacts() {
    HashMap<String, Contact> contactList = new HashMap<String, Contact>();
    Contact lino = new Contact("Lino", "Meyer", "Eichenstrasse 11", "6023", "Rothenburg", "lino.meyer@bluewin.ch",
        "+41 76 558 20 90");
    Contact luca = new Contact("Luca", "Bucher", "Scheid 1", "6026", "Rain", "lucbu01@bluewin.ch", "+41 79 664 10 72");
    Contact lars = new Contact("Lars", "Ghezzi", "Geuenseerstrasse 16d", "6210", "Sursee", "lars.ghezzi@bluewin.ch",
        "+41 79 608 91 35");

    contactList.put("myl", lino);
    contactList.put("bhl", luca);
    contactList.put("ghl", lars);

    assertThat(contactList.get("myl"), is(lino));
    assertThat(contactList.get("ghl"), is(lars));
    assertThat(contactList.get("bhl"), is(luca));
  }

  @Test
  public void contactList_removeContactsFromList_ContactListWithoutRemovedContacts() {
    HashMap<String, Contact> contactList = new HashMap<String, Contact>();
    Contact lino = new Contact("Lino", "Meyer", "Eichenstrasse 11", "6023", "Rothenburg", "lino.meyer@bluewin.ch",
        "+41 76 558 20 90");
    Contact luca = new Contact("Luca", "Bucher", "Scheid 1", "6026", "Rain", "lucbu01@bluewin.ch", "+41 79 664 10 72");
    Contact lars = new Contact("Lars", "Ghezzi", "Geuenseerstrasse 16d", "6210", "Sursee", "lars.ghezzi@bluewin.ch",
        "+41 79 608 91 35");

    contactList.put("myl", lino);
    contactList.put("bhl", luca);
    contactList.put("ghl", lars);

    Contact removedContact = contactList.remove("myl");

    assertThat(removedContact, is(lino));
    assertThat(contactList.containsKey("myl"), is(false));
    assertThat(contactList.get("ghl"), is(lars));
    assertThat(contactList.get("bhl"), is(luca));
  }
}
