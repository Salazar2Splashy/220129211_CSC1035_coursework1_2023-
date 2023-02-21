import java.util.*;

public class Main {
    public static final String ANSI_RESET = "\u001B[0m"; // Used to reset text output colour after an error message
    public static final String ANSI_RED = "\u001B[31m"; // Used to turn text red during an error message

    public static void main(String[] args) { // Creates a blank list of auction houses to begin with
        List AuctionHousesList = new ArrayList();
        mainMenu(AuctionHousesList);
    }

    public static void mainMenu(List AuctionHousesList) { // Creates a main menu
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
        if (choice == 1) { // If the user selects the option to enter a new auction house's data:
            Scanner sc = new Scanner(System.in);
            System.out.print("Enter auction house name: ");
            String name = sc.next(); // Takes the user's input for the auction house name
            AuctionHouse newHouse = new AuctionHouse(name, new ArrayList<>()); // Creates a new house with an empty sold items list
            System.out.println("Created new auction house: "+ name+"\n");
            AuctionHousesList.add(newHouse); // Adds the auction house to the list of saved auction houses
            mainMenu(AuctionHousesList); // Returns to the main menu
        }
        if (choice == 2) { // If the user selects the option to add a new item's data:
            if (AuctionHousesList.size() == 0) {
                System.out.println(ANSI_RED + "You must have an auction house in order to add items." + ANSI_RESET);
                mainMenu(AuctionHousesList);
            }
            accepted = false; // Initialises a variable used to validate input
            int lotNumber = 0;
            while (!accepted) { // While their input has not been accepted, it loops this code. This means if any errors are caught it will just retry from here.
                try {
                    Scanner sc = new Scanner(System.in);
                    System.out.print("Enter item's lot number: ");
                    lotNumber = sc.nextInt();
                    accepted = true; // If they entered an integer it allows them to proceed
                } catch (InputMismatchException ex) {
                    System.out.print(ANSI_RED + "Please input an integer number.\n\n" + ANSI_RESET); // If they did not enter a number, this will catch the error and allow them to retry
                }
            }
            accepted = false; // Initialises a variable used to validate input
            String buyerName = null;
            while (!accepted) { // While their input has not been accepted, it loops this code. This means if any errors are caught it will just retry from here.
                try {
                    Scanner sc2 = new Scanner(System.in);
                    System.out.print("Enter item's buyer name: ");
                    buyerName = sc2.next();
                    accepted = true; // If they entered a valid string it allows them to proceed
                } catch (InputMismatchException ex) {
                    System.out.print(ANSI_RED + "Please input a valid string.\n\n" + ANSI_RESET); // If they did not enter a number, this will catch the error and allow them to retry
                }
            }
            accepted = false; // Initialises a variable used to validate input
            float price = 0;
            while (!accepted) { // While their input has not been accepted, it loops this code. This means if any errors are caught it will just retry from here.
                try {
                    Scanner sc3 = new Scanner(System.in);
                    System.out.print("Enter item's price: ");
                    price = sc3.nextFloat();
                    accepted = true; // If they entered a valid float it allows them to proceed
                } catch (InputMismatchException ex) {
                    System.out.print(ANSI_RED + "Please input a float number.\n\n" + ANSI_RESET); // If they did not enter a number, this will catch the error and allow them to retry
                }
            }
            System.out.println(lotNumber);

            //Item newItem = new Item(lotNumber, buyerName, price, );
            mainMenu(AuctionHousesList);
        }
    }
}
