public class Item {
    int lotNumber;
    String buyerName;
    float price;
    int yearSold;
    String typeOfItem;
    String auctionHouseName;

    public Item(int lotNumber, String buyerName, float price, int yearSold, String typeOfItem, String auctionHouseName) {
        this.lotNumber = lotNumber;
        this.buyerName = buyerName;
        this.price = price;
        this.yearSold = yearSold;
        this.typeOfItem = typeOfItem;
        this.auctionHouseName = auctionHouseName;
    }

    @Override
    public String toString() {
        return "Item{" +
                "lotNumber=" + lotNumber +
                ", buyerName='" + buyerName + '\'' +
                ", price=" + price +
                ", yearSold=" + yearSold +
                ", typeOfItem='" + typeOfItem + '\'' +
                '}';
    }

}
