public class Item {
    int lotNumber;
    String buyerName;
    float price;
    int yearSold;
    String typeOfItem;

    public Item(int lotNumber, String buyerName, float price, int yearSold, String typeOfItem) {
        this.lotNumber = lotNumber;
        this.buyerName = buyerName;
        this.price = price;
        this.yearSold = yearSold;
        this.typeOfItem = typeOfItem;
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
