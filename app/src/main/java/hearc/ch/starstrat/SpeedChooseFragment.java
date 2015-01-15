package hearc.ch.starstrat;

import android.app.Activity;
import android.net.Uri;
import android.os.Bundle;
import android.app.Fragment;
import android.util.DisplayMetrics;
import android.util.TypedValue;
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
public class SpeedChooseFragment extends Fragment{

    public static final float slowerSpeed = 0.599f;
    public static final float slowSpeed = 0.83f;
    public static final float regularSpeed = 1;
    public static final float fastSpeed = 1.21f;
    public static final float fasterSpeed = 1.38f;

    private RadioGroup radioGroup;
    private Button buttonReturn;
    private TextView textTitle;
    private float speedOfGame;

    /**
     * Use this factory method to create a new instance of
     * this fragment using the provided parameters.
     *
     * @return A new instance of fragment SpeedChooseFragment.
     */
    // TODO: Rename and change types and number of parameters
    public static SpeedChooseFragment newInstance() {
        SpeedChooseFragment fragment = new SpeedChooseFragment();
        return fragment;
    }

    public SpeedChooseFragment() {

    }

    @Override
    public void onActivityCreated (Bundle savedInstanceState)
    {
        super.onActivityCreated(savedInstanceState);

        DisplayMetrics displaymetrics = new DisplayMetrics();
        getActivity().getWindowManager().getDefaultDisplay().getMetrics(displaymetrics);
        int widthScreen = displaymetrics.widthPixels;

        //Adapt text size related to screen width
        textTitle = (TextView)getActivity().findViewById(R.id.textChooseSpeed);
        textTitle.setTextSize(TypedValue.COMPLEX_UNIT_PX,0.05f*widthScreen);

        //Récupére le groupe de radioButton et change la vitesse de jeu par rapport à la selection
        radioGroup = (RadioGroup)this.getActivity().findViewById(R.id.radioGroupSpeed);
        radioGroup.setOnCheckedChangeListener(new RadioGroup.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(RadioGroup group, int checkedId) {
                switch(checkedId)
                {
                    case R.id.radioSlower:
                        speedOfGame = slowerSpeed;
                        break;
                    case R.id.radioSlow:
                        speedOfGame = slowSpeed;
                        break;
                    case R.id.radioRegular:
                        speedOfGame = regularSpeed;
                        break;
                    case R.id.radioFast:
                        speedOfGame = fastSpeed;
                        break;
                    case R.id.radioFaster:
                        speedOfGame = fasterSpeed;
                        break;
                    default:
                        speedOfGame = fastSpeed;
                        radioGroup.check(R.id.radioFast);
                }


                ((MainActivity)getActivity()).setSpeedOfGame(speedOfGame);
            }
        });
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
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
