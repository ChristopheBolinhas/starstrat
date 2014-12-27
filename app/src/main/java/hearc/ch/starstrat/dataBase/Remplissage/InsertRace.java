package hearc.ch.starstrat.dataBase.Remplissage;

import hearc.ch.starstrat.dataBase.BDD.RaceBDD;
import hearc.ch.starstrat.dataBase.models.Race;

/**
 * Created by Kevin on 23/12/2014.
 */
public class InsertRace
{

    public InsertRace(RaceBDD race)
    {
        //race.open();

        //Race Zerg
        Race zerg = new Race();
        zerg.setName("Zerg");
        race.insertRace(zerg);

        //Race Protoss
        Race protoss = new Race("Protoss");
        protoss.setName("Protoss");
        race.insertRace(protoss);

        //Race terran
        Race terran = new Race("Terran");
        terran.setName("Terran");
        race.insertRace(terran);

        //race.close();
    }
}
