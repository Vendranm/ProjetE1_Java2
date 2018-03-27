package pkg_Command;


/**
 * Enumeration CommandWord - écrire ici la description de l'énumération
 *
 * @author (votre nom)
 * @version (numéro de version ou date)
 */
public enum CommandWord
{
    GO("go", new GoCommand()),
    QUIT("quit", new QuitCommand()),
    HELP("help", new HelpCommand()), 
    LOOK("look", new LookCommand()), 
    EAT("eat", new EatCommand()),
    GRAB("grab", new GrabCommand()),
    DROP("drop", new DropCommand()),
    BACK("back", new BackCommand()),
    TEST("test", new TestCommand()),
    UNKNOWN("?", null),
    CHARGE("charge", new ChargeCommand()),
    TELEPORT("teleport", new TeleportCommand()),
    ALEA("alea", new AleaCommand());
    
    
    private String aCommandString;
    private Command aCommand;
    /**
     * Initialise with the corresponding command word.
     * @param commandWord The command string.
     */
    CommandWord(final String pCommandString, final Command pC)
    {
        this.aCommandString = pCommandString;
        this.aCommand = pC;
    }
    
    /**
     * @return The command word as a string.
     */
    public String toString()
    {
        return this.aCommandString;
    }
    
    /**
     * Returns the command aCommand
     */
    public Command getCommand()
    {
        return this.aCommand;
    }
}
