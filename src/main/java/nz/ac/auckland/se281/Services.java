package nz.ac.auckland.se281;

public abstract class Services extends Object {

  protected String bookingReference;

  public enum Type {
    Catering,
    Music,
    Floral
  }

  public Services(String bookingReference) {
    this.bookingReference = bookingReference;
  }

  public String getBookingReference() {
    return this.bookingReference;
  }

  public abstract Type getServiceType();
}
