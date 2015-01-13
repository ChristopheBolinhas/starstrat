package hearc.ch.starstrat.adapter;

import android.content.Context;
import android.graphics.drawable.Drawable;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import hearc.ch.starstrat.R;

/**
 * Created by juust on 24.12.2014.
 */
public class SpinnerUnitAdapter extends ArrayAdapter<String> {
    private Context mContext;
    private String[] mTitles;
    private Drawable[] mIcons;
    private Integer[] unitIds;



    public SpinnerUnitAdapter(Context context, int textViewResId, String[] titles, Drawable[] icons, Integer[] ids)
    {
        super(context,textViewResId,titles);
        this.mContext = context;
        this.mTitles = titles;
        this.mIcons = icons;

        this.unitIds = ids;
        //TODO : Adapter au remplissage automatique
    }

    public int getSelectedUnitId(int position)
    {
        return unitIds[position];
    }

    public String getSelectedUnitName(int position)
    {
        return mTitles[position];
    }

    @Override
    public View getDropDownView(int position, View convertView, ViewGroup parent)
    {
        return getCustomView(position, convertView, parent);
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent)
    {
        return getCustomView(position, convertView, parent);
    }

    public View getCustomView(int position, View convertView, ViewGroup parent)
    {
        LayoutInflater inflater = LayoutInflater.from(mContext);
        View spinnerRow = inflater.inflate(R.layout.spinner_units_style, parent, false);
        ImageView imgView = (ImageView)spinnerRow.findViewById(R.id.spinner_unit_image);
        //imgView.setImageResource(mIcons[position]);
        imgView.setImageDrawable(mIcons[position]);
        TextView textView = (TextView)spinnerRow.findViewById(R.id.spinner_unit_text);
        textView.setText(mTitles[position]);

        return spinnerRow;


    }
}
