package pkg_Command;
import pkg_Character.Player;
import pkg_Mechanics.GameEngine;
/**
 * Décrivez votre classe QuitCommand ici.
 *
 * @author (votre nom)
 * @version (un numéro de version ou une date)
 */
public class QuitCommand extends Command
{

    /**
     * Constructeur d'objets de classe QuitCommand
     */
    public QuitCommand()
    {

    }
    
    /**
     * Override method that execute the quit command
     */
    @Override 
    public void execute(final Player pPlayer)
    {
        GameEngine.endGame(); 
    }
}
