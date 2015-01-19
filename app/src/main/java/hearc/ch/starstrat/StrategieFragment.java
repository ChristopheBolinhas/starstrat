package hearc.ch.starstrat;


import android.app.ListFragment;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ListView;

import java.util.ArrayList;
import java.util.List;

import hearc.ch.starstrat.adapter.StrategyListAdapter;
import hearc.ch.starstrat.dataBase.Use.UseBDD;
import hearc.ch.starstrat.model.StrategyListItem;
import hearc.ch.starstrat.objects.StrategyItem;



public class StrategieFragment extends ListFragment {

    private List<StrategyListItem> mItems;

    /*@Override
    public void onActivityCreated (Bundle savedInstanceState) {
        super.onActivityCreated(savedInstanceState);




    }*/







    //Instance du fragment
    public static StrategieFragment newInstance() {
        StrategieFragment fragment = new StrategieFragment();
        //fragment.bdd = bdd;
        return fragment;
    }

    public StrategieFragment() {

    }





    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        //On mets à jour la liste des stratégies
        updateList();
    }

    @Override
    public void onViewCreated(View view, Bundle savedInstanceState)
    {
        super.onViewCreated(view, savedInstanceState);

        getListView().setDivider(null);

    }

    @Override
    public void onListItemClick(ListView l, View v, int position, long id)
    {
        /*StrategyListItem item = mItems.get(position);
        if(position == 0)
        {

        }
        else
        {


        }*/




    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_strategie, container, false);
    }


    public void updateList() {

        mItems = new ArrayList<StrategyListItem>();
        mItems.add(new StrategyListItem(R.drawable.ic_add,"Nouvelle stratégie", "Composer une stratégie", -1));
        UseBDD bdd =((MainActivity)getActivity()).getDBInstance();
        if(bdd != null) {
            for (StrategyItem item : bdd.getAllStrategie()) {
                int icon;
                switch (item.getRace()) {
                    case 0:
                    default:
                        icon = R.drawable.ic_terran;
                        break;
                    case 1:
                        icon = R.drawable.ic_protoss;
                        break;
                    case 2:
                        icon = R.drawable.ic_zerg;
                        break;

                }
                mItems.add(new StrategyListItem(icon, item));
                //On ajoute chaque stratégie à la liste avec l'icone correspondant
            }
        }

        setListAdapter(new StrategyListAdapter(getActivity(),mItems));

    }
}
