package hearc.ch.starstrat.model;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by JuUsT on 28.12.2014.
 */
public class StrategyItem {
    private String name;
    private String description;
    private List<StrategyListItem> listUnits;

    private int race; //0 - terran, 1 - protoss -, 2 - zerg, -1 - unset


    public StrategyItem(){
        race = -1;
        listUnits = new ArrayList<StrategyListItem>();
    }

    public StrategyItem(StrategyItem src)
    {

    }

    public int getRace()
    {
        return race;
    }

    public void setRace(int race)
    {
        this.race = race;
    }

    public int getListSize()
    {
        return listUnits.size();
    }




}
