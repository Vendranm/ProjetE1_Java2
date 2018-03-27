package pkg_Mechanics;
import pkg_Command.Parser;
import pkg_Character.*;
import pkg_Items.*;
import pkg_Command.CommandWord;
import pkg_Command.Command;
import pkg_Room.*;
import java.io.File;
import java.io.PrintWriter;
import java.util.Scanner;
import java.util.Stack;
import java.util.Map;
import java.util.ArrayList;
import java.util.HashMap;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.Timer;
/**
 *  This class is part of the "World of Zuul" application. 
 *  "World of Zuul" is a very simple, text based adventure game.
 * 
 *  This class creates all rooms, creates the parser and starts
 *  the game.  It also evaluates and executes the commands that 
 *  the parser returns.
 * 
 * @author  Michael Kolling and David J. Barnes
 * @version 1.0 (Jan 2003)
 */
public class GameEngine
{
    public static Parser aParser;
    public static UserInterface aGui;
    private static int aLimite;
    private static Timer aTimer;
    private Item aItem;
    private static Player aPlayer;
    //private static ArrayList<Room> aRooms;
    /**
     * Constructor for objects of class GameEngine
     */
    public GameEngine()
    {
        this.aParser = new Parser();
        this.createPlayer();
        this.createRooms();        
        this.aLimite = 5*60;
        //this.aRooms = new ArrayList<Room>();
        ActionListener vListener = new ActionListener()
            {
                public void actionPerformed(ActionEvent e) 
                {
                    aGui.setTimer("" + aLimite);
                    aLimite--;
                    if (aLimite == 0)
                    {
                        loose();
                    }
                }
            };
        this.aTimer = new Timer(1000, vListener);
    }//GameEngine

    /**
     * Define the interface and display the welcome phrases
     */
    public void setGUI(final UserInterface pUserInterface)
    {
        this.aGui = pUserInterface;
        printWelcome();
        aGui.setTimer(""+ this.aLimite);
        aTimer.start();
    }//setGUI

    /**
     * Print out the opening message for the player.
     */
    private void printWelcome()
    {
        aGui.print("\n");
        aGui.println("Welcome to the game where you create life!");
        aGui.println("You are about to give life to a new born. If you can win..");
        aGui.println("Type " + CommandWord.HELP + "if you need help.");
        aGui.print("\n");
        printLocationInfo();
        aGui.showImage(aPlayer.getCurrentRoom().getImageName());
    }//printWelcome

    /**
     * Create all the rooms and link their exits together.
     */
    private void createRooms()
    {
        RoomRandomizer vRandomRoom = new RoomRandomizer();
        
        Room vEntree, vColUt, vCanal1, vCanal2, vCavite1, vCavite2, vInc, vGrenier, vUnder, vTrompe1, vTrompe2, vFin1, vFin2;

        Item vVaccin, vVitamine, vClef, vBeammer, vOvum;

        Charactere vVirus;
        //create the charactere
        vVirus = new Charactere("virus", "Watch out I can heart you very bad..", 1);
        // Create the Items
        vVaccin = new Item("vaccin", "It will allow you to survive infections", 3, false);
        vVitamine = new Item("vitamines","It will give you strength", 4, true);
        vClef = new Item("key", "It might be usefull to open some close doors", 0, false);
        vBeammer = new Beammer("globule", "It will make you go faster.", 0, false);
        vOvum = new Item("ovum", "Together you will create life.",1, false);

        // create the rooms
        vEntree = new Room(" about to be released and start the run.", "Images/vEntree.jpg",null, null);
        vColUt = new Room(" in the cervix a rough path", "Images/ImgColUt.jpg", null, null);
        vCanal1 = new Room(" now you have to pass the cervical canal by the West side" , "Images/ImgCanal1.jpg", null, null);
        vCanal2 = new TransporterRoom(" now you have to pass the cervical canal by the East side", "Images/ImgCanal2.jpg", null, null, vRandomRoom);
        vCavite1 = new Room(" arrived in the Uterine cavity. A large and vast place where you can lost yourself", "Images/vCavite1.jpg", null, vVirus);
        vCavite2 = new Room(" still in the Uterine cavity, a bit futher.", "Images/vCavite2.jpg", null, null);
        vInc = new Room(" in a special room which leads nowhere..", "Images/vInc.jpg", null, null);
        vGrenier = new Room(" in a dark room where you can do special things", "Images/ImgGrenier.jpg", null, null);
        vUnder = new Room(" in the underground where you might find interesting things.","Images/vUnder.jpg", null, null);
        vTrompe1 = new Room(" going through the fallopian tube by the east way", "Images/vTrompe1.jpg", null, null);
        vTrompe2 = new Room(" going through the fallopian tube by the west way", "Images/vTrompe2.jpg", null, null); 
        vFin1 = new Room(" at the end of the circuit. Is there the ovule ?", "Images/vFin1.jpg", null, null);
        vFin2 = new Room (" at the end of the circuit. Is there the ovule ?", "Images/vFin2.jpg", null, null);

        //Define all the exits of the rooms
        vEntree.setExit("North",vColUt);
        vColUt.setExit("South", vEntree);
        vColUt.setExit("West", vCanal2);
        vColUt.setExit("East", vCanal1);
        vCanal1.setExit("North", vCavite1);
        vCanal1.setExit("Up", vGrenier);
        vCanal1.setExit("West", vColUt);
        vGrenier.setExit("Down", vCanal1);
        vCanal2.setExit("North", vCavite2);
        vCanal2.setExit("East", vColUt);
        vCavite1.setExit("South", vCanal1);
        vCavite1.setExit("East", vInc);
        vInc.setExit("West", vCavite1);
        vCavite1.setExit("North", vTrompe1);
        vCavite1.setExit("West", vCavite2);
        vCavite2.setExit("North", vTrompe2);
        vCavite2.setExit("East", vCavite1);
        vCavite2.setExit("Down", vUnder);
        vCavite2.setExit("South", vCanal2);
        vUnder.setExit("Up", vCavite2);
        vTrompe2.setExit("South", vCavite2);
        vTrompe1.setExit("South", vCavite1);
        vTrompe1.setExit("East", vFin1);
        vTrompe1.setExit("West", vTrompe2);
        vTrompe2.setExit("East", vTrompe1);
        vTrompe2.setExit("West", vFin2);
        vFin1.setExit("West", vTrompe1);
        vFin2.setExit("East", vTrompe2);
        
        //Add Rooms to the list of random room.
        vRandomRoom.addRooms(vCavite1);
        vRandomRoom.addRooms(vInc);
        vRandomRoom.addRooms(vUnder);
        // Add all the Items
        vGrenier.getItems().addItem(vVaccin.getName(), vVaccin);
        vUnder.getItems().addItem(vVitamine.getName(), vVitamine);
        vCanal1.getItems().addItem(vClef.getName(), vClef);
        vInc.getItems().addItem(vBeammer.getName(), vBeammer);
        vFin1.getItems().addItem(vOvum.getName(), vOvum);
        //         //Add the rooms to the HasMap
        //         aRooms.add(vEntree);
        //         aRooms.add(vColUt);
        //         aRooms.add(vCanal1);
        //         aRooms.add(vCanal2);
        //         aRooms.add( vCavite1);
        //         aRooms.add(vCavite2);
        //         aRooms.add(vInc);
        //         aRooms.add(vGrenier);
        //         aRooms.add(vUnder);
        //         aRooms.add(vTrompe1);
        //         aRooms.add(vTrompe2);
        //         aRooms.add(vFin1);
        //         aRooms.add(vFin2);

        aPlayer.setCurrentRoom(vEntree); // Start the game in the entrance
    }//createRooms

