package pkg_Command;
import pkg_Mechanics.GameEngine;
import pkg_Character.Player;
import pkg_Items.Item;
/**
 * Décrivez votre classe EatCommand ici.
 *
 * @author (votre nom)
 * @version (un numéro de version ou une date)
 */
public class EatCommand extends Command
{
    // variables d'instance - remplacez l'exemple qui suit par le vôtre
    /**
     * Constructeur d'objets de classe EatCommand
     */
    public EatCommand()
    {
        // initialisation des variables d'instance
    }

    /**
     * Override method that allows to eat Items that can be eaten. Somme of them will help you 
     */
    @Override
    public void execute(final Player pPlayer)
    {
        String vC = getSecondWord();
        Item vItem = pPlayer.getInventaire().get(vC);
        if(! hasSecondWord())
        {
            GameEngine.aGui.println("What do you want to eat ?");
            return;
        }
        if(! pPlayer.getInventaire().hasItem(vC))
        {
            GameEngine.aGui.println("You don't have this item : " + vC);
        }
        else
        {
            if(! vItem.isEdible())
            {
                GameEngine.aGui.println("You can't eat " + vC);
            }
            else
            {
                if(vC.equals("vitamines"))
                {
                    pPlayer.setForce(pPlayer.getForce() + 1);
                    GameEngine.setLimite( GameEngine.getLimite()+ 60);
                    GameEngine.aGui.println("Your force just increase");
                    
                }
                pPlayer.getInventaire().remove(vC);
                GameEngine.aGui.println("You've eat " + vC);
            }
        }
    }//eat()
}
