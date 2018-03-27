package pkg_Command;
import pkg_Character.Player;
import pkg_Mechanics.GameEngine;
/**
 * Décrivez votre classe LookCommand ici.
 *
 * @author (votre nom)
 * @version (un numéro de version ou une date)
 */
public class LookCommand extends Command
{
    // variables d'instance - remplacez l'exemple qui suit par le vôtre
    /**
     * Constructeur d'objets de classe LookCommand
     */
    public LookCommand()
    {
        // initialisation des variables d'instance
    }

    /**
     * Override method displaying the description and exits of the current room
     */
    @Override
    public void execute(final Player pPlayer)
    {
        GameEngine.aGui.println(pPlayer.getCurrentRoom().getLongDescription());
        if(! pPlayer.getInventaire().isEmpty())
        {
            GameEngine.aGui.println(pPlayer.getInvenatireDesc());
        }
    }//look()
}
