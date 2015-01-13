package hearc.ch.starstrat.dataBase.Use;

import android.content.Context;

import java.util.ArrayList;
import java.util.List;

import hearc.ch.starstrat.dataBase.BDD.ElementStrategieBDD;
import hearc.ch.starstrat.dataBase.BDD.EventsBDD;
import hearc.ch.starstrat.dataBase.BDD.ImageBDD;
import hearc.ch.starstrat.dataBase.BDD.RaceBDD;
import hearc.ch.starstrat.dataBase.BDD.Race_entitiesBDD;
import hearc.ch.starstrat.dataBase.BDD.StrategiesBDD;
import hearc.ch.starstrat.dataBase.BDD.TypeBDD;
import hearc.ch.starstrat.dataBase.Remplissage.InsertRace;
import hearc.ch.starstrat.dataBase.Remplissage.InsertRaceEntities;
import hearc.ch.starstrat.dataBase.Remplissage.InsertType;
import hearc.ch.starstrat.dataBase.models.ElementStrategie;
import hearc.ch.starstrat.dataBase.models.Race;
import hearc.ch.starstrat.dataBase.models.Race_entities;
import hearc.ch.starstrat.dataBase.models.Strategies;
import hearc.ch.starstrat.dataBase.models.Type;
import hearc.ch.starstrat.objects.StrategyItem;
import hearc.ch.starstrat.objects.UnitItem;

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
    private ImageBDD image;
    private ElementStrategieBDD elementStrategie;

    private Context context;

    public UseBDD(Context context)
    {
        this.race = new RaceBDD(context);
        this.type = new TypeBDD(context);
        this.raceEntities = new Race_entitiesBDD(context);
        this.events = new EventsBDD(context);
        this.strats = new StrategiesBDD(context);
        this.image = new ImageBDD(context);
        this.elementStrategie = new ElementStrategieBDD(context);

        this.context = context;

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

        //TODO Image
        /*Image im = image.getImageWithID(1);
        //Toast.makeText(context, ""+im.getImage_Texte(), Toast.LENGTH_LONG).show();
        if(im==null)
            new InsertImages(image, context);*/

    }

    //Fonction pour ouvrir les tables
    private void open()
    {
        race.open();
        type.open();
        raceEntities.open();
        events.open();
        strats.open();
        image.open();
        elementStrategie.open();
    }

    //Fonction pour fermer les tables
    public void close()
    {
        race.close();
        type.close();
        raceEntities.close();
        events.close();
        strats.close();
        image.close();
        elementStrategie.close();
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


    public void addStrat(StrategyItem objetStrategie)
    {
        Strategies strategies = new Strategies();
        strategies.setDescription(objetStrategie.getDescription());
        strategies.setName(objetStrategie.getName());
        if(objetStrategie.getRace()==0)
            strategies.setId_race(3);
        else if(objetStrategie.getRace()==1)
            strategies.setId_race(2);
        else if(objetStrategie.getRace()==2)
            strategies.setId_race(1);

        strats.insertStrategies(strategies);

        //TODO a voir pour ameliorer la recuperation de l'id
        strategies = strats.getStrategiesWithName(objetStrategie.getName());

        int id = strategies.getId();

        List<UnitItem> list = objetStrategie.getListUnits(false);

        for(int i=0;i<list.size();i++)
        {
            ElementStrategie element = new ElementStrategie();
            element.setId_Strat(id);
            element.setMinute(list.get(i).getMinutes());
            element.setSecond(list.get(i).getSecondes());
            element.setVibrate(list.get(i).getVibrate());

            Race_entities entities = raceEntities.getRaceEntitiesWithName(list.get(i).getNom());
            element.setId_Race_Entities(entities.getId());

            elementStrategie.insertElement(element);
        }
    }

    public List<StrategyItem> getAllStrategie()
    {
        List<StrategyItem> listFinal = new ArrayList<StrategyItem>();

        List<Strategies> listStrats = strats.getAllStrategie();
        List<ElementStrategie> listElement = null;
        for(int i = 0;i<listStrats.size();i++)
        {
            listElement = elementStrategie.getListElementStrategieWithIDStrat(listStrats.get(i).getId());

            List<UnitItem> listUnit = new ArrayList<UnitItem>();
            for(int j=0;j<listElement.size();j++)
            {
                ElementStrategie el = listElement.get(i);
                Race_entities entities = raceEntities.getRaceEntitiesWithID(el.getId_Race_Entities());

                UnitItem item = new UnitItem(el.getId(),el.getMinute(),el.getSecond(),el.isVibrate(),entities.getName());
                listUnit.add(item);
            }

            listFinal.add(new StrategyItem());
            listFinal.get(listFinal.size()-1).setListUnits(listUnit);
        }
        
        return listFinal;
    }

}
