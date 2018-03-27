package pkg_Command;
import pkg_Character.Player;
import pkg_Items.*;
import pkg_Mechanics.GameEngine;
import pkg_Room.Room;
/**
 * Décrivez votre classe TeleportCommand ici.
 *
 * @author (votre nom)
 * @version (un numéro de version ou une date)
 */
public class TeleportCommand extends Command
{
    // variables d'instance - remplacez l'exemple qui suit par le vôtre
    /**
     * Constructeur d'objets de classe TeleportCommand
     */
    public TeleportCommand()
    {
        // initialisation des variables d'instance
    }

    /**
     * Override method that use the Bemmer to teleport yourself
     */
    @Override
    public void execute(final Player pPlayer)
    {
        String vCommand = getSecondWord();
        Item vBeamerI = pPlayer.getInventaire().get("globule");

        if (vBeamerI == null)
        {
            GameEngine.aGui.println("You don't have the globul in your possession.");
        }
        //if (vCommand.equals("Beamer")) aGui.println("Vous ne pouvez pas vous téléportez sans le beamer.");

        try 
        {
            Beammer vBeamer = (Beammer) vBeamerI;
            if (vBeamer.isCharged() == true)
            {
                Room vRoom = vBeamer.getSavedRoom();
                if (! vRoom.equals(pPlayer.getCurrentRoom()))
                {
                    GameEngine.aGui.println("And poof...");
                    pPlayer.setCurrentRoom(vBeamer.getSavedRoom());
                    vBeamer.setCharged(false);
                    GameEngine.printLocationInfo();
                    GameEngine.aGui.showImage(pPlayer.getCurrentRoom().getImageName());
                }
                else
                {
                    GameEngine.aGui.println("You are already in the saved room.");
                }
            }
            else
            {
                GameEngine.aGui.println("The globul isn't charged.");
            }
        }
        catch (java.lang.ClassCastException pE)
        {
            GameEngine.aGui.println("You can't charge that.");
        } 
    }//teleport()
}
