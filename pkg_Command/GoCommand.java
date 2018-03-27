package pkg_Command;
import pkg_Character.Player;
import pkg_Mechanics.GameEngine;
import pkg_Room.Room;
/**
 * Décrivez votre classe GoCommand ici.
 *
 * @author (votre nom)
 * @version (un numéro de version ou une date)
 */
public class GoCommand extends Command
{
    // variables d'instance - remplacez l'exemple qui suit par le vôtre

    /**
     * Constructeur d'objets de classe GoCommand
     */
    public GoCommand()
    {

    }
    
    /**
     * Override method that execute the command go
     */
    @Override
    public void execute(final Player pPlayer) 
    {
        if(!hasSecondWord()) 
        {
            // if there is no second word, we don't know where to go...
            GameEngine.aGui.println("Go where?");
            return;
        }

        String vDirection = getSecondWord();

        // Try to leave current room.
        Room vPreviousRoom= pPlayer.getCurrentRoom();
        pPlayer.getBackRoom().push(vPreviousRoom);
        Room vNextRoom = pPlayer.getCurrentRoom().getExit(vDirection);

        if (vNextRoom == null)
            GameEngine.aGui.println("There is no door!");
        
        else if(! pPlayer.getInventaire().hasItem("key") && pPlayer.getCurrentRoom().getDescription().equals(" in a special room which leads nowhere..") && vDirection.equals("West"))
        {
            GameEngine.aGui.println("You can't go this way. The door is closed. You need the key.");
            return;
        }
        else 
        {
            pPlayer.setCurrentRoom(vNextRoom);
            GameEngine.printLocationInfo();        
            if(pPlayer.getCurrentRoom().getImageName() != null)
            {
                GameEngine.aGui.showImage(pPlayer.getCurrentRoom().getImageName());
            }
            GameEngine.hurt();
        }
    }//goRoom
}
