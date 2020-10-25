/**
 *  This class is the main class of the "Queen's Crystals" application.
 *  
 *  This is based on the "World of Zuul" application by Barnes and Kölling. 
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
 * @version 10/22/2020
 */

public class Game 
{
    /**
     * A main method to create a Game object and invoke its play method.
     */
    public static void main(String[] args)
    {
        Game game = new Game();
        game.play();
    }
    
    private Parser parser;
    private Room startRoom;
    private Player thePlayer;
        
    /**
     * Create the game and initialise its internal map.
     */
    public Game() 
    {
        createRooms();
        thePlayer = new Player("Name", startRoom);
        parser = new Parser();
    }

    /**
     * Create all the rooms and link their exits together.
     * Create items and place them in the rooms.
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
        westVault = new Room("a vault with only one entrance; 'Xyzzy' is carved on the wall but speaking this word only makes you feel like a fool");
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
        
        // add items that can be picked up to the rooms
	galleryOfGlass.addItem(new Item(2, "glass", "a piece of green glass from a stained glass window"));
	galleryOfGlass.addItem(new Item(2, "necklace", "a necklace with a broken clasp"));

	hallOfKnowledge.addItem(new Item(2, "parchment", "scraps of parchment with burns near their edges"));
        hallOfKnowledge.addItem(new Item(10, "book", "a dusty old tome written in a language you don't recognize"));
        hallOfKnowledge.addItem(new Item(6, "journal", "what looks like a journal, badly water damaged"));
	hallOfKnowledge.addItem(new Item(5, "sketchbook", "a sketchbook with renderings of architectural features"));
	hallOfKnowledge.addItem(new Item(1, "quill", "a quill pen with a broken nib"));
	hallOfKnowledge.addItem(new Item(2, "ink", "a stoppered jar of deep blue ink"));
	
	hallOfQueens.addItem(new Item(15, "stone hand", "a stone hand that broke off a statue"));
	hallOfQueens.addItem(new Item(4, "cuff", "a tarnished silver cuff set with deep red stones"));
	hallOfQueens.addItem(new Item(2, "pebble", "a pretty pebble"));
	
	armory.addItem(new Item(20, "shield", "a small shield, old, but still in good condition"));
	armory.addItem(new Item(10, "crystal sword", "a sword made entirely of crystal and much too fragile to use as a weapon"));
	armory.addItem(new Item(8, "spear", "a plain spear"));
	armory.addItem(new Item(8, "broken sword", "a sword whose rusty blade looks like it will break the moment you touch it"));
	armory.addItem(new Item(10, "staff", "a sturdy wooden staff"));
	armory.addItem(new Item(5, "hammer", "the kind of hammer that would be used in a smithy"));
	
	chamberOfStairs.addItem(new Item(2, "rope", "a three-foot length of rope"));
	
	catacombOfDreaming.addItem(new Item(1, "red ribbon", "a bit of red ribbon"));
	catacombOfDreaming.addItem(new Item(1, "blue ribbon", "a long piece of blue ribbon"));
	catacombOfDreaming.addItem(new Item(1, "green ribbon", "a torn, tattered green ribbon"));
	catacombOfDreaming.addItem(new Item(1, "purple ribbon", "a fancy purple ribbon with gold edges"));
	catacombOfDreaming.addItem(new Item(1, "string", "what looks like a small ribbon is actually a bit of string"));

	shrineToSong.addItem(new Item(3, "flute", "a crystal flute"));
	shrineToSong.addItem(new Item(4, "dagger", "a dagger with a heavily jeweled hilt"));
	shrineToSong.addItem(new Item(3, "incense", "a cone of heavily aromatic sandalwood incense"));
	shrineToSong.addItem(new Item(3, "incense burner", "a small brass incense burner"));
	
	ossuary.addItem(new Item(10, "mask", "a heavy funeral mask"));
	ossuary.addItem(new Item(6, "shroud", "a moth-eaten burial shroud"));
	ossuary.addItem(new Item(2, "hinge", "a broken hinge"));
	
	coldChamber.addItem(new Item(4, "stick", "a wooden stick, good for poking things"));
	coldChamber.addItem(new Item(1, "button", "a shiny brass button"));
	
	eastVault.addItem(new Item(10, "lead", "a lump of lead"));
	eastVault.addItem(new Item(5, "lock", "a metal padlock"));
	eastVault.addItem(new Item(1, "key", "a key for a padlock"));

	westVault.addItem(new Item(3, "wand", "a wand with 'Xyzzy' carved on the side...but speaking this word only makes you feel like a fool"));
	westVault.addItem(new Item(5, "brick", "a brick"));
	
	centralHall.addItem(new Item(3, "torch", "an unlit torch"));
	centralHall.addItem(new Item(1, "spoon", "a runcible spoon"));

	westHall.addItem(new Item(10, "tapestry", "an old tapestry that has fallen off the wall"));
	
	// add items that can't be picked up to the rooms
	hallOfKnowledge.addItem(new Item(200, "desk", "a sturdy desk"));
	hallOfKnowledge.addItem(new Item(200, "rug", "a surprisingly soft rug"));
	
        hallOfQueens.addItem(new Item(200, "statue of Desarae", "a statue of Queen Desarae; the inscription at the base is worn off"));
	hallOfQueens.addItem(new Item(200, "statue of Idani", "a statue of Queen Idani; the inscription at the base says 'BELOVED'"));
	hallOfQueens.addItem(new Item(200, "statue of Yelena", "a statue of Queen Yelena; the inscription at the base says 'STRENGTH'"));
	hallOfQueens.addItem(new Item(200, "unknown statue", "a statue whose head has been broken off; the inscription at the base looks to have been deliberately chiseled away"));

        armory.addItem(new Item(200, "anvil", "a really heavy anvil"));
	armory.addItem(new Item(200, "grue statue", "a carved statue of a grue"));
	
        catacombOfDreaming.addItem(new Item(200, "crystal pillars", "several large, heavy crystal pillars in various colors"));
	catacombOfDreaming.addItem(new Item(200, "chandelier", "an ornate crystal chandelier"));
	
        shrineToSong.addItem(new Item(200, "altar", "a carved marble altar"));
	shrineToSong.addItem(new Item(200, "drum", "an ornate drum in a large stand"));
		
        ossuary.addItem(new Item(200, "sarcophagus", "a sarcophagus resting on a stone slab"));
	ossuary.addItem(new Item(200, "candle stands", "four large, squat stands made of bones, for holding pillar candles"));
	
        coldChamber.addItem(new Item(200, "iron ring", "a heavy iron ring, bolted to the floor"));
	
        eastVault.addItem(new Item(200, "barrel", "a large barrel full of... nails?"));
	
        westVault.addItem(new Item(200, "magic mirror", "a mirror in a large frame, with the word 'magic' scrawled across the glass (it is not actually magic)"));
	westVault.addItem(new Item(200, "planks", "a stack of large wooden planks"));
	
        centralHall.addItem(new Item(200, "wall sconce", "an iron sconce for holding a torch, bolted to the wall"));
	
        eastHall.addItem(new Item(200, "brick pile", "a pile of bricks"));
        
        startRoom = entryHall;  // start game in the entry hall
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
        System.out.println("Welcome to The Queen's Crystals!");
        System.out.println("The Queen's Crystals is a text-based adventure game.");
        System.out.println();
        System.out.println("You, intrepid adventurer, have traveled across the land of Ithlen,");
        System.out.println("seeking answers to the strange visions invading your sleep.");
        System.out.println("Even more troubling is the crystal you found embedded at the base");
        System.out.println("of your throat, warm and seeming to pulse as if somehow alive.");
        System.out.println("A witch woman bade you seek the knowledge of the Crystal Queens");
        System.out.println("but as far as you know, they died out a century ago.");
        System.out.println();
        System.out.println("Every day that passes the crystal grows warmer, its pulse stronger,");
        System.out.println("and you feel incrementally weaker. It's as if some part of your soul");
        System.out.println("fights a great battle...one you know you cannot lose.");
        System.out.println();
        System.out.println("You have made it to the ruins of Damerel, a once-great keep in");
        System.out.println("the Pernrith Mountains. Violent weather has chased you into the");
        System.out.println("once-great halls, whose doors yield to your slightest touch yet");
        System.out.println("close behind you with a decisive boom. You are alone, and safe");
        System.out.println("from the storm...and your crystal has started to glow.");
        System.out.println();
        System.out.println("Type '" + CommandWord.HELP + "' if you need help.");
        System.out.println();
        System.out.println(startRoom.getLongDescription());
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
                
            case LOOK:
                look();
                break;
            
            case DROP:
                thePlayer.dropItem();
                break;
            
            case TAKE:
                thePlayer.takeItem();
                break;
                
            case INVENTORY:
                thePlayer.printInventory();
                break;
                
            case SLEEP:
                sleep();
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
        System.out.println("You are lost. You are alone. The crystal");
        System.out.println("embedded in your skin pulses painfully.");
        System.out.println("You close your eyes and take a deep breath.");
        System.out.println("Then, you remember your goal.");
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
        Room nextRoom = thePlayer.getCurrentRoom().getExit(direction);

        if (nextRoom == null) {
            System.out.println("There is no door!");
        }
        else {
            thePlayer.setCurrentRoom(nextRoom);
            System.out.println(thePlayer.getCurrentRoom().getLongDescription());
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
    
    /**
     * Look around the current room.
     * A description of the room is printed to the terminal window.
     */
    private void look()
    {
        System.out.println("You take a look at your surroundings.");
        // print the room description
        System.out.println(thePlayer.getCurrentRoom().getLongDescription());
    }
    
    /**
     * The player sleeps.
     * A message prints to the terminal window about the sleep period.
     */
    private void sleep()
    {
        System.out.println("You have been awake for some time now and");
        System.out.println("you feel like you're fighting for every step.");
        System.out.println("You drag yourself into what looks like a");
        System.out.println("defensible corner and all but collapse into");
        System.out.println("your bedroll.");
        System.out.println();
        System.out.println("You slept more soundly than you thought you");
        System.out.println("would, and wake feeling refreshed.");
    }
}
