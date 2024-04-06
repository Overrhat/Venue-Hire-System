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
}
