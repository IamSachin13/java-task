package task4;

import java.util.Scanner;

public class task4c {
    public static void main(String[] args) {
        // Array of weekdays
        String[] weekdays = {"Sunday", "Monday", "Tuesday", "Wednesday", "Thursday", "Friday", "Saturday"};

        // Scanner to get input from user
        Scanner scanner = new Scanner(System.in);

        System.out.print("Enter the day index (0-6): ");
        int dayIndex = scanner.nextInt();

        try {
            // Try to access the day at the given index
            String dayName = weekdays[dayIndex];
            System.out.println("The day is: " + dayName);
        } catch (ArrayIndexOutOfBoundsException e) {
            // Handle the exception if index is out of bounds
            System.out.println("Invalid day index. Please enter a number between 0 and 6.");
        } finally {
            // Close the scanner
            scanner.close();
        }
    }
}
