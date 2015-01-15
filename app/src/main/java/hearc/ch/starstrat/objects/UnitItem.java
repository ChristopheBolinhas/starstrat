package hearc.ch.starstrat.objects;

import android.graphics.drawable.Drawable;

/**
 * Created by JuUsT on 25.12.2014.
 */
public class UnitItem {
    private int id;
    private int minutes;
    private int secondes;
    private boolean vibrate;
    private String name;
    private Drawable icon;
    private int idDB = -1;

    public void setIcon(Drawable icon) {
        this.icon = icon;
    }

    public UnitItem(int id, int minutes, int secondes, boolean vibrate, String name)
    {
        this.id = id;
        this.minutes = minutes;
        this.secondes = secondes;
        this.vibrate = vibrate;
        this.name = name;
    }

    public Drawable getIcon() {
        return icon;
    }
    public int getIdDB() {
        return idDB;
    }

    public void setIdDB(int idDB) {
        this.idDB = idDB;
    }

    public int getId()
    {
        return id;
    }

    public String getNom()
    {
        return this.name;
    }

    public int getMinutes()
    {
        return minutes;
    }
    public int getSecondes()
    {
        return secondes;
    }
    public boolean getVibrate() { return vibrate;}

}
