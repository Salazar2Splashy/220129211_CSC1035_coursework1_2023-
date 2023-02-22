import java.util.*;
public class AuctionHouse {
    String name; //Adds a string for the name of the auction house
    List<Item> soldItems; //Creates a list to store all sold items
    public AuctionHouse(String name, List<Item> soldItems) { //Initialises the auction house with the required variables
        this.name = name;
        this.soldItems = soldItems;
    }
    public void addItemSold(Item a) { //Used to add a sold item to the auction house
        soldItems.add(a); //Adds the item to the house's sold list
        System.out.println("Added sold item to Auction House " + this.name); //Gives the user confirmation that the item has been added.
    }
    public Item findMostExpensive() { //Used to find the highest price an item has been sold for
        Item mostExpensiveItem = null; //Initialises the most expensive item to nothing to stop errors
        float highestPrice = 0; //Gives an initial highest price of 0 so any item will overtake it
        for (Item soldItem : this.soldItems) { //Iterates through all sold items
            if (soldItem.price > highestPrice) { //Checks if the price of the current item is higher than current maximum
                mostExpensiveItem = soldItem; //If it is, updates the most expensive item to be that one
                highestPrice = soldItem.price;//Updates price accordingly
            }
        }
        return mostExpensiveItem;//Returns the most expensive item - will return null if no items sold.
    }
    public float findAveragePrice(int year) { //Used to find the average price sale
        float totalPrice = 0; //Initialises total to 0
        for (Item soldItem : this.soldItems) { //Cycles through every sold item
            if (soldItem.yearSold == year) { // If it was sold in the correct year then
                totalPrice += soldItem.price; //Creates a total amount of money
            }
        }
       return totalPrice / this.soldItems.size(); //Returns the average (total price / number of items)
    }
    public List itemsOverPrice(float minPrice) { //Used to find all items sold over a certain value
        List<Item> returnedList = new ArrayList<Item>(); //Creates an empty list
        for (Item soldItem : this.soldItems) { //Cycles through every sold item
            if (soldItem.price >= minPrice) { //Checks if the item sold for enough money
                returnedList.add(soldItem); //Adds it to the list if it did
            }
        }
        return returnedList;
    }
}
