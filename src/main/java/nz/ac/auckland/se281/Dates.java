package nz.ac.auckland.se281;

public class Dates {

  private String date;
  private String month;
  private String year;

  public Dates(String fullDates) {
    String[] dateParts = fullDates.split("/");
    this.date = dateParts[0];
    this.month = dateParts[1];
    this.year = dateParts[2];
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
}
