package tech.bison.trainee17.chapter10;

import java.util.ArrayList;

public class ContactList extends ArrayList<Contact> {

  private static final long serialVersionUID = 1L;

  public void editEmail(int index, String email) {
    this.get(index).email = email;
  }

  public void editFirstName(int index, String firstName) {
    this.get(index).firstName = firstName;
  }

  public void editLastName(int index, String lastName) {
    this.get(index).lastName = lastName;
  }

  public void editPostalCode(int index, String postalCode) {
    this.get(index).postalCode = postalCode;
  }

  public void editPlace(int index, String place) {
    this.get(index).place = place;
  }

  public void editPhoneNumber(int index, String phoneNumber) {
    this.get(index).phoneNumber = phoneNumber;
  }

  public void editAddress(int index, String address) {
    this.get(index).address = address;

  }

}
