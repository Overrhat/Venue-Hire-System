package nz.ac.auckland.se281;

public class Catering extends Services {

  private final Types.CateringType cateringType;

  public Catering(String bookingReference, Types.CateringType cateringType) {
    super(bookingReference);
    this.cateringType = cateringType;
  }

  public Types.CateringType getCateringType() {
    return this.cateringType;
  }

  public String getCateringTypeName() {
    return this.cateringType.getName();
  }

  public int getCateringTypeCostPerPerson() {
    return this.cateringType.getCostPerPerson();
  }

  @Override
  public Type getServiceType() {
    return Services.Type.Catering;
  }
}
