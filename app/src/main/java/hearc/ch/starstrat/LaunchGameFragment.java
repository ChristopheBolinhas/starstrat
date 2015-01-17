package hearc.ch.starstrat;

import android.app.Activity;
import android.app.Fragment;
import android.content.Context;
import android.os.Bundle;
import android.os.Handler;
import android.os.SystemClock;
import android.os.Vibrator;
import android.util.DisplayMetrics;
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
public class LaunchGameFragment extends Fragment  implements View.OnClickListener{


    private LinkedList<ImagesViewLaunch> listImagesAnimation;
    private StrategyItem myStrategy;
    private long totalTimeOfGame;
    private float speedOfGame;

    //To regroup all units under every 10s
    private int timeForUnit = 10, timeUpdateTimer = 100;
    private float scaleOutsideScreen = 0.2f;

    private int widthScreen, heightScreen, marginLeftLayout = 200;
    private boolean isStartButton = true, isFirstClick = true, isFinish = false;
    private int nbAnimation;
    private int timeTransitionAnimation = 600;

    private long timeAtStart, timeInMilisecond, timeSwapBuff, timeSinceLastAnimation;

    private TextView textStepTime;
    private ImageButton buttonLaunchGame;
    private RelativeLayout layoutAnimation;

    //Handler to update time
    private final Handler handlerStep = new Handler();

    //Handler for launch animation
    private final Handler hAnimationToMiddle = new Handler();
    private final Handler hAnimationToOutside = new Handler();

