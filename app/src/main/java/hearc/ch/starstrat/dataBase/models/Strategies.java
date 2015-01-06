package hearc.ch.starstrat.dataBase.models;

/**
 * Created by Kevin on 16/12/2014.
 */
public class Strategies
{
    private int id;
    private int id_race;
    private String name;
    private String description;
    private String games_tried;
    private String games_won;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getId_race() {
        return id_race;
    }

    public void setId_race(int id_race) {
        this.id_race = id_race;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getGames_tried() {
        return games_tried;
    }

    public void setGames_tried(String games_tried) {
        this.games_tried = games_tried;
    }

    public String getGames_won() {
        return games_won;
    }

    public void setGames_won(String games_won) {
        this.games_won = games_won;
    }

    public String toString()
    {
        return "Strategie id : "+id;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }
}
