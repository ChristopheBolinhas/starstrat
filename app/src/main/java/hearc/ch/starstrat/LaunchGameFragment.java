package hearc.ch.starstrat;

import android.app.Activity;
import android.content.Context;
import android.os.Bundle;
import android.app.Fragment;
import android.os.Handler;
import android.os.Vibrator;
import android.text.format.Time;
import android.util.DisplayMetrics;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.ViewTreeObserver;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import android.widget.TextView;
import android.widget.Toast;

import java.util.ArrayList;
import java.util.LinkedList;

import hearc.ch.starstrat.objects.ImagesViewLaunch;
import hearc.ch.starstrat.objects.StrategyItem;
import hearc.ch.starstrat.objects.UnitItem;

/**
 * A simple {@link Fragment} subclass.
 * Activities that contain this fragment must implement the
 * to handle interaction events.
 * Use the {@link LaunchGameFragment#newInstance} factory method to
 * create an instance of this fragment.
 */
public class LaunchGameFragment extends Fragment {

    //Standard time between animation : 10s
    private static int standardTimeOfAnimation = 10000;
    private static float miniScale = 0.1f;

    //Real
    private LinkedList<ImagesViewLaunch> listImagesAnimation;
    private StrategyItem myStrategy;
    private long timeBetweenAnimation, totalTime;
    private float speedOfGame;

    //To regroup all units under every 10s
    private int timeForUnit = 10;

    private int widthScreen, heightScreen, transX = 20, marginLeftLayout = 200;
    private boolean isPause, isFirstPassed;
    private int nbAnimation;
    private int timeAnimate = 500;
    private String textButtonStart, textButtonPause;

    private android.text.format.Time timeSincePause, timeSinceLastAnimation, totalTimeAnimation,timeAnimation;

    private TextView textStepTime;
    private Button buttonLaunchGame;
    private RelativeLayout layoutAnimation;

    //Handler to update time
    private final Handler handlerStep = new Handler();
    //Runnable to update time
    private final Runnable updateTime = new Runnable() {
        @Override
        public void run() {
            incrementTime();
        }
    };

    //Handler to relaunch animation after pause
    private final Handler hRelaunchAnimation = new Handler();

    //Handler for launch animation
    private final Handler hAnimation = new Handler();
    private final Handler hAnimation2 = new Handler();
    private final Handler hAnimation3 = new Handler();
    private final Handler hAnimation4 = new Handler();

    //Runnable for launch animation
    private final Runnable launchFirst = new Runnable() {
        int index = 2;
        @Override
        public void run() {
            if(!isPause && nbAnimation > index) {
                firstAnimation(index);
                index++;
            }

        }
    };
    private final Runnable launchSecond = new Runnable() {
        int index = 1;
        @Override
        public void run() {
            if(!isPause && nbAnimation > index) {
                secondAnimation(index);
                if(listImagesAnimation.get(index).getIsVibrate())
                {
                    Vibrator vib;
                    vib= (Vibrator) getActivity().getSystemService(Context.VIBRATOR_SERVICE);
                    vib.vibrate(1000);
                }
                index++;
            }
        }
    };
    private final Runnable launchThird = new Runnable() {
        int index = 0;
        @Override
        public void run() {
            if(!isPause && nbAnimation > index) {
                thirdAnimation(index);
                index++;
            }
        }
    };
    private final Runnable launchFourth = new Runnable() {
        int index = 0;
        @Override
        public void run() {
            if(!isPause && nbAnimation > index) {
                fourthAnimation(index);
                index++;
            }
        }
    };

    public static LaunchGameFragment newInstance(StrategyItem strategy, float speedGame) {
        LaunchGameFragment fragment = new LaunchGameFragment();
        fragment.myStrategy = strategy;
        fragment.speedOfGame = speedGame;
        return fragment;
    }

    public LaunchGameFragment() {
        // Required empty public constructor
    }

    public void incrementTime()
    {
        timeAnimation.setToNow();

        //Calculate the real time elapsed in minute and second
        long tmp = (timeAnimation.toMillis(false)-totalTimeAnimation.toMillis(false));

        Time timeAffichage = new Time();
        timeAffichage.set(tmp);
        textStepTime.setText(""+timeAffichage.toMillis(false));

        //Set the time every 100ms
        if(totalTime > tmp && !isPause)
            handlerStep.postDelayed(updateTime,1000);
    }

