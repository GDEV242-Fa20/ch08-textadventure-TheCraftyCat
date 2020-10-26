import java.util.ArrayList;
import java.util.Random;

/**
 *  This class is the NonPlayerChar class of the "Queen's Crystals" application,
 *  which is based on the "World of Zuul" application by Barnes and Kölling. 
 *  "World of Zuul" is a very simple, text based adventure game.  Users 
 *  can walk around some scenery. That's all. It should really be extended 
 *  to make it more interesting!
 * 
 *  A "NonPlayerChar" represents an NPC in the game: a character with which the
 *  Player can interact, but is not playable itself. The NPC offers hints to 
 *  the Player, stored in an ArrayList of dialog strings.
 * 
 * @author Catherine Oldfield
 * For RVCC GDEV242 - Fall 2020
 * from code written by Michael Kölling and David J. Barnes
 * @version 10/25/2020
 */
public class NonPlayerChar
{
    private String name;        // the name of the character
    private String description; // a physical description of the character
    private boolean isMale;     // to indicate NPC gender for pronouns
    private ArrayList<String> hints;  // dialog strings the character can speak 

    /**
     * Constructor for objects of class NonPlayerChar
     */
    public NonPlayerChar(String npcName, boolean npcGender, String npcDesc)
    {
        name = npcName;
        isMale = npcGender;
        description = npcDesc;
        hints = new ArrayList<String>();
        hints.add(name + " has nothing to say.");
    }

    /**
     * Returns the name of the NonPlayerChar
     * @return name The name of the NonPlayerChar
     */
    public String getName()
    {
        return name;
    }
    
    /**
     * Returns a description of the NonPlayerChar
     * @return description A description of the NonPlayerChar
     */
    public String getDesc()
    {
        return description;
    }
    
    /**
     * Add a String containing "hint" dialog to the NonPlayerChar's list
     * of "hints".
     * @param newHint The String to add.
     */
    public void addHint(String newHint)
    {
        hints.add(name + " says, '" + newHint + "'");
    }
    
    /**
     * Return a randomly chosen String from the NonPlayerChar's list of "hints".
     * @return 
     */
    public String getHint()
    {
        Random randomizer = new Random();
        int hintChoice = randomizer.nextInt(hints.size());
        return hints.get(hintChoice);
    }
}
