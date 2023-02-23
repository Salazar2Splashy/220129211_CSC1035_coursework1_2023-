/**
 * This class is used to construct an item and store details about it
 */

public class Item {
    int lotNumber;
    String buyerName;
    float price;
    int yearSold;
    String typeOfItem;
    String auctionHouseName;

    /**
     * This constructs an item using the following parameters passed in by the user:
     * @param lotNumber defines the lot number on which the item was sold
     * @param buyerName defines the name of the person who purchased the item
     * @param price defines the price in GBP the item sold for
     * @param yearSold defines the calendar year in which the item sold
     * @param typeOfItem defines whether the item was furniture, painting or sculpture
     * @param auctionHouseName defines the name of the auction house it was sold in
     */
    public Item(int lotNumber, String buyerName, float price, int yearSold, String typeOfItem, String auctionHouseName) { // Creates an item
        this.lotNumber = lotNumber;
        this.buyerName = buyerName;
        this.price = price;
        this.yearSold = yearSold;
        this.typeOfItem = typeOfItem;
        this.auctionHouseName = auctionHouseName;
    }

    /**
     * This converts the items attributes into a human-readable format
     * @return returns a string displaying all the attribute names and values.
     */
    @Override
    public String toString() { // Prints the item details in a readable, human format
        return "Item{" +
                "Lot Number= " + lotNumber +
                ", Buyer Name= '" + buyerName + '\'' +
                ", Price= £" + price +
                ", Year Sold= " + yearSold +
                ", Type Of Item= '" + typeOfItem + '\'' +
                '}';
    }

}
