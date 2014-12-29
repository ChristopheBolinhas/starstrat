package hearc.ch.starstrat.comparators;

import java.util.Comparator;

import hearc.ch.starstrat.objects.UnitItem;

/**
 * Created by JuUsT on 28.12.2014.
 */
public class UnitItemComparator implements Comparator<UnitItem> {
    @Override
    public int compare(UnitItem unitItem, UnitItem unitItem2) {

        int item1 = unitItem.getMinutes()*100 + unitItem.getSecondes();
        int item2 = unitItem2.getMinutes()*100 + unitItem2.getSecondes();

        return -compare(item1,item2);
    }

    private int compare(int a, int b)
    {
        return a < b ? -1 : a > b ? 1 : 0;

    }
}
