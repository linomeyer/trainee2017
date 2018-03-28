package tech.bison.trainee17.collections;

public class Contact {
  String firstName;
  String lastName;
  String address;
  String postalCode;
  String place;
  String email;
  String phoneNumber;

  /**
   * Creates a contact with the attributes firstName, lastName, address,
   * postalCode, place, email and phoneNumber
   */
  public Contact(String firstName, String lastName, String address, String postalCode, String place, String email,
      String phone) {
    this.firstName = firstName;
    this.lastName = lastName;
    this.address = address;
    this.postalCode = postalCode;
    this.place = place;
    this.email = email;
    this.phoneNumber = phone;
  }

  @Override
  public String toString() {

    return firstName + " " + lastName + "\n" + address + "\n" + postalCode + " " + place + "\n" + email + "\n"
        + phoneNumber;
  }

  @Override
  public boolean equals(Object obj) {
    obj = (Contact) obj;
    return this.toString().equals(obj.toString());
  }
}
