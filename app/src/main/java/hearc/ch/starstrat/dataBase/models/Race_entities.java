package hearc.ch.starstrat.dataBase.models;

/**
 * Created by Kevin on 16/12/2014.
 */
public class Race_entities
{
    private int id;
    private int id_races;
    private int id_type;
    private String name;
    private int time_creation;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getId_races() {
        return id_races;
    }

    public void setId_races(int id_races) {
        this.id_races = id_races;
    }

    public int getId_type() {
        return id_type;
    }

    public void setId_type(int id_type) {
        this.id_type = id_type;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getTime_creation() {
        return time_creation;
    }

    public void setTime_creation(int time_creation) {
        this.time_creation = time_creation;
    }
}
