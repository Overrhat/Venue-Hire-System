package nz.ac.auckland.se281;

public class Catering extends Services {

  private final Types cateringType;

  public Catering(String bookingReference, Types cateringType) {
    super(bookingReference);
    this.cateringType = cateringType;
  }

  public Types getCateringType() {
    return this.cateringType;
  }

  @Override
  public Type getServiceType() {
    return Services.Type.Catering;
  }
}
