package hearc.ch.starstrat;


import android.app.Fragment;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.Spinner;

import hearc.ch.starstrat.adapter.SpinnerUnitAdapter;


/**
 * A simple {@link Fragment} subclass.
 */
public class StrategieMakerFragment extends Fragment {

    String[] unitsList = {"ahah", "2eme"};
    Integer[] iconList = {R.drawable.ic_home_favs,R.drawable.ic_home_favs};
    public StrategieMakerFragment() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_strategie_maker, container, false);
    }
    public void onActivityCreated (Bundle savedInstanceState) {
        super.onActivityCreated(savedInstanceState);

        Spinner spinner = (Spinner) getActivity().findViewById(R.id.spinner_race);

        ArrayAdapter<CharSequence> adapter = ArrayAdapter.createFromResource(getView().getContext(),R.array.races_array, android.R.layout.simple_spinner_item);
        adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        spinner.setAdapter(adapter);

        Spinner spinnerUnits = (Spinner) getActivity().findViewById(R.id.spinner_unit_choice);
        spinnerUnits.setAdapter(new SpinnerUnitAdapter(getView().getContext(),R.layout.spinner_units_style,unitsList,iconList));


    }





}
