package hearc.ch.starstrat.dataBase.BDD;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;

import hearc.ch.starstrat.dataBase.Use.MaBaseSQLite;
import hearc.ch.starstrat.dataBase.models.Type;


/**
 * Created by Kevin on 22/12/2014.
 */
public class TypeBDD {

    private static final int VERSION_BDD = 1;
    private static final String NOM_BDD = "StarStrat.db";

    private static final String TABLE_TYPE = "type";
    private static final String COL_ID = "ID";
    private static final String COL_NAME = "Name";
    private static final int NUM_COL_ID = 0;
    private static final int NUM_COL_NAME = 1;


    private SQLiteDatabase bdd;

    private MaBaseSQLite maBaseSQLite;

    public TypeBDD(Context context)
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

    public long insertType(Type type)
    {
        //Création d'un ContentValues (fonctionne comme une HashMap)
        ContentValues values = new ContentValues();
        //on lui ajoute une valeur associé à une clé (qui est le nom de la colonne dans laquelle on veut mettre la valeur)
        values.put(COL_NAME, type.getName());
        //on insère l'objet dans la BDD via le ContentValues
        return bdd.insert(TABLE_TYPE, null, values);
    }

    public int updateType(int id, Type type)
    {
        ContentValues values = new ContentValues();
        values.put(COL_NAME, type.getName());
        return bdd.update(TABLE_TYPE, values, COL_ID + " = " +id, null);
    }

    public int removeTypeWithID(int id)
    {
        return bdd.delete(TABLE_TYPE, COL_ID + " = " +id, null);
    }

    public Type getTypeWithID(int id)
    {
        Cursor c = bdd.query(TABLE_TYPE, new String[] {COL_ID, COL_NAME}, COL_ID + " = " + id , null, null, null, null);
        return cursorToType(c);
    }

    //Cette méthode permet de convertir un cursor en un type
    private Type cursorToType(Cursor c)
    {
        //si aucun élément n'a été retourné dans la requête, on renvoie null
        if (c.getCount() == 0)
            return null;

        //Sinon on se place sur le premier élément
        c.moveToFirst();
        //On créé un Type
        Type type = new Type();
        //on lui affecte toutes les infos grâce aux infos contenues dans le Cursor
        type.setId(c.getInt(NUM_COL_ID));
        type.setName(c.getString(NUM_COL_NAME));
        //On ferme le cursor
        c.close();

        //On retourne le Type
        return type;
    }

}