    private final Runnable launchFirst = new Runnable() {
        //the first element to be animate here
        int index = 1;
        @Override
        public void run() {
            //check if animation can run
            if(nbAnimation > index) {
                firstAnimation(index);

                //check if we have to vibrate
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

    private final Runnable launchSecond = new Runnable() {
        //the first element to be animate here
        int index = 0;
        @Override
        public void run() {
            //check if animation can run
            if(nbAnimation > index) {

                secondAnimation(index);

                index++;
            }
        }
    };

    //Runnable to update time
    private final Runnable updateTime = new Runnable() {
        @Override
        public void run() {

            long timeElapsed = 0;

            timeInMilisecond = SystemClock.uptimeMillis() - timeAtStart;

            timeElapsed = ((timeSwapBuff) + (timeInMilisecond));

            //Make the time in the game
            timeElapsed = (long) (timeElapsed*speedOfGame);

            int secs = (int) (timeElapsed / 1000);

            //Set the time every 100ms
            if(totalTimeOfGame >= secs) {

                //Calculate if at least 1 sec is passed after the last animation (in time of game)
                long updateTimeAnimation = SystemClock.uptimeMillis() - timeSinceLastAnimation;
                updateTimeAnimation = (long) (updateTimeAnimation*speedOfGame);
                updateTimeAnimation = updateTimeAnimation / 1000;

                if(secs % timeForUnit == 0 && secs > 0 && updateTimeAnimation > 0)
                {
                    timeSinceLastAnimation = SystemClock.uptimeMillis();

                    hAnimationToMiddle.postDelayed(launchFirst,0);
                    hAnimationToOutside.postDelayed(launchSecond,0);
                }

                int mins = secs / 60;
                secs = secs % 60;

                textStepTime.setText("" + String.format("%02d", mins) + ":"+ String.format("%02d", secs));
                handlerStep.postDelayed(updateTime, timeUpdateTimer);
            }
            else if(totalTimeOfGame < secs && !isFinish)
            {
                isFinish = true;

                TextView textFinish = new TextView(getActivity());
                textFinish.setText(R.string.launch_game_fragment_end);
                textFinish.setTextSize(24);
                textFinish.setTextColor(getResources().getColor(R.color.launch_fragment_timer));
                textFinish.setLayoutParams(new RelativeLayout.LayoutParams(RelativeLayout.LayoutParams.WRAP_CONTENT, RelativeLayout.LayoutParams.WRAP_CONTENT));

                layoutAnimation.addView(textFinish);

                textFinish.measure(0,0);

                float translateX = (widthScreen/2)+marginLeftLayout - textFinish.getMeasuredWidth()/2;

                textFinish.animate().translationX(translateX).setDuration(timeTransitionAnimation).withLayer();
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

    @Override
    public void onActivityCreated (Bundle savedInstanceState) {
        super.onActivityCreated(savedInstanceState);

        textStepTime = (TextView)getActivity().findViewById(R.id.timerActuel);
        layoutAnimation = (RelativeLayout)getActivity().findViewById(R.id.layoutAnimation);

        timeInMilisecond = 0;
        timeAtStart = 0;
        timeSwapBuff = 0;

        //GET SCREEN SIZE
        DisplayMetrics displaymetrics = new DisplayMetrics();
        getActivity().getWindowManager().getDefaultDisplay().getMetrics(displaymetrics);
        widthScreen = displaymetrics.widthPixels;
        heightScreen = displaymetrics.heightPixels;

        listImagesAnimation = new LinkedList<>();

        //Add all images in outside of layout
        //Position the first image in 1/2 screen
        //Event that happened always when the window is totally draw to get right size of element in the second passage
        ViewTreeObserver vto = getView().getViewTreeObserver();
        vto.addOnGlobalLayoutListener(new ViewTreeObserver.OnGlobalLayoutListener() {
            boolean isFirst = true;
            @Override
            public void onGlobalLayout() {
                int sizeHeight = heightScreen-getView().findViewById(R.id.layoutTime).getMeasuredHeight();

                if(isFirst) {


                    List<UnitItem> listUnite = myStrategy.getListUnits(true);

                    int totalUnit = listUnite.size();
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
                        im.getLinearAnimation().animate().scaleX(scaleOutsideScreen).scaleY(scaleOutsideScreen).setDuration(0).alpha(0.2f).withLayer();
                    }

                    nbAnimation = listImagesAnimation.size();

                    totalTimeOfGame = nbAnimation*timeForUnit;

                    isFirst = false;
                }
                else {

                    //Calculate the scale for each image
                    for(ImagesViewLaunch im : listImagesAnimation)
                    {
                        float bScale = 1;
                        if(im.getNBUnit() > 0)
                        {
                            //To prevent pixelisation of the picture
                            if(im.getNBUnit() == 1)
                                bScale = (sizeHeight/4)/(im.getLinearAnimation().getMeasuredHeight());
                            else
                                bScale = (sizeHeight/2)/(im.getLinearAnimation().getMeasuredHeight());
                        }

                        im.setBigScale(bScale);
                    }

                    float translateX = marginLeftLayout + (widthScreen/2) - (listImagesAnimation.get(0).getLinearAnimation().getMeasuredWidth()/2);
                    float scale = listImagesAnimation.get(0).getBigScale();

                    //We move the first image to 1/2 screen to be ready
                    listImagesAnimation.get(0).getLinearAnimation().animate().alpha(1).translationX(translateX).scaleX(scale).scaleY(scale).setDuration(0).withLayer();


                    //Delete event because it occurs always
                    ViewTreeObserver obs = getView().getViewTreeObserver();
                    obs.removeOnGlobalLayoutListener(this);
                }
            }
        });

        buttonLaunchGame = (ImageButton)getActivity().findViewById(R.id.buttonLaunchGame);

        buttonLaunchGame.setOnClickListener(this);

    }

    @Override
    public void onClick(View v) {

        //if its first click, get the time
        if(isFirstClick)
        {
            timeSinceLastAnimation = SystemClock.uptimeMillis();
            isFirstClick = false;
        }

        //if it's not pause, start the animation at the right time
        if(isStartButton)
        {
            timeAtStart = SystemClock.uptimeMillis();

            buttonLaunchGame.setImageResource(R.drawable.ic_pause);

            isStartButton = false;


            handlerStep.postDelayed(updateTime,0);
        }
        //else it's pause and we stop the animation and remembered the time between last animation and pause
        else
        {
            isStartButton = true;

            timeSwapBuff += timeInMilisecond;

            buttonLaunchGame.setImageResource(R.drawable.ic_play);

            //To make sur that animation will not be launch before the relaunch of animation
            hAnimationToMiddle.removeCallbacks(launchFirst);
            hAnimationToOutside.removeCallbacks(launchSecond);

            //To stop the timer
            handlerStep.removeCallbacks(updateTime);
        }
    }

    private void firstAnimation(int index)
    {
        float translateX = marginLeftLayout+(widthScreen/2)-(listImagesAnimation.get(index).getLinearAnimation().getMeasuredWidth()/2);
        float scale = listImagesAnimation.get(index).getBigScale();

        (listImagesAnimation.get(index).getLinearAnimation()).animate().translationX(translateX).alpha(1).scaleX(scale).scaleY(scale).setDuration(timeTransitionAnimation).withLayer();

        timeSinceLastAnimation = SystemClock.uptimeMillis();
    }

    private void secondAnimation(final int index)
    {
        float translateX = marginLeftLayout + widthScreen;

        //Animate the object from 3/4 screen to outside screen
        (listImagesAnimation.get(index).getLinearAnimation()).animate().translationX(translateX).scaleX(scaleOutsideScreen).scaleY(scaleOutsideScreen).alpha(0.2f).setDuration(timeTransitionAnimation).withLayer().withEndAction(new Runnable() {
            @Override
            public void run() {
                layoutAnimation.removeView(listImagesAnimation.get(index).getLinearAnimation());
            }
        });

        timeSinceLastAnimation = SystemClock.uptimeMillis();
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
