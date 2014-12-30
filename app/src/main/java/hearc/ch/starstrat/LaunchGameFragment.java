package hearc.ch.starstrat;

import android.animation.Animator;
import android.app.ActionBar;
import android.app.Activity;
import android.graphics.Color;
import android.os.Bundle;
import android.app.Fragment;
import android.os.Handler;
import android.util.DisplayMetrics;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.view.animation.TranslateAnimation;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.RelativeLayout;
import android.widget.TextView;

import java.util.Timer;

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
    private boolean isPause;
    private int nbAnimation, whereFirstPassed;
    private int timeAnimate = 500, timeBetweenAnimation = 3000;
    private String textButtonStart, textButtonPause;

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
                else if(isPause == false) {
                    isPause = true;
                    buttonLaunchGame.setText(textButtonStart);
                }
                //Si on relance l'animation, relancer aux bonnes étapes
                else
                {
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

        if(index == 0)
            whereFirstPassed++;
        tabLayoutImage[index].animate().translationX(transX).scaleX(littleScale).scaleY(littleScale).setDuration(timeAnimate).withLayer();
        //tabLayoutImage[index].animate().translationX((withScreen/4)-tabLayoutImage[index].getMeasuredWidth()).scaleX(0.5f).scaleY(0.5f).setDuration(timeAnimate).withLayer();
        if(index < nbAnimation)
            hAnimation.postDelayed(launchFirst,timeBetweenAnimation);

        hAnimation2.postDelayed(launchSecond,timeBetweenAnimation);
    }

    private void launch2(int index)
    {
        if(index == 0)
            whereFirstPassed++;
        tabLayoutImage[index].animate().translationX(withScreen/2 - tabLayoutImage[index].getMeasuredWidth()/2).scaleX(bigScale).scaleY(bigScale).setDuration(timeAnimate).withLayer();
        hAnimation3.postDelayed(launchThird,timeBetweenAnimation);
    }

    private void launch3(int index)
    {
        if(index == 0)
            whereFirstPassed++;
        tabLayoutImage[index].animate().translationX(withScreen-tabLayoutImage[index].getMeasuredWidth()-transX).scaleX(littleScale).scaleY(littleScale).setDuration(timeAnimate).withLayer();
        hAnimation4.postDelayed(launchFourth,timeBetweenAnimation);
    }

    private void launch4(final int index)
    {
        tabLayoutImage[index].animate().translationX(withScreen).setDuration(timeAnimate).withLayer().withEndAction(new Runnable() {
            @Override
            public void run() {
                layoutAnimation.removeView(tabLayoutImage[index]);
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
