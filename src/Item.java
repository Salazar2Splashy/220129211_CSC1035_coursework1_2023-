public class Item {
    int lotNumber;
    String buyerName;
    float price;
    int yearSold;
    String typeOfItem;
    String auctionHouseName;

    public Item(int lotNumber, String buyerName, float price, int yearSold, String typeOfItem, String auctionHouseName) { // Creates an item
        this.lotNumber = lotNumber;
        this.buyerName = buyerName;
        this.price = price;
        this.yearSold = yearSold;
        this.typeOfItem = typeOfItem;
        this.auctionHouseName = auctionHouseName;
    }

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
