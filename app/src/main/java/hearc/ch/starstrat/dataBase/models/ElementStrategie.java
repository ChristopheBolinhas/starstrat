package hearc.ch.starstrat.dataBase.models;

/**
 * Created by Kevin on 06/01/2015.
 */
public class ElementStrategie
{

    private int id;
    private int id_Strat;
    private int id_Race_Entities;
    private int minute;
    private int second;
    private boolean vibrate;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getId_Strat() {
        return id_Strat;
    }

    public void setId_Strat(int id_Strat) {
        this.id_Strat = id_Strat;
    }

    public int getId_Race_Entities() {
        return id_Race_Entities;
    }

    public void setId_Race_Entities(int id_Race_Entities) {
        this.id_Race_Entities = id_Race_Entities;
    }

    public int getMinute() {
        return minute;
    }

    public void setMinute(int minute) {
        this.minute = minute;
    }

    public int getSecond() {
        return second;
    }

    public void setSecond(int second) {
        this.second = second;
    }

    public boolean isVibrate() {
        return vibrate;
    }

    public void setVibrate(int v){
        if(v==1)
            vibrate = true;
        else
            vibrate = false;
    }

    public void setVibrate(boolean v)
    {
        vibrate = v;
    }


    public int getVibrate(){
        if(vibrate)
            return 1;
        else
            return 0;
    }
}
