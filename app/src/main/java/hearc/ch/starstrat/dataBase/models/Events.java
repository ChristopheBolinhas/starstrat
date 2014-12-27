package hearc.ch.starstrat.dataBase.models;

/**
 * Created by Kevin on 16/12/2014.
 */
public class Events
{

    private int id;
    private int id_strategies;
    private int id_race_entities;
    private int time_Start;
    private String comment;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getId_strategies() {
        return id_strategies;
    }

    public void setId_strategies(int id_strategies) {
        this.id_strategies = id_strategies;
    }

    public int getId_race_entities() {
        return id_race_entities;
    }

    public void setId_race_entities(int id_race_entities) {
        this.id_race_entities = id_race_entities;
    }

    public int getTime_Start() {
        return time_Start;
    }

    public void setTime_Start(int time_Start) {
        this.time_Start = time_Start;
    }

    public String getComment() {
        return comment;
    }

    public void setComment(String comment) {
        this.comment = comment;
    }
}
