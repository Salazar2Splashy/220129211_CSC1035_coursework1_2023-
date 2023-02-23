import java.util.*;

/**
 * This class stores information about the names of each auction house and which items have been sold there.
 */
public class AuctionHouse {
    String name; //Adds a string for the name of the auction house
    List<Item> soldItems; //Creates a list to store all sold items

    /**
     * This is used to create a new auction house
     * @param name is the name of the auction house
     * @param soldItems is a list of all items sold at that house
     */
    public AuctionHouse(String name, List<Item> soldItems) { //Initialises the auction house with the required variables
        this.name = name;
        this.soldItems = soldItems;
    }

    /**
     * This adds a new item sale to the house. This is called when an item is added by the user, as they specify which house it was sold in.
     * @param a is the item being added to the sold items list
     */
    public void addItemSold(Item a) { //Used to add a sold item to the auction house
        soldItems.add(a); //Adds the item to the house's sold list
        System.out.println("Added sold item to Auction House " + this.name); //Gives the user confirmation that the item has been added.
    }

    /**
     * This finds the most expensive item sold by this auction house
     * @return returns the most expensive item
     */
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

    /**
     * This finds the average price this house sold items for in a certain year
     * @param year is specified by the user and decides which year to check for
     * @return returns the average price as a float
     */
    public float findAveragePrice(int year) { //Used to find the average price sale
        float totalPrice = 0; //Initialises total to 0
        List<Item> itemsSoldThisYear = new ArrayList<Item>(); // Creates a new list to store items sold in the given year
        for (Item soldItem : this.soldItems) { //Cycles through every sold item
            if (soldItem.yearSold == year) { // If it was sold in the correct year then
                totalPrice += soldItem.price; //Creates a total amount of money
                itemsSoldThisYear.add(soldItem); // Adds the item to the list of items sold this year
            }
        }
       return totalPrice / itemsSoldThisYear.size(); //Returns the average (total price / number of items sold this year)
    }

    /**
     * This finds all items sold in the house for over x price
     * @param minPrice is specified by the user and states the price all returned items must be over
     * @return returns a list of items sold over that price
     */
    public List itemsOverPrice(float minPrice) { //Used to find all items sold over a certain value
        List<Item> returnedList = new ArrayList<Item>(); //Creates an empty list
        for (Item soldItem : this.soldItems) { //Cycles through every sold item
            if (soldItem.price > minPrice) { //Checks if the item sold for enough money
                returnedList.add(soldItem); //Adds it to the list if it did
            }
        }
        return returnedList;
    }
}
