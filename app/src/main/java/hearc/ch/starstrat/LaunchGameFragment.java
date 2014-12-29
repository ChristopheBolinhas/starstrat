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
    private int withScreen;
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

        tabImageAnimation = new ImageView[6];
        tabLayoutImage = new LinearLayout[10];
        nbAnimation = 10;
        isPause = false;


        for(int i = 0; i < 10 ; i++)
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

        /*
        layoutAnimation.addView(imageAnimation);
        imageAnimation.animate().translationX(-100).scaleX((float)0.2).scaleY((float)0.2).setDuration(0).withLayer();
*/
        //GET SCREEN SIZE
        DisplayMetrics displaymetrics = new DisplayMetrics();
        getActivity().getWindowManager().getDefaultDisplay().getMetrics(displaymetrics);
        final int height = displaymetrics.heightPixels;
        final int width = displaymetrics.widthPixels;
        withScreen = displaymetrics.widthPixels;

        /* MARCHE MAIS PAS PRATIQUE (TRANSLATION SEPARER DE SCALE)
        trAnim1 = new TranslateAnimation(0, (width/2),0,0);
        trAnim1.setDuration(3000);
        trAnim2 = new TranslateAnimation(layoutAnimation.getMeasuredWidth()/4, layoutAnimation.getMeasuredWidth()/2,0,0);
        trAnim2.setDuration(3000);
        trAnim3 = new TranslateAnimation(layoutAnimation.getMeasuredWidth()/2, layoutAnimation.getMeasuredWidth()/2+ layoutAnimation.getMeasuredWidth()/4,0,0);
        trAnim3.setDuration(3000);
        trAnim4 = new TranslateAnimation(layoutAnimation.getMeasuredWidth()/2+ layoutAnimation.getMeasuredWidth()/4, layoutAnimation.getMeasuredWidth(), layoutAnimation.getMeasuredHeight()/2, layoutAnimation.getMeasuredHeight()/2);
        */

        buttonLaunchGame = (Button)getActivity().findViewById(R.id.buttonLaunchGame);
        buttonLaunchGame.setOnClickListener(new View.OnClickListener() {
            private boolean isFirst = true;
            @Override
            public void onClick(View v) {

                /* MARCHE PAS, COORDONNE CENSER ETRE EN % EST EN PIXEL (MEILLEURE METHODE POURTANT...)
                Animation animation = AnimationUtils.loadAnimation(getActivity().getApplicationContext(), R.anim.game_anim);
                textAnim.startAnimation(animation);
                //textAnim.startAnimation(trAnim1);
                */

                //launchAnimation(0,width,height);

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
        if(index == 0)
            whereFirstPassed++;
        layoutAnimation.addView(tabLayoutImage[index]);
        tabLayoutImage[index].animate().translationX((withScreen/4)-tabLayoutImage[index].getMeasuredWidth()).scaleX(0.5f).scaleY(0.5f).setDuration(timeAnimate).withLayer();
        if(index < 9)
            hAnimation.postDelayed(launchFirst,timeBetweenAnimation);

        hAnimation2.postDelayed(launchSecond,timeBetweenAnimation);
    }

    private void launch2(int index)
    {
        if(index == 0)
            whereFirstPassed++;
        tabLayoutImage[index].animate().translationX(withScreen/2 - tabLayoutImage[index].getMeasuredWidth()).scaleX(2f).scaleY(2f).setDuration(timeAnimate).withLayer();
        hAnimation3.postDelayed(launchThird,timeBetweenAnimation);
    }

    private void launch3(int index)
    {
        if(index == 0)
            whereFirstPassed++;
        tabLayoutImage[index].animate().translationX(withScreen-withScreen/4).scaleX(0.5f).scaleY(0.5f).setDuration(timeAnimate).withLayer();
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

    private void launchAnimation(int ind, final int width, final int height)
    {
        final int index = ind;
        final int quartW = width/4;
        final int demiW = width/4;


        layoutAnimation.addView(tabLayoutImage[index]);
        tabLayoutImage[index].animate().scaleX(0.5f).scaleY(0.5f).translationX(quartW - (tabLayoutImage[index].getWidth()*0.5f)).setDuration(1000).withLayer().withEndAction(new Runnable() {
            @Override
            public void run() {
                tabLayoutImage[index].animate().scaleX(2).scaleY(2).translationX(demiW - (tabLayoutImage[index].getMeasuredWidth())).setStartDelay(3000).setDuration(1000).withLayer().withStartAction(new Runnable() {
                    @Override
                    public void run() {
                        if (index < 9)
                            launchAnimation(index + 1, width, height);
                    }
                }).withEndAction(new Runnable() {

                    @Override
                    public void run() {
                        tabLayoutImage[index].animate().scaleX(0.5f).scaleY(0.5f).translationX(width - quartW - (tabLayoutImage[index].getWidth() * 0.5f)).setStartDelay(3000).setDuration(1000).withLayer().withEndAction(new Runnable() {

                            @Override
                            public void run() {
                                tabLayoutImage[index].animate().translationX(width).scaleX((float) 0.2).scaleY((float) 0.2).withLayer().setDuration(1000).withEndAction(new Runnable() {

                                    @Override
                                    public void run() {

                                        layoutAnimation.removeView(tabLayoutImage[index]);
                                    }
                                });
                            }
                        });
                    }
                });
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
