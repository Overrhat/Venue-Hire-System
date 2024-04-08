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

  public Dates getNextDate() {
    int nextDate = this.date;
    int nextMonth = this.month;
    int nextYear = this.year;

    // Modify the date, month, and year accordingly
    if ((nextMonth == 4 || nextMonth == 6 || nextMonth == 9 || nextMonth == 11) && nextDate == 30) {
      nextMonth++;
      nextDate = 1;
    } else if (nextMonth == 2) { // February
      // Check if it's a leap year
      if ((nextYear % 4 == 0 && nextYear % 100 != 0) || (nextYear % 400 == 0)) {
        if (nextDate == 29) {
          nextMonth++;
          nextDate = 1;
        }
      } else {
        if (nextDate == 28) {
          nextMonth++;
          nextDate = 1;
        }
      }
    } else if (nextDate == 31) { // End of month for months with 31 days
      if (nextMonth == 12) { // End of the year
        nextYear++;
        nextMonth = 1;
      } else {
        nextMonth++;
      }
      nextDate = 1;
    } else { // For all other cases, just increment the date
      nextDate++;
    }

    // Return a new Dates object representing the next date
    return new Dates(String.format("%02d/%02d/%04d", nextDate, nextMonth, nextYear));
  }

  public void updateDate(Dates newDate) {
    this.date = newDate.getDate();
    this.month = newDate.getMonth();
    this.year = newDate.getYear();
  }
}
