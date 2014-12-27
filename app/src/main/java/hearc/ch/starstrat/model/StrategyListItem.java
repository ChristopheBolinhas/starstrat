package hearc.ch.starstrat.model;

/**
 * Created by JuUsT on 26.12.2014.
 */
public class StrategyListItem {
    public final int raceIcon;
    public final String title;
    public final String description;
    public final int id;

    public StrategyListItem(int raceIcon, String title, String description, int id) {
        this.raceIcon = raceIcon;
        this.title = title;
        this.description = description;
        this.id = id;
    }

}
