package pkg_Command;
import pkg_Character.Player;
import pkg_Mechanics.GameEngine;
/**
 * Décrivez votre classe HelpCommand ici.
 *
 * @author (votre nom)
 * @version (un numéro de version ou une date)
 */
public class HelpCommand extends Command
{
    // variables d'instance - remplacez l'exemple qui suit par le vôtre

    /**
     * Constructeur d'objets de classe HelpCommand
     */
    public HelpCommand()
    {
        // initialisation des variables d'instance
    }

    /**
     * Override method that execute the help command
     */
    @Override
    public void execute(final Player pPlayer) 
    {
        GameEngine.aGui.println("You are lost. You are alone. You wander");
        GameEngine.aGui.println("around at Monash Uni, Peninsula Campus." + "\n");
        GameEngine.aGui.print("Your command words are: " + GameEngine.aParser.showCommands());
    }//printHelp
}
