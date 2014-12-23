package hearc.ch.starstrat;

import android.app.Activity;
import android.content.pm.ActivityInfo;
import android.net.Uri;
import android.os.Bundle;
import android.app.Fragment;
import android.os.Handler;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.TextView;

import hearc.ch.starstrat.R;

/**
 * A simple {@link Fragment} subclass.
 * Activities that contain this fragment must implement the
 * to handle interaction events.
 * Use the {@link LaunchGameFragment#newInstance} factory method to
 * create an instance of this fragment.
 */
public class LaunchGameFragment extends Fragment {

    private TextView textTotal, textActuel;
    private Button buttonLaunch;

    private int totalTime, stepTime, stepTimeTMP;

    private int activityOrientation;

    private final Runnable updateStep = new Runnable() {
        @Override
        public void run() {
            incrementStep();
        }
    };

    private final Runnable updateAfterStep = new Runnable() {
        @Override
        public void run() {
            incrementAfterStep();
        }
    };

    private final Handler handlerStep = new Handler();
    private final Handler handlerAfterStep = new Handler();
    /**
     * Use this factory method to create a new instance of
     * this fragment using the provided parameters.
     *
     * @param param1 Parameter 1.
     * @param param2 Parameter 2.
     * @return A new instance of fragment LaunchGameFragment.
     */
    // TODO: Rename and change types and number of parameters
    public static LaunchGameFragment newInstance(String param1, String param2) {
        LaunchGameFragment fragment = new LaunchGameFragment();

        return fragment;
    }

    public LaunchGameFragment() {
        // Required empty public constructor
    }


    public void incrementAfterStep()
    {
        textTotal.setText(""+(totalTime - stepTimeTMP));
    }

    public void incrementStep()
    {
        stepTimeTMP++;
        textActuel.setText(""+stepTimeTMP);

        if(totalTime > stepTimeTMP)
            handlerStep.post(updateStep);

        if(stepTimeTMP % stepTime == 0)
            handlerAfterStep.post(updateAfterStep);

    }

    @Override
    public void onActivityCreated (Bundle savedInstanceState) {
        super.onActivityCreated(savedInstanceState);

        textTotal = (TextView)getActivity().findViewById(R.id.timerTotal);
        textActuel = (TextView)getActivity().findViewById(R.id.timerActuel);

        buttonLaunch = (Button)getActivity().findViewById(R.id.buttonLaunchGame);
        buttonLaunch.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                handlerStep.post(updateStep);
            }
        });

        //Réception des temps
        totalTime = 1000;
        stepTime = 50;
        stepTimeTMP = 1;
    }

        @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_launch_game, container, false);
    }

    @Override
    public void onAttach(Activity activity) {
        super.onAttach(activity);

        /*
        activityOrientation = activity.getRequestedOrientation();
        activity.setRequestedOrientation(ActivityInfo.SCREEN_ORIENTATION_LANDSCAPE);
        */
    }

    @Override
    public void onStop() {
        /*
        Activity parent = getActivity();

        if(parent != null)
            getActivity().setRequestedOrientation(activityOrientation);
        */
        super.onStop();

    }

    @Override
    public void onDetach() {
        super.onDetach();
    }

}
