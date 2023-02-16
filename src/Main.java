import java.util.*;
public class Main {
    public static void main(String[] args) { // Creates a main menu
        Scanner sc= new Scanner(System.in);
        System.out.print("MAIN MENU\n" + // Displays the options for the user
                "1. Enter Auction House data\n" +
                "2. Enter item data\n" +
                "3. Provide reporting statistics\n" +
                "4. Exit\n" +
                "Selection: ");
        int choice= sc.nextInt(); // Checks to see what the user has inputted as their choice
        if (choice == 4){ //If the user chooses 4, the program closes
            System.exit(0);
        }
        System.out.println("Selected: " +choice);

    }
}