package hearc.ch.starstrat;

import android.animation.Animator;
import android.app.ActionBar;
import android.app.Activity;
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
import android.widget.TextView;

/**
 * A simple {@link Fragment} subclass.
 * Activities that contain this fragment must implement the
 * to handle interaction events.
 * Use the {@link LaunchGameFragment#newInstance} factory method to
 * create an instance of this fragment.
 */
public class LaunchGameFragment extends Fragment {

    private ImageView[] tabImageAnimation;

    private TextView textTotalTime, textStepTime;
    private Button buttonLaunchGame;
    private TextView text,textAnim;
    private ImageView imageAnimation;
    private LinearLayout layoutAnimation;

    private TranslateAnimation trAnim1, trAnim2, trAnim3, trAnim4;

    private int totalTime, stepTime, stepTimeTMP;

    private int activityOrientation;

    private Thread thread;
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

        text = (TextView)getActivity().findViewById(R.id.textTest);
        textTotalTime = (TextView)getActivity().findViewById(R.id.timerTotal);
        textStepTime = (TextView)getActivity().findViewById(R.id.timerActuel);
        layoutAnimation = (LinearLayout)getActivity().findViewById(R.id.layoutAnimation);

        tabImageAnimation = new ImageView[10];

        for(int i=0; i < 10; i++) {
            ImageView tmp = new ImageView(getActivity());
            tmp.setImageResource(R.drawable.ic_home_favs);
            tabImageAnimation[i] = tmp;
        }/*
        layoutAnimation.addView(imageAnimation);
        imageAnimation.animate().translationX(-100).scaleX((float)0.2).scaleY((float)0.2).setDuration(0).withLayer();
*/
        //GET SCREEN SIZE
        DisplayMetrics displaymetrics = new DisplayMetrics();
        getActivity().getWindowManager().getDefaultDisplay().getMetrics(displaymetrics);
        final int height = displaymetrics.heightPixels;
        final int width = displaymetrics.widthPixels;

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
            int index = 0;
            @Override
            public void onClick(View v) {

                System.out.println("lalalalalalalalala"+ layoutAnimation.getMeasuredWidth());

                /* MARCHE PAS, COORDONNE CENSER ETRE EN % EST EN PIXEL (MEILLEURE METHODE POURTANT...)
                Animation animation = AnimationUtils.loadAnimation(getActivity().getApplicationContext(), R.anim.game_anim);
                textAnim.startAnimation(animation);
                //textAnim.startAnimation(trAnim1);
                */

                launchAnimation(0,width,height);

                handlerStep.post(updateStep);

            }
        });

        //Réception des temps
        totalTime = 1000;
        stepTime = 50;
        stepTimeTMP = 1;
    }

    private void launchAnimation(int ind, final int width, final int height)
    {
        final int index = ind;
        final int quartW = width/4;
        final int demiW = width/4;
        layoutAnimation.addView(tabImageAnimation[index]);
        tabImageAnimation[index].animate().translationX(quartW).scaleX((float) 0.5).scaleY((float) 0.5).setDuration(1000).withLayer().withEndAction(new Runnable() {
            @Override
            public void run() {
                tabImageAnimation[index].animate().scaleX(2).scaleY(2).translationX(demiW).setStartDelay(3000).setDuration(1000).withLayer().withEndAction(new Runnable() {

                    @Override
                    public void run() {
                        if(index < 9)
                            launchAnimation(index+1,width,height);
                        tabImageAnimation[index].animate().translationX(width-quartW).scaleX((float) 0.5).scaleY((float) 0.5).setStartDelay(3000).setDuration(1000).withLayer().withEndAction(new Runnable() {

                            @Override
                            public void run() {
                                tabImageAnimation[index].animate().translationX(width+tabImageAnimation[index].getMeasuredWidth()).scaleX((float)0.2).scaleY((float)0.2).withLayer().setDuration(1000).withEndAction(new Runnable() {

                                    @Override
                                    public void run() {

                                        layoutAnimation.removeView(tabImageAnimation[index]);
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
