
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
    private int weight; // the weight of the item
    private String shortDescription; // an item name or short description
    private String longDescription; // a longer, more detailed description

    /**
     * Constructor for objects of class Item
     * @param itemWeight The weight of the item
     * @param shortDesc The item name or short description
     * @param longDesc The longer, more detailed item description
     */
    public Item(int itemWeight, String shortDesc, String longDesc)
    {
        weight = itemWeight;
        shortDescription = shortDesc;
        longDescription = longDesc;
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
     * This method returns the item's short decription
     * 
     * @return shortDescription The short description of the item
     */
    public String getShortDesc()
    {
        return shortDescription;
    }
    
    /**
     * This method returns the item's long decription
     * 
     * @return longDescription The long description of the item
     */
    public String getLongDesc()
    {
        return longDescription;
    }
}
