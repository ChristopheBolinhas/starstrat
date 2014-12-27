package hearc.ch.starstrat.dataBase.Use;

import android.content.Context;
import java.util.List;
import hearc.ch.starstrat.dataBase.BDD.EventsBDD;
import hearc.ch.starstrat.dataBase.BDD.RaceBDD;
import hearc.ch.starstrat.dataBase.BDD.Race_entitiesBDD;
import hearc.ch.starstrat.dataBase.BDD.StrategiesBDD;
import hearc.ch.starstrat.dataBase.BDD.TypeBDD;
import hearc.ch.starstrat.dataBase.Remplissage.InsertRace;
import hearc.ch.starstrat.dataBase.Remplissage.InsertRaceEntities;
import hearc.ch.starstrat.dataBase.Remplissage.InsertType;
import hearc.ch.starstrat.dataBase.models.Race;
import hearc.ch.starstrat.dataBase.models.Race_entities;
import hearc.ch.starstrat.dataBase.models.Type;

/**
 * Created by Kevin on 25/12/2014.
 */
public class UseBDD
{

    private RaceBDD race;
    private TypeBDD type;
    private Race_entitiesBDD raceEntities;
    private EventsBDD events;
    private StrategiesBDD strats;


    public UseBDD(Context context)
    {
        this.race = new RaceBDD(context);
        this.type = new TypeBDD(context);
        this.raceEntities = new Race_entitiesBDD(context);
        this.events = new EventsBDD(context);
        this.strats = new StrategiesBDD(context);

        open();
        init();
    }

    //Fonction d'initialisation de la Base de donnée
    private void init()
    {
        Race r = race.getRaceWithID(1);
        if(r==null)
            new InsertRace(race);

        Type t = type.getTypeWithID(1);
        if(t==null)
            new InsertType(type);

        Race_entities re = raceEntities.getRaceEntitiesWithID(1);
        if(re==null)
            new InsertRaceEntities(raceEntities);
    }

    //Fonction pour ouvrir les tables
    private void open()
    {
        race.open();
        type.open();
        raceEntities.open();
        events.open();
        strats.open();
    }

    //Fonction pour fermer les tables
    public void close()
    {
        race.close();
        type.close();
        raceEntities.close();
        events.close();
        strats.close();
    }


    public List<Race_entities> getAllUnitTerran()
    {
        Race r = race.getRaceWithName("terran");

        return raceEntities.getRaceEntitiesByRace(r.getId());
    }

    public List<Race_entities> getAllUnitProtoss()
    {
        Race r = race.getRaceWithName("protoss");

        return raceEntities.getRaceEntitiesByRace(r.getId());
    }

    public List<Race_entities> getAllUnitZerg()
    {
        Race r = race.getRaceWithName("zerg");

        return raceEntities.getRaceEntitiesByRace(r.getId());
    }



}
