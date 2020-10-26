import java.util.ArrayList;
import java.util.Iterator;
import java.util.Scanner;

/**
 *  This class is the Player class of the "Queen's Crystals" application,
 *  which is based on the "World of Zuul" application by Barnes and Kölling. 
 *  "World of Zuul" is a very simple, text based adventure game.  Users 
 *  can walk around some scenery. That's all. It should really be extended 
 *  to make it more interesting!
 * 
 *  A "Player" represents a player character in the game. Players can
 *  travel from Room to Room and carry Items. Players can also use Items.
 * 
 * @author Catherine Oldfield
 * For RVCC GDEV242 - Fall 2020
 * from code written by Michael Kölling and David J. Barnes
 * @version 10/25/2020
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
     * If the item isn't in the room, a message prints to the terminal 
     * window. If the item is in the room but is too heavy for the 
     * Player to carry, a message prints to the terminal window and the
     * item is not picked up.
     */
    public void takeItem()
    {
        boolean itemTaken = false;
        boolean itemExists = false;
        Item tempItem;
        Iterator<Item> it = currentRoom.getItems().iterator();
        
        // ask the Player what item to pick up
        Scanner reader = new Scanner(System.in);
        System.out.println("What item do you want to pick up?");
        System.out.print("> ");
        // obtain and clean user input
        String takenItem = reader.nextLine().trim().toLowerCase();
        
        // check if the item is present in the room
        while(it.hasNext())
        {
            Item checkItem = it.next();
            if(checkItem.getName().toLowerCase().equals(takenItem))
            {
                // if the item exists in the room...
                itemExists = true;
                // can the item be picked up at all?
                if(!checkItem.canBePickedUp())
                {
                    System.out.println("You cannot remove the " + 
                        checkItem.getName() + " from this room!");
                }
                
                // check the item weight against what the Player can carry
                else if((checkItem.getWeight() + getCurrentCarry()) > carryCapacity)
                {
                    // item is too heavy to pick up
                    System.out.println("The " + checkItem.getName() + 
                        " is too heavy for you to pick up." + "\n" + 
                        "Maybe you should put something down first.");
                }
                
                else    // the item is added to the Player's inventory
                {
                    // remove it from the room
                    it.remove();
                    // add it to Player inventory
                    inventory.add(checkItem); 
                    // update the current carried weight
                    currentCarry = getCurrentCarry(); 
                    // print the success message and update itemTaken
                    System.out.println("You have picked up the " + 
                        checkItem.getName() + " and added it to " +
                        "your inventory.");
                        itemTaken = true;
                }    
            }
        }
        
        if(!itemTaken && !itemExists)
        {
            System.out.println("That item isn't in this room...");
        }
    }
    
    
    /**
     * The Player drops an item, removing it from his inventory and 
     * printing a confirmation message to the terminal window.
     * If the item isn't in the player's inventory, a message prints to
     * the terminal window.
     */
    
    public void dropItem()
    {
        boolean itemDropped = false;
        Item tempItem;
        Iterator<Item> it = inventory.iterator();
        
        // ask the Player what item to drop
        Scanner reader = new Scanner(System.in);
        System.out.println("What item do you want to drop?");
        System.out.print("> ");
        // obtain and clean user input
        String droppedItem = reader.nextLine().trim().toLowerCase();
        
        // check if the item is present in the player's inventory
        while(it.hasNext())
        {
            Item checkItem = it.next();
            if(checkItem.getName().toLowerCase().equals(droppedItem))
            {
                // if the item exists in inventory...
                
                // remove it from Player inventory
                it.remove();
                // add it to Room inventory
                currentRoom.addItem(checkItem); 
                // update the current carried weight
                currentCarry = getCurrentCarry(); 
                // print the drop message and update itemDropped
                System.out.println("You have dropped the " + 
                    checkItem.getName());
                itemDropped = true;
            }
        }
        
        if(!itemDropped)
        {
            System.out.println("That item isn't in your inventory...");
        }
    }
    
    /**
     * Calculates the total weight of everything the Player currently 
     * has in his inventory
     * @return returnValue The currently carried weight
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
    
    /**
     * Set the Player name.
     * @param newName The name to set.
     */
    public void setName(String newName)
    {
        name = newName;
    }
    
    /**
     * Print a list of the items in the Player's inventory
     * to the terminal window.
     */
    public void printInventory()
    {
        if(inventory.size() == 0)
        {
            System.out.println("Your inventory is empty.");
        }
        
        else
        {
            System.out.println("Your inventory contains: ");
            Iterator<Item> it = inventory.iterator();
            while(it.hasNext())
            {
                Item currentItem = it.next();
                System.out.println("\t" + "- " + currentItem.getName() +
                    ": " + currentItem.getDesc());
            }
        }
    }
    
    /**
     * Use an item from the Player's inventory.
     * A message prints to the terminal window about the item's use.
     */
    public void useItem()
    {
        boolean itemExists = false;
        Item tempItem;
        Iterator<Item> it = inventory.iterator();
        
        // ask the Player what item to use
        Scanner reader = new Scanner(System.in);
        System.out.println("What item do you want to use?");
        System.out.print("> ");
        // obtain and clean user input
        String usedItem = reader.nextLine().trim().toLowerCase();
        
        // check if the item is present in the player's inventory
        while(it.hasNext())
        {
            Item checkItem = it.next();
            if(checkItem.getName().toLowerCase().equals(usedItem))
            {
                // if the item exists in inventory...
                // invoke the method to use it
                checkItem.useItem();
                itemExists = true;
            }
        }
        
        if(!itemExists)
        {
            System.out.println("That item isn't in your inventory...");
        }
    }
}
