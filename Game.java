/**
 *  This class is the main class of the "World of Zuul" application. 
 *  "World of Zuul" is a very simple, text based adventure game.  Users 
 *  can walk around some scenery. That's all. It should really be extended 
 *  to make it more interesting!
 * 
 *  To play this game, create an instance of this class and call the "play"
 *  method.
 * 
 *  This main class creates and initialises all the others: it creates all
 *  rooms, creates the parser and starts the game.  It also evaluates and
 *  executes the commands that the parser returns.
 * 
 * @author Catherine Oldfield
 * For RVCC GDEV242 - Fall 2020
 * from code written by Michael Kölling and David J. Barnes
 * @version 10/21/2020
 */

public class Game 
{
    private Parser parser;
    private Room currentRoom;
        
    /**
     * Create the game and initialise its internal map.
     */
    public Game() 
    {
        createRooms();
        parser = new Parser();
    }

    /**
     * Create all the rooms and link their exits together.
     */
    private void createRooms()
    {
        Room entryHall, galleryOfGlass, hallOfKnowledge, hallOfQueens;
        Room armory, chamberOfStairs, catacombOfDreaming, shrineToSong;
        Room ossuary, coldChamber, eastVault, westVault, centralHall;
        Room northHall, southHall, eastHall, westHall;
      
        // create the rooms
        entryHall = new Room("a large, vacant entry hall");
        galleryOfGlass = new Room("a gallery with many stained glass windows");
        hallOfKnowledge = new Room("a long room with many shelves of decayed books");
        hallOfQueens = new Room("a great hall filled with statues of the great Queens");
        armory = new Room("an armory with old, forgotten weapons");
        chamberOfStairs = new Room("a small chamber with carved stone steps leading down");
        catacombOfDreaming = new Room("a large cavern filled with candelabras and fanciful carvings");
        shrineToSong = new Room("a room whose crystal stalactites turn every breath into a vibrant song");
        ossuary = new Room("a bone crypt where dead Queens are interred");
        coldChamber = new Room("a drafty chamber; the gates at the exits have rusted off the hinges");
        eastVault = new Room("a mostly empty vault; above the door is enscribed 'All that glitters is n--'");
        westVault = new Room("a vault with only one entrance; 'Xyzzy' is carved on the wall");
        centralHall = new Room("a twisty passage whose ornate wall sconces are empty of tourches");
        northHall = new Room("a tiled passage, wide enough for several people to walk abreast");
        southHall = new Room("a long, dark, straight hallway");
        eastHall = new Room("a narrow hall where the stone is crumbling in spots");
        westHall = new Room("a wide hallway with faded tapestries on the walls");
        
        // initialize the room exits
        entryHall.setExit("south", galleryOfGlass);
        
        galleryOfGlass.setExit("north", entryHall);
        galleryOfGlass.setExit("south", hallOfQueens);
        galleryOfGlass.setExit("west", hallOfKnowledge);
        
        hallOfKnowledge.setExit("east", galleryOfGlass);
        hallOfKnowledge.setExit("west", westHall);
        hallOfKnowledge.setExit("south", centralHall);
        
        hallOfQueens.setExit("north", galleryOfGlass);
        hallOfQueens.setExit("west", centralHall);
        hallOfQueens.setExit("south", southHall);
        
        armory.setExit("north", westHall);
        armory.setExit("east", centralHall);
        armory.setExit("south", southHall);
        
        chamberOfStairs.setExit("south", westHall);
        chamberOfStairs.setExit("down", catacombOfDreaming);
        
        catacombOfDreaming.setExit("up", chamberOfStairs);
        catacombOfDreaming.setExit("east", northHall);
        catacombOfDreaming.setExit("south", ossuary);
        
        shrineToSong.setExit("south", eastHall);
        shrineToSong.setExit("west", northHall);
        
        ossuary.setExit("north", northHall);
        ossuary.setExit("south", eastVault);
        ossuary.setExit("east", eastHall);
        ossuary.setExit("west", catacombOfDreaming);
        
        coldChamber.setExit("north", eastHall);
        coldChamber.setExit("west", eastVault);
        
        eastVault.setExit("north", ossuary);
        eastVault.setExit("west", westVault);
        eastVault.setExit("east", coldChamber);
        
        westVault.setExit("east", eastVault);
        
        centralHall.setExit("north", hallOfKnowledge);
        centralHall.setExit("east", hallOfQueens);
        centralHall.setExit("west", armory);
        
        northHall.setExit("west", catacombOfDreaming);
        northHall.setExit("east", shrineToSong);
        northHall.setExit("south", ossuary);
        
        southHall.setExit("east", hallOfQueens);
        southHall.setExit("west", armory);
        
        eastHall.setExit("north", shrineToSong);
        eastHall.setExit("south", coldChamber);
        eastHall.setExit("west", ossuary);
        
        westHall.setExit("north", chamberOfStairs);
        westHall.setExit("south", armory);
        westHall.setExit("east", hallOfKnowledge);

        currentRoom = entryHall;  // start game outside
    }

