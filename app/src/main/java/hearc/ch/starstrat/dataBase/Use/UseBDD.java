package hearc.ch.starstrat.dataBase.Use;

import android.content.Context;
import android.graphics.drawable.Drawable;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import hearc.ch.starstrat.dataBase.BDD.ElementStrategieBDD;
import hearc.ch.starstrat.dataBase.BDD.EventsBDD;
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
    private ElementStrategieBDD elementStrategie;

    private Context context;

    public UseBDD(Context context)
    {
        this.race = new RaceBDD(context);
        this.type = new TypeBDD(context);
        this.raceEntities = new Race_entitiesBDD(context);
        this.events = new EventsBDD(context);
        this.strats = new StrategiesBDD(context);
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

    }

    public Context getContext()
    {
        return context;
    }

    //Fonction pour ouvrir les tables
    private void open()
    {
        race.open();
        type.open();
        raceEntities.open();
        events.open();
        strats.open();
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
        elementStrategie.close();
    }

    public Drawable getDrawable(Race_entities r)
    {
        try
        {
            return Drawable.createFromStream(context.getAssets().open(r.getPathImage()), null);
        } catch (IOException e)
        {
            e.printStackTrace();
        }
        return null;
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
        int idStrat = objetStrategie.getDbId();
        if(idStrat==-1)
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


            long l = strats.insertStrategies(strategies);


            int id = (int)l;

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
        else
        {
            Strategies strategie = strats.getStrategiesWithID(idStrat);
            strategie.setName(objetStrategie.getName());
            strategie.setId_race(objetStrategie.getRace());
            strategie.setDescription(objetStrategie.getDescription());

            strats.updateStrategies(idStrat,strategie);

            List<UnitItem> list = objetStrategie.getListUnits(false);
            List<ElementStrategie> listElementStrat = elementStrategie.getListElementStrategieWithIDStrat(idStrat);

            for(int i=0;i<list.size();i++)
            {
                boolean exist = false;
                for(int j=0;j<listElementStrat.size();j++)
                {
                    if(listElementStrat.get(j).getId()==list.get(i).getId())
                        exist = true;
                }
                UnitItem item = list.get(i);
                if(exist)
                {
                    ElementStrategie element = elementStrategie.getElementWithID(item.getId());

                    element.setMinute(item.getMinutes());
                    element.setSecond(item.getSecondes());
                    element.setVibrate(item.getVibrate());
                    Race_entities entities = raceEntities.getRaceEntitiesWithName(item.getNom());
                    element.setId_Race_Entities(entities.getId());

                    elementStrategie.updateElement(item.getId(),element);
                }
                else
                {
                    ElementStrategie element = new ElementStrategie();
                    element.setId_Strat(idStrat);
                    element.setMinute(item.getMinutes());
                    element.setSecond(item.getSecondes());
                    element.setVibrate(item.getVibrate());

                    Race_entities entities = raceEntities.getRaceEntitiesWithName(item.getNom());
                    element.setId_Race_Entities(entities.getId());

                    elementStrategie.insertElement(element);
                }
            }

        }

    }

    public List<StrategyItem> getAllStrategie()
    {
        List<StrategyItem> listFinal = new ArrayList<StrategyItem>();

        List<Strategies> listStrats = strats.getAllStrategie();
        List<ElementStrategie> listElement = new ArrayList<ElementStrategie>();
        if(listStrats != null) {
            for (int i = 0; i < listStrats.size(); i++) {
                listElement = elementStrategie.getListElementStrategieWithIDStrat(listStrats.get(i).getId());

                List<UnitItem> listUnit = new ArrayList<UnitItem>();
                for (int j = 0; j < listElement.size(); j++) {
                    ElementStrategie el = listElement.get(i);
                    Race_entities entities = raceEntities.getRaceEntitiesWithID(el.getId_Race_Entities());

                    UnitItem item = new UnitItem(el.getId(), el.getMinute(), el.getSecond(), el.isVibrate(), entities.getName());
                    item.setIcon(getDrawable(entities));
                    listUnit.add(item);
                }
                StrategyItem item = new StrategyItem();
                Strategies stratref = listStrats.get(i);
                item.setName(stratref.getName());
                item.setDescription(stratref.getDescription());
                item.setDbId(stratref.getId());
                item.setRace(convertRaceId(stratref.getId_race()));

                item.setListUnits(listUnit);
                listFinal.add(item);
            }
        }

        return listFinal;
    }

    private int convertRaceId(int id)
    {
        switch(id)
        {
            case 3://Terran
                return 0;
            case 2://Protoss
                return 1;
            case 1://zergs
                return 2;
        }
        return -1;
    }

}
