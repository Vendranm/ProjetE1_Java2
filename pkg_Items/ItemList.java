package pkg_Items;

import java.util.HashMap;
import java.util.Set;

/**
 * Décrivez votre classe ItemList ici.
 *
 * @author (votre nom)
 * @version (un numéro de version ou une date)
 */
public class ItemList
{
    // variables d'instance - remplacez l'exemple qui suit par le vôtre
    private HashMap <String, Item> aItems;
    
    /**
     * Constructor of the class ItemList
     */
    public ItemList()
    {
        this.aItems = new HashMap <String, Item>();
    }
    
    /**
     * Method use to add an Item to the list
     */
    public void addItem(final String pNom, final Item pItem)
    {
        this.aItems.put(pNom, pItem);
    }//addItem()
    
    /**
     * Method to put an Item in the list
     */
    public void put(final Item pItem)
    {
        this.aItems.put(pItem.getName(),pItem);
    }
    
    /**
     * Method to remove an item from the list
     */
    public void remove(final String pI)
    {
        this.aItems.remove(pI);
    }
    
    /**
     * Return true if the list is empty
     */
    public boolean isEmpty()
    {
        return this.aItems.isEmpty();
    }
    
    /**
     * 
     */
    public Item get(final String pN)
    {
        return this.aItems.get(pN); 
    }
    
    /**
     * Return the attribut aItems
     */
    public HashMap<String,Item> getItems()
    {
        return this.aItems;
    }//getaItems()
    
    /**
     * Returns a String with all the items in the list
     */
    public String getItemsString()
    {
        String RS = " ";
        Set<String> keySet = aItems.keySet();
        for (String vItem : keySet) RS +=" "+ vItem;
        return RS;        
    }//getItem()
    
    /**
     * Method used to know if an item
     */
    public boolean hasItem(final String pI)
    {
        return this.aItems.containsKey(pI);
    }
}
