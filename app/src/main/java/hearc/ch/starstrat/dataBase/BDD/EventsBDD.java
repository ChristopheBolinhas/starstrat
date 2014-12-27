package hearc.ch.starstrat.dataBase.BDD;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;

import hearc.ch.starstrat.dataBase.Use.MaBaseSQLite;
import hearc.ch.starstrat.dataBase.models.Events;


/**
 * Created by Kevin on 16/12/2014.
 */
public class EventsBDD
{
    private static final int VERSION_BDD = 1;
    private static final String NOM_BDD = "StarStrat.db";

    private static final String TABLE_Events = "events";

    private static final String COL_ID = "ID";
    private static final int NUM_COL_ID = 0;

    private static final String COL_ID_strategies = "ID_strategies";
    private static final int NUM_COL_ID_Strategie = 1;

    private static final String COL_ID_Race_Entities = "ID_Race_Entities";
    private static final int NUM_COL_ID_Race_Entities = 2;

    private static final String COL_Time_Start = "Time_Start";
    private static final int NUM_COL_Time_Start = 3;

    private static final String COL_Comment = "Comment";
    private static final int NUM_COL_Comment = 4;

    private SQLiteDatabase bdd;

    private MaBaseSQLite maBaseSQLite;

    public EventsBDD(Context context)
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

    public long insertEvents(Events event)
    {
        //Création d'un ContentValues (fonctionne comme une HashMap)
        ContentValues values = new ContentValues();
        //on lui ajoute une valeur associé à une clé (qui est le nom de la colonne dans laquelle on veut mettre la valeur)

        values.put(COL_ID_strategies, event.getId_strategies());
        values.put(COL_ID_Race_Entities, event.getId_race_entities());
        values.put(COL_Time_Start, event.getTime_Start());
        values.put(COL_Comment, event.getComment());

        //on insère l'objet dans la BDD via le ContentValues
        return bdd.insert(TABLE_Events, null, values);
    }

    public int removeEventWithID(int id)
    {
        //Suppression d'un Event de la BDD grâce à l'ID
        return bdd.delete(TABLE_Events, COL_ID + " = " +id, null);
    }

    public Events getEventWithTitre(int id)
    {
        //Récupère dans un Cursor les valeur correspondant à un livre contenu dans la BDD (ici on sélectionne le livre grâce à son titre)
        Cursor c = bdd.query(TABLE_Events, new String[] {COL_ID, COL_ID_strategies, COL_ID_Race_Entities,COL_Time_Start,COL_Comment}, COL_ID + "=" + id +"\"", null, null, null, null);
        return cursorToEvent(c);
    }

    private Events cursorToEvent(Cursor c)
    {
        //si aucun élément n'a été retourné dans la requête, on renvoie null
        if (c.getCount() == 0)
            return null;

        //Sinon on se place sur le premier élément
        c.moveToFirst();
        //On créé un event
        Events event = new Events();
        //on lui affecte toutes les infos grâce aux infos contenues dans le Cursor
        event.setId(c.getInt(NUM_COL_ID));
        event.setId_strategies(c.getInt(NUM_COL_ID_Strategie));
        event.setId_race_entities(c.getInt(NUM_COL_ID_Race_Entities));
        event.setTime_Start(c.getInt(NUM_COL_Time_Start));
        event.setComment(c.getString(NUM_COL_Comment));

        //On ferme le cursor
        c.close();

        //On retourne le livre
        return event;
    }

}
