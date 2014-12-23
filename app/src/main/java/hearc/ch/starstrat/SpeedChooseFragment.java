package hearc.ch.starstrat;

import android.app.Activity;
import android.net.Uri;
import android.os.Bundle;
import android.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.RadioGroup;
import android.widget.TextView;

import hearc.ch.starstrat.R;

/**
 * A simple {@link Fragment} subclass.
 * Activities that contain this fragment must implement the
 * to handle interaction events.
 * Use the {@link SpeedChooseFragment#newInstance} factory method to
 * create an instance of this fragment.
 */
public class SpeedChooseFragment extends Fragment implements View.OnClickListener{
    private static final int regularSpeed = 1;
    private static final int fastSpeed = 2;
    private RadioGroup radioGroup;
    private Button buttonReturn;
    private TextView textTitle;
    private float speedOfGame;

    // TODO: Rename parameter arguments, choose names that match
    // the fragment initialization parameters, e.g. ARG_ITEM_NUMBER
  /*
    private static final String ARG_PARAM1 = "param1";
    private static final String ARG_PARAM2 = "param2";
*/
    // TODO: Rename and change types of parameters
    /*
    private String mParam1;
    private String mParam2;
*/

    /**
     * Use this factory method to create a new instance of
     * this fragment using the provided parameters.
     *
     * @return A new instance of fragment SpeedChooseFragment.
     */
    // TODO: Rename and change types and number of parameters
    public static SpeedChooseFragment newInstance() {
        SpeedChooseFragment fragment = new SpeedChooseFragment();
        /*
        Bundle args = new Bundle();
        args.putString(ARG_PARAM1, param1);
        args.putString(ARG_PARAM2, param2);
        fragment.setArguments(args);
        */
        return fragment;
    }

    public SpeedChooseFragment() {

    }

    public void onClick(View v){
        //TODO : Retourne dans le main
    }

    @Override
    public void onActivityCreated (Bundle savedInstanceState)
    {
        super.onActivityCreated(savedInstanceState);
        textTitle = (TextView)getActivity().findViewById(R.id.textChooseSpeed);

        //Récupère le bouton de retour et crée le lien pour retourner au parent
        buttonReturn = (Button)getActivity().findViewById(R.id.returnButton);
        buttonReturn.setOnClickListener(this);

        //Récupére le groupe de radioButton et change la vitesse de jeu par rapport à la selection
        radioGroup = (RadioGroup)this.getActivity().findViewById(R.id.radioGroupSpeed);
        radioGroup.setOnCheckedChangeListener(new RadioGroup.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(RadioGroup group, int checkedId) {
                switch(checkedId)
                {
                    case R.id.radioRegular:
                        speedOfGame = 1;
                        break;
                    case R.id.radioRegular2:
                        speedOfGame = (float)1.5*regularSpeed;
                        break;
                    case R.id.radioFast:
                        speedOfGame = fastSpeed;
                        break;
                    case R.id.radioFast2:
                        speedOfGame = (float)1.5*fastSpeed;
                        break;
                    case R.id.radioFast3:
                        speedOfGame = (float)2*fastSpeed;
                        break;
                    case R.id.radioFast4:
                        speedOfGame = (float)4*fastSpeed;
                        break;
                    default:
                        speedOfGame = 1;
                        radioGroup.check(0);
                }
            }
        });

    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);



/*
        if (getArguments() != null) {
            mParam1 = getArguments().getString(ARG_PARAM1);
            mParam2 = getArguments().getString(ARG_PARAM2);
        }
*/
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {

        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_speed_choose, container, false);
    }

    @Override
    public void onAttach(Activity activity) {
        super.onAttach(activity);

    }

    @Override
    public void onDetach() {
        super.onDetach();
    }

}
