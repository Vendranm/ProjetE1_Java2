package pkg_Command;
import pkg_Character.Player;
import pkg_Mechanics.GameEngine;
import java.util.Scanner;
import java.io.File;
/**
 * Décrivez votre classe TestCommand ici.
 *
 * @author (votre nom)
 * @version (un numéro de version ou une date)
 */
public class TestCommand extends Command
{
    // variables d'instance - remplacez l'exemple qui suit par le vôtre

    /**
     * Constructeur d'objets de classe TestCommand
     */
    public TestCommand()
    {
        // initialisation des variables d'instance
    }
    
    /**
     * Override method that execute the test command
     */
    @Override
    public void execute(final Player pPlayer)
    {
        if (! hasSecondWord())
        {
            GameEngine.aGui.println("\n Please add the name of the file. \n");
        }
        else
        {
            String vFichier = getSecondWord();
            try
            {
                Scanner vScan = new Scanner (new File("./" + vFichier + ".txt"));
                while (vScan.hasNextLine())
                {
                    String vLigne = vScan .nextLine();
                    GameEngine.interpretCommand(vLigne);
                }
            }
            catch (java.io.FileNotFoundException pException)
            {
                GameEngine.aGui.println("\n Can't find the file.\n");
            }
        }
    }
}
