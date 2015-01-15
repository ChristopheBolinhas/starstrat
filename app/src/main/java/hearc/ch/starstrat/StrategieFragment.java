package hearc.ch.starstrat;


import android.app.Fragment;
import android.app.ListFragment;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ListView;
import android.widget.Toast;

import java.util.ArrayList;
import java.util.List;

import hearc.ch.starstrat.adapter.StrategyListAdapter;
import hearc.ch.starstrat.dataBase.Use.UseBDD;
import hearc.ch.starstrat.model.StrategyListItem;
import hearc.ch.starstrat.objects.StrategyItem;


/**
 * A simple {@link Fragment} subclass.
 * Use the {@link StrategieFragment#newInstance} factory method to
 * create an instance of this fragment.
 */
public class StrategieFragment extends ListFragment {
    // TODO: Rename parameter arguments, choose names that match
    // the fragment initialization parameters, e.g. ARG_ITEM_NUMBER
    private static final String ARG_PARAM1 = "param1";
    private static final String ARG_PARAM2 = "param2";

    // TODO: Rename and change types of parameters
    private String mParam1;
    private String mParam2;

    private UseBDD bdd;

    private List<StrategyListItem> mItems;

    /*@Override
    public void onActivityCreated (Bundle savedInstanceState) {
        super.onActivityCreated(savedInstanceState);




    }*/



    /**
     * Use this factory method to create a new instance of
     * this fragment using the provided parameters.
     *
     * @param param1 Parameter 1.
     * @param param2 Parameter 2.
     * @return A new instance of fragment StrategieFragment.
     */
    // TODO: Rename and change types and number of parameters
    public static StrategieFragment newInstance(String param1, String param2) {
        StrategieFragment fragment = new StrategieFragment();
        Bundle args = new Bundle();

        args.putString(ARG_PARAM1, param1);
        args.putString(ARG_PARAM2, param2);
        fragment.setArguments(args);
        return fragment;
    }


    public static StrategieFragment newInstance(UseBDD bdd) {
        StrategieFragment fragment = new StrategieFragment();
        //fragment.bdd = bdd;
        return fragment;
    }

    public StrategieFragment() {
        // Required empty public constructor
    }





    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        /*if (getArguments() != null) {
            mParam1 = getArguments().getString(ARG_PARAM1);
            mParam2 = getArguments().getString(ARG_PARAM2);
        }*/
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
        StrategyListItem item = mItems.get(position);
        if(position == 0)
        {

        }
        else
        {
            //TODO LancerStrategie

        }


        Toast.makeText(getActivity(),item.title,Toast.LENGTH_LONG).show();


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
        UseBDD bdd1 =((MainActivity)getActivity()).getDBInstance();

        for(StrategyItem item : bdd1.getAllStrategie()) {
            int icon;
            switch(item.getRace())
            {
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
            //Toast.makeText(getActivity(),item.getDescription(),Toast.LENGTH_LONG).show();
        }

        setListAdapter(new StrategyListAdapter(getActivity(),mItems));

    }
}
