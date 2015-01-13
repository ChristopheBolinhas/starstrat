package hearc.ch.starstrat.dataBase.Use;

/**
 * Created by Kevin on 25/11/2014.
 */

import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteDatabase.CursorFactory;
import android.database.sqlite.SQLiteOpenHelper;

public class MaBaseSQLite extends SQLiteOpenHelper {

    private static final String TABLE_Events = "events";
    private static final String COL_ID_EVENT = "ID";
    private static final String COL_ID_strategies_EVENT = "ID_strategies";
    private static final String COL_ID_Race_Entities_EVENT = "ID_Race_Entities";
    private static final String COL_Time_Start_EVENT = "Time_Start";
    private static final String COL_Comment_EVENT = "Comment";

    private static final String CREATE_EVENT = "CREATE TABLE "+ TABLE_Events + "("
            + COL_ID_EVENT + " INTEGER PRIMARY KEY AUTOINCREMENT, "
            + COL_ID_strategies_EVENT + " INTEGER,"
            + COL_ID_Race_Entities_EVENT + " INTEGER,"
            + COL_Time_Start_EVENT + " INTEGER,"
            + COL_Comment_EVENT + " TEXT);";


    private static final String TABLE_Race_Entities = "race_Entities";
    private static final String COL_ID_Race_Entities = "ID";
    private static final String COL_ID_Race_Race_Entities = "ID_Race";
    private static final String COL_ID_Type_Race_Entities = "ID_Type";
    private static final String COL_Name_Race_Entities = "name";
    private static final String COL_Time_Creation_Race_Entities = "Time_Creation";

    private static final String CREATE_Race_Entities = "CREATE TABLE "+ TABLE_Race_Entities + "("
            + COL_ID_Race_Entities + " INTEGER PRIMARY KEY AUTOINCREMENT, "
            + COL_ID_Race_Race_Entities + " INTEGER,"
            + COL_ID_Type_Race_Entities + " INTEGER,"
            + COL_Name_Race_Entities + " TEXT,"
            + COL_Time_Creation_Race_Entities + " INTEGER);";


    private static final String TABLE_RACE = "race";
    private static final String COL_ID_Race = "ID";
    private static final String COL_Name_Race = "Name";

    private static final String CREATE_Race = "CREATE TABLE "+ TABLE_RACE + "("
            + COL_ID_Race + " INTEGER PRIMARY KEY AUTOINCREMENT, "
            + COL_Name_Race + " TEXT);";


    private static final String TABLE_Strategies = "Strategies";
    private static final String COL_ID_Strategies = "ID";
    private static final String COL_ID_Race_Strategies = "ID_Race";
    private static final String COL_Name_Strategies = "Name";
    private static final String COL_Description_Strategies = "Description";
    private static final String COL_Game_Tried_Strategies = "Game_Tried";
    private static final String COL_Game_Won_Strategies = "Game_Won";

    private static final String CREATE_Strategies = "CREATE TABLE "+ TABLE_Strategies + "("
            + COL_ID_Strategies + " INTEGER PRIMARY KEY AUTOINCREMENT, "
            + COL_ID_Race_Strategies + " INTEGER,"
            + COL_Name_Strategies + " TEXT,"
            + COL_Description_Strategies + " TEXT,"
            + COL_Game_Tried_Strategies + " INTEGER,"
            + COL_Game_Won_Strategies + " INTEGER);";


    private static final String TABLE_TYPE = "type";
    private static final String COL_ID_Type = "ID";
    private static final String COL_NAME_Type = "Name";

    private static final String CREATE_Type = "CREATE TABLE "+ TABLE_TYPE + "("
            + COL_ID_Type + " INTEGER PRIMARY KEY AUTOINCREMENT, "
            + COL_NAME_Type + " TEXT);";


    private static final String TABLE_IMAGE = "images";
    private static final String COL_ID_Image = "ID";
    private static final String COL_ImageTexte_Image = "Image_Texte";
    private static final String COL_IDRaceEntities_Image = "ID_Race_Entities";

    private static final String CREATE_Image = "CREATE TABLE "+ TABLE_IMAGE + "("
            + COL_ID_Image + " INTEGER PRIMARY KEY AUTOINCREMENT, "
            + COL_ImageTexte_Image + " BLOB, "
            + COL_IDRaceEntities_Image + " INTEGER );";


    private static final String TABLE_ELEMENT_Strategie = "elementStrategie";
    private static final String COL_ID_Element = "ID";
    private static final String COL_ID_Strat_Element = "ID_Strategie";
    private static final String COL_ID_RaceEntities_Element = "ID_RaceEntities";
    private static final String COL_Minute_Element = "Minute";
    private static final String COL_Seconde_Element = "Seconde";
    private static final String COL_Vibrate_Element = "Vibrate";

    private static final String CREATE_Element_Strategie = "CREATE TABLE "+ TABLE_ELEMENT_Strategie + "("
            + COL_ID_Element + " INTEGER PRIMARY KEY AUTOINCREMENT, "
            + COL_ID_Strat_Element + " INTEGER, "
            + COL_ID_RaceEntities_Element + " INTEGER, "
            + COL_Minute_Element + " INTEGER, "
            + COL_Seconde_Element + " INTEGER, "
            + COL_Vibrate_Element + " INTEGER );";


    public MaBaseSQLite(Context context, String name, CursorFactory factory, int version) {
        super(context, name, factory, version);
    }

    @Override
    public void onCreate(SQLiteDatabase db)
    {

        db.execSQL(CREATE_EVENT);
        db.execSQL(CREATE_Race_Entities);
        db.execSQL(CREATE_Race);
        db.execSQL(CREATE_Strategies);
        db.execSQL(CREATE_Type);
        db.execSQL(CREATE_Image);
        db.execSQL(CREATE_Element_Strategie);

    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
        //On peut fait ce qu'on veut ici moi j'ai décidé de supprimer la table et de la recréer
        //comme ça lorsque je change la version les id repartent de 0
        //db.execSQL("DROP TABLE " + TABLE_LIVRES + ";");

        //db.execSQL("DROP TABLE " + TABLE_RACE + ";");

        onCreate(db);
    }

}