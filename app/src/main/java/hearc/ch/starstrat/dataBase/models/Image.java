package hearc.ch.starstrat.dataBase.models;

/**
 * Created by Kevin on 06/01/2015.
 */
public class Image
{

    private int id;
    private byte[] image_Texte;
    private int id_Race_Entities;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public byte[] getImage_Texte() {
        return image_Texte;
    }

    public void setImage_Texte(byte[] image_Texte) {
        this.image_Texte = image_Texte;
    }

    public int getId_Race_Entities() {
        return id_Race_Entities;
    }

    public void setId_Race_Entities(int id_Race_Entities) {
        this.id_Race_Entities = id_Race_Entities;
    }
}
