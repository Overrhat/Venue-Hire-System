package nz.ac.auckland.se281;

public class Dates {

  private String fullDates;
  private String date;
  private String month;
  private String year;

  public Dates(String fullDates) {
    this.fullDates = fullDates;
    String[] dateParts = fullDates.split("/");
    this.date = dateParts[0];
    this.month = dateParts[1];
    this.year = dateParts[2];
  }

  public String getFullDates() {
    return this.fullDates;
  }

  public String getDate() {
    return this.date;
  }

  public String getMonth() {
    return this.month;
  }

  public String getYear() {
    return this.year;
  }

  public Boolean isOtherDatePast(Dates other) {
    // Initialize the other date is past
    Boolean isPast = true;

    // Return the result
    return isPast;
  }
}
