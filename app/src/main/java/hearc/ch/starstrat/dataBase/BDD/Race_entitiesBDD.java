package hearc.ch.starstrat.dataBase.BDD;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;

import java.util.ArrayList;
import java.util.List;

import hearc.ch.starstrat.dataBase.Use.MaBaseSQLite;
import hearc.ch.starstrat.dataBase.models.Race_entities;

/**
 * Created by Kevin on 16/12/2014.
 */
public class Race_entitiesBDD
{

    private static final int VERSION_BDD = 1;
    private static final String NOM_BDD = "StarStrat.db";

    private static final String TABLE_Race_Entities = "race_Entities";

    private static final String COL_ID = "ID";
    private static final int NUM_COL_ID = 0;

    private static final String COL_ID_Race = "ID_Race";
    private static final int NUM_COL_ID_Race = 1;

    private static final String COL_ID_Type = "ID_Type";
    private static final int NUM_COL_ID_Type = 2;

    private static final String COL_Name = "name";
    private static final int NUM_COL_Name = 3;

    private static final String COL_Time_Creation = "Time_Creation";
    private static final int NUM_COL_Time_Creation = 4;

    private SQLiteDatabase bdd;

    private MaBaseSQLite maBaseSQLite;

    public Race_entitiesBDD(Context context)
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

    public long insertRaceEntities(Race_entities race)
    {
        //Création d'un ContentValues (fonctionne comme une HashMap)
        ContentValues values = new ContentValues();

        //on lui ajoute une valeur associé à une clé (qui est le nom de la colonne dans laquelle on veut mettre la valeur)
        values.put(COL_ID_Race, race.getId_races());
        values.put(COL_ID_Type, race.getId_type());
        values.put(COL_Name, race.getName());
        values.put(COL_Time_Creation, race.getTime_creation());

        //on insère l'objet dans la BDD via le ContentValues
        return bdd.insert(TABLE_Race_Entities, null, values);
    }

    public int updateRaceEntities(int id, Race_entities race)
    {
        //La mise à jour d'une Race entities dans la BDD fonctionne plus ou moins comme une insertion
        //il faut simple préciser quelle livre on doit mettre à jour grâce à l'ID
        ContentValues values = new ContentValues();

        values.put(COL_ID_Race, race.getId_races());
        values.put(COL_ID_Type, race.getId_type());
        values.put(COL_Name, race.getName());
        values.put(COL_Time_Creation, race.getTime_creation());

        return bdd.update(TABLE_Race_Entities, values, COL_ID + " = " +id, null);
    }

    public int removeRaceEntitiesWithID(int id)
    {
        //Suppression d'une Race entities de la BDD grâce à l'ID
        return bdd.delete(TABLE_Race_Entities, COL_ID + " = " +id, null);
    }

    public Race_entities getRaceEntitiesWithID(int id)
    {
        //Récupère dans un Cursor les valeur correspondant à une RaceEntities contenu dans la BDD (ici on sélectionne la RaceEntities grâce à son titre)
        Cursor c = bdd.query(TABLE_Race_Entities, new String[] {COL_ID, COL_ID_Race, COL_ID_Type,COL_Name,COL_Time_Creation}, COL_ID + "=" + id, null, null, null, null);
        return cursorToRaceEntities(c);
    }

    public List<Race_entities> getRaceEntitiesByRace(int id)
    {
        //Cursor c = bdd.query(TABLE_Race_Entities, new String[] {COL_ID, COL_ID_Race, COL_ID_Type,COL_Name,COL_Time_Creation}, COL_ID_Race + "=" + id+"\"" , null, null, null, null);
        Cursor c = bdd.rawQuery("SELECT "+COL_ID+", "+ COL_ID_Race+", "+ COL_ID_Type+", "+COL_Name+", "+COL_Time_Creation + " FROM "+TABLE_Race_Entities+" WHERE "+ COL_ID_Race + " = " + id , null );
        return cursorToListRaceEntities(c);
    }

    //Cette méthode permet de convertir un cursor en une Race_entities
    private Race_entities cursorToRaceEntities(Cursor c){
        //si aucun élément n'a été retourné dans la requête, on renvoie null
        if (c.getCount() == 0)
            return null;

        //Sinon on se place sur le premier élément
        c.moveToFirst();

        //On créé un Race_entities
        Race_entities race = new Race_entities();

        //on lui affecte toutes les infos grâce aux infos contenues dans le Cursor
        race.setId(c.getInt(NUM_COL_ID));
        race.setId_races(c.getInt(NUM_COL_ID_Race));
        race.setId_type(c.getInt(NUM_COL_ID_Type));
        race.setName(c.getString(NUM_COL_Name));
        race.setTime_creation(c.getInt(NUM_COL_Time_Creation));

        //On ferme le cursor
        c.close();

        //On retourne la Race_entities
        return race;
    }

    private List<Race_entities> cursorToListRaceEntities(Cursor c)
    {
        if (c.getCount() == 0)
            return null;

        ArrayList<Race_entities> list = new ArrayList<Race_entities>();


        c.moveToFirst();
        while(!c.isAfterLast())
        {
            Race_entities race = new Race_entities();

            race.setId(c.getInt(NUM_COL_ID));
            race.setId_races(c.getInt(NUM_COL_ID_Race));
            race.setId_type(c.getInt(NUM_COL_ID_Type));
            race.setName(c.getString(NUM_COL_Name));
            race.setTime_creation(c.getInt(NUM_COL_Time_Creation));

            list.add(race);
            c.moveToNext();
        }

        return list;
    }
}
