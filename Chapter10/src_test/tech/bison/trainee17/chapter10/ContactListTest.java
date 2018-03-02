package tech.bison.trainee17.chapter10;

import static org.hamcrest.CoreMatchers.is;
import static org.junit.Assert.assertThat;

import org.junit.Test;

public class ContactListTest {
  @Test
  public void contact_addToContactList_contactListWithContact() throws Exception {
    Contact lino = new Contact("Lino", "Meyer", "Eichenstrasse 11", "6023", "Rothenburg", "lino.meyer@bluewin.ch",
        "+41 76 558 20 90");
    ContactList contactList = new ContactList();

    contactList.add(lino);

    assertThat(contactList.get(0), is(lino));
  }

  @Test
  public void contactList_removeContacts_contactListWithoutRemovedContacts() throws Exception {
    Contact lino = new Contact("Lino", "Meyer", "Eichenstrasse 11", "6023", "Rothenburg", "lino.meyer@bluewin.ch",
        "+41 76 558 20 90");
    Contact luca = new Contact("Luca", "Bucher", "Scheid 1", "6026", "Rain", "lucbu01@bluewin.ch", "+41 79 664 10 72");
    Contact lars = new Contact("Lars", "Ghezzi", "Geuenseerstrasse 16d", "6210", "Sursee", "lars.ghezzi@bluewin.ch",
        "+41 79 608 91 35");

    ContactList contactList = new ContactList();

    contactList.add(lino);
    contactList.add(luca);
    contactList.add(lars);

    contactList.remove(0);
    contactList.remove(luca);

    assertThat(contactList.get(0), is(lars));
  }
}
