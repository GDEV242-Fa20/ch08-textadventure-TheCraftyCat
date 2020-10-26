import java.util.Set;
import java.util.HashMap;
import java.util.Iterator;
import java.util.ArrayList;

/**
 *  This class is the Room class of the "Queen's Crystals" application,
 *  which is based on the "World of Zuul" application by Barnes and Kölling. 
 *  "World of Zuul" is a very simple, text based adventure game.  Users 
 *  can walk around some scenery. That's all. It should really be extended 
 *  to make it more interesting!
 * 
 *  A "Room" represents a room in the game. Players can travel from
 *  Room to Room. Rooms can hold any number of Items, implemented as an
 *  ArrayList. Rooms can optinally contain a single NonPlayerChar.
 * 
 * @author Catherine Oldfield
 * For RVCC GDEV242 - Fall 2020
 * from code written by Michael Kölling and David J. Barnes
 * @version 10/25/2020
 */

public class Room 
{
    private String name;
    private String description;
    private HashMap<String, Room> exits;       // stores exits of this room.
    private ArrayList<Item> items;             // stores the items in this room.
    private NonPlayerChar npc;                 // the npc (if any) in this room.

    /**
     * Create a Room named "name". Initially, it has no exits.
     * "name" is something like "kitchen" or "court yard" and
     * "description" is a short description of the room.
     * This version of the room has no NonPlayerChar.
     * @param roomName The room's name.
     * @param roomDescription The room's description.
     */
    public Room(String roomName, String roomDescription) 
    {
        name = roomName;
        description = roomDescription;
        exits = new HashMap<>();
        items = new ArrayList<Item>();
        npc = null;
    }
    
    /**
     * Create a Room named "name". Initially, it has no exits.
     * name" is something like "kitchen" or "court yard" and
     * "description" is a short description of the room.
     * This version of the room has a NonPlayerChar.
     * @param roomName The room's name.
     * @param roomDescription The room's description.
     * @param newNPC The NonPlayerChar present in this room.
     */
    public Room(String roomName, String roomDescription, NonPlayerChar newNPC) 
    {
        name = roomName;
        description = roomDescription;
        exits = new HashMap<>();
        items = new ArrayList<Item>();
        npc = newNPC;
    }

    /**
     * Define an exit from this room.
     * @param direction The direction of the exit.
     * @param neighbor  The room to which the exit leads.
     */
    public void setExit(String direction, Room neighbor) 
    {
        exits.put(direction, neighbor);
    }

    /**
     * Returns the name of the room
     * @return name The name of the room
     */
    public String getName()
    {
        return name;
    }

    /**
     * Return a description of the room, including its name and the names of
     * any Items or NonPlayerChars that are in the room.
     * Also list the room's exits.
     * @return A description of this room
     */
    public String getDescription()
    {
        String returnString = "You are in the " + name + ".\n";
        
        if(items.size() == 0) // if there are no items in this room
        {
            returnString += "There is nothing in this room.";
        }
        
        else // list the room's items
        {
            returnString += "This room contains: ";
            for(Item currentItem : items)
            {
                returnString += "\n" + "\t" + "- " +
                    currentItem.getName();
            }
        }
        
        if(npc == null) // if there is no NonPlayerChar in this room
        {
            returnString += "\n" + "You are alone in this room.";
        }
        
        else // list the room's NonPlayerChar
        {
            returnString += "\n" + npc.getName() + " is in this room with you."; 
        }
        
        returnString += "\n" + getExitString();
        return returnString;
    }
    
    /**
     * Return a description of the room, including its name and the names of
     * any Items or NonPlayerChars that are in the room. If there are any 
     * Items or NonPlayerChars, list their descriptions as well. 
     * Also list the room's exits.
     * @return A detailed description of this room
     */
    public String getDetailedDescription()
    {
        String returnString = "You are in the " + name + ".\n";
        returnString += description + "\n";
        
        if(items.size() == 0) // if there are no items in this room
        {
            returnString += "There is nothing in this room.";
        }
        
        else // list the room's items
        {
            returnString += "This room contains: ";
            for(Item currentItem : items)
            {
                returnString += "\n" + "\t" + "- " +
                    currentItem.getName() + ": " + currentItem.getDesc();
            }
        }
        
        if(npc == null) // if there is no NonPlayerChar in this room
        {
            returnString += "\n" + "You are alone in this room.";
        }
        
        else // list the room's NonPlayerChar
        {
            returnString += "\n" + npc.getName() + ", a " +
                    npc.getDesc() + " is in this room with you."; 
        }
        
        returnString += "\n" + getExitString();
        return returnString;
    }

    /**
     * Return a string describing the room's exits, for example
     * "Exits: north west".
     * @return Details of the room's exits.
     */
    private String getExitString()
    {
        String returnString = "Exits:";
        Set<String> keys = exits.keySet();
        for(String exit : keys) {
            returnString += " " + exit;
        }
        return returnString;
    }

    /**
     * Return the room that is reached if we go from this room in direction
     * "direction". If there is no room in that direction, return null.
     * @param direction The exit's direction.
     * @return The room in the given direction.
     */
    public Room getExit(String direction) 
    {
        return exits.get(direction);
    }
    
    /**
     * Add an item to this room.
     * @param newItem The item to add.
     */
    public void addItem(Item newItem)
    {
        items.add(newItem);
    }
    
    /**
     * Return the list of items in this room.
     * @return items The ArrayList of items in this room.
     */
    public ArrayList<Item> getItems()
    {
        return items;
    }
    
    /**
     * Set the NonPlayerChar for this room.
     * @param newNPC The NonPlayerChar for this room.
     */
    public void setNPC(NonPlayerChar newNPC)
    {
        npc = newNPC;
    }
    
    /**
     * Return the NonPlayerChar in this room.
     * @return npc The NonPlayerChar in this room.
     */
    public NonPlayerChar getNPC()
    {
        return npc;
    }
}

