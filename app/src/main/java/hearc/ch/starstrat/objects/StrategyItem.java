package hearc.ch.starstrat.objects;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

import hearc.ch.starstrat.comparators.UnitItemComparator;
import hearc.ch.starstrat.dataBase.Use.UseBDD;

/**
 * Created by JuUsT on 28.12.2014.
 */
public class StrategyItem {
    private String name;
    private String description;
    //private List<StrategyListItem> listItems;
    private List<UnitItem> listUnits;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public List<UnitItem> getListUnits() {
        return listUnits;
    }

    public void setListUnits(List<UnitItem> listUnits) {
        this.listUnits = listUnits;
    }

    private int race; //0 - terran, 1 - protoss -, 2 - zerg, -1 - unset


    public StrategyItem(){
        race = -1;
        listUnits = new ArrayList<UnitItem>();
    }

    public StrategyItem(StrategyItem src)
    {
        this.name = src.name;
        this.description = src.description;
        this.listUnits = new ArrayList<UnitItem>();
        for(UnitItem item : src.listUnits)
        {
            this.listUnits.add(item);
        }
    }

    public void addItem(String nom, int id, int minutes, int secondes, boolean vibrate, UseBDD useBDD)
    {
        listUnits.add(new UnitItem(id,minutes,secondes,vibrate,nom));
        sortList();
    }

    private void sortList()
    {
        if(listUnits != null)
        {
            Collections.sort(listUnits,new UnitItemComparator());
        }
    }


    public void loadFromDB(UseBDD useBDD)
    {
        //TODO
    }

    public void saveToDB(UseBDD useBDD)
    {
        //TODO
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
