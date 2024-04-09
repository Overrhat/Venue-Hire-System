package nz.ac.auckland.se281;

public class Floral extends Services {

  private final Types floralType;

  public Floral(String bookingReference, Types floralType) {
    super(bookingReference);
    this.floralType = floralType;
  }

  public Types getFloralType() {
    return this.floralType;
  }

  @Override
  public Type getServiceType() {
    return Services.Type.Floral;
  }
}
