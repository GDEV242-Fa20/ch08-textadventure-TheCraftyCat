/**
 * Representations for all the valid command words for the game
 * along with a string in a particular language.
 * 
 * @author  Michael Kölling and David J. Barnes
 * @version 2016.02.29
 * 
 * This class is incorporated into the "Queens Crystals" application by 
 * Catherine Oldfield for RVCC GDEV242 (Fall 2020). The only changes made to the
 * authors' original version are to add additional command words.
 */
public enum CommandWord
{
    // A value for each command word along with its
    // corresponding user interface string.
    GO("go"), QUIT("quit"), LOOK("look"), SLEEP("sleep"), DROP("drop"),
    TAKE("take"), INVENTORY("inventory"), USE("use"), TALK("talk"),
    HELP("help"), UNKNOWN("?");
    
    // The command string.
    private String commandString;
    
    /**
     * Initialise with the corresponding command string.
     * @param commandString The command string.
     */
    CommandWord(String commandString)
    {
        this.commandString = commandString;
    }
    
    /**
     * @return The command word as a string.
     */
    public String toString()
    {
        return commandString;
    }
}