    @Override
    public void onActivityCreated (Bundle savedInstanceState) {
        super.onActivityCreated(savedInstanceState);

        textStepTime = (TextView)getActivity().findViewById(R.id.timerActuel);
        layoutAnimation = (RelativeLayout)getActivity().findViewById(R.id.layoutAnimation);

        timeBetweenAnimation = (long)(standardTimeOfAnimation / speedOfGame);

        //GET SCREEN SIZE
        DisplayMetrics displaymetrics = new DisplayMetrics();
        getActivity().getWindowManager().getDefaultDisplay().getMetrics(displaymetrics);
        widthScreen = displaymetrics.widthPixels;
        heightScreen = displaymetrics.heightPixels;

        //Get text for button (Start,Pause)
        textButtonStart = (String)getActivity().getText(R.string.launch_game_fragment_Start);
        textButtonPause = (String)getActivity().getText(R.string.launch_game_fragment_Pause);

        isPause = false;

        timeSinceLastAnimation = new Time();

        listImagesAnimation = new LinkedList<ImagesViewLaunch>();

        //Add all images in outside of layout
        //Position the 2 first images in, respectively, 1/4 and 1/2 screen
        //Event that happened when the window is totally draw
        ViewTreeObserver vto = getView().getViewTreeObserver();
        vto.addOnGlobalLayoutListener(new ViewTreeObserver.OnGlobalLayoutListener() {
            boolean isFirst = true;
            @Override
            public void onGlobalLayout() {
                int sizeHeight = heightScreen-getView().findViewById(R.id.layoutTime).getMeasuredHeight();

                if(isFirst) {

                    int time = timeForUnit;

                    ArrayList<UnitItem> listUnite = new ArrayList<UnitItem>();

                    //Foreach strategy item in strategylistitem (list sort by time)
                    for(UnitItem unit : myStrategy.getListUnits(true))
                    {
                        //Toast.makeText(getActivity(),"size " +unit.getSecondes(),Toast.LENGTH_LONG).show();

                        int timeUnit = unit.getMinutes()*60+unit.getSecondes();

                        if(timeUnit <= timeForUnit)
                        {
                            //we group the unit that have the same field of time
                            listUnite.add(unit);
                        }
                        else
                        {
                            Toast.makeText(getActivity(),"size " +listUnite.size(),Toast.LENGTH_LONG).show();

                            //We create element to draw with right units
                            ImagesViewLaunch imgGroup = new ImagesViewLaunch(listUnite,getActivity());
                            imgGroup.constructImagesView(sizeHeight);
                            listImagesAnimation.add(imgGroup);

                            listUnite = new ArrayList<UnitItem>();

                            //Increment the time for next units field of time
                            time += timeForUnit;
                        }
                    }

                    //We move all image outside view
                    for(ImagesViewLaunch im : listImagesAnimation)
                    {
                        layoutAnimation.addView(im.getLinearAnimation());
                        im.getLinearAnimation().animate().scaleX(miniScale).scaleY(miniScale).setDuration(0).alpha(0.2f).withLayer();
                    }

                    nbAnimation = listImagesAnimation.size();
                    totalTime = nbAnimation*timeBetweenAnimation;

                    isFirst = false;
                }
                else {

                    //Calculate the scale for each image
                    for(ImagesViewLaunch im : listImagesAnimation)
                    {
                        float lScale = (sizeHeight/2)/2;//im.getLinearAnimation().getMeasuredHeight();
                        float bScale = (sizeHeight)/2;//im.getLinearAnimation().getMeasuredHeight();
                        im.setLittleScale(lScale);
                        im.setBigScale(bScale);
                    }
                    //We move the first and second image to 1/2 and 1/4 screen to be ready
                    listImagesAnimation.get(0).getLinearAnimation().animate().alpha(1).translationX(marginLeftLayout + (widthScreen/2) - (listImagesAnimation.get(0).getLinearAnimation().getMeasuredWidth()/2)).scaleX(listImagesAnimation.get(0).getBigScale()).scaleY(listImagesAnimation.get(0).getBigScale()).setDuration(0).withLayer();

                    //Maybe we have only 1 image ?
                    if(listImagesAnimation.size() >= 2) {
                        listImagesAnimation.get(1).getLinearAnimation().animate().translationX(transX + marginLeftLayout).alpha(0.5f).scaleX(listImagesAnimation.get(1).getLittleScale()).scaleY(listImagesAnimation.get(1).getLittleScale()).setDuration(0).withLayer();
                    }

                    //Delete event because it occurs always
                    ViewTreeObserver obs = getView().getViewTreeObserver();
                    obs.removeOnGlobalLayoutListener(this);
                }
            }
        });

        buttonLaunchGame = (Button)getActivity().findViewById(R.id.buttonLaunchGame);
        buttonLaunchGame.setOnClickListener(new View.OnClickListener() {
            private boolean isFirst = true;
            @Override
            public void onClick(View v) {

                //If it's first clic, launch the animation
                if(isFirst) {
                    isFirstPassed = false;

                    handlerStep.post(updateTime);
                    isFirst = false;
                    buttonLaunchGame.setText(textButtonPause);

                    totalTimeAnimation = new Time();
                    timeAnimation = new Time();
                    totalTimeAnimation.setToNow();

                    hRelaunchAnimation.postDelayed(new Runnable() {
                        @Override
                        public void run() {
                            hAnimation.post(launchFirst);
                            hAnimation2.post(launchSecond);
                            hAnimation3.post(launchThird);
                            hAnimation4.post(launchFourth);
                        }
                    }, timeBetweenAnimation);
                }
                //else if it's pause and we stop the animation and remembered the time between last animation and pause
                else if(isPause == false) {
                    timeSincePause = new Time();
                    timeSincePause.setToNow();
                    timeSincePause.set(timeSincePause.toMillis(false) - timeSinceLastAnimation.toMillis(false));

                    isPause = true;
                    buttonLaunchGame.setText(textButtonStart);
                }
                //else we relaunch the animation because the pause is finish
                else
                {
                    hRelaunchAnimation.postDelayed(new Runnable() {
                        @Override
                        public void run() {
                            if(isFirstPassed)
                            {
                                hAnimation.post(launchFirst);
                                hAnimation2.post(launchSecond);
                                hAnimation3.post(launchThird);
                                hAnimation4.post(launchFourth);
                            }
                            else
                            {
                                hAnimation.post(launchFirst);
                                hAnimation2.post(launchSecond);
                                hAnimation3.post(launchThird);
                            }
                        }
                    }, timeBetweenAnimation-timeSincePause.toMillis(false));

                    isPause = false;
                    buttonLaunchGame.setText(textButtonPause);
                }
            }
        });

        //Get total time
        //timeBetween animation = 10 / speedOfGame
        totalTime = 30000;
    }