    /**
     * Method that creates the player
     */
    public void createPlayer()
    {
        this.aPlayer = new Player("Jean", 2, null);
    }

    /**
     * Given a command, process (that is: execute) the command.
     * If this command ends the game, true is returned, otherwise false is
     * returned.
     */
    public static void interpretCommand(final String pCommandLine) 
    {
        aGui.println(pCommandLine);
        Command vCommand = aParser.getCommand(pCommandLine);
        if(vCommand == null) 
        {
            aGui.println("\n I don't know what you mean. \n");
            return;
        }
        else 
        {
            vCommand.execute(aPlayer);
        }//interpretCommand()
    }//interpretCommand

    /**
     * Returns the Limit
     */
    public static int getLimite()
    {
        return aLimite;
    }

    /**
     * Sets the Limit
     */
    public static void setLimite(final int pLimite)
    {
        aLimite = pLimite;
    }

    /**
     * Method printing the description of the room
     */
    public static void printLocationInfo()
    {
        aGui.println(aPlayer.getCurrentRoom().getLongDescription());
    }//printLocationInfo()

    /**
     * Method printing a message if you win
     */
    public static void win()
    {
        if(aPlayer.getInventaire().hasItem("ovum"))
        {
            aGui.println("You won !!!");
            aGui.println("Nice job !");
            endGame();
        }
    }

    /**
     * Method printing a message if you loose. 
     * If you run out of time.
     */
    public void loose()
    {
        aGui.println("You have been to slow, you loose. Try again");
        endGame();     
    }
    // implementations of user commands

    public static void hurt()
    {
        try{
        if(aPlayer.getCurrentRoom().getChaRoom().getChaName().equals("virus"))
        {
            if(! aPlayer.getInventaire().hasItem("vaccin"))
            
            {
                aPlayer.setForce(aPlayer.getForce() -1);
                aGui.println("You have been attacked by the virus. You lost one point of life");
            }
            else
            {
                aGui.println("You have the vaccin lucky for you.");
            }
        }
    }
    catch(NullPointerException aE){}
    }

    /**
     * Method ending the game
     */
    public static void endGame()
    {
        aGui.println("Thank you for playing.  Good bye.");
        aTimer.stop();
        aGui.enable(false);
    }//endGame

    //     /**
    //      * Method wich registers the previous room
    //      */
    //     public void changeRoom(final Room pRoom)
    //     {
    //         this.aPreviousRoom = aCurrentRoom;
    //         this.aCurrentRoom = pRoom;
    //     }

    //     /**
    //      * Returns the HashMap aRomms
    //      */
    //     public static ArrayList<Room> getRooms()
    //     {
    //         return GameEngine.aRooms;
    //     }
}// GameEngine 
