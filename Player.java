import java.util.ArrayList;

/**
 *  This class is the Player class of the "Queen's Crystals" application,
 *  which is based on the "World of Zuul" application by Barnes and Kölling. 
 *  "World of Zuul" is a very simple, text based adventure game.  Users 
 *  can walk around some scenery. That's all. It should really be extended 
 *  to make it more interesting!
 * 
 *  A "Player" represents a player character in the game. Players can
 *  travel from Room to Room and carry Items.
 * 
 * @author Catherine Oldfield
 * For RVCC GDEV242 - Fall 2020
 * from code written by Michael Kölling and David J. Barnes
 * @version 10/22/2020
 */
public class Player
{
    private String name;        // the name of the player
    private Room currentRoom;   // where the player is on the map
    private int carryCapacity;  // how much the player can carry
    private int currentCarry;   // how much the player currently carries
    private ArrayList<Item> inventory;  // what the player currently carries

    /**
     * Constructor for objects of class Player
     * @param playerName The name of the Player
     */
    public Player(String playerName, Room playerRoom)
    {
        name = playerName;
        currentRoom = playerRoom;
        carryCapacity = 80;    // all Players have a carry limit of 80
                                // this might change in a later version
        inventory = new ArrayList<Item>();
        currentCarry = getCurrentCarry();
    }

    /**
     * The Player attempts to pick up an item and adds it to his inventory.
     * The method first checks to see if the item's weight would put the
     * Player over his carrying capacity.
     *
     * @param newItem The item the Player wishes to pick up
     * @return true if the item is added to inventory, false otherwise
     */
    public boolean pickUpItem(Item newItem)
    {
        boolean success;
        
        // check the item weight against what the Player can carry
        if((newItem.getWeight() + getCurrentCarry()) > carryCapacity)
        {
            // item is too heavy to pick up
            System.out.println("The " + newItem.getName() + "is too " +
                "heavy for you to pick up." + "\n" + "Maybe you " +
                "should put something down first.");
            success = false;
        }
        
        else
        {
            // item is added to inventory
            System.out.println("You have added the " + newItem.getName() +
                " to your inventory.");
            inventory.add(newItem);
            // update the current carryied weight
            currentCarry = getCurrentCarry();
            success = true;
        }
                
        return success;
    }
    
    /**
     * The Player drops an item, removing it from his inventory.
     * @param discardedItem The item to remove from inventory
     */
    
    public void dropItem(Item discardedItem)
    {
        // copy the item reference into a local variable:
        Item tempItem = discardedItem;
        
        // remove the item from Player inventory
        inventory.remove(discardedItem);
        
        // update the current carryied weight
        currentCarry = getCurrentCarry();
        
        // add the item to the Room's item list
        //currentRoom.addItem(tempItem);
    }
    
    /**
     * Calculates the total weight of everything the Player currently 
     * has in his inventory
     * @return
     */
    public int getCurrentCarry()
    {
        int returnValue = 0;
        
        for(Item currentItem : inventory)
        {
            returnValue += currentItem.getWeight();
        }
        
        return returnValue;
    }
    
    /**
     * Get the current Room location of the Player.
     * @return currentRoom The current room.
     */
    public Room getCurrentRoom()
    {
        return currentRoom;
    }
    
    /**
     * Set the current Room location of the Player.
     * @param newRoom The Room to become the current Room.
     */
    public void setCurrentRoom(Room newRoom)
    {
        currentRoom = newRoom;
    }
}
