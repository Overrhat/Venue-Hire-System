package nz.ac.auckland.se281;

public class Dates {

  private String fullDates;
  private int date;
  private int month;
  private int year;

  public Dates(String fullDates) {
    this.fullDates = fullDates;
    String[] dateParts = fullDates.split("/");
    this.date = Integer.parseInt(dateParts[0]);
    this.month = Integer.parseInt(dateParts[1]);
    this.year = Integer.parseInt(dateParts[2]);
  }

  public String getFullDates() {
    return this.fullDates;
  }

  public int getDate() {
    return this.date;
  }

  public int getMonth() {
    return this.month;
  }

  public int getYear() {
    return this.year;
  }

  public Boolean isOtherDatePast(Dates other) {
    // Initialize the other date is past
    Boolean isPast = true;

    // Check the year

    // Return the result
    return isPast;
  }
}
