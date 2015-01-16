package hearc.ch.starstrat;

import android.app.Activity;
import android.app.Fragment;
import android.content.Context;
import android.os.Bundle;
import android.os.Handler;
import android.os.Vibrator;
import android.text.format.Time;
import android.util.DisplayMetrics;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.ViewTreeObserver;
import android.widget.ImageButton;
import android.widget.RelativeLayout;
import android.widget.TextView;

import java.util.LinkedList;
import java.util.List;

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
    private boolean isPause, isFirstPassed, isPauseJustFinish;
    private int nbAnimation;
    private int timeAnimate = 500, timeInGame;
    private String textButtonStart, textButtonPause;

    private android.text.format.Time timeUntilPause, timeSinceLastAnimation, totalTimeAnimation,timeAnimation;

    private TextView textStepTime;
    private ImageButton buttonLaunchGame;
    private RelativeLayout layoutAnimation;

    //Handler to update time
    private final Handler handlerStep = new Handler();
    //Runnable to update time
    private final Runnable updateTime = new Runnable() {
        Time time = new Time();
        @Override
        public void run() {
            //incrementTime(time);

            long timeElapsed = (timeAnimation.toMillis(false))/1000;
            Log.d("TIME","TIME ELAPSED " + timeElapsed);
            //Set the time every 100ms
            if(totalTime > timeElapsed && !isPause) {
                textStepTime.setText(time.minute + ":" + time.second);
                time.set(time.toMillis(false)+1000);
                handlerStep.postDelayed(updateTime, (long) (1000 / speedOfGame));
            }
        }
    };

    //Handler to relaunch animation after pause
    private final Handler hRelaunchAnimation = new Handler();

    //Handler for launch animation
    private final Handler hAnimation = new Handler();
    private final Handler hAnimation2 = new Handler();
    private final Handler hAnimation3 = new Handler();
    private final Handler hAnimation4 = new Handler();

    /*
    //Runnable for launch animation
    private final Runnable launchFirst = new Runnable() {
        int index = 2;
        @Override
        public void run() {
            if(!isPause && !isPauseJustFinish && nbAnimation > index) {
                firstAnimation(index);
                index++;
            }

        }
    };
    */
    private final Runnable launchSecond = new Runnable() {
        int index = 1;
        @Override
        public void run() {
            if(!isPause && !isPauseJustFinish && nbAnimation > index) {
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
    /*
    private final Runnable launchThird = new Runnable() {
        int index = 0;
        @Override
        public void run() {
            if(!isPause && !isPauseJustFinish && nbAnimation > index) {
                thirdAnimation(index);
                index++;
            }
        }
    };
    */
    private final Runnable launchFourth = new Runnable() {
        int index = 0;
        @Override
        public void run() {
            if(!isPause && !isPauseJustFinish && nbAnimation > index) {
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

    public void incrementTime(Time time)
    {
        //timeAnimation.setToNow();

        //Calculate the real time elapsed in minute and second
        //long tmp = (timeAnimation.toMillis(false)-totalTimeAnimation.toMillis(false));

        /*
        Time timeAffichage = new Time();
        timeAffichage.set((long) (tmp*speedOfGame));
        textStepTime.setText(timeAffichage.minute + ":" + timeAffichage.second);
        */

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

        isPause = false;
        isPauseJustFinish = false;

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

                    int totalUnit = myStrategy.getListSize();

                    List<UnitItem> listUnite = myStrategy.getListUnits(true);
                    UnitItem lastUnit = listUnite.get(totalUnit-1);

                    int create = ((lastUnit.getMinutes()*60)+lastUnit.getSecondes())/timeForUnit;

                    for(int i = 0 ; i <= create; i++)
                    {
                        ImagesViewLaunch imgGroup = new ImagesViewLaunch(getActivity());
                        listImagesAnimation.add(imgGroup);
                    }

                    for(UnitItem unit : listUnite)
                    {
                        int indexUnit = ((unit.getMinutes()*60)+unit.getSecondes())/timeForUnit;

                        (listImagesAnimation.get(indexUnit)).addUnit(unit);
                    }

                    //We move all image outside view
                    for(ImagesViewLaunch im : listImagesAnimation)
                    {
                        im.constructImagesView(sizeHeight);
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
                        float lScale = 1;
                        float bScale = 1;
                        if(im.getNBUnit() > 0)
                        {
                            lScale = (sizeHeight/4)/(im.getLinearAnimation().getMeasuredHeight());
                            bScale = (sizeHeight/2)/(im.getLinearAnimation().getMeasuredHeight());
                        }

                        im.setLittleScale(lScale);
                        im.setBigScale(bScale);
                    }

                    //We move the first and second image to 1/2 and 1/4 screen to be ready
                    listImagesAnimation.get(0).getLinearAnimation().animate().alpha(1).translationX(marginLeftLayout + (widthScreen/2) - (listImagesAnimation.get(0).getLinearAnimation().getMeasuredWidth()/2)).scaleX(listImagesAnimation.get(0).getBigScale()).scaleY(listImagesAnimation.get(0).getBigScale()).setDuration(0).withLayer();

                    /*
                    //Maybe we have only 1 image ?
                    if(listImagesAnimation.size() >= 2) {
                        listImagesAnimation.get(1).getLinearAnimation().animate().translationX(transX + marginLeftLayout).alpha(0.5f).scaleX(listImagesAnimation.get(1).getLittleScale()).scaleY(listImagesAnimation.get(1).getLittleScale()).setDuration(0).withLayer();
                    }
                    */

                    //Delete event because it occurs always
                    ViewTreeObserver obs = getView().getViewTreeObserver();
                    obs.removeOnGlobalLayoutListener(this);
                }
            }
        });

        buttonLaunchGame = (ImageButton)getActivity().findViewById(R.id.buttonLaunchGame);
        buttonLaunchGame.setOnClickListener(new View.OnClickListener() {
            private boolean isFirst = true;
            @Override
            public void onClick(View v) {

                //If it's first clic, launch the animation
                if(isFirst) {
                    isFirstPassed = false;

                    timeAnimation = new Time();
                    timeAnimation.setToNow();
                    handlerStep.post(updateTime);
                    isFirst = false;

                    buttonLaunchGame.setImageResource(R.drawable.ic_pause);

                    totalTimeAnimation = new Time();
                    totalTimeAnimation.set(0);

                    timeSinceLastAnimation.setToNow();

                    hRelaunchAnimation.postDelayed(new Runnable() {
                        @Override
                        public void run() {
                            //hAnimation.post(launchFirst);
                            hAnimation2.post(launchSecond);
                            //hAnimation3.post(launchThird);
                            hAnimation4.post(launchFourth);
                        }
                    }, timeBetweenAnimation);
                }
                //else if it's pause and we stop the animation and remembered the time between last animation and pause
                else if(isPause == false) {
                    isPause = true;

                    timeUntilPause = new Time();
                    timeUntilPause.setToNow();
                    timeUntilPause.set(timeUntilPause.toMillis(false) - timeSinceLastAnimation.toMillis(false));

                    buttonLaunchGame.setImageResource(R.drawable.ic_play);
                }
                //else we relaunch the animation because the pause is finish
                else
                {
                    isPauseJustFinish = true;
                    long timeModified = (long) (timeUntilPause.toMillis(false)/speedOfGame);
                    long timeToRelaunch = (long) (timeBetweenAnimation-timeModified);

                    Log.d("TIMEEEE","TIME_BETWEEN_ANIM " + timeBetweenAnimation);
                    Log.d("TIMEEEE","TIME_SINCE_PAUSE " + timeUntilPause.toMillis(false));
                    Log.d("TIMEEEE","TIME_SINCE_PAUSE MODIFIE " + timeModified);

                    handlerStep.post(updateTime);

                    hRelaunchAnimation.postDelayed(new Runnable() {
                        @Override
                        public void run() {
                            isPauseJustFinish = false;
                            //if(isFirstPassed)
                            //{
                                //hAnimation.post(launchFirst);
                                hAnimation2.post(launchSecond);
                                //hAnimation3.post(launchThird);
                                hAnimation4.post(launchFourth);
                            /*
                            }
                            else
                            {
                                //hAnimation.post(launchFirst);
                                hAnimation2.post(launchSecond);
                                //hAnimation3.post(launchThird);
                            }*/
                        }
                    }, timeToRelaunch);

                    Log.d("TIMEEEE","TIME_UNTIL_NEXT " + timeToRelaunch);

                    isPause = false;

                    buttonLaunchGame.setImageResource(R.drawable.ic_pause);
                }
            }
        });

        //Get total time
        //timeBetween animation = 10 / speedOfGame
        totalTime = 30000;
    }
/*
    private void firstAnimation(int index)
    {
        //Animate the object from outside screen to 1/4 screen
        (listImagesAnimation.get(index).getLinearAnimation()).animate().translationX(marginLeftLayout).alpha(0.5f).scaleX(listImagesAnimation.get(index).getLittleScale()).scaleY(listImagesAnimation.get(index).getLittleScale()).setDuration(timeAnimate).withLayer();

        if(index < nbAnimation)
            hAnimation.postDelayed(launchFirst,timeBetweenAnimation);

        hAnimation2.postDelayed(launchSecond, timeBetweenAnimation);
    }
*/
    private void secondAnimation(int index)
    {
        //Animate the object from 1/4 screen to 1/2 screen
        //(listImagesAnimation.get(index).getLinearAnimation()).animate().translationX(marginLeftLayout+(widthScreen/2)-(listImagesAnimation.get(index).getLinearAnimation().getMeasuredWidth()/2)).alpha(1).scaleX(listImagesAnimation.get(index).getBigScale()).scaleY(listImagesAnimation.get(index).getBigScale()).setDuration(timeAnimate).withLayer();
        //hAnimation3.postDelayed(launchThird,timeBetweenAnimation);
        (listImagesAnimation.get(index).getLinearAnimation()).animate().translationX(marginLeftLayout+(widthScreen/2)-(listImagesAnimation.get(index).getLinearAnimation().getMeasuredWidth()/2)).alpha(1).scaleX(listImagesAnimation.get(index).getBigScale()).scaleY(listImagesAnimation.get(index).getBigScale()).setDuration(timeAnimate).withLayer();
        hAnimation4.postDelayed(launchFourth,timeBetweenAnimation);
    }
/*
    private void thirdAnimation(int index)
    {
        if(index == 0) {
            isFirstPassed = true;
            timeSinceLastAnimation.setToNow();
        }

        //Animate the object from 1/2 screen to 3/4 screen
        (listImagesAnimation.get(index).getLinearAnimation()).animate().translationX(marginLeftLayout+widthScreen-(listImagesAnimation.get(index).getLinearAnimation().getMeasuredWidth())).alpha(0.5f).scaleX(listImagesAnimation.get(index).getLittleScale()).scaleY(listImagesAnimation.get(index).getLittleScale()).setDuration(timeAnimate).withLayer();
        hAnimation4.postDelayed(launchFourth,timeBetweenAnimation);
    }
*/
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
