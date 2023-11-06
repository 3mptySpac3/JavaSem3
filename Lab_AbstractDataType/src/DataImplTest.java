//****\\											//****\\
//\\*****THIS IS GENERATED WITH THE HELP OF CHATGPT*****\\//
//****\\											//****\\


import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

class DataImplTest {

    private DataImpl date;

    @BeforeEach
    void setUp() {
        // Initialize a new DataImpl object before each test
        date = new DataImpl();
    }

    @Test
    void testDataImpl() {
        // Test if the DataImpl object is successfully created
        assertNotNull(date, "DataImpl object should not be null");
    }

    @Test
    void testSetDate() {
        // Test if the setDate method correctly sets the date
        date.setDate(2020, 1, 1);
        assertEquals("2020-01-01", date.toISOFormat(), "SetDate should set the correct date");
    }

    @Test
    void testCompareTo() {
        // Test if the compareTo method correctly compares two dates
        DataImpl date1 = new DataImpl();
        date1.setDate(2020, 1, 1);

        DataImpl date2 = new DataImpl();
        date2.setDate(2020, 1, 2);

        assertTrue(date1.compareTo(date2) < 0, "date1 should be before date2");
        assertTrue(date2.compareTo(date1) > 0, "date2 should be after date1");
        assertEquals(0, date1.compareTo(date1), "Comparing the same date should return 0");
    }

    @Test
    void testToISOFormat() {
        // Test if the toISOFormat method correctly formats the date
        date.setDate(2020, 12, 31);
        assertEquals("2020-12-31", date.toISOFormat(), "toISOFormat should return the date in ISO format");
    }

    @Test
    void testAdvanceByDays() {
        // Test if the advanceByDays method correctly advances the date
        date.setDate(2020, 1, 1);
        date.advanceByDays(10);
        assertEquals("2020-01-11", date.toISOFormat(), "advanceByDays should correctly advance the date");

        // Test if advanceByDays handles negative values correctly
        date.advanceByDays(-5);
        assertEquals("2020-01-06", date.toISOFormat(), "advanceByDays should correctly handle negative values");
    }

    @Test
    void testGetDayOfWeek() {
        // Test if the getDayOfWeek method returns the correct day of the week
        date.setDate(2020, 1, 1); // January 1, 2020 was a Wednesday
        assertEquals("Wednesday", date.getDayOfWeek(), "getDayOfWeek should return the correct day of the week");

        date.setDate(2020, 1, 6); // January 6, 2020 was a Monday
        assertEquals("Monday", date.getDayOfWeek(), "getDayOfWeek should return the correct day of the week");
    }

}