    /**
     *  Main play routine.  Loops until end of play.
     */
    public void play() 
    {            
        printWelcome();

        // Enter the main command loop.  Here we repeatedly read commands and
        // execute them until the game is over.
                
        boolean finished = false;
        while (! finished) {
            Command command = parser.getCommand();
            finished = processCommand(command);
        }
        System.out.println("Thank you for playing.  Good bye.");
    }

    /**
     * Print out the opening message for the player.
     */
    private void printWelcome()
    {
        System.out.println();
        System.out.println("Welcome to the World of Zuul!");
        System.out.println("World of Zuul is a new, incredibly boring adventure game.");
        System.out.println("Type '" + CommandWord.HELP + "' if you need help.");
        System.out.println();
        System.out.println(currentRoom.getLongDescription());
    }

    /**
     * Given a command, process (that is: execute) the command.
     * @param command The command to be processed.
     * @return true If the command ends the game, false otherwise.
     */
    private boolean processCommand(Command command) 
    {
        boolean wantToQuit = false;

        CommandWord commandWord = command.getCommandWord();

        switch (commandWord) {
            case UNKNOWN:
                System.out.println("I don't know what you mean...");
                break;

            case HELP:
                printHelp();
                break;

            case GO:
                goRoom(command);
                break;

            case QUIT:
                wantToQuit = quit(command);
                break;
        }
        return wantToQuit;
    }

    // implementations of user commands:

    /**
     * Print out some help information.
     * Here we print some stupid, cryptic message and a list of the 
     * command words.
     */
    private void printHelp() 
    {
        System.out.println("You are lost. You are alone. You wander");
        System.out.println("around at the university.");
        System.out.println();
        System.out.println("Your command words are:");
        parser.showCommands();
    }

    /** 
     * Try to go in one direction. If there is an exit, enter the new
     * room, otherwise print an error message.
     */
    private void goRoom(Command command) 
    {
        if(!command.hasSecondWord()) {
            // if there is no second word, we don't know where to go...
            System.out.println("Go where?");
            return;
        }

        String direction = command.getSecondWord();

        // Try to leave current room.
        Room nextRoom = currentRoom.getExit(direction);

        if (nextRoom == null) {
            System.out.println("There is no door!");
        }
        else {
            currentRoom = nextRoom;
            System.out.println(currentRoom.getLongDescription());
        }
    }

    /** 
     * "Quit" was entered. Check the rest of the command to see
     * whether we really quit the game.
     * @return true, if this command quits the game, false otherwise.
     */
    private boolean quit(Command command) 
    {
        if(command.hasSecondWord()) {
            System.out.println("Quit what?");
            return false;
        }
        else {
            return true;  // signal that we want to quit
        }
    }
}
