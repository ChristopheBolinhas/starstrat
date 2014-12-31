package hearc.ch.starstrat;

import android.app.Activity;
import android.os.Bundle;
import android.app.Fragment;
import android.os.Handler;
import android.text.format.Time;
import android.util.DisplayMetrics;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.RelativeLayout;
import android.widget.TextView;
import java.util.Date;

/**
 * A simple {@link Fragment} subclass.
 * Activities that contain this fragment must implement the
 * to handle interaction events.
 * Use the {@link LaunchGameFragment#newInstance} factory method to
 * create an instance of this fragment.
 */
public class LaunchGameFragment extends Fragment {

    private ImageView[] tabImageAnimation;
    private LinearLayout[] tabLayoutImage;
    private int withScreen, heightScreen, transX = 20, marginLeftLayout = 200;
    private float littleScale = 0.5f, bigScale = 2;
    private boolean isPause, isPauseFinish;
    private int nbAnimation, whereFirstPassed;
    private int timeAnimate = 500, timeBetweenAnimation = 3000;
    private String textButtonStart, textButtonPause;

    private android.text.format.Time timeSincePause, timeSinceLastAnimation;

    private TextView textTotalTime, textStepTime;
    private Button buttonLaunchGame;
    private TextView text,textAnim;
    private ImageView imageAnimation;
    private RelativeLayout layoutAnimation;

    private int totalTime, stepTime, stepTimeTMP;

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

    private final Handler hRelaunchAnimation = new Handler();
    private final Handler hAnimation = new Handler();
    private final Handler hAnimation2 = new Handler();
    private final Handler hAnimation3 = new Handler();
    private final Handler hAnimation4 = new Handler();

