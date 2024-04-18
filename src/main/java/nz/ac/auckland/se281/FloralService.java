package nz.ac.auckland.se281;

public class FloralService extends Services {

  private final Types.FloralType floralType;

  public FloralService(String bookingReference, Types.FloralType floralType) {
    super(bookingReference);
    this.floralType = floralType;
  }

  public Types.FloralType getFloralType() {
    return this.floralType;
  }

  public String getFloralTypeName() {
    return this.floralType.getName();
  }

  public int getFloralTypeCost() {
    return this.floralType.getCost();
  }

  @Override
  public Type getServiceType() {
    return Services.Type.Floral;
  }
}
