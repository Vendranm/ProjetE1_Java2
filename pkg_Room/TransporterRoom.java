package pkg_Room;
import pkg_Items.Item;
import pkg_Character.Charactere;
/**
 * Décrivez votre classe TransporterRoom ici.
 *
 * @author (Maxime Vendrand-Maillet)
 * @version (un numéro de version ou une date)
 */
public class TransporterRoom extends Room
{
    // variables d'instance - remplacez l'exemple qui suit par le vôtre
    private RoomRandomizer aRoomRandom;
    /**
     * Constructeur d'objets de classe TransporterRoom
     */
    public TransporterRoom(final String pDesc,final String pImage,final Item pItem, final Charactere pCha, final RoomRandomizer pRandom)
    {
        // initialisation des variables d'instance
        super(pDesc, pImage, pItem, pCha);
        this.aRoomRandom = pRandom;
    }
    
    @Override
    public Room getExit(final String pDir)
    {
        return findRandomRoom();
    }
    
    public Room findRandomRoom()
    {
        return aRoomRandom.getRoomRandom();
    }
}
