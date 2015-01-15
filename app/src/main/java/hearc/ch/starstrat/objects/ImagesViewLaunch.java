package hearc.ch.starstrat.objects;

import android.app.Activity;
import android.content.Context;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.Toast;

import java.util.ArrayList;
import java.util.List;

import hearc.ch.starstrat.R;
import hearc.ch.starstrat.dataBase.Use.UseBDD;
import hearc.ch.starstrat.model.StrategyListItem;

/**
 * Created by Pierre on 13.01.2015.
 */
public class ImagesViewLaunch {

    List<UnitItem> myListOfUnit;
    Activity myActivity;
    float littleScale, bigScale;
    int nbImagePerLine;
    boolean isVibrate;
    LinearLayout linearAnimation;

    public int getNBUnit()
    {
        return myListOfUnit.size();
    }

    public void addUnit(UnitItem unit)
    {
        myListOfUnit.add(unit);
    }

    public boolean getIsVibrate(){return isVibrate;}

    public float getLittleScale()
    {
        return littleScale;
    }

    public float getBigScale()
    {
        return bigScale;
    }

    public void setLittleScale(float scale){
        littleScale = scale;
    }

    public void setBigScale(float scale){
        bigScale = scale;
    }

    public LinearLayout getLinearAnimation()
    {
        return linearAnimation;
    }

    public ImagesViewLaunch(Activity activity)
    {
        myActivity = activity;
        myListOfUnit = new ArrayList<UnitItem>();
        isVibrate = false;
    }

    public void constructImagesView(int height)
    {
        linearAnimation = new LinearLayout(myActivity);

        //Construction des vues avec les images
        linearAnimation.setOrientation(LinearLayout.VERTICAL);

        //Number of image per line
        if(myListOfUnit.size() < 6)
            nbImagePerLine = 1;
        else if(myListOfUnit.size() < 12)
            nbImagePerLine = 2;
        else
            nbImagePerLine = 3;

        //foreach unit, get the image
        for(int j = 0; j < myListOfUnit.size(); j+= nbImagePerLine)
        {
            LinearLayout l = new LinearLayout(myActivity);
            l.setOrientation(LinearLayout.HORIZONTAL);

            for(int i = 0; i < nbImagePerLine; i++)
            {
                if((j+i) < myListOfUnit.size()) {

                    //Creation of the horizontal image
                    ImageView tmp = new ImageView(myActivity);

                    tmp.setImageDrawable(myListOfUnit.get(j + i).getIcon());
                    tmp.setMinimumWidth(30);
                    tmp.setMinimumHeight(30);
                    tmp.setMaxHeight(60);
                    tmp.setMaxWidth(60);
                    l.addView(tmp);

                    //if vibrate then isvibrate = true
                    if(myListOfUnit.get(i+j).getVibrate()) {
                        isVibrate = true;
                    }
                }

            }
            //Put the horizontal image in vertical layout
            linearAnimation.addView(l);

        }
    }
}
