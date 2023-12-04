import java.util.Scanner;

public class Driver {
    public static void main(String[] args) {
        
    	// Create a Scanner object to read input from the user.
    	Scanner scanner = new Scanner(System.in);
        
        // Print the purpose of the program.
        System.out.println("This program prints out all the dates in the year 2010 that fall on a specified day of the week.\n");
        
        // Variable to store the user's input for the day of the week.
        String dayOfWeekInput = null;
        
        // Loop until a valid day of the week is entered.
        while (dayOfWeekInput == null) {
        
        // Prompt the user to select a day of the week.
        System.out.println("Select the day of the week:");
        System.out.println("1: Monday");
        System.out.println("2: Tuesday");
        System.out.println("3: Wednesday");
        System.out.println("4: Thursday");
        System.out.println("5: Friday");
        System.out.println("6: Saturday");
        System.out.println("7: Sunday");


        // Read the user's input.
        int dayOfWeekNumber = scanner.nextInt();
        dayOfWeekInput = getDayOfWeekString(dayOfWeekNumber);

        if (dayOfWeekInput == null) {
            System.out.println("Invalid input. Please enter a number between 1 and 7.");
        }
        }

        DateADT date = new DataImpl();
        int count = 0;
        

        // Iterate through all the dates in 2010
        for (int month = 1; month <= 12; month++) {
            for (int day = 1; day <= 31; day++) {
                try {
                    date.setDate(2010, month, day);
                    String dayOfWeek = date.getDayOfWeek();

                    if (dayOfWeek.equalsIgnoreCase(dayOfWeekInput)) {
                        System.out.println(date.toISOFormat());
                        count++; // Increment the counter
                    }
                } catch (Exception e) {
                    // This exception is expected for invalid dates like February 30th
                }
            }
        }

        // Print the total count
        System.out.println("\nThere are " + count + " " + dayOfWeekInput + "s in the year 2010.");

        scanner.close();
    }

    private static String getDayOfWeekString(int dayOfWeekNumber) {
        switch (dayOfWeekNumber) {
            case 1: return "Monday";
            case 2: return "Tuesday";
            case 3: return "Wednesday";
            case 4: return "Thursday";
            case 5: return "Friday";
            case 6: return "Saturday";
            case 7: return "Sunday\n";
            default: return null;
        }
    }
}
