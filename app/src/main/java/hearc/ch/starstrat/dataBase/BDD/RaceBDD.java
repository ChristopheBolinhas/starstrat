package hearc.ch.starstrat.dataBase.BDD;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;

import hearc.ch.starstrat.dataBase.Use.MaBaseSQLite;
import hearc.ch.starstrat.dataBase.models.Race;


/**
 * Created by Kevin on 16/12/2014.
 */
public class RaceBDD
{
    private static final int VERSION_BDD = 1;
    private static final String NOM_BDD = "StarStrat.db";

    private static final String TABLE_RACE = "race";

    private static final String COL_ID = "ID";
    private static final int NUM_COL_ID = 0;

    private static final String COL_Name = "Name";
    private static final int NUM_COL_Name = 1;

    private SQLiteDatabase bdd;

    private MaBaseSQLite maBaseSQLite;

    public RaceBDD(Context context)
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

    public long insertRace(Race race)
    {
        //Création d'un ContentValues (fonctionne comme une HashMap)
        ContentValues values = new ContentValues();

        //on lui ajoute une valeur associé à une clé (qui est le nom de la colonne dans laquelle on veut mettre la valeur)
        values.put(COL_Name, race.getName());

        //on insère l'objet dans la BDD via le ContentValues
        return bdd.insert(TABLE_RACE, null, values);
    }

    public int updateRace(int id, Race race)
    {
        //La mise à jour d'un Race dans la BDD fonctionne plus ou moins comme une insertion
        //il faut simple préciser quelle RAce on doit mettre à jour grâce à l'ID
        ContentValues values = new ContentValues();
        values.put(COL_Name, race.getName());
        return bdd.update(TABLE_RACE, values, COL_ID + " = " +id, null);
    }


    public int removeRaceWithID(int id)
    {
        //Suppression d'une Race de la BDD grâce à l'ID
        return bdd.delete(TABLE_RACE, COL_ID + " = " +id, null);
    }

    public Race getRaceWithID(int id)
    {
        //Récupère dans un Cursor les valeur correspondant à un RACE contenu dans la BDD (ici on sélectionne la RAce grâce à son titre)
        Cursor c = bdd.query(TABLE_RACE, new String[] {COL_ID, COL_Name}, COL_ID + " = " + id, null, null, null, null);
        return cursorToRace(c);
    }

    public Race getRaceWithName(String n)
    {
        //Récupère dans un Cursor les valeur correspondant à un RACE contenu dans la BDD (ici on sélectionne la RAce grâce à son titre)
        Cursor c = bdd.query(TABLE_RACE, new String[] {COL_ID, COL_Name}, COL_Name + " LIKE \"" + n +"\"", null, null, null, null);
        return cursorToRace(c);
    }


    //Cette méthode permet de convertir un cursor en une Race
    private Race cursorToRace(Cursor c)
        {
        //si aucun élément n'a été retourné dans la requête, on renvoie null
        if (c.getCount() == 0)
            return null;

        //Sinon on se place sur le premier élément
        c.moveToFirst();
        //On créé une Race
        Race race = new Race();
        //on lui affecte toutes les infos grâce aux infos contenues dans le Cursor
        race.setId(c.getInt(NUM_COL_ID));
        race.setName(c.getString(NUM_COL_Name));
        //On ferme le cursor
        c.close();

        //On retourne la Race
        return race;
    }

}
