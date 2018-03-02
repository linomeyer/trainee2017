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
}
