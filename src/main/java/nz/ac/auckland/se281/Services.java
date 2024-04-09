package nz.ac.auckland.se281;

public abstract class Services extends Object {

  protected String bookingReference;

  public Services(String bookingReference) {
    this.bookingReference = bookingReference;
  }

  public String getBookingReference() {
    return this.bookingReference;
  }
}
