package nz.ac.auckland.se281;

public class Venue {

  private String venueName;
  private String venueCode;
  private int capacity;
  private int hireFee;

  public Venue(String venueName, String venueCode, String capacityInput, String hireFeeInput) {
    this.venueName = venueName;
    this.venueCode = venueCode;
    this.capacity = Integer.parseInt(capacityInput);
    this.hireFee = Integer.parseInt(hireFeeInput);
  }

  public String getVenueName() {
    return this.venueName;
  }

  public String getVenueCode() {
    return this.venueCode;
  } 
  public int getCapacity() {
    return this.capacity;
  }

  public int getHireFee() {
    return this.hireFee;
  }
}
