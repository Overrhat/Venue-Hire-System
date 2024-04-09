package nz.ac.auckland.se281;

public class Music extends Services {

  public Music(String bookingRefernce) {
    super(bookingRefernce);
  }

  @Override
  public Type getServiceType() {
    return Services.Type.Music;
  }
}
