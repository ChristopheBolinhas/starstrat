package hearc.ch.starstrat.model;

import hearc.ch.starstrat.objects.StrategyItem;

/**
 * Created by JuUsT on 26.12.2014.
 */
public class StrategyListItem{
    public final int raceIcon;
    public final String title;
    public final String description;
    public final int id;
    public final StrategyItem item;


    public StrategyListItem(int raceIcon, String title, String description, int id) {
        this.raceIcon = raceIcon;
        this.title = title;
        this.description = description;
        this.id = id;
        this.item = null;
    }

    public StrategyListItem(int raceIcon, StrategyItem item) {

        this.raceIcon = raceIcon;
        this.title = item.getName();
        this.description = item.getDescription();
        this.id = item.getDbId();
        this.item = item;
    }

    public StrategyItem getItem()
    {
        return this.item;
    }
}
