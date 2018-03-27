package pkg_Command;
import pkg_Character.Player;
import pkg_Mechanics.GameEngine;
import pkg_Items.*;
/**
 * Décrivez votre classe ChargeCommand ici.
 *
 * @author (votre nom)
 * @version (un numéro de version ou une date)
 */
public class ChargeCommand extends Command
{
    /**
     * Constructeur d'objets de classe ChargeCommand
     */
    public ChargeCommand()
    {
        // initialisation des variables d'instance
    }
    
    /**
     * Override method that charge the Beammer before you can use it to teleport
     */
    @Override
    public void execute(final Player pPlayer)
    {
       String vC = getSecondWord();
       Item vBeamerI = pPlayer.getInventaire().get(vC);
       Beammer vBeamer = new Beammer("globule", "This item will make you teleporte your self.", 3, true);
       if (! hasSecondWord()) 
       {
           GameEngine.aGui.println("Charge what ?");
           return;
       }
       
       else if(! pPlayer.getInventaire().hasItem("globule"))
       {
           GameEngine.aGui.println("You don't have the globul in your possession."); 
       }
       
       try 
       {
           vBeamer = (Beammer) vBeamerI;
       }
       catch (java.lang.ClassCastException pE) 
       {
           GameEngine.aGui.println("You can't charge that\n");
       }
       
       vBeamer.setSavedRoom(pPlayer.getCurrentRoom());
       GameEngine.aGui.println("The globul is charged.");
       vBeamer.setCharged(true);
    }
}
