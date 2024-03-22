package nz.ac.auckland.se281;

import java.util.ArrayList;

import nz.ac.auckland.se281.Types.CateringType;
import nz.ac.auckland.se281.Types.FloralType;

public class VenueHireSystem {

  private ArrayList venueList = new ArrayList<>();
  private String venueName;
  private String venueCode;
  private int capacity;
  private int hireFee;

  public VenueHireSystem() {
    // this.venueName = venueName;
    // this.venueCode = venueCode;
    // this.capacity = Integer.parseInt(capacityInput);
    // this.hireFee = Integer.parseInt(hireFeeInput);
    // MessageCli.VENUE_SUCCESSFULLY_CREATED.printMessage(venueName, venueCode);
  }

  public void printVenues() {
    // finding the size of the venue list to check how many venues are in the list
    int venueNumber = venueList.size();

    // using switch to print the correct way for each cases
    switch (venueNumber) {
      case 0:
        MessageCli.NO_VENUES.printMessage();
        break;
      case 1:
        MessageCli.NUMBER_VENUES.printMessage("is", "one", "");
        break;
      case 2:
        MessageCli.NUMBER_VENUES.printMessage("are", "two", "s");
        break;
      case 3:
        MessageCli.NUMBER_VENUES.printMessage("are", "one", "s");
        break;
      case 4:
        MessageCli.NUMBER_VENUES.printMessage("are", "one", "s");
        break;
      case 5:
        MessageCli.NUMBER_VENUES.printMessage("are", "one", "s");
        break;
      case 6:
        MessageCli.NUMBER_VENUES.printMessage("are", "one", "s");
        break;
      case 7:
        MessageCli.NUMBER_VENUES.printMessage("are", "one", "s");
        break;
      case 8:
        MessageCli.NUMBER_VENUES.printMessage("are", "one", "s");
        break;
      case 9:
        MessageCli.NUMBER_VENUES.printMessage("are", "one", "s");
        break;
      default:
        MessageCli.NUMBER_VENUES.printMessage("are", "one", "s");
        break;
  
        // Print all the venue list
        
    }
  }

  public void createVenue(
      String venueName, String venueCode, String capacityInput, String hireFeeInput) {
        
  }

  public void setSystemDate(String dateInput) {
    // TODO implement this method
  }

  public void printSystemDate() {
    // TODO implement this method
  }

  public void makeBooking(String[] options) {
    // TODO implement this method
  }

  public void printBookings(String venueCode) {
    // TODO implement this method
  }

  public void addCateringService(String bookingReference, CateringType cateringType) {
    // TODO implement this method
  }

  public void addServiceMusic(String bookingReference) {
    // TODO implement this method
  }

  public void addServiceFloral(String bookingReference, FloralType floralType) {
    // TODO implement this method
  }

  public void viewInvoice(String bookingReference) {
    // TODO implement this method
  }
}
