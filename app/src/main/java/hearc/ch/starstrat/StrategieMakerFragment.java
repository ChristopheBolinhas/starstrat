package hearc.ch.starstrat;


import android.app.AlertDialog;
import android.app.Fragment;
import android.content.DialogInterface;
import android.graphics.drawable.Drawable;
import android.os.Bundle;
import android.util.TypedValue;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.EditText;
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
import hearc.ch.starstrat.objects.StrategyItem;
import hearc.ch.starstrat.objects.UnitItem;


/**
 * A simple {@link Fragment} subclass.
 */
public class StrategieMakerFragment extends Fragment {


    private List<UnitItem> unitList;
    private UseBDD useBDD;
    private StrategyItem currentStrat;
    private int selectedRaceId;
    private boolean configurationInProgress = false;

    public StrategieMakerFragment() {
        unitList = new ArrayList<UnitItem>();
        currentStrat = new StrategyItem();
    }
    public static StrategieMakerFragment newInstance(StrategyItem strat, UseBDD bdd)
    {
        StrategieMakerFragment frag = new StrategieMakerFragment();
        frag.useBDD = bdd;
        if(strat != null) {
            frag.currentStrat = strat;
            //frag.setControls();
        }
        return frag;
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
                if(!configurationInProgress) {
                    switch (selectedRace) {
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
                    if (currentStrat.getRace() == -1) {
                        resetConfiguration();
                    } else {
                        if (currentStrat.getRace() != selectedRaceId && currentStrat.getListSize() > 0) {
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
                        } else {
                            resetConfiguration();
                        }
                    }
                    if (currentStrat.getDbId() != -1)
                        setControls();
                }
                else

                {
                    configurationInProgress = false;
                }

            }

            @Override
            public void onNothingSelected(AdapterView<?> adapterView) {
                Toast.makeText(getActivity(),"Nothing",Toast.LENGTH_LONG).show();
            }
        });




        Button buttonAddUnit = (Button) getActivity().findViewById(R.id.button_add_unit);
        buttonAddUnit.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Spinner spinnerUnits = (Spinner) getActivity().findViewById(R.id.spinner_unit_choice);
                SpinnerUnitAdapter spinnerUnitAdapter = (SpinnerUnitAdapter)spinnerUnits.getAdapter();
                int unitId = spinnerUnitAdapter.getSelectedUnitId(spinnerUnits.getSelectedItemPosition());
                String nom = spinnerUnitAdapter.getSelectedUnitName(spinnerUnits.getSelectedItemPosition());
                boolean checked = ((CheckBox)getActivity().findViewById(R.id.checkbox_vibrate)).isChecked();

                int mMinutes = ((NumberPicker) getActivity().findViewById(R.id.picker_minutes)).getValue();
                int mSecondes = ((NumberPicker) getActivity().findViewById(R.id.picker_secondes)).getValue();

                addUnit(unitId,mMinutes,mSecondes, checked, nom);


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


        Button buttonValidStrategy = (Button) getActivity().findViewById(R.id.buttonValidStrat);
        buttonValidStrategy.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {


                int nbUnits = currentStrat.getListSize();
                String stratName = ((EditText) getActivity().findViewById(R.id.editName)).getText().toString();
                currentStrat.setName(stratName);
                String stratDescription = ((EditText)getActivity().findViewById(R.id.editDescription)).getText().toString();
                currentStrat.setDescription(stratDescription);

                if(selectedRaceId != -1 && nbUnits > 0 && stratName != "")
                {
                    useBDD.addStrat(currentStrat);
                    Toast.makeText(getActivity(),"Stratégie ajoutée !",Toast.LENGTH_LONG).show();
                    ((MainActivity)getActivity()).updateStratFrag();
                    getFragmentManager().popBackStack();
                }
                else
                {
                    Toast.makeText(getActivity(),"Veuilez remplir tous les champs obligatoires (*)",Toast.LENGTH_LONG).show();
                }


            }
        });

    }

    private void resetConfiguration()
    {
        List<Race_entities> list;
        currentStrat.setRace(selectedRaceId);
        switch(selectedRaceId)
        {
            case 1://Protoss
                list = useBDD.getAllUnitProtoss();
                break;
            case 2://Zerg
                list = useBDD.getAllUnitZerg();
                break;

            default:
            case 0://Terran
                list = useBDD.getAllUnitTerran();
        }





        String[] unitTab = new String[list.size()];
        Drawable[] iconTab = new Drawable[list.size()];
        Integer[] idTab = new Integer[list.size()];
        for(int i=0;i<list.size();i++)
        {
            unitTab[i] = list.get(i).getName();
            iconTab[i] =  useBDD.getDrawable(list.get(i));
            idTab[i] = list.get(i).getId();
        }

        Spinner spinnerUnits = (Spinner) getActivity().findViewById(R.id.spinner_unit_choice);
        spinnerUnits.setAdapter(new SpinnerUnitAdapter(getView().getContext(),R.layout.spinner_units_style, unitTab, iconTab, idTab));


        //Toast.makeText(getActivity(),"Set race : " + currentStrat.getRace(),Toast.LENGTH_LONG).show();
    }




    private void addUnit(int unitId, int minutes, int secondes, boolean checked, String nom)
    {


        UnitItem unit = new UnitItem(unitId,minutes,secondes,checked,nom);
        currentStrat.addItem(unit);
        remakeUnitList();


        //addUiUnit(unit);

        //newRow.setLayout
       //newRow.s
        //
        /*android:layout_height="60dp"
        android:padding="5dp"
        android:textAlignment="center"*/

    }

    private void remakeUnitList()
    {
        TableLayout tableLayout = (TableLayout)getActivity().findViewById(R.id.table_units);
        tableLayout.removeAllViews();

        for(UnitItem item : currentStrat.getListUnits(false))
        {
            addUiUnit(item);
        }
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


        CheckBox box = new CheckBox(getView().getContext());
        box.setChecked(unit.getVibrate());
        box.setEnabled(false);
        box.setGravity(CheckBox.TEXT_ALIGNMENT_CENTER);
        box.setPadding(padding,padding,padding,padding);
        //box.setGravity(CheckBox.ALIGN);

        TextView textView2 = new TextView(getView().getContext());
        textView2.setText(unit.getMinutes() + ":" + unit.getSecondes());
        textView2.setGravity(TextView.TEXT_ALIGNMENT_CENTER);
        textView2.setPadding(padding,padding,padding,padding);
        Button buttonRemove = new Button(getView().getContext());
        buttonRemove.setText("x");
        buttonRemove.setWidth(20);
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
        newRow.addView(box);
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

        selectedRaceId = currentStrat.getRace();
        Spinner spinner = (Spinner) getActivity().findViewById(R.id.spinner_race);

        configurationInProgress = true;

        spinner.setSelection(selectedRaceId);

        ((EditText ) getActivity().findViewById(R.id.editName)).setText(currentStrat.getName());
        ((EditText ) getActivity().findViewById(R.id.editDescription)).setText(currentStrat.getDescription());

        //resetConfiguration();

        remakeUnitList();

    }




}
