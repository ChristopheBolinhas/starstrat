package hearc.ch.starstrat.dataBase.BDD;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.graphics.drawable.ColorDrawable;

import hearc.ch.starstrat.dataBase.Use.MaBaseSQLite;
import hearc.ch.starstrat.dataBase.models.Strategies;


/**
 * Created by Kevin on 16/12/2014.
 */
public class StrategiesBDD
{
    private static final int VERSION_BDD = 1;
    private static final String NOM_BDD = "StarStrat.db";

    private static final String TABLE_Strategies = "Strategies";

    private static final String COL_ID = "ID";
    private static final int NUM_COL_ID = 0;

    private static final String COL_ID_Race = "ID_Race";
    private static final int NUM_COL_ID_Race = 1;

    private static final String COL_Name = "Name";
    private static final int NUM_COL_Name = 2;

    private static final String COL_Game_Tried = "Game_Tried";
    private static final int NUM_COL_Game_Tried = 3;

    private static final String COL_Game_Won = "Game_Won";
    private static final int NUM_COL_Game_Won = 4;

    private static final String COL_Description = "Description";
    private static final int NUM_COL_Description = 5;

    private SQLiteDatabase bdd;

    private MaBaseSQLite maBaseSQLite;

    public StrategiesBDD(Context context)
    {
        maBaseSQLite = new MaBaseSQLite(context, NOM_BDD, null, VERSION_BDD);
    }

    public void open()
    {
        bdd = maBaseSQLite.getWritableDatabase();
    }

    public void close()
    {
        bdd.close();
    }

    public SQLiteDatabase getBDD()
    {
        return bdd;
    }

    public long insertStrategies(Strategies strat){
        //Création d'un ContentValues (fonctionne comme une HashMap)
        ContentValues values = new ContentValues();
        //on lui ajoute une valeur associé à une clé (qui est le nom de la colonne dans laquelle on veut mettre la valeur)
        values.put(COL_ID_Race, strat.getId_race());
        values.put(COL_Name, strat.getName());
        values.put(COL_Game_Tried, strat.getGames_tried());
        values.put(COL_Game_Won, strat.getGames_won());
        values.put(COL_Description, strat.getDescription());

        //on insère l'objet dans la BDD via le ContentValues
        return bdd.insert(TABLE_Strategies, null, values);
    }

    public int updateStrategies(int id, Strategies strat){
        //La mise à jour d'un livre dans la BDD fonctionne plus ou moins comme une insertion
        //il faut simple préciser quelle livre on doit mettre à jour grâce à l'ID
        ContentValues values = new ContentValues();
        values.put(COL_ID_Race, strat.getId_race());
        values.put(COL_Name, strat.getName());
        values.put(COL_Game_Tried, strat.getGames_tried());
        values.put(COL_Game_Won, strat.getGames_won());
        values.put(COL_Description, strat.getDescription());

        return bdd.update(TABLE_Strategies, values, COL_ID + " = " +id, null);
    }

    public int removeStrategiesWithID(int id)
    {
        return bdd.delete(TABLE_Strategies, COL_ID + " = " +id, null);
    }

    public Strategies getStrategiesWithName(String name)
    {
        Cursor c = bdd.query(TABLE_Strategies, new String[] {COL_ID, COL_ID_Race, COL_Name, COL_Game_Tried, COL_Game_Won, COL_Description}, COL_Name + " LIKE \"" + name +"\"", null, null, null, null);
        return cursorToStrategies(c);
    }

    private Strategies cursorToStrategies(Cursor c)
    {
        //si aucun élément n'a été retourné dans la requête, on renvoie null
        if (c.getCount() == 0)
            return null;

        //Sinon on se place sur le premier élément
        c.moveToFirst();
        //On créé un livre
        Strategies strat = new Strategies();
        //on lui affecte toutes les infos grâce aux infos contenues dans le Cursor
        strat.setId(c.getInt(NUM_COL_ID));
        strat.setId_race(c.getInt(NUM_COL_ID_Race));
        strat.setName(c.getString(NUM_COL_Name));
        strat.setGames_tried(c.getString(NUM_COL_Game_Tried));
        strat.setGames_won(c.getString(NUM_COL_Game_Won));
        strat.setDescription(c.getString(NUM_COL_Description));

        //On ferme le cursor
        c.close();

        //On retourne le livre
        return strat;
    }

}
