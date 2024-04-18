package nz.ac.auckland.se281;

import java.util.ArrayList;
import nz.ac.auckland.se281.Types.CateringType;
import nz.ac.auckland.se281.Types.FloralType;

public class VenueHireSystem {

  private ArrayList<Venue> venueList = new ArrayList<Venue>();
  private String systemDate = "";
  private ArrayList<Booking> bookingsList = new ArrayList<Booking>();
  private ArrayList<Services> servicesList = new ArrayList<Services>();

  public VenueHireSystem() {}

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
    }

    // Print all the venue list
    for (Venue venue : venueList) {
      String name = venue.getVenueName();
      String code = venue.getVenueCode();
      String capacity = Integer.toString(venue.getCapacity());
      String hireFee = Integer.toString(venue.getHireFee());

      // If system date is not set then just print without date
      if (systemDate.isEmpty() || systemDate.equals(null)) {
        MessageCli.VENUE_ENTRY.printMessage(name, code, capacity, hireFee);
        continue;
      }

      // Find the next available date for the venue
      Dates nextAvailableDate = new Dates(systemDate); // Initialize with the current system date

      // Check if there are bookings for this venue
      ArrayList<Booking> venueBookingList = new ArrayList<Booking>();
      for (Booking booking : bookingsList) {
        if (booking.getVenueCode().equals(code)) {
          venueBookingList.add(booking); // Creates a booking list for the specific venue
        }
      }

      // If there is no bookings
      if (venueBookingList.isEmpty()) {
        MessageCli.VENUE_ENTRY.printMessage(name, code, capacity, hireFee, systemDate);
        continue;
      }

      // Get the earliest date
      Dates earliestDate =
          new Dates(
              venueBookingList
                  .get(0)
                  .getDate()); // Initialise the earliest date to be the first index
      for (int i = 1; i < venueBookingList.size(); i++) {
        Dates newDate = new Dates(venueBookingList.get(i).getDate());
        if (earliestDate.isOtherDatePast(newDate)) {
          earliestDate = newDate;
        }
      }

      // Check if the systemdate has no booking
      if (earliestDate.isOtherDatePast(nextAvailableDate)) {
        // Print the venue entry
        String nextDate = nextAvailableDate.getFullDates();
        MessageCli.VENUE_ENTRY.printMessage(name, code, capacity, hireFee, nextDate);
        return;
      }

      // Find the closest date possible
      Boolean noBooking = false;
      int daysChecked = 0;
      while (noBooking == false && daysChecked < 365) {
        earliestDate.updateDate(earliestDate.getNextDate());
        daysChecked++;
        Boolean continueChecker = false;
        for (int i = 0; i < venueBookingList.size(); i++) {
          Dates newDate = new Dates(venueBookingList.get(i).getDate());
          if (earliestDate.getFullDates().equals(newDate.getFullDates())) {
            continueChecker = true;
            break;
          }
        }
        if (continueChecker == false) {
          noBooking = true;
          nextAvailableDate = earliestDate;
          break;
        }
      }

      // Print the venue entry
      String nextDate = nextAvailableDate.getFullDates();
      MessageCli.VENUE_ENTRY.printMessage(name, code, capacity, hireFee, nextDate);
    }
  }

  public void createVenue(
      String venueName, String venueCode, String capacityInput, String hireFeeInput) {
    // checking if there is any existing same code in the list
    for (Venue venue : venueList) {
      String code = venue.getVenueCode();
      String name = venue.getVenueName();
      if (code.equals(venueCode)) {
        MessageCli.VENUE_NOT_CREATED_CODE_EXISTS.printMessage(code, name);
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
    if (Integer.parseInt(hireFeeInput) < 0 || Integer.parseInt(hireFeeInput) == 0) {
      MessageCli.VENUE_NOT_CREATED_INVALID_NUMBER.printMessage("hire fee", " positive");
      return;
    }

    // checking if capacityInput is a valid number
    try {
      Integer.parseInt(capacityInput);
    } catch (NumberFormatException e) {
      MessageCli.VENUE_NOT_CREATED_INVALID_NUMBER.printMessage("capacity", "");
      return;
    }
    if (Integer.parseInt(capacityInput) < 0 || Integer.parseInt(capacityInput) == 0) {
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
    // Sets the dateInput to the systemDate
    this.systemDate = dateInput;
    MessageCli.DATE_SET.printMessage(systemDate);
  }

  public void printSystemDate() {
    // Checking if the system's date has not been set
    if (this.systemDate.isEmpty()) {
      MessageCli.CURRENT_DATE.printMessage("not set");
    } else {
      MessageCli.CURRENT_DATE.printMessage(systemDate); // printing the system date
    }
  }

  public void makeBooking(String[] options) {
    // Checks if the system date has not been set
    if (systemDate.isEmpty()) {
      MessageCli.BOOKING_NOT_MADE_DATE_NOT_SET.printMessage();
      return;
    }

    // Checks if there are no venues in the system
    if (venueList.isEmpty()) {
      MessageCli.BOOKING_NOT_MADE_NO_VENUES.printMessage();
      return;
    }

    // Checks if the venue code exists
    Boolean isCodeFake = true;
    for (Venue venue : venueList) {
      String code = venue.getVenueCode();
      if (code.equals(options[0])) {
        isCodeFake = false;
        break;
      }
    }
    if (isCodeFake) {
      MessageCli.BOOKING_NOT_MADE_VENUE_NOT_FOUND.printMessage(options[0]);
      return;
    }

    // Get a Venue name
    String venueName = "";
    for (Venue venue : venueList) {
      String code = venue.getVenueCode();
      if (code.equals(options[0])) {
        venueName = venue.getVenueName(); // Find the venueName
        break;
      }
    }

    // Checks if the venue is available on the specified date
    for (Booking booking : bookingsList) {
      String code = booking.getVenueCode();
      String bookingDate = booking.getDate();
      if (bookingDate.equals(options[1]) && code.equals(options[0])) {
        MessageCli.BOOKING_NOT_MADE_VENUE_ALREADY_BOOKED.printMessage(venueName, options[1]);
        return;
      }
    }

    // Checks if the booking date is in past (reference to the systemDate)
    Dates system = new Dates(systemDate);
    Dates bookingDate = new Dates(options[1]);
    if (system.isOtherDatePast(bookingDate)) {
      MessageCli.BOOKING_NOT_MADE_PAST_DATE.printMessage(options[1], systemDate);
      return;
    }

    // Make a booking
    // Check the venue capacity and the number of attendence
    int venueCapacity = 0;
    String newAttendees = "";
    int attendees = Integer.parseInt(options[3]);
    for (Venue venue : venueList) {
      String code = venue.getVenueCode();
      if (code.equals(options[0])) {
        venueCapacity = venue.getCapacity(); // Get the capacity;
        break;
      }
    }
    if (attendees > venueCapacity) {
      newAttendees = Integer.toString(venueCapacity);
      MessageCli.BOOKING_ATTENDEES_ADJUSTED.printMessage(options[3], newAttendees, newAttendees);
    } else if (attendees < (0.25 * venueCapacity)) {
      newAttendees = Integer.toString((int) (0.25 * venueCapacity));
      MessageCli.BOOKING_ATTENDEES_ADJUSTED.printMessage(
          options[3], newAttendees, Integer.toString(venueCapacity));
    } else {
      newAttendees = Integer.toString(attendees);
    }

    // Generate an instance of a Booking with BookingReference Generator
    String reference = BookingReferenceGenerator.generateBookingReference();
    Booking booking =
        new Booking(reference, options[0], options[1], options[2], newAttendees, systemDate);

    // Add to the booking list
    bookingsList.add(booking);

    // Print the succesful created booking
    MessageCli.MAKE_BOOKING_SUCCESSFUL.printMessage(reference, venueName, options[1], newAttendees);
  }

  public void printBookings(String venueCode) {
    // Check if there is no venue
    if (venueList.isEmpty()) {
      MessageCli.PRINT_BOOKINGS_VENUE_NOT_FOUND.printMessage(venueCode);
      return;
    }

    // Check if there is no venue with the code
    Boolean noCode = true;
    for (Venue venue : venueList) {
      String code = venue.getVenueCode();
      if (venueCode.equals(code)) {
        noCode = false;
        break;
      }
    }
    if (noCode) {
      MessageCli.PRINT_BOOKINGS_VENUE_NOT_FOUND.printMessage(venueCode);
      return;
    }

    // Make an arrayList containing the booking with the specified venue
    ArrayList<Booking> venueBookingList = new ArrayList<Booking>();
    for (Booking booking : bookingsList) {
      if (booking.getVenueCode().equals(venueCode)) {
        venueBookingList.add(booking); // Creates a booking list for the specific venue
      }
    }

    // Get the venue name
    String venueName = "";
    for (Venue venue : venueList) {
      String code = venue.getVenueCode();
      if (venueCode.equals(code)) {
        venueName = venue.getVenueName();
        break;
      }
    }

    // Check if there is no bookings for specified venue
    if (venueBookingList.isEmpty()) {
      MessageCli.PRINT_BOOKINGS_HEADER.printMessage(venueName);
      MessageCli.PRINT_BOOKINGS_NONE.printMessage(venueName);
      return;
    }

    // Print all the bookings
    MessageCli.PRINT_BOOKINGS_HEADER.printMessage(venueName);
    for (Booking booking : venueBookingList) {
      String reference = booking.getReference();
      String bookingDate = booking.getDate();
      MessageCli.PRINT_BOOKINGS_ENTRY.printMessage(reference, bookingDate);
    }
  }

  public void addCateringService(String bookingReference, CateringType cateringType) {
    // Check if there is no booking reference
    Boolean noReference = true;
    for (Booking booking : bookingsList) {
      String reference = booking.getReference();
      if (reference.equals(bookingReference)) {
        noReference = false;
        break;
      }
    }
    if (noReference) {
      MessageCli.SERVICE_NOT_ADDED_BOOKING_NOT_FOUND.printMessage("Catering", bookingReference);
      return;
    }

    // Add service
    Services service = new Catering(bookingReference, cateringType);
    servicesList.add(service);
    String cateringName = ((Catering) service).getCateringTypeName();
    String printingName = String.format("Catering (%s)", cateringName);
    MessageCli.ADD_SERVICE_SUCCESSFUL.printMessage(printingName, bookingReference);
  }

  public void addServiceMusic(String bookingReference) {
    // Check if there is no booking reference
    Boolean noReference = true;
    for (Booking booking : bookingsList) {
      String reference = booking.getReference();
      if (reference.equals(bookingReference)) {
        noReference = false;
        break;
      }
    }
    if (noReference) {
      MessageCli.SERVICE_NOT_ADDED_BOOKING_NOT_FOUND.printMessage("Music", bookingReference);
      return;
    }

    // Add service
    Services service = new Music(bookingReference);
    servicesList.add(service);
    MessageCli.ADD_SERVICE_SUCCESSFUL.printMessage("Music", bookingReference);
  }

  public void addServiceFloral(String bookingReference, FloralType floralType) {
    // Check if there is no booking reference
    Boolean noReference = true;
    for (Booking booking : bookingsList) {
      String reference = booking.getReference();
      if (reference.equals(bookingReference)) {
        noReference = false;
        break;
      }
    }
    if (noReference) {
      MessageCli.SERVICE_NOT_ADDED_BOOKING_NOT_FOUND.printMessage("Floral", bookingReference);
      return;
    }

    // Add service
    Services service = new FloralService(bookingReference, floralType);
    servicesList.add(service);
    String floralName = ((FloralService) service).getFloralTypeName();
    String printingName = String.format("Floral (%s)", floralName);
    MessageCli.ADD_SERVICE_SUCCESSFUL.printMessage(printingName, bookingReference);
  }

  public void viewInvoice(String bookingReference) {
    // Check if the bookingReference does not exist and get the booking
    Boolean noReference = true;
    Booking invoiceBooking = null;
    for (Booking booking : bookingsList) {
      String reference = booking.getReference();
      if (reference.equals(bookingReference)) {
        noReference = false;
        invoiceBooking = booking;
        break;
      }
    }
    if (noReference) {
      MessageCli.VIEW_INVOICE_BOOKING_NOT_FOUND.printMessage(bookingReference);
      return;
    }

    // Get the venue of the booking
    String code = invoiceBooking.getVenueCode();
    Venue bookingVenue = null;
    for (Venue venue : venueList) {
      String venueCode = venue.getVenueCode();
      if (code.equals(venueCode)) {
        bookingVenue = venue;
        break;
      }
    }
    // Get the details needed for invoice content top half
    String venueName = bookingVenue.getVenueName();
    String customerEmail = invoiceBooking.getEmail();
    String dateBooked = invoiceBooking.getDateBooked();
    String partyDate = invoiceBooking.getDate();
    String guests = invoiceBooking.getAttendees();

    // Print the invoice content top half
    MessageCli.INVOICE_CONTENT_TOP_HALF.printMessage(
        bookingReference, customerEmail, dateBooked, partyDate, guests, venueName);

    // Get venue hire fee and print
    int venueHireFee = bookingVenue.getHireFee();
    String hireFeeString = Integer.toString(venueHireFee);
    MessageCli.INVOICE_CONTENT_VENUE_FEE.printMessage(hireFeeString);

    // Find all the services for the booking
    ArrayList<Services> bookingServices = new ArrayList<Services>();
    for (Services service : servicesList) {
      String bookingRef = service.getBookingReference();
      if (bookingRef.equals(bookingReference)) {
        bookingServices.add(service);
      }
    }

    // Initialize fees
    int cateringFee = 0;
    int musicFee = 0;
    int floralFee = 0;
    int totalFee = 0;
    int guestsNumber = Integer.parseInt(guests);

    // Print the rest of the invoice
    if (bookingServices.isEmpty()) { // When there is no services
      MessageCli.INVOICE_CONTENT_BOTTOM_HALF.printMessage(hireFeeString);
      return;
    } else { // Check services
      for (Services service : bookingServices) {
        Services.Type serviceType = service.getServiceType();

        // Check for each type of services
        if (serviceType == Services.Type.Catering) { // For Catering service
          String cateringName = ((Catering) service).getCateringTypeName();
          int cateringFeePerPerson = ((Catering) service).getCateringTypeCostPerPerson();
          cateringFee = cateringFeePerPerson * guestsNumber;
          String cateringFeeString = Integer.toString(cateringFee);
          MessageCli.INVOICE_CONTENT_CATERING_ENTRY.printMessage(cateringName, cateringFeeString);
        } else if (serviceType == Services.Type.Music) { // For Music service
          musicFee = 500;
          String musicFeeString = Integer.toString(musicFee);
          MessageCli.INVOICE_CONTENT_MUSIC_ENTRY.printMessage(musicFeeString);
        } else { // For Floral service
          String floralType = ((FloralService) service).getFloralTypeName();
          floralFee = ((FloralService) service).getFloralTypeCost();
          String floralFeeString = Integer.toString(floralFee);
          MessageCli.INVOICE_CONTENT_FLORAL_ENTRY.printMessage(floralType, floralFeeString);
        }
      }
    }

    totalFee = venueHireFee + cateringFee + musicFee + floralFee;
    String totalFeeString = Integer.toString(totalFee);
    // Print the bottom half invoice content
    MessageCli.INVOICE_CONTENT_BOTTOM_HALF.printMessage(totalFeeString);
  }
}
