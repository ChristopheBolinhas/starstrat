package hearc.ch.starstrat.dataBase.Remplissage;

import hearc.ch.starstrat.dataBase.BDD.TypeBDD;
import hearc.ch.starstrat.dataBase.models.Type;

/**
 * Created by Kevin on 23/12/2014.
 */
public class InsertType
{

    public InsertType(TypeBDD type)
    {
        //type.open();

        //Type Batiment
        Type bati = new Type();
        bati.setName("Building");
        type.insertType(bati);

        //Type Unitée
        Type unit = new Type();
        unit.setName("Unit");

        //Type Amélioration
        Type up = new Type();
        up.setName("Upgrade");
        type.insertType(up);

        //type.close();
    }
}