    private void firstAnimation(int index)
    {
        //Animate the object from outside screen to 1/4 screen
        (listImagesAnimation.get(index).getLinearAnimation()).animate().translationX(transX + marginLeftLayout).alpha(0.5f).scaleX(listImagesAnimation.get(index).getLittleScale()).scaleY(listImagesAnimation.get(index).getLittleScale()).setDuration(timeAnimate).withLayer();

        if(index < nbAnimation)
            hAnimation.postDelayed(launchFirst,timeBetweenAnimation);

        hAnimation2.postDelayed(launchSecond, timeBetweenAnimation);
    }

    private void secondAnimation(int index)
    {
        //Animate the object from 1/4 screen to 1/2 screen
        (listImagesAnimation.get(index).getLinearAnimation()).animate().translationX(marginLeftLayout+(widthScreen/2)-(listImagesAnimation.get(index).getLinearAnimation().getMeasuredWidth()/2)).alpha(1).scaleX(listImagesAnimation.get(index).getBigScale()).scaleY(listImagesAnimation.get(index).getBigScale()).setDuration(timeAnimate).withLayer();
        hAnimation3.postDelayed(launchThird,timeBetweenAnimation);
    }

    private void thirdAnimation(int index)
    {
        if(index == 0) {
            isFirstPassed = true;
            timeSinceLastAnimation.setToNow();
        }

        //Animate the object from 1/2 screen to 3/4 screen
        (listImagesAnimation.get(index).getLinearAnimation()).animate().translationX(marginLeftLayout+widthScreen-transX-(listImagesAnimation.get(index).getLinearAnimation().getMeasuredWidth()/2)).alpha(0.5f).scaleX(listImagesAnimation.get(index).getLittleScale()).scaleY(listImagesAnimation.get(index).getLittleScale()).setDuration(timeAnimate).withLayer();
        hAnimation4.postDelayed(launchFourth,timeBetweenAnimation);
    }

    private void fourthAnimation(final int index)
    {
        //Animate the object from 3/4 screen to outside screen
        (listImagesAnimation.get(index).getLinearAnimation()).animate().translationX(marginLeftLayout + widthScreen).scaleX(miniScale).scaleY(miniScale).alpha(0.2f).setDuration(timeAnimate).withLayer().withEndAction(new Runnable() {
            @Override
            public void run() {
                layoutAnimation.removeView(listImagesAnimation.get(index).getLinearAnimation());
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
    }

    @Override
    public void onStop() {
        super.onStop();
    }

    @Override
    public void onDetach() {
        super.onDetach();
    }

}
