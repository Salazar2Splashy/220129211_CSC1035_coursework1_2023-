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
}
