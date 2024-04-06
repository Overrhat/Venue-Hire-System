package nz.ac.auckland.se281;

public class Booking {

  private String reference;
  private String venueCode;
  private String date;
  private String email;
  private String attendees;

  public Booking(String reference, String venueCode, String date, String email, String attendees) {
    this.reference = reference;
    this.venueCode = venueCode;
    this.date = date;
    this.email = email;
    this.attendees = attendees;
  }
}
