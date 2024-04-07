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
    this.fullDates = String.format("%02d/%02d/%04d", this.date, this.month, this.year);
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
    // Check the year
    if (this.year > other.getYear()) {
      return true;
    } else if (this.year < other.getYear()) {
      return false;
    }

    // Check the month
    if (this.month > other.getMonth()) {
      return true;
    } else if (this.month < other.getMonth()) {
      return false;
    }

    // Check the date
    if (this.date > other.getDate()) {
      return true;
    } else if (this.date < other.getDate()) {
      return false;
    } else {
      return false; // In this case it is the same date, thus it is not past
    }
  }

  public String getNextDate() {
    // Return the next date
    return this.getFullDates();
  }
}
