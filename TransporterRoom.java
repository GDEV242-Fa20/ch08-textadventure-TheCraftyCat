
/**
 * Write a description of class TransporterRoom here.
 *
 * @author (your name)
 * @version (a version number or a date)
 */
public class TransporterRoom extends Room
{
    private RandomRoom randRoom;
    
    /**
     * Create a TransporterRoom and initialize the 
     */
    public TransporterRoom(String roomName, String roomDescription, 
        RandomRoom rooms)
    {
        super (roomName, roomDescription);
        randRoom = rooms;
    }
    
    /**
     * Constructor for objects of class TransporterRoom
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
     * @return A randomly chosen exit.
     */
    public Room getExit(String direction)
    {
        // direction of exit is ignored
        return randRoom.getRandRoom();
    }
}
