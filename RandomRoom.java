import java.util.ArrayList;
import java.util.Random;

/**
 * Write a description of class RandomRoom here.
 *
 * @author (your name)
 * @version (a version number or a date)
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
