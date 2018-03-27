package pkg_Command;
import pkg_Mechanics.GameEngine;
import pkg_Character.Player;
import pkg_Items.Item;
/**
 * Décrivez votre classe GrabCommand ici.
 *
 * @author (votre nom)
 * @version (un numéro de version ou une date)
 */
public class GrabCommand extends Command
{
    // variables d'instance - remplacez l'exemple qui suit par le vôtre
    /**
     * Constructeur d'objets de classe GrabCommand
     */
    public GrabCommand()
    {
        // initialisation des variables d'instance
    }

   /**
   * Override method garbing the Item from the current room
   */
    @Override
    public void execute(final Player pPlayer)
    {
        if (! hasSecondWord())
        {
            GameEngine.aGui.println("What item do you want to grab ?");
        }

        String vC = getSecondWord();
        Item vItem = pPlayer.getCurrentRoom().getItems().get(vC);
        
        if (vItem == null)
        {
            GameEngine.aGui.println("\nThis item is not in the room \n");
        }
        else
        {
            pPlayer.putInventaire(vItem);
            pPlayer.getCurrentRoom().getItems().remove(vC);
            GameEngine.aGui.println("You grabed the item : " + vItem.getName() + "\n");
            GameEngine.win();
        }
    }//grab()
}
