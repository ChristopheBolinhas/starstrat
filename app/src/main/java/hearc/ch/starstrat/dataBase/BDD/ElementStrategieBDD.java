package hearc.ch.starstrat.dataBase.BDD;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.sax.ElementListener;

import java.util.ArrayList;
import java.util.List;

import hearc.ch.starstrat.dataBase.Use.MaBaseSQLite;
import hearc.ch.starstrat.dataBase.models.ElementStrategie;
import hearc.ch.starstrat.dataBase.models.Race;
import hearc.ch.starstrat.dataBase.models.Race_entities;

/**
 * Created by Kevin on 06/01/2015.
 */
public class ElementStrategieBDD
{
    private static final int VERSION_BDD = 1;
    private static final String NOM_BDD = "StarStrat.db";

    private static final String TABLE_ElementStrategie = "elementStrategie";

    private static final String COL_ID = "ID";
    private static final int NUM_COL_ID = 0;

    private static final String COL_ID_Strat = "ID_Strategie";
    private static final int NUM_COL_ID_Strat = 1;

    private static final String COL_ID_RaceEntities = "ID_RaceEntities";
    private static final int NUM_COL_ID_RaceEntities = 2;

    private static final String COL_Minute = "Minute";
    private static final int NUM_COL_Minute = 3;

    private static final String COL_Seconde = "Seconde";
    private static final int NUM_COL_Seconde = 4;

    private static final String COL_Vibrate = "Vibrate";
    private static final int NUM_COL_Vibrate = 5;

    private SQLiteDatabase bdd;

    private MaBaseSQLite maBaseSQLite;

    public ElementStrategieBDD(Context context)
    {
        //On créer la BDD et sa table
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

    public long insertElement(ElementStrategie element)
    {
        //Création d'un ContentValues (fonctionne comme une HashMap)
        ContentValues values = new ContentValues();

        //on lui ajoute une valeur associé à une clé (qui est le nom de la colonne dans laquelle on veut mettre la valeur)
        values.put(COL_ID_Strat, element.getId_Strat());
        values.put(COL_ID_RaceEntities, element.getId_Race_Entities());
        values.put(COL_Minute, element.getMinute());
        values.put(COL_Seconde, element.getSecond());
        values.put(COL_Vibrate, element.getVibrate());

        //on insère l'objet dans la BDD via le ContentValues
        return bdd.insert(TABLE_ElementStrategie, null, values);
    }

    public int updateElement(int id, ElementStrategie element)
    {
        //La mise à jour d'un Race dans la BDD fonctionne plus ou moins comme une insertion
        //il faut simple préciser quelle RAce on doit mettre à jour grâce à l'ID
        ContentValues values = new ContentValues();
        values.put(COL_ID_Strat, element.getId_Strat());
        values.put(COL_ID_RaceEntities, element.getId_Race_Entities());
        values.put(COL_Minute, element.getMinute());
        values.put(COL_Seconde, element.getSecond());
        values.put(COL_Vibrate, element.getVibrate());

        return bdd.update(TABLE_ElementStrategie, values, COL_ID + " = " +id, null);
    }

    public int removeElementWithID(int id)
    {
        //Suppression d'une Race de la BDD grâce à l'ID
        return bdd.delete(TABLE_ElementStrategie, COL_ID + " = " +id, null);
    }

    public ElementStrategie getElementWithID(int id)
    {
        //Récupère dans un Cursor les valeur correspondant à un RACE contenu dans la BDD (ici on sélectionne la RAce grâce à son titre)
        Cursor c = bdd.query(TABLE_ElementStrategie, new String[] {COL_ID, COL_ID_Strat,COL_ID_RaceEntities,COL_Minute,COL_Seconde,COL_Vibrate}, COL_ID + " = " + id, null, null, null, null);
        return cursorToElement(c);
    }

    public List<ElementStrategie> getListElementStrategieWithIDStrat(int id)
    {
        Cursor c = bdd.query(TABLE_ElementStrategie, new String[] {COL_ID, COL_ID_Strat,COL_ID_RaceEntities,COL_Minute,COL_Seconde,COL_Vibrate}, COL_ID_Strat + " = " + id, null, null, null, null);
        return cursorToListElementStrategie(c);
    }

    private ElementStrategie cursorToElement(Cursor c)
    {
        //si aucun élément n'a été retourné dans la requête, on renvoie null
        if (c.getCount() == 0)
            return null;

        //Sinon on se place sur le premier élément
        c.moveToFirst();
        //On créé une Race
        ElementStrategie element = new ElementStrategie();
        //on lui affecte toutes les infos grâce aux infos contenues dans le Cursor
        element.setId(c.getInt(NUM_COL_ID));
        element.setId_Strat((c.getInt(NUM_COL_ID_Strat)));
        element.setId_Race_Entities((c.getInt(NUM_COL_ID_RaceEntities)));
        element.setMinute((c.getInt(NUM_COL_Minute)));
        element.setSecond((c.getInt(NUM_COL_Seconde)));
        element.setVibrate((c.getInt(NUM_COL_Vibrate)));
        element.setId_Strat((c.getInt(NUM_COL_ID_Strat)));

        //On ferme le cursor
        c.close();

        //On retourne la Race
        return element;
    }

    private List<ElementStrategie> cursorToListElementStrategie(Cursor c)
    {
        if (c.getCount() == 0)
            return null;

        ArrayList<ElementStrategie> list = new ArrayList<ElementStrategie>();


        c.moveToFirst();
        while(!c.isAfterLast())
        {
            ElementStrategie element = new ElementStrategie();

            element.setId(c.getInt(NUM_COL_ID));
            element.setId_Strat(c.getInt(NUM_COL_ID_Strat));
            element.setId_Race_Entities(c.getInt(NUM_COL_ID_RaceEntities));
            element.setMinute(c.getInt(NUM_COL_Minute));
            element.setSecond(c.getInt(NUM_COL_Seconde));
            element.setVibrate(c.getInt(NUM_COL_Vibrate));

            list.add(element);
            c.moveToNext();
        }

        return list;
    }

}