    private final Runnable launchFirst = new Runnable() {
        int index = 0;
        @Override
        public void run() {
            if(!isPause && nbAnimation > index) {
                launch(index);
                index++;
            }

        }
    };
    private final Runnable launchSecond = new Runnable() {
        int index = 0;
        @Override
        public void run() {
            if(!isPause && nbAnimation > index) {
                launch2(index);
                index++;
            }
        }
    };
    private final Runnable launchThird = new Runnable() {
        int index = 0;
        @Override
        public void run() {
            if(!isPause && nbAnimation > index) {
                launch3(index);
                index++;
            }
        }
    };
    private final Runnable launchFourth = new Runnable() {
        int index = 0;
        @Override
        public void run() {
            if(!isPause && nbAnimation > index) {
                launch4(index);
                index++;
            }
        }
    };

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
        textTotalTime.setText("" + (totalTime - stepTimeTMP));
    }

    public void incrementStep()
    {
        stepTimeTMP++;
        textStepTime.setText("" + stepTimeTMP);

        if(totalTime > stepTimeTMP)
            handlerStep.post(updateStep);

        if(stepTimeTMP % stepTime == 0)
            handlerAfterStep.post(updateAfterStep);

    }

    @Override
    public void onActivityCreated (Bundle savedInstanceState) {
        super.onActivityCreated(savedInstanceState);

        textTotalTime = (TextView)getActivity().findViewById(R.id.timerTotal);
        textStepTime = (TextView)getActivity().findViewById(R.id.timerActuel);
        layoutAnimation = (RelativeLayout)getActivity().findViewById(R.id.layoutAnimation);

        textButtonStart = (String)getActivity().getText(R.string.launch_game_fragment_Start);
        textButtonPause = (String)getActivity().getText(R.string.launch_game_fragment_Pause);

        tabLayoutImage = new LinearLayout[10];
        nbAnimation = 10;
        isPause = false;

        timeSinceLastAnimation = new Time();

        //Construction des vues avec les images
        for(int i = 0; i < nbAnimation ; i++)
        {
            LinearLayout first = new LinearLayout(getActivity());
            first.setOrientation(LinearLayout.VERTICAL);

            for(int j = 0; j < 6 ; j+=2)
            {
                LinearLayout l = new LinearLayout(getActivity());
                l.setOrientation(LinearLayout.HORIZONTAL);


                ImageView tmp = new ImageView(getActivity());
                tmp.setImageResource(R.drawable.ic_home_favs);

                l.addView(tmp);

                tmp = new ImageView(getActivity());
                tmp.setImageResource(R.drawable.ic_home_favs);

                l.addView(tmp);

                first.addView(l);
            }

            tabLayoutImage[i] = first;
        }

        //GET SCREEN SIZE
        DisplayMetrics displaymetrics = new DisplayMetrics();
        getActivity().getWindowManager().getDefaultDisplay().getMetrics(displaymetrics);
        final int height = displaymetrics.heightPixels;
        final int width = displaymetrics.widthPixels;
        withScreen = displaymetrics.widthPixels;
        heightScreen = displaymetrics.heightPixels - layoutAnimation.getMeasuredHeight();


        buttonLaunchGame = (Button)getActivity().findViewById(R.id.buttonLaunchGame);
        buttonLaunchGame.setOnClickListener(new View.OnClickListener() {
            private boolean isFirst = true;
            @Override
            public void onClick(View v) {

                //Si c'est le 1er passage, on lance l'animation et change le texte du bouton
                if(isFirst) {
                    whereFirstPassed = 0;
                    hAnimation.post(launchFirst);

                    handlerStep.post(updateStep);
                    isFirst = false;
                    buttonLaunchGame.setText(textButtonPause);
                }
                //Sinon c'est la pause et on enregistre le temps de l'animation qui s'est déroulé
                else if(isPause == false) {
                    timeSincePause = new Time();
                    timeSincePause.setToNow();
                    timeSincePause.set(timeSincePause.toMillis(false) - timeSinceLastAnimation.toMillis(false));

                    isPause = true;
                    buttonLaunchGame.setText(textButtonStart);
                }
                //Si on relance l'animation, relancer aux bonnes étapes avec le bon temps
                else
                {
                    hRelaunchAnimation.postDelayed(new Runnable() {
                        @Override
                        public void run() {
                            switch(whereFirstPassed)
                            {
                                case 1:
                                    hAnimation.post(launchFirst);
                                    hAnimation2.post(launchSecond);
                                    break;
                                case 2:
                                    hAnimation.post(launchFirst);
                                    hAnimation2.post(launchSecond);
                                    hAnimation3.post(launchThird);
                                    break;

                                case 3:
                                    hAnimation.post(launchFirst);
                                    hAnimation2.post(launchSecond);
                                    hAnimation3.post(launchThird);
                                    hAnimation4.post(launchFourth);
                                    break;

                                default:
                                    hAnimation.post(launchFirst);
                            }
                        }
                    }, timeBetweenAnimation-timeSincePause.toMillis(false));

                    isPause = false;
                    buttonLaunchGame.setText(textButtonPause);
                }
            }
        });

        //Réception des temps
        totalTime = 1000;
        stepTime = 50;
        stepTimeTMP = 1;
    }

    private void launch(int index)
    {
        layoutAnimation.addView(tabLayoutImage[index]);

        RelativeLayout.LayoutParams rlParams =
                (RelativeLayout.LayoutParams)tabLayoutImage[index].getLayoutParams();
        rlParams.setMargins(-1*tabLayoutImage[index].getMeasuredWidth(), 0, 0, 0);

        tabLayoutImage[index].setLayoutParams(rlParams);

        if(index == 0)
            whereFirstPassed++;

        tabLayoutImage[index].animate().translationX(transX).scaleX(littleScale).scaleY(littleScale).setDuration(timeAnimate).withLayer();

        if(index < nbAnimation)
            hAnimation.postDelayed(launchFirst,timeBetweenAnimation);

        hAnimation2.postDelayed(launchSecond,timeBetweenAnimation);

        timeSinceLastAnimation.setToNow();
    }

    private void launch2(int index)
    {
        if(index == 0)
            whereFirstPassed++;
        tabLayoutImage[index].animate().translationX(withScreen/2 - tabLayoutImage[index].getMeasuredWidth()/2).scaleX(bigScale).scaleY(bigScale).setDuration(timeAnimate).withLayer();
        hAnimation3.postDelayed(launchThird,timeBetweenAnimation);
        timeSinceLastAnimation.setToNow();
    }

    private void launch3(int index)
    {
        if(index == 0)
            whereFirstPassed++;
        tabLayoutImage[index].animate().translationX(withScreen-tabLayoutImage[index].getMeasuredWidth()-transX).scaleX(littleScale).scaleY(littleScale).setDuration(timeAnimate).withLayer();
        hAnimation4.postDelayed(launchFourth,timeBetweenAnimation);
        timeSinceLastAnimation.setToNow();
    }

    private void launch4(final int index)
    {
        tabLayoutImage[index].animate().translationX(withScreen).setDuration(timeAnimate).withLayer().withEndAction(new Runnable() {
            @Override
            public void run() {
                layoutAnimation.removeView(tabLayoutImage[index]);
            }
        });
        timeSinceLastAnimation.setToNow();
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
