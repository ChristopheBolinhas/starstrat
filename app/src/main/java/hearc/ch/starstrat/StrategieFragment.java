package hearc.ch.starstrat;


import android.app.ListFragment;
import android.content.Context;
import android.graphics.drawable.Drawable;
import android.os.Bundle;
import android.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ImageView;
import android.widget.ListView;
import android.widget.TextView;
import android.widget.Toast;

import java.util.ArrayList;
import java.util.List;

import hearc.ch.starstrat.adapter.StrategyListAdapter;
import hearc.ch.starstrat.model.StrategyListItem;


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
        mItems = new ArrayList<StrategyListItem>();

        mItems.add(new StrategyListItem(R.drawable.ic_zerg,"Strat 1", "Yolo strat",0));
        mItems.add(new StrategyListItem(R.drawable.ic_protoss,"Strat 2", "Yolo strat 2",1));

        setListAdapter(new StrategyListAdapter(getActivity(),mItems));
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
        Toast.makeText(getActivity(),item.title,Toast.LENGTH_LONG).show();


    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_strategie, container, false);
    }


}
