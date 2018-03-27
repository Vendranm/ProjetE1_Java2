package pkg_Room;

import java.util.ArrayList;
import java.util.Random;

/**
 * Décrivez votre classe RoomRandom ici.
 *
 * @author (Maxime Vendrand-Maillet)
 * @version (30/05/2017)
 */
public class RoomRandomizer
{
    // variables d'instance - remplacez l'exemple qui suit par le vôtre
    private ArrayList<Room> aRandomRoom;
    /**
     * Constructeur d'objets de classe RoomRandom
     */
    public RoomRandomizer()
    {
        // initialisation des variables d'instance
        this.aRandomRoom = new ArrayList<Room>();
    }

    public void addRooms(final Room pRoom)
    {
    	this.aRandomRoom.add(pRoom);
    }
    
    public Room getRoomRandom()
    {
        Random vRandom = new Random();
        int vRandomNumber = vRandom.nextInt(aRandomRoom.size());
        try
        {
            return aRandomRoom.get(vRandomNumber);
        }
        catch(IndexOutOfBoundsException pE)
        {
            vRandomNumber--;
            return aRandomRoom.get(vRandomNumber);
        }
    }
}
