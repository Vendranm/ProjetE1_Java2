package pkg_Command;
import pkg_Mechanics.GameEngine;
import pkg_Character.Player;
import pkg_Room.RoomRandomizer;
/**
 * Décrivez votre classe AleaCommand ici.
 *
 * @author (votre nom)
 * @version (un numéro de version ou une date)
 */
public class AleaCommand extends Command
{
    // variables d'instance - remplacez l'exemple qui suit par le vôtre
    /**
     * Constructeur d'objets de classe AleaCommand
     */
    public AleaCommand()
    {
        // initialisation des variables d'instance
    }
    
    /**
     * Override method that execute the alea command
     */
    @Override
    public void execute(final Player pPlayer)
    {
        if(! hasSecondWord())
        {
            GameEngine.aGui.println("Seed enable");
            RoomRandomizer.setSeed(null);
        }
        else
        {
            try
            {
                RoomRandomizer.setSeed( Long.parseLong(getSecondWord(), 10) );
            }
            catch(final NumberFormatException pE)
            {
                GameEngine.aGui.println("Wrong seed");
                return;
            }
            GameEngine.aGui.println("You've changed the seed");
        }
    }
}
