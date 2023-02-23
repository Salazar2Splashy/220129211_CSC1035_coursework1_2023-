import java.util.ArrayList;
import java.util.List;

/**
 * This class is used to report back to the user and compares data from each auction house
 */
public class Reporting {
    public static final String ANSI_RESET = "\u001B[0m"; // Used to reset text output colour after an error message
    public static final String ANSI_RED = "\u001B[31m"; // Used to turn text red during an error message

    /**
     * This compares all auction houses' most expensive sale to find the most expensive one of them
     * It then returns this to the user in a readable format
     * @param AuctionHousesList is the list of all auction houses
     */
    public static void MostExpensive(List<AuctionHouse> AuctionHousesList) { // Finds the most expensive item from all houses
        float currentHighest = 0;
        Item mostExpensiveItem = null;
        for (AuctionHouse house : AuctionHousesList) { // Iterates through all houses
           Item item = house.findMostExpensive(); // Finds the most expensive item from that house
           if (item.price > currentHighest){ // If this is a new highest:
               currentHighest = item.price;
               mostExpensiveItem = item; // Sets it to be the most expensive item
           }
        }
        if (mostExpensiveItem == null) { // If no items are found it flags it
            System.out.println(ANSI_RED + "You must have an item in order to view statistics." + ANSI_RESET);
            ReportingIO.mainMenu(AuctionHousesList);
        }
        System.out.println("The most expensive item is: " + mostExpensiveItem.toString()); // If successful, outputs the details of the item
        ReportingIO.mainMenu(AuctionHousesList);
    }

    /**
     * This finds the highest average price an auction house has made in any year specified by the user.
     * It is printed in a clear, understandable way.
     * @param AuctionHousesList is a list of all auction houses
     * @param Year is specified by the user. It is the year the sales are made in.
     */
    public static void AverageInYear(List<AuctionHouse> AuctionHousesList, int Year) { // Finds the highest average sales price of a year
        float currentHighest = 0;
        AuctionHouse houseSoldIn = null;
        if (houseSoldIn == null) { // If no houses have sold anything it flags it
            System.out.println(ANSI_RED + "You have not sold any items in this year." + ANSI_RESET);
            ReportingIO.mainMenu(AuctionHousesList);
        }
        for (AuctionHouse house : AuctionHousesList) { // Loops all houses
            float averageOfHouse = house.findAveragePrice(Year); // Finds their average price
            if (averageOfHouse > currentHighest){
                currentHighest = averageOfHouse;
                houseSoldIn = house; // If their sales price is the new highest it updates it
            }
        }
        System.out.println("The highest average in "+ Year + " was house '" + houseSoldIn.name + "' with an average sale price of " + currentHighest); // Outputs the details
        ReportingIO.mainMenu(AuctionHousesList);
    }

    /**
     * This finds all items sold for above a certain price.
     * These items are then printed in a human-readable way as a list.
     * @param AuctionHousesList lists all auction houses
     * @param minPrice is set by the user to set the price all items must have sold for over.
     */
    public static void FindAllAbove(List<AuctionHouse> AuctionHousesList, float minPrice) { // Finds all items sold for above x price
        List<Item> itemsList = new ArrayList<Item>(); // Creates an empty list for the items to go in
        for (AuctionHouse house : AuctionHousesList) { // Loops through houses
            List<Item> houseItems = house.itemsOverPrice(minPrice); // Runs their function to retrieve a list of the house's items sold over x price
            for (Item item : houseItems) { // For every item returned by the house
                itemsList.add(item); // Adds it to the master list
            }
        }
        if (itemsList.size() == 0) { // If no items are in the list by the end then none have been sold for that price
            System.out.println(ANSI_RED + "You have not sold any items over this price." + ANSI_RESET);
            ReportingIO.mainMenu(AuctionHousesList);
        }
        System.out.println("You have sold the following items for over £" + minPrice);
        for (Item item : itemsList) { // Lists all items sold over £x
            System.out.println(item.toString());
        }
    }
}
