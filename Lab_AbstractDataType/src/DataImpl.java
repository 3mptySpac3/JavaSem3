import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.time.DayOfWeek;

// Implementation of the DateADT interface.
public class DataImpl implements DateADT {
    
    // Instance variable to hold the date.
    private LocalDate date;
    
    // Constructor to initialize the date to the current date.
    public DataImpl() {
        this.date = LocalDate.now();
    }
    
    // Method to set the date to a specific year, month, and day.
    @Override
    public void setDate(int y, int m, int d) {
        this.date = LocalDate.of(y, m, d);
    }
    
    // Method to compare this date with another date.
    // Returns a negative value if this date is before the other date,
    // a positive value if this date is after the other date,
    // and zero if they are equal.
    @Override
    public int compareTo(DateADT otherDate) {
        DataImpl other = (DataImpl) otherDate;
        return this.date.compareTo(other.date);
    }
    
    // Method to get the date in ISO local date format (yyyy-MM-dd).
    @Override
    public String toISOFormat() {
        return date.format(DateTimeFormatter.ISO_LOCAL_DATE);
    }
    
    // Method to advance the date by a specified number of days.
    @Override
    public void advanceByDays(int days) {
        this.date = this.date.plusDays(days);
    }
    
    // Method to get the name of the day of the week for this date.
    @Override
    public String getDayOfWeek() {
        DayOfWeek dayOfWeek = date.getDayOfWeek();
        return dayOfWeek.getDisplayName(java.time.format.TextStyle.FULL, java.util.Locale.ENGLISH);
    }
}
