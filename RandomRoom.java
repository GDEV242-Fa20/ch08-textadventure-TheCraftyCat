import java.util.ArrayList;
import java.util.Random;

/**
 *  This class is the RandomRoom class of the "Queen's Crystals" application,
 *  which is based on the "World of Zuul" application by Barnes and Kölling. 
 *  "World of Zuul" is a very simple, text based adventure game.  Users 
 *  can walk around some scenery. That's all. It should really be extended 
 *  to make it more interesting!
 * 
 *  A "RandomRoom" implements a way to randomly select a Room from an ArrayList
 *  of Rooms. Rooms must be added to the ArrayList before the random selection
 *  can occur.
 * 
 * @author Catherine Oldfield
 * For RVCC GDEV242 - Fall 2020
 * from code written by Michael Kölling and David J. Barnes
 * @version 10/25/2020
 */
public class RandomRoom
{
    private ArrayList<Room> roomList;    // list of possible Rooms

    /**
     * Create an object of class RandomRoom and instantiate the roomList.
     */
    public RandomRoom()
    {
        roomList = new ArrayList<Room>();
    }

    /**
     * Add a Room to the roomList.
     *
     * @param newRoom The Room to add to the roomList.
     */
    public void addRoom(Room newRoom)
    {
        roomList.add(newRoom);
    }
    
    /**
     * Return a randomly selected room from the roomList.
     * 
     * @return A randomly slected room.
     */
    public Room getRandRoom()
    {
        Random randomizer = new Random();
        return roomList.get(randomizer.nextInt(roomList.size()));
    }
}
