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
    // Check if it's the end of the month
    if ((this.month == 4 || this.month == 6 || this.month == 9 || this.month == 11)
        && this.date == 30) {
      this.month++;
      this.date = 1;
    } else if (this.month == 2) { // February
      if ((this.year % 4 == 0 && this.year % 100 != 0)
          || (this.year % 400 == 0)) { // Leap year check
        if (this.date == 29) {
          this.month++;
          this.date = 1;
        }
      } else {
        if (this.date == 28) {
          this.month++;
          this.date = 1;
        }
      }
    } else if (this.date == 31) { // End of month for months with 31 days
      if (this.month == 12) { // End of the year
        this.year++; // Move to the next year
        this.month = 1; // Reset month to January
      } else {
        this.month++;
      }
      this.date = 1;
    } else { // For all other cases, just increment the date
      this.date++;
    }

    // Return the next date
    return this.getFullDates();
  }
}
