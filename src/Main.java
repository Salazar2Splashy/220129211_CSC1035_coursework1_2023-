import java.util.*;
public class Main {
    public static final String ANSI_RESET = "\u001B[0m"; // Used to reset text output colour after an error message
    public static final String ANSI_RED = "\u001B[31m"; // Used to turn text red during an error message
    public static void main(String[] args) { // Creates a main menu
        boolean accepted = false; // Initialises a variable used to validate input
        int choice = 0; // Initialises a choice variable
        while (!accepted) { // While their input has not been accepted, it loops this code. This means if any errors are caught it will just retry from here.
            try {
                Scanner sc = new Scanner(System.in);
                System.out.print("MAIN MENU\n" + // Displays the options for the user
                        "1. Enter Auction House data\n" +
                        "2. Enter item data\n" +
                        "3. Provide reporting statistics\n" +
                        "4. Exit\n" +
                        "Selection: ");
                choice = sc.nextInt(); // Takes the user's input
                if (choice > 4 || choice<1){ // Checks if the user inputted something within a valid range
                    System.out.println(ANSI_RED + "Please choose an option between 1 and 4.\n\n" + ANSI_RESET); // If they did not it prompts them to retry. This and the corresponding error message below are both in red.
                } else {
                    accepted = true; // If they did it allows them to proceed
                }
            } catch (InputMismatchException ex) {
                System.out.print(ANSI_RED + "Please input an integer number.\n\n" + ANSI_RESET); // If they did not enter a number, this will catch the error and allow them to retry
            }
        }
        if (choice == 4) { //If the user chooses 4, the program closes
            System.exit(0);
        }
        System.out.println("Selected: " + choice);

    }
}