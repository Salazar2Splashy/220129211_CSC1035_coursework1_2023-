import java.util.ArrayList;
import java.util.List;

public class Reporting {
    public static final String ANSI_RESET = "\u001B[0m"; // Used to reset text output colour after an error message
    public static final String ANSI_RED = "\u001B[31m"; // Used to turn text red during an error message
    public static void MostExpensive(List<AuctionHouse> AuctionHousesList) {
        float currentHighest = 0;
        Item mostExpensiveItem = null;
        for (AuctionHouse house : AuctionHousesList) {
           Item item = house.findMostExpensive();
           if (item.price > currentHighest){
               currentHighest = item.price;
               mostExpensiveItem = item;
           }
        }
        if (mostExpensiveItem == null) {
            System.out.println(ANSI_RED + "You must have an item in order to view statistics." + ANSI_RESET);
            ReportingIO.mainMenu(AuctionHousesList);
        }
        System.out.println("The most expensive item is: " + mostExpensiveItem.toString());
        ReportingIO.mainMenu(AuctionHousesList);
    }

    public static void AverageInYear(List<AuctionHouse> AuctionHousesList, int Year) {
        float currentHighest = 0;
        AuctionHouse houseSoldIn = null;
        for (AuctionHouse house : AuctionHousesList) {
            float averageOfHouse = house.findAveragePrice(Year);
            if (averageOfHouse > currentHighest){
                currentHighest = averageOfHouse;
                houseSoldIn = house;
            }
        }
        if (houseSoldIn == null) {
            System.out.println(ANSI_RED + "You have not sold any items in this year." + ANSI_RESET);
            ReportingIO.mainMenu(AuctionHousesList);
        }
        System.out.println("The highest average in "+ Year + " was house '" + houseSoldIn.name + "' with an average sale price of " + currentHighest);
        ReportingIO.mainMenu(AuctionHousesList);
    }

    public static void FindAllAbove(List<AuctionHouse> AuctionHousesList, float minPrice) {
        List<Item> itemsList = new ArrayList<Item>();
        for (AuctionHouse house : AuctionHousesList) {
            List<Item> houseItems = house.itemsOverPrice(minPrice);
            for (Item item : houseItems) {
                itemsList.add(item);
            }
        }
        if (itemsList.size() == 0) {
            System.out.println(ANSI_RED + "You have not sold any items over this price." + ANSI_RESET);
            ReportingIO.mainMenu(AuctionHousesList);
        }
        System.out.println("You have sold the following items for over £" + minPrice);
        for (Item item : itemsList) {
            System.out.println(item.toString());
        }
    }
}
