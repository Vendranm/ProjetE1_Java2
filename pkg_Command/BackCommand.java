package pkg_Command;
import pkg_Mechanics.GameEngine;
import pkg_Character.Player;
/**
 * Décrivez votre classe BackCommand ici.
 *
 * @author (votre nom)
 * @version (un numéro de version ou une date)
 */
public class BackCommand extends Command
{
    // variables d'instance - remplacez l'exemple qui suit par le vôtre
    /**
     * Constructeur d'objets de classe BackCommand
     */
    public BackCommand()
    {
        // initialisation des variables d'instance
    }

    /**
     * Override method wich makes you go back to the previous room
     */
    @Override
    public void execute(final Player pPlayer)
    {
        if(pPlayer.getBackRoom().empty()) 
        {
            GameEngine.aGui.println("You are already in the starter Room");
            return;
        }
        else 
        {
            if(pPlayer.getCurrentRoom().getDescription().equals(" in a special room which leads nowhere..") && ! pPlayer.getInventaire().hasItem("key"))
            {
                GameEngine.aGui.println("You can't go back without the key.");
                return;
            }
            pPlayer.backPlayer();
            GameEngine.printLocationInfo();
            GameEngine.aGui.showImage(pPlayer.getCurrentRoom().getImageName());
        }
    }
}
