package hearc.ch.starstrat.dataBase.BDD;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;

import hearc.ch.starstrat.dataBase.Use.MaBaseSQLite;
import hearc.ch.starstrat.dataBase.models.Image;
import hearc.ch.starstrat.dataBase.models.Race;

/**
 * Created by Kevin on 06/01/2015.
 */
public class ImageBDD
{

    private static final int VERSION_BDD = 1;
    private static final String NOM_BDD = "StarStrat.db";

    private static final String TABLE_IMAGE = "images";

    private static final String COL_ID = "ID";
    private static final int NUM_COL_ID = 0;

    private static final String COL_ImageTexte = "Image_Texte";
    private static final int NUM_COL_ImageTexte = 1;

    private static final String COL_IDRaceEntities = "ID_Race_Entities";
    private static final int NUM_COL_IDRaceEntities = 2;

    private SQLiteDatabase bdd;

    private MaBaseSQLite maBaseSQLite;

    public ImageBDD(Context context)
    {
        maBaseSQLite = new MaBaseSQLite(context, NOM_BDD, null, VERSION_BDD);
    }

    public void open()
    {
        //on ouvre la BDD en écriture
        bdd = maBaseSQLite.getWritableDatabase();
    }

    public void close()
    {
        //on ferme l'accès à la BDD
        bdd.close();
    }

    public SQLiteDatabase getBDD()
    {
        return bdd;
    }

    public long insertImage(Image image)
    {
        //Création d'un ContentValues (fonctionne comme une HashMap)
        ContentValues values = new ContentValues();

        //on lui ajoute une valeur associé à une clé (qui est le nom de la colonne dans laquelle on veut mettre la valeur)
        values.put(COL_ImageTexte, image.getImage_Texte());
        values.put(COL_IDRaceEntities, image.getId_Race_Entities());

        //on insère l'objet dans la BDD via le ContentValues
        return bdd.insert(TABLE_IMAGE, null, values);
    }

    public int updateImage(int id, Image image)
    {
        //La mise à jour d'un Race dans la BDD fonctionne plus ou moins comme une insertion
        //il faut simple préciser quelle RAce on doit mettre à jour grâce à l'ID
        ContentValues values = new ContentValues();

        values.put(COL_ImageTexte, image.getImage_Texte());
        values.put(COL_IDRaceEntities, image.getId_Race_Entities());

        return bdd.update(TABLE_IMAGE, values, COL_ID + " = " +id, null);
    }

    public int removeImageWithID(int id)
    {
        //Suppression d'une Race de la BDD grâce à l'ID
        return bdd.delete(TABLE_IMAGE, COL_ID + " = " +id, null);
    }

    public Image getImageWithID(int id)
    {
        //Récupère dans un Cursor les valeur correspondant à un RACE contenu dans la BDD (ici on sélectionne la RAce grâce à son titre)
        Cursor c = bdd.query(TABLE_IMAGE, new String[] {COL_ID, COL_ImageTexte, COL_IDRaceEntities}, COL_ID + " = " + id, null, null, null, null);
        return cursorToImage(c);
    }

    private Image cursorToImage(Cursor c)
    {
        //si aucun élément n'a été retourné dans la requête, on renvoie null
        if (c.getCount() == 0)
            return null;

        //Sinon on se place sur le premier élément
        c.moveToFirst();
        //On créé une Race
        Image image = new Image();
        //on lui affecte toutes les infos grâce aux infos contenues dans le Cursor
        image.setId(c.getInt(NUM_COL_ID));
        image.setImage_Texte(c.getBlob(NUM_COL_ImageTexte));
        image.setId_Race_Entities(c.getInt(NUM_COL_IDRaceEntities));
        //On ferme le cursor
        c.close();

        //On retourne la Race
        return image;
    }


}
