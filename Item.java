
/**
 * This class is the main class of the "Queen's Crystals" application,
 * which is based on the "World of Zuul" application by Barnes and Kölling. 
 *  "World of Zuul" is a very simple, text based adventure game.  Users 
 *  can walk around some scenery. That's all. It should really be extended 
 *  to make it more interesting!
 * 
 *  An "Item" represents an item in the game. Items have descriptions and
 *  weights. Items are placed in Rooms.
 * 
 * @author Catherine Oldfield
 * For RVCC GDEV242 - Fall 2020
 * from code written by Michael Kölling and David J. Barnes
 * @version 10/22/2020
 */
public class Item
{
    private int weight;
    private String description;

    /**
     * Constructor for objects of class Item
     */
    public Item(int itemWeight, String itemDesc)
    {
        weight = itemWeight;
        description = itemDesc;
    }

    /**
     * This method returns the weight of the item
     * 
     * @return weight The weight of the item
     */
    public int getWeight()
    {
        return weight;
    }
    
    /**
     * This method returns the item's decription
     * 
     * @return description The description of the item
     */
    public String getDescription()
    {
        return description;
    }
}
