
/**
 *  This class is the BeamerItem class of the "Queen's Crystals" application,
 *  which is based on the "World of Zuul" application by Barnes and Kölling. 
 *  "World of Zuul" is a very simple, text based adventure game.  Users 
 *  can walk around some scenery. That's all. It should really be extended 
 *  to make it more interesting!
 * 
 *  A "BeamerItem" represents an item in the game that has a significant
 *  use: it allows a Player to transport from one room to another.
 *  BeamerItems have descriptions and weights. BeamerItems are initially
 *  placed in Rooms.
 * 
 * @author Catherine Oldfield
 * For RVCC GDEV242 - Fall 2020
 * from code written by Michael Kölling and David J. Barnes
 * @version 10/25/2020
 */
public class BeamerItem extends Item
{
    private Player player;
    private Room storedRoom; // reference to a stored room

    /**
     * Constructor for objects of class BeamerItem
     */
    public BeamerItem(int itemWeight, String itemName, String itemDesc, 
                    boolean pickUp, Player thePlayer)
    {
        super(itemWeight, itemName, itemDesc, pickUp);
        player = thePlayer;
        storedRoom = null;
    }

    /**
     * The Player calls this method when attempting to use the Item.
     * A message about use prints to the terminal window.
     */
    public void useItem()
    {
        System.out.println("You use the " + getName() + ". ");
        
        if(storedRoom == null) // if the beamer is "empty"
        {
            // charge it to remember the current room
            storedRoom = player.getCurrentRoom();
            System.out.println("You have stored your current location " +
                "with the " + getName() + "'s magic.");
        }
        
        else    // if the beamer has a stored room
        {
            // transport the player to that room
            player.setCurrentRoom(storedRoom);
            // reset the beamer to empty
            storedRoom = null;
            System.out.println("The magic of the " + getName() + 
                "surrounds you. You are transported to the  " + 
                player.getCurrentRoom().getName() + ".");
        }
        
    }
}
