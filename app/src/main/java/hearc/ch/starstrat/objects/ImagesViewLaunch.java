package hearc.ch.starstrat.objects;

import android.app.Activity;
import android.content.Context;
import android.widget.ImageView;
import android.widget.LinearLayout;

import java.util.List;

import hearc.ch.starstrat.R;
import hearc.ch.starstrat.model.StrategyListItem;

/**
 * Created by Pierre on 13.01.2015.
 */
public class ImagesViewLaunch {

    List<UnitItem> myListOfUnit;
    Activity myActivity;
    float littleScale, bigScale, sizeImage;
    int nbImagePerLine = 2;
    boolean isVibrate;
    LinearLayout linearAnimation;

    public boolean getIsVibrate(){return isVibrate;}

    public float getLittleScale()
    {
        return littleScale;
    }

    public float getBigScale()
    {
        return bigScale;
    }

    public LinearLayout getLinearAnimation()
    {
        return linearAnimation;
    }

    public ImagesViewLaunch(List<UnitItem> listUnit, Activity activity)
    {
        myListOfUnit = listUnit;
        myActivity = activity;

        isVibrate = false;
    }

    public void constructImagesView(int height)
    {
        linearAnimation = new LinearLayout(myActivity);

        //Construction des vues avec les images
        linearAnimation.setOrientation(LinearLayout.VERTICAL);

        //NBRE DIMAGE PR CHAQUE ANIMATION
        int nbImage = 6;
        //?????????
        nbImagePerLine = 2;

        //foreach unit
        //if vibrate then isvibrate = true

        for (int j = 0; j < nbImage; j += 2) {

            LinearLayout l = new LinearLayout(myActivity);
            l.setOrientation(LinearLayout.HORIZONTAL);

            for(int i = 0; i < nbImagePerLine; i++)
            {
                //Création des images horizontales
                ImageView tmp = new ImageView(myActivity);
                //Image de myListOfUnit.get(j+i);
                tmp.setImageResource(R.drawable.ic_home_favs);
                sizeImage = tmp.getMeasuredWidth();
                l.addView(tmp);
            }


            //Mettre les images horizontales a la suite verticalement
            linearAnimation.addView(l);
        }

        //Pas sur du bon endroit
        //littleScale = (height/2)/linearAnimation.getMeasuredHeight();
    }
}
