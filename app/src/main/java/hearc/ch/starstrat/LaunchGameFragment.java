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
import android.widget.LinearLayout;
import android.widget.RelativeLayout;
import android.widget.TextView;

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

    //Real
    private LinkedList<ImagesViewLaunch> listImagesAnimation;
    private StrategyItem myStrategy;
    private float speedGame;

    //Testing
    private ImageView[] tabImageAnimation;
    private LinearLayout[] tabLayoutImage;
    private int widthScreen, heightScreen, transX = 20, marginLeftLayout = 200, sizeImage;
    private float littleScale = 0.5f, bigScale = 2;
    private boolean isPause, isPauseFinish;
    private int nbAnimation = 10, nbImage = 12, whereFirstPassed;
    private int timeAnimate = 500, timeBetweenAnimation = 3000, totalTime = 30000;
    private String textButtonStart, textButtonPause;

    private android.text.format.Time timeSincePause, timeSinceLastAnimation, totalTimeAnimation,timeAnimation;

    private TextView textTotalTime, textStepTime;
    private Button buttonLaunchGame;
    private TextView text,textAnim;
    private ImageView imageAnimation;
    private RelativeLayout layoutAnimation;

    private final Runnable updateTime = new Runnable() {
        @Override
        public void run() {
            incrementTime();
        }
    };

    private final Handler handlerStep = new Handler();
    private final Handler hRelaunchAnimation = new Handler();
    private final Handler hAnimation = new Handler();
    private final Handler hAnimation2 = new Handler();
    private final Handler hAnimation3 = new Handler();
    private final Handler hAnimation4 = new Handler();

    private final Runnable launchFirst = new Runnable() {
        int index = 2;
        @Override
        public void run() {
            if(!isPause && nbAnimation > index) {
                launch(index);
                index++;
            }

        }
    };
    private final Runnable launchSecond = new Runnable() {
        int index = 1;
        @Override
        public void run() {
            if(!isPause && nbAnimation > index) {
                launch2(index);
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

    public static LaunchGameFragment newInstance(StrategyItem strategy) {
        LaunchGameFragment fragment = new LaunchGameFragment();
        fragment.myStrategy = strategy;
        //fragment.speedGame = ((MainActivity)getActivity())
        return fragment;
    }

    public LaunchGameFragment() {
        // Required empty public constructor
    }

    public void incrementTime()
    {
        timeAnimation.format("MM:SS");
        timeAnimation.setToNow();
        long tmp = timeAnimation.toMillis(false)-totalTimeAnimation.toMillis(false);
        textStepTime.setText(""+tmp);

        if(totalTime > tmp && !isPause)
            handlerStep.postDelayed(updateTime,100);
    }

    @Override
    public void onActivityCreated (Bundle savedInstanceState) {
        super.onActivityCreated(savedInstanceState);

        textStepTime = (TextView)getActivity().findViewById(R.id.timerActuel);
        layoutAnimation = (RelativeLayout)getActivity().findViewById(R.id.layoutAnimation);

        //GET SCREEN SIZE
        DisplayMetrics displaymetrics = new DisplayMetrics();
        getActivity().getWindowManager().getDefaultDisplay().getMetrics(displaymetrics);
        final int height = displaymetrics.heightPixels;
        final int width = displaymetrics.widthPixels;
        widthScreen = displaymetrics.widthPixels;
        heightScreen = displaymetrics.heightPixels - layoutAnimation.getMeasuredHeight();

        textButtonStart = (String)getActivity().getText(R.string.launch_game_fragment_Start);
        textButtonPause = (String)getActivity().getText(R.string.launch_game_fragment_Pause);

        tabLayoutImage = new LinearLayout[nbAnimation];
        isPause = false;

        timeSinceLastAnimation = new Time();

        listImagesAnimation = new LinkedList<ImagesViewLaunch>();

        //Position the 2 first images
        //Event that happened when the window is totally draw
        ViewTreeObserver vto = getView().getViewTreeObserver();
        vto.addOnGlobalLayoutListener(new ViewTreeObserver.OnGlobalLayoutListener() {
            boolean isFirst = true;
            @Override
            public void onGlobalLayout() {
                int sizeHeight = heightScreen-getView().findViewById(R.id.layoutTime).getMeasuredHeight();

                if(isFirst) {

                    int time = 10;

                    ArrayList<UnitItem> listUnite = new ArrayList<UnitItem>();

                    //Foreach strategy item in strategylistitem (liste trié dans l'ordre du temps)
                    for(UnitItem unit : myStrategy.getListUnits(true))
                    {
                        if(unit.getSecondes() <= time)
                        {
                            //on regroupe les unites par tranche de 10 secondes
                            listUnite.add(unit);
                        }
                        else
                        {
                            //On crée l'élément a afficher avec les bonnes unités
                            ImagesViewLaunch imgGroup = new ImagesViewLaunch(listUnite,getActivity());
                            imgGroup.constructImagesView(sizeHeight);
                            listImagesAnimation.add(imgGroup);

                            listUnite = new ArrayList<UnitItem>();

                            time += 10;
                        }
                    }

                    //On place toutes les images en dehors de l'écran en format petit
                    for(ImagesViewLaunch im : listImagesAnimation)
                    {
                        layoutAnimation.addView(im.getLinearAnimation());
                        im.getLinearAnimation().animate().scaleX(littleScale).scaleY(littleScale).setDuration(0).alpha(0.2f).withLayer();
                    }

                    nbAnimation = listImagesAnimation.size();

                    isFirst = false;
                }
                else {
                    //On place les 2 premiers respectivement au centre et a gauche
                    listImagesAnimation.get(0).getLinearAnimation().animate().alpha(1).translationX(marginLeftLayout + (widthScreen/2) - (listImagesAnimation.get(0).getLinearAnimation().getMeasuredWidth()/2)).scaleX(bigScale).scaleY(bigScale).setDuration(0).withLayer();
                    listImagesAnimation.get(1).getLinearAnimation().animate().translationX(transX + marginLeftLayout).alpha(0.5f).scaleX(littleScale).scaleY(littleScale).setDuration(0).withLayer();

                    //bigScale = sizeHeight/listImagesAnimation.getFirst().getLinearAnimation().getHeight();
                    /*
                    tabLayoutImage[0].animate().alpha(1).translationX(marginLeftLayout + widthScreen / 2 - tabLayoutImage[0].getMeasuredWidth()/2).scaleX(bigScale).scaleY(bigScale).setDuration(0).withLayer();
                    tabLayoutImage[1].animate().translationX(transX + marginLeftLayout).alpha(0.5f).scaleX(littleScale).scaleY(littleScale).setDuration(0).withLayer();
                    */
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

                //Si c'est le 1er passage, on lance l'animation et change le texte du bouton
                if(isFirst) {
                    whereFirstPassed = 0;

                    handlerStep.post(updateTime);
                    isFirst = false;
                    buttonLaunchGame.setText(textButtonPause);
                    buttonLaunchGame.setText("n "+nbAnimation);

                    totalTimeAnimation = new Time();
                    timeAnimation = new Time();
                    totalTimeAnimation.setToNow();

                    hRelaunchAnimation.postDelayed(new Runnable() {
                        @Override
                        public void run() {
                            switch(whereFirstPassed)
                            {
                                case 1:
                                    hAnimation.post(launchFirst);
                                    hAnimation2.post(launchSecond);
                                    hAnimation3.post(launchThird);
                                    hAnimation4.post(launchFourth);
                                    break;

                                default:
                                    hAnimation.post(launchFirst);
                                    hAnimation2.post(launchSecond);
                                    hAnimation3.post(launchThird);
                            }
                        }
                    }, timeBetweenAnimation);
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
                                    hAnimation3.post(launchThird);
                                    hAnimation4.post(launchFourth);
                                    break;

                                default:
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

        //Réception des temps
        //timeBetween animation = 10 / vitesse du jeu
        totalTime = 30000;
    }

    private void launch(int index)
    {
        listImagesAnimation.get(index).getLinearAnimation().animate().translationX(transX + marginLeftLayout).alpha(0.5f).scaleX(littleScale).scaleY(littleScale).setDuration(timeAnimate).withLayer();

        if(index < nbAnimation)
            hAnimation.postDelayed(launchFirst,timeBetweenAnimation);

        hAnimation2.postDelayed(launchSecond, timeBetweenAnimation);

        timeSinceLastAnimation.setToNow();
    }

    private void launch2(int index)
    {
        (listImagesAnimation.get(index).getLinearAnimation()).animate().translationX(marginLeftLayout+(widthScreen/2)-listImagesAnimation.get(index).getLinearAnimation().getMeasuredWidth()/2).alpha(1).scaleX(bigScale).scaleY(bigScale).setDuration(timeAnimate).withLayer();
        //(listImagesAnimation.get(index).getLinearAnimation()).animate().translationX(marginLeftLayout+widthScreen /2 - listImagesAnimation.get(index).getLinearAnimation().getMeasuredWidth()/2).alpha(1).scaleX(bigScale).scaleY(bigScale).setDuration(timeAnimate).withLayer();
        hAnimation3.postDelayed(launchThird,timeBetweenAnimation);
        timeSinceLastAnimation.setToNow();
    }

    private void launch3(int index)
    {
        if(index == 0) {
            whereFirstPassed++;
            //tabLayoutImage[index].setLayoutParams(tabImageAnimation[index+2].getLayoutParams());
        }
        listImagesAnimation.get(index).getLinearAnimation().animate().translationX(marginLeftLayout+widthScreen-transX-(listImagesAnimation.get(index).getLinearAnimation().getMeasuredWidth()/2)).alpha(0.5f).scaleX(littleScale).scaleY(littleScale).setDuration(timeAnimate).withLayer();
        hAnimation4.postDelayed(launchFourth,timeBetweenAnimation);
        timeSinceLastAnimation.setToNow();
    }

    private void launch4(final int index)
    {
        listImagesAnimation.get(index).getLinearAnimation().animate().translationX(marginLeftLayout + widthScreen).alpha(0.2f).setDuration(timeAnimate).withLayer().withEndAction(new Runnable() {
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
