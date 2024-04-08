package nz.ac.auckland.se281;

public class Booking {

  private String reference;
  private String venueCode;
  private String date;
  private String email;
  private String attendees;
  private String dateBooked;

  public Booking(
      String reference,
      String venueCode,
      String date,
      String email,
      String attendees,
      String dateBooked) {
    this.reference = reference;
    this.venueCode = venueCode;
    this.date = date;
    this.email = email;
    this.attendees = attendees;
    this.dateBooked = dateBooked;
  }

  public String getReference() {
    return this.reference;
  }

  public String getVenueCode() {
    return this.venueCode;
  }

  public String getDate() {
    return this.date;
  }

  public String getEmail() {
    return this.email;
  }

  public String getAttendees() {
    return this.attendees;
  }

  public String getDateBooked() {
    return this.dateBooked;
  }
}
