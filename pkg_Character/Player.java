package pkg_Character;
import pkg_Room.Room;
import pkg_Items.*;
import java.util.Stack;

/**
 * Décrivez votre classe Player ici.
 *
 * @author (votre nom)
 * @version (un numéro de version ou une date)
 */
public class Player
{
    // variables d'instance - remplacez l'exemple qui suit par le vôtre
    private String aName;
    private int aForce;
    private Room aCurrentRoom;
    private Room aPreviousRoom;
    private Stack<Room> aBackRooms;
    private ItemList aItems;
    private Room aBackRoom;
    
    /**
     * Constructor of the class
     */
    public Player(final String pName, final int pForce, final Room pCu)
    {
        this.aName = pName;
        this.aForce = pForce;
        this.aCurrentRoom = pCu;
        this.aBackRooms = new Stack<Room>();
        this.aItems = new ItemList();
    }
    
    /**
     * Return the current room of the player
     */
    public Room getCurrentRoom()
    {
        return this.aCurrentRoom;
    }
    
    /**
     * Add the backRoom to the stack and sets the currentRoom as the backRoom
     */
    public void backPlayer()
    {
        this.aBackRoom = aBackRooms.pop();
        this.aCurrentRoom = aBackRoom;
    }
    
    /**
     * Return les salles (stack)
     */
    public Stack<Room> getBackRoom()
    {
        return this.aBackRooms;
    }
    
    /**
     * Return the PreviousRoom
     */
    public Room getPreviousRoom()
    {
        return this.aPreviousRoom;
    }
    
    /**
     * Fixer la salle du joueur
     */
    public void setCurrentRoom(final Room pCurrentRoom)
    {
        this.aCurrentRoom = pCurrentRoom;
    }
    
    /**
     * Retourne l'inventaire
     */
    public ItemList getInventaire()
    {
        return this.aItems;
    }
    
    /**
     * Return the description of the Inventory
     */
    public String getInvenatireDesc()
    {
        if(! this.getInventaire().isEmpty())
        {
            return "Inventory : " + this.getInventaire().getItemsString();
        }
        else return "";
    }
    
    /**
     * Rajoute l'item à l'inventaire
     */
    public void putInventaire(final Item pI)
    {
        this.aItems.put(pI);
    }
   
    /**
     * Enlève l'item de l'inventaire
     */
    public void removeInventaire(final String pI)
    {
        this.aItems.remove(pI);
    }
    
    /**
     * Retourne le nom du joueur 
     */
    public String getName()
    {
        return aName;
    }
    
    /**
     * Retourne la force du joueur 
     */
    public int getForce()
    {
        return aForce;
    }
    
    /**
     * Permet de changer la force du joueur
     */
    public void setForce(final int pF)
    {
        this.aForce = pF;
    }
    
    /**
     * Change the room of the player
     */
    public void changeRoom(final Room pRoom)
    {
        this.aPreviousRoom = aCurrentRoom;
        this.aCurrentRoom = pRoom;
    }
    
    /**
     * Gets an Item in the list
     */
    public Item get(final String pN)
    {
        return this.aItems.get(pN); 
    }
}
