package hearc.ch.starstrat;


import android.app.Fragment;
import android.os.Bundle;
import android.util.TypedValue;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.NumberPicker;
import android.widget.Spinner;
import android.widget.TableLayout;
import android.widget.TableRow;
import android.widget.TableRow.LayoutParams;
import android.widget.TextView;

import java.util.ArrayList;
import java.util.List;

import hearc.ch.starstrat.adapter.SpinnerUnitAdapter;
import hearc.ch.starstrat.objects.UnitItem;


/**
 * A simple {@link Fragment} subclass.
 */
public class StrategieMakerFragment extends Fragment {

    String[] unitsList = {"ahah", "2eme"};
    Integer[] iconList = {R.drawable.ic_home_favs,R.drawable.ic_home_favs};
    private List<UnitItem> unitList;

    public StrategieMakerFragment() {
        unitList = new ArrayList<UnitItem>();
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


        Button buttonAddUnit = (Button) getActivity().findViewById(R.id.button_add_unit);
        buttonAddUnit.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Spinner spinnerUnits = (Spinner) getActivity().findViewById(R.id.spinner_unit_choice);
                SpinnerUnitAdapter spinnerUnitAdapter = (SpinnerUnitAdapter)spinnerUnits.getAdapter();
                int unitId = spinnerUnitAdapter.getSelectedUnitId(spinnerUnits.getSelectedItemPosition());

                int mMinutes = ((NumberPicker) getActivity().findViewById(R.id.picker_minutes)).getValue();
                int mSecondes = ((NumberPicker) getActivity().findViewById(R.id.picker_secondes)).getValue();

                addUnit(unitId,mMinutes,mSecondes);
            }
        });


        NumberPicker numberPickerMinutes = (NumberPicker) getActivity().findViewById(R.id.picker_minutes);
        numberPickerMinutes.setMaxValue(120);
        numberPickerMinutes.setMinValue(0);
        numberPickerMinutes.setWrapSelectorWheel(false);

        NumberPicker numberPickerSecondes = (NumberPicker) getActivity().findViewById(R.id.picker_secondes);
        numberPickerSecondes.setMaxValue(59);
        numberPickerSecondes.setMinValue(0);
        numberPickerSecondes.setWrapSelectorWheel(false);



    }

    private void addUnit(int unitId, int minutes, int secondes)
    {


        UnitItem unit = new UnitItem(unitId,minutes,secondes);
        unitList.add(unit);
        addUiUnit(unit);

        //newRow.setLayout
       //newRow.s
        //
        /*android:layout_height="60dp"
        android:padding="5dp"
        android:textAlignment="center"*/

    }

    private void addUiUnit(final UnitItem unit)
    {
        final float scale = getView().getContext().getResources().getDisplayMetrics().density;
        int hauteur = (int) TypedValue.applyDimension(TypedValue.COMPLEX_UNIT_DIP, 48, getResources().getDisplayMetrics());
        int padding = (int) TypedValue.applyDimension(TypedValue.COMPLEX_UNIT_DIP, 3, getResources().getDisplayMetrics());

        final TableLayout tableLayout = (TableLayout)getActivity().findViewById(R.id.table_units);
        TableRow newRow = new TableRow(getView().getContext());
        LayoutParams rowParams = new LayoutParams(ViewGroup.LayoutParams.MATCH_PARENT,hauteur);
        newRow.setLayoutParams(rowParams);
        newRow.setTextAlignment(View.TEXT_ALIGNMENT_CENTER);
        newRow.setPadding(padding,padding,padding,padding);
        TextView textView1 = new TextView(getView().getContext());
        textView1.setText(unit.getNom());
        textView1.setGravity(TextView.TEXT_ALIGNMENT_CENTER);
        textView1.setPadding(padding,padding,padding,padding);
        TextView textView2 = new TextView(getView().getContext());
        textView2.setText(unit.getMinutes() + " : " + unit.getSecondes());
        textView2.setGravity(TextView.TEXT_ALIGNMENT_CENTER);
        textView2.setPadding(padding,padding,padding,padding);
        Button buttonRemove = new Button(getView().getContext());
        buttonRemove.setText("x");
        buttonRemove.setBackgroundResource(R.drawable.button_stratmake_style_normal);
        buttonRemove.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                removeUnit(unit);
                final TableRow parent = (TableRow) view.getParent();
                tableLayout.removeView(parent);
            }
        });

        newRow.addView(textView1);
        newRow.addView(textView2);
        newRow.addView(buttonRemove);
        tableLayout.addView(newRow);


    }


    private void removeUnit(UnitItem unit)
    {
        unitList.remove(unit);
    }


    private void setControls()
    {

    }




}
