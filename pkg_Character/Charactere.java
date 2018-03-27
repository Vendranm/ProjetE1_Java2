package pkg_Character;
import pkg_Room.Room;

/**
 * Décrivez votre classe Character ici.
 *
 * @author (votre nom)
 * @version (un numéro de version ou une date)
 */
public class Charactere
{
    // variables d'instance - remplacez l'exemple qui suit par le vôtre
    private String aName;
    private String aDesc;
    private int aForce;
    /**
     * Constructeur d'objets de classe Character
     */
    public Charactere(final String pN, final String pDesc, final int pF)
    {
        // initialisation des variables d'instance
        this.aName = pN;
        this.aDesc = pDesc;
        this.aForce = pF;
    }
    
    /**
     * Return the name of the character
     */
    public String getChaName()
    {
        return this.aName;
    }
    
    /**
     * Return the description of the character
     */
    public String getChaDesc()
    {
        return this.aDesc;
    }
    
    /**
     * Return a String with the name and description of the character
     */
    public String getChaLongDesc()
    {
        return "I'm a " + this.aName + ". " + this.aDesc;
    }
    
    /**
     * Return the force of the character
     */
    public int getChaForce()
    {
        return this.aForce;
    }
}
