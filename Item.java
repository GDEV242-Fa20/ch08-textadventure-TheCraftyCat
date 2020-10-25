
/**
 *  This class is the Item class of the "Queen's Crystals" application,
 *  which is based on the "World of Zuul" application by Barnes and Kölling. 
 *  "World of Zuul" is a very simple, text based adventure game.  Users 
 *  can walk around some scenery. That's all. It should really be extended 
 *  to make it more interesting!
 * 
 *  An "Item" represents an item in the game. Items have descriptions and
 *  weights. Items are placed in Rooms. Items can either be picked up or
 *  not.
 * 
 * @author Catherine Oldfield
 * For RVCC GDEV242 - Fall 2020
 * from code written by Michael Kölling and David J. Barnes
 * @version 10/24/2020
 */
public class Item
{
    private int weight; // the weight of the item
    private String name; // an item name or short description
    private String description; // a longer, more detailed description
    private boolean canPickUp; // an indicator if the item can be picked up

    /**
     * Constructor for objects of class Item
     * @param itemWeight The weight of the item
     * @param shortDesc The item name or short description
     * @param longDesc The longer, more detailed item description
     * @param pickUp An indicator if the item can be picked up or not
     */
    public Item(int itemWeight, String itemName, String itemDesc, boolean pickUp)
    {
        weight = itemWeight;
        name = itemName;
        description = itemDesc;
        canPickUp = pickUp;
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
     * This method returns the item's name
     * 
     * @return name The name of the item
     */
    public String getName()
    {
        return name;
    }
    
    /**
     * This method returns the item's longer, more detailed decription
     * 
     * @return description The long description of the item
     */
    public String getDesc()
    {
        return description;
    }
    
    /**
     * This method returns the item's ability to be picked up
     * @return true if a Player could pick up the item, false otherwise
     */
    public boolean canBePickedUp()
    {
        return canPickUp;
    }
    
    /**
     * The Player calls this method when attempting to use the Item.
     * A message about use prints to the terminal window.
     */
    public void useItem()
    {
        System.out.println("You attempt to use the " + name +
            " but nothing happens.");
    }
}
