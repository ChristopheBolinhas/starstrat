package hearc.ch.starstrat.adapter;

import android.app.Activity;
import android.content.Context;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.GridView;
import android.widget.ImageButton;

import hearc.ch.starstrat.MainActivity;
import hearc.ch.starstrat.R;

/**
 * Created by JuUsT on 23.12.2014.
 */
public class HomeButtonAdapter extends BaseAdapter {
    private Context mContext;
    private MainActivity activity;

    public HomeButtonAdapter(Context c, MainActivity a)
    {
        mContext = c;
        activity = a;
    }

    @Override
    public int getCount() {
        return menuStyles.length;
    }

    @Override
    public Object getItem(int i) {
        return null;
    }

    @Override
    public long getItemId(int i) {
        return 0;
    }

    @Override
    public View getView(final int position, View view, ViewGroup viewGroup) {
        ImageButton button;
        if(view == null)
        {
            button = new ImageButton(mContext);
            button.setBackgroundResource(menuStyles[position]);
            button.setImageResource(menuImages[position]);
            button.setLayoutParams(new GridView.LayoutParams(120,120));
            button.setPadding(8,8,8,8);
            button.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {
                    activity.displayView(position+1);
                }
            });

        }
        else
        {
            button = (ImageButton) view;
        }
        return button;
    }

    public Integer[] menuStyles = {
           R.drawable.button_home_style,
           R.drawable.button_home_style,
           R.drawable.button_home_style,
            R.drawable.button_home_style,
            R.drawable.button_home_style,
            R.drawable.button_home_style

    };

    public Integer[] menuImages = {
           R.drawable.ic_home_favs,
            R.drawable.ic_home_favs,
            R.drawable.ic_home_favs,
            R.drawable.ic_home_favs,
            R.drawable.ic_home_favs,
            R.drawable.ic_home_favs
    };

}
