
/**
 *  This class is the TransporterRoom class of the "Queen's Crystals" application,
 *  which is based on the "World of Zuul" application by Barnes and Kölling. 
 *  "World of Zuul" is a very simple, text based adventure game.  Users 
 *  can walk around some scenery. That's all. It should really be extended 
 *  to make it more interesting!
 * 
 *  A "TransporterRoom" represents a room in the game. Players can travel from
 *  a Room into the TransporterRoom. When the Player exits the TransporterRoom,
 *  he is transported to a random location on the map. Like regular Rooms, 
 *  TransporterRooms can hold any number of Items, implemented as an
 *  ArrayList. TransporterRooms can optinally contain a single NonPlayerChar.
 * 
 * @author Catherine Oldfield
 * For RVCC GDEV242 - Fall 2020
 * from code written by Michael Kölling and David J. Barnes
 * @version 10/25/2020
 */
public class TransporterRoom extends Room
{
    private RandomRoom randRoom;
    
    /**
     * Create a TransporterRoom named "name". Initially, it has no exits.
     * "name" is something like "kitchen" or "court yard" and
     * "description" is a short description of the room.
     * This version of the room has no NonPlayerChar.
     * @param roomName The room's name.
     * @param roomDescription The room's description.
     */
    public TransporterRoom(String roomName, String roomDescription, 
        RandomRoom rooms)
    {
        super (roomName, roomDescription);
        randRoom = rooms;
    }
    
    /**
     * Create a TransporterRoom named "name". Initially, it has no exits.
     * name" is something like "kitchen" or "court yard" and
     * "description" is a short description of the room.
     * This version of the room has a NonPlayerChar.
     * @param roomName The room's name.
     * @param roomDescription The room's description.
     * @param newNPC The NonPlayerChar present in this room.
     */
    public TransporterRoom(String roomName, String roomDescription, 
        NonPlayerChar newNPC, RandomRoom rooms)
    {
        super (roomName, roomDescription, newNPC);
        randRoom = rooms;
    }

    /**
     * Return the room that is reached if we leave this room.
     *
     * @param direction The direction of the exit (ignored).
     * @return A randomly chosen room to which the player is transported.
     */
    public Room getExit(String direction)
    {
        // direction of exit is ignored
        return randRoom.getRandRoom();
    }
}
