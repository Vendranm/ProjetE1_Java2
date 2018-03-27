package pkg_Items;


/**
 * Décrivez votre classe Item ici.
 *
 * @author (Maxime Vendrand-MAillet)
 * @version (un numéro de version ou une date)
 */
public class Item
{
    // variables d'instance - remplacez l'exemple qui suit par le vôtre
    private int aForce;
    private String aDesc;
    private String aName;
    private boolean isEdible;

    /**
     * Constructeur d'objets de classe Item
     */
    public Item(final String pName, final String pDesc,final int pForce, final boolean pEdible)
    {
        // initialisation des variables d'instance
        this.aName = pName;
        this.aForce = pForce;
        this.aDesc = pDesc;
        this.isEdible = pEdible;
    }
    
    /**
     * Return the Name of the Item
     */
    public String getName()
    {
        return this.aName;
    }
    
    /**
     * Return the description of the Item
     */
    public String getDesc()
    {
        return this.aDesc;
    }
    
    /**
     * Return true if Item isEdible
     */
    public boolean isEdible()
    {
        return this.isEdible;
    }
    
    /**
     * Return the weight of the Item
     */
    public int getForce()
    {
        return this.aForce;
    }
    
    /**
     * Sets the weight of the Item
     */
    public void setItemForce(final int pF)
    {
        this.aForce = pF;
    }
    
    /**
     * Sets the description of the item
     */
    public void setItemDescription (final String pDesc)
    {
        this.aDesc = pDesc;
    }//setItemDescription (String pDescription)
    
    /**
     * Sets the name of the item
     */
    public void setIntemNom(final String pN)
    {
        this.aName = pN;
    }
    
    /**
     * Return the name and weight of the Item
     */
    public String getItemDesc()
    {
        return this.aName+" and as a force of "+this.aForce  ;
    }
    
    /**
     * Returns a String with the name and description of the item
     */
    public String getLongItemDesc()
    {
        return this.getItemDesc() + " which will " + this.aDesc;
    }
}
