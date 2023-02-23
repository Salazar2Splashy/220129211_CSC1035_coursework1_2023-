import java.util.*;

public class ReportingIO {
    public static final String ANSI_RESET = "\u001B[0m"; // Used to reset text output colour after an error message
    public static final String ANSI_RED = "\u001B[31m"; // Used to turn text red during an error message

    public static void main(String[] args) { // Creates a blank list of auction houses to begin with - ensuring it only runs this once and does not wipe data
        List<AuctionHouse> AuctionHousesList = new ArrayList<>();
        mainMenu(AuctionHousesList); // Sends the blank list of type AuctionHouse to the main menu to utilise.
    }

    public static void mainMenu(List<AuctionHouse> AuctionHousesList) { // Creates a main menu
        boolean accepted = false; // Initialises a variable used to validate input
        int choice = 0; // Initialises a choice variable
        while (!accepted) { // While their input has not been accepted, it loops this code. This means if any errors are caught it will just retry from here.
            try {
                Scanner sc = new Scanner(System.in);
                System.out.print("\nMAIN MENU\n" + // Displays the options for the user
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
            System.out.println("Created new auction house: "+ name);
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
                    System.out.print(ANSI_RED + "Please input a valid string.\n\n" + ANSI_RESET); // If they did not enter a valid string, this will catch the error and allow them to retry
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
            accepted = false; // Initialises a variable used to validate input
            int yearSold = 0;
            while (!accepted) { // While their input has not been accepted, it loops this code. This means if any errors are caught it will just retry from here.
                try {
                    Scanner sc4 = new Scanner(System.in);
                    System.out.print("Enter item's year sold: ");
                    yearSold = sc4.nextInt();
                    accepted = true; // If they entered a valid integer it allows them to proceed
                } catch (InputMismatchException ex) {
                    System.out.print(ANSI_RED + "Please input an integer number.\n\n" + ANSI_RESET); // If they did not enter an integer, this will catch the error and allow them to retry
                }
            }
            accepted = false; // Initialises a variable used to validate input
            String typeOfItem = null;
            while (!accepted) { // While their input has not been accepted, it loops this code. This means if any errors are caught it will just retry from here.
                try {
                    Scanner sc4 = new Scanner(System.in);
                    System.out.print("Enter item type: \n1. Furniture\n2. Painting\n3. Sculpture\nSelection: "); // Gives options for the allowed types of items
                    int selection = sc4.nextInt();
                    if (choice > 3 || choice<1){ // Checks if the user inputted something within a valid range
                        System.out.println(ANSI_RED + "Please choose an option between 1 and 3.\n\n" + ANSI_RESET); // If they did not it prompts them to retry. This and the corresponding error message below are both in red.
                    } else { // Then sets the item type based on input
                        if (selection == 1) {
                            typeOfItem = "Furniture";
                        }
                        if (selection == 2) {
                            typeOfItem = "Painting";
                        }
                        if (selection == 3) {
                            typeOfItem = "Sculpture";
                        }
                        accepted = true; // If they entered a valid option it allows them to proceed
                    }
                } catch (InputMismatchException ex) {
                    System.out.print(ANSI_RED + "Please input an integer number.\n\n" + ANSI_RESET); // If they did not enter a valid integer, this will catch the error and allow them to retry
                }
            }
            accepted = false; // Initialises a variable used to validate input
            String auctionHouseName = null;
            AuctionHouse auctionHouseToUse = null;
            while (!accepted) { // While their input has not been accepted, it loops this code. This means if any errors are caught it will just retry from here.
                System.out.println("Auction Houses:");
                for(AuctionHouse house : AuctionHousesList) {
                    System.out.println(house.name); // Prints a list of all auction houses
                }
                Scanner sc5 = new Scanner(System.in);
                System.out.print("\nEnter item's auction house name: ");
                auctionHouseName = sc5.next();
                for(AuctionHouse house : AuctionHousesList) { // Loops through the auction houses to check if the input matches
                    if (auctionHouseName.equals(house.name)) {
                        auctionHouseToUse = house; // If it does, it stores this auction house as the one the item was sold in
                        accepted = true;
                    }
                }
                if (!accepted) { // If not the user is told to try again
                    System.out.print(ANSI_RED + "That is not a valid auction house.\n\n" + ANSI_RESET);
                }
            }

            Item newItem = new Item(lotNumber, buyerName, price, yearSold, typeOfItem, auctionHouseName); // The item is created
            auctionHouseToUse.addItemSold(newItem); // The item is added to the house's sold items list.
            mainMenu(AuctionHousesList); // The user is returned to the main menu
        }
        if (choice == 3) { // If the user selects the option to view reporting statistics:
            if (AuctionHousesList.size() == 0) {
                System.out.println(ANSI_RED + "You must have an auction house in order to view statistics." + ANSI_RESET);
                mainMenu(AuctionHousesList);
            }
            accepted = false; // Initialises a variable used to validate input
            choice = 0;
            while (!accepted) { // While their input has not been accepted, it loops this code. This means if any errors are caught it will just retry from here.
                try {
                    Scanner sc = new Scanner(System.in);
                    System.out.print("\nWhat do you wish to do?\n" + // Displays the options for the user
                            "1. Display most expensive item\n" +
                            "2. See house with largest average price for a given year\n" +
                            "3. View all items over £x\n" +
                            "Selection: ");
                    choice = sc.nextInt(); // Takes the user's input
                    if (choice > 3 || choice<1){ // Checks if the user inputted something within a valid range
                        System.out.println(ANSI_RED + "Please choose an option between 1 and 3.\n\n" + ANSI_RESET); // If they did not it prompts them to retry. This and the corresponding error message below are both in red.
                    } else {
                        accepted = true; // If they did it allows them to proceed
                    }
                } catch (InputMismatchException ex) {
                    System.out.print(ANSI_RED + "Please input an integer number.\n\n" + ANSI_RESET); // If they did not enter a number, this will catch the error and allow them to retry
                }
            }
            if (choice == 1) {
                Reporting.MostExpensive(AuctionHousesList);
            }
            if (choice == 2) {
                accepted = false; // Initialises a variable used to validate input
                int yearToCheck = 0;
                while (!accepted) { // While their input has not been accepted, it loops this code. This means if any errors are caught it will just retry from here.
                    try {
                        Scanner sc6 = new Scanner(System.in);
                        System.out.print("Enter year to check: ");
                        yearToCheck = sc6.nextInt();
                        accepted = true; // If they entered a valid integer it allows them to proceed
                    } catch (InputMismatchException ex) {
                        System.out.print(ANSI_RED + "Please input an integer number.\n\n" + ANSI_RESET); // If they did not enter an integer, this will catch the error and allow them to retry
                    }
                }
                Reporting.AverageInYear(AuctionHousesList,yearToCheck);
            }
            if (choice == 3) {
                accepted = false; // Initialises a variable used to validate input
                float lowestPrice = 0;
                while (!accepted) { // While their input has not been accepted, it loops this code. This means if any errors are caught it will just retry from here.
                    try {
                        Scanner sc7 = new Scanner(System.in);
                        System.out.print("Enter price to search for items being over: ");
                        lowestPrice = sc7.nextFloat();
                        accepted = true; // If they entered a valid integer it allows them to proceed
                    } catch (InputMismatchException ex) {
                        System.out.print(ANSI_RED + "Please input a float number.\n\n" + ANSI_RESET); // If they did not enter an integer, this will catch the error and allow them to retry
                    }
                }
                Reporting.FindAllAbove(AuctionHousesList,lowestPrice);
            }
            mainMenu(AuctionHousesList); // Returns to the main menu
        }
    }
}
