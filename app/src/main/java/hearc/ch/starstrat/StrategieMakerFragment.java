package hearc.ch.starstrat;


import android.app.AlertDialog;
import android.app.Fragment;
import android.content.DialogInterface;
import android.os.Bundle;
import android.util.TypedValue;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.Window;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.NumberPicker;
import android.widget.Spinner;
import android.widget.TableLayout;
import android.widget.TableRow;
import android.widget.TableRow.LayoutParams;
import android.widget.TextView;
import android.widget.Toast;

import java.util.ArrayList;
import java.util.List;

import hearc.ch.starstrat.adapter.SpinnerUnitAdapter;
import hearc.ch.starstrat.dataBase.Use.UseBDD;
import hearc.ch.starstrat.dataBase.models.Race_entities;
import hearc.ch.starstrat.model.StrategyItem;
import hearc.ch.starstrat.objects.UnitItem;


/**
 * A simple {@link Fragment} subclass.
 */
public class StrategieMakerFragment extends Fragment {

    String[] unitsList = {"ahah", "2eme"};
    Integer[] iconList = {R.drawable.ic_home_favs,R.drawable.ic_home_favs};
    private List<UnitItem> unitList;
    private UseBDD useBDD;
    StrategyItem currentStrat;
    private int selectedRaceId;

    public StrategieMakerFragment() {
        unitList = new ArrayList<UnitItem>();
        currentStrat = new StrategyItem();
    }


    public void setUseBDD(UseBDD use)
    {
        useBDD = use;
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_strategie_maker, container, false);
    }
    public void onActivityCreated (Bundle savedInstanceState) {
        super.onActivityCreated(savedInstanceState);

        final Spinner spinner = (Spinner) getActivity().findViewById(R.id.spinner_race);

        ArrayAdapter<CharSequence> adapter = ArrayAdapter.createFromResource(getView().getContext(),R.array.races_array, android.R.layout.simple_spinner_item);
        adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        spinner.setAdapter(adapter);

        spinner.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener(){

            @Override
            public void onItemSelected(AdapterView<?> adapterView, View view, int position, long id) {
                String selectedRace = (String)adapterView.getItemAtPosition(position);
                switch(selectedRace)
                {
                    case "Terran":
                        selectedRaceId = 0;
                        break;
                    case "Protoss":
                        selectedRaceId = 1;
                        break;
                    case "Zerg":
                        selectedRaceId = 2;
                        break;
                    default:
                        selectedRaceId = 0;

                }
                if(currentStrat.getRace() == -1)
                {
                    resetConfiguration();
                }
                else
                {
                    if(currentStrat.getRace() != selectedRaceId )//&& currentStrat.getListSize() > 0)
                    {
                        AlertDialog.Builder builder = new AlertDialog.Builder(getActivity());
                        builder.setMessage("Changer de race supprimera la configuration actuelle")
                                .setTitle("Changer de race ?");
                        builder.setPositiveButton("Ok", new DialogInterface.OnClickListener() {
                            @Override
                            public void onClick(DialogInterface dialogInterface, int i) {
                                resetConfiguration();
                            }
                        });

                        builder.setNegativeButton("Annuler", new DialogInterface.OnClickListener() {
                            @Override
                            public void onClick(DialogInterface dialogInterface, int i) {
                                spinner.setSelection(currentStrat.getRace());
                            }
                        });

                        AlertDialog dialog = builder.create();
                        dialog.show();
                    }
                }

            }

            @Override
            public void onNothingSelected(AdapterView<?> adapterView) {
                Toast.makeText(getActivity(),"Nothing",Toast.LENGTH_LONG).show();
            }
        });

        List<Race_entities> list = useBDD.getAllUnitTerran();




        unitsList = new String[list.size()];
        iconList = new Integer[list.size()];
        for(int i=0;i<list.size();i++)
        {
            unitsList[i] = list.get(i).getName();
            iconList[i] = R.drawable.ic_home_favs;
        }

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

    private void resetConfiguration()
    {
        currentStrat.setRace(selectedRaceId);
        Toast.makeText(getActivity(),"Set race : " + currentStrat.getRace(),Toast.LENGTH_LONG).show();
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
