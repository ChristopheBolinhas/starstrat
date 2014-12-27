package hearc.ch.starstrat.dataBase.models;

/**
 * Created by Kevin on 25/11/2014.
 */
public class Race
{
    private int id;
    private String name;

    public Race()
    {}

    public Race(String n)
    {
        name = n;
    }

    public int getId()
    {
        return id;
    }

    public String getName()
    {
        return name;
    }

    public void setName(String n)
    {
        name = n;
    }

    public void setId(int i)
    {
        id = i;
    }

    public String toString()
    {
        return "Models : Race \nID : "+id+"\nName : "+name;
    }

}
