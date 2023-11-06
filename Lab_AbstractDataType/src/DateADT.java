
public interface DateADT {
	
	// Construct a date from the given year, month and day
	
	void setDate(int y, int m, int d);
	
	// Compares this date to another date. 
    // Returns -1 if this date is before the other date, 
    // 0 if they are equal, and 1 if this date is after the other date.
    int compareTo(DateADT otherDate);
    
 // Renders the date in ISO format (i.e., “y-m-d”).
    String toISOFormat();
    
    // Advances the date by the given number of days. 
    // If days is negative, the date is retreated.
    void advanceByDays(int days);

    // Returns the day of the week for this date.
    String getDayOfWeek();
}
