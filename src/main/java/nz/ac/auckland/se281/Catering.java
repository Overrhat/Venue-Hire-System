package nz.ac.auckland.se281;

public class Catering extends Services {

  private final Types CateringType;

  public Catering(String bookingReference, Types CateringType) {
    super(bookingReference);
    this.CateringType = CateringType;
  }

  public Types getCateringType() {
    return this.CateringType;
  }
}
