package hearc.ch.starstrat.objects;

/**
 * Created by JuUsT on 25.12.2014.
 */
public class UnitItem {
    private int id;
    private int minutes;
    private int secondes;

    public UnitItem(int id, int minutes, int secondes)
    {
        this.id = id;
        this.minutes = minutes;
        this.secondes = secondes;
    }


    public int getId()
    {
        return id;
    }

    public String getNom()
    {
        //TODO : Rajouter requete en fonction de valeur dans la bdd
        return "todo";
    }

    public int getMinutes()
    {
        return minutes;
    }
    public int getSecondes()
    {
        return secondes;
    }


}
