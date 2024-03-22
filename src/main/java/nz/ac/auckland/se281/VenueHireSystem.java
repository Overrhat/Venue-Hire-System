package nz.ac.auckland.se281;

import java.util.ArrayList;

import nz.ac.auckland.se281.Types.CateringType;
import nz.ac.auckland.se281.Types.FloralType;

public class VenueHireSystem {

  private ArrayList<Venue> venueList = new ArrayList<Venue>();

  public VenueHireSystem() {
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
        MessageCli.NUMBER_VENUES.printMessage("are", "three", "s");
        break;
      case 4:
        MessageCli.NUMBER_VENUES.printMessage("are", "four", "s");
        break;
      case 5:
        MessageCli.NUMBER_VENUES.printMessage("are", "five", "s");
        break;
      case 6:
        MessageCli.NUMBER_VENUES.printMessage("are", "six", "s");
        break;
      case 7:
        MessageCli.NUMBER_VENUES.printMessage("are", "seven", "s");
        break;
      case 8:
        MessageCli.NUMBER_VENUES.printMessage("are", "eight", "s");
        break;
      case 9:
        MessageCli.NUMBER_VENUES.printMessage("are", "nine", "s");
        break;
      default:
        MessageCli.NUMBER_VENUES.printMessage("are", Integer.toString(venueNumber), "s");
        break;
  
        // Print all the venue list

    }
  }

  public void createVenue(
      String venueName, String venueCode, String capacityInput, String hireFeeInput) {
        // checking if there is any existing same code in the list 
        for (Venue venue : venueList) {
          String code = venue.getVenueCode();
          if (code.equals(venueCode)) {
            MessageCli.VENUE_NOT_CREATED_CODE_EXISTS.printMessage(code, code);
            return;
          }
        }

        // checking if hireFeeInput is a valid numebr
        try {
          Integer.parseInt(hireFeeInput);
        } catch (NumberFormatException e) {
          MessageCli.VENUE_NOT_CREATED_INVALID_NUMBER.printMessage("hire fee", "");
          return;
        }

        // checking if capacityInput is a valid number
        try {
          Integer.parseInt(capacityInput);
        } catch (NumberFormatException e) {
          MessageCli.VENUE_NOT_CREATED_INVALID_NUMBER.printMessage("capacity", "");
          return;
        }
        if (Integer.parseInt(capacityInput) < 0) {
          MessageCli.VENUE_NOT_CREATED_INVALID_NUMBER.printMessage("capacity", " positive");
          return;
        }
        
        // checking if the venueName is valid 
        if (venueName.isEmpty() || venueName.equals(" ")) {
          MessageCli.VENUE_NOT_CREATED_EMPTY_NAME.printMessage();
          return;
        }

        // Now all the inputs have been checked that they are valid so create the venue
        Venue venue = new Venue(venueName, venueCode, capacityInput, hireFeeInput);
        venueList.add(venue);
        MessageCli.VENUE_SUCCESSFULLY_CREATED.printMessage(venueName, venueCode);
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
