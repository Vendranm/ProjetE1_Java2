package pkg_Items;
import pkg_Room.Room;

/**
 * Décrivez votre classe Beammer ici.
 *
 * @author (Maxime Vendrand-Maillet)
 * @version (29/05/2017)
 */
public class Beammer extends Item
{
    // variables d'instance - remplacez l'exemple qui suit par le vôtre
    private Room aSavedRoom;
    private boolean aCharged;
    
    /**
     * Constructor of the class
     */
    public Beammer(final String pName, final String pDescription, final int pForce, final boolean pCharged) 
    {
        super(pName, pDescription, pForce, false);
    }
    
    /**
     * Returns the attribut aSavedRoom
     */
    public Room getSavedRoom() 
    {
        return aSavedRoom;
    }
    
    /**
     * Sets the attribut aSavedRoom
     */
    public void setSavedRoom(final Room pSavedRoom) 
    {
        this.aSavedRoom = pSavedRoom;
    }
    
    /**
     * Returns the attribut aCharged
     */
    public boolean isCharged() 
    {
        return aCharged;
    }
    
    /**
     * Sets the attribut aCharged
     */
    public void setCharged(final boolean pCharged) 
    {
        this.aCharged = pCharged;
    }
}
