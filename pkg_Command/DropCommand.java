package pkg_Command;
import pkg_Character.Player;
import pkg_Mechanics.GameEngine;
import pkg_Items.Item;
/**
 * Décrivez votre classe DropCommand ici.
 *
 * @author (votre nom)
 * @version (un numéro de version ou une date)
 */
public class DropCommand extends Command
{
    // variables d'instance - remplacez l'exemple qui suit par le vôtre
    /**
     * Constructeur d'objets de classe DropCommand
     */
    public DropCommand()
    {
        // initialisation des variables d'instance
    }

    /**
     * Override method droping the Item in the current room
     */
    @Override
    public void execute(final Player pPlayer)
    {
        if( ! hasSecondWord())
        {
            GameEngine.aGui.println("What Item do tou want to drop ?");
        }
        else
        {
            String vC = getSecondWord();
            Item vItemInv = pPlayer.getInventaire().get(vC);

            if( vItemInv == null)
            {
                GameEngine.aGui.println("You don't have this Item in you're possession");
            }
            else
            {
                pPlayer.removeInventaire(vC);
                pPlayer.getCurrentRoom().getItems().put(vItemInv);
                GameEngine.aGui.println("You droped this " + vItemInv.getName());
            }
        }
    }//execute()
}
