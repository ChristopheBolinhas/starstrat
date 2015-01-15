package hearc.ch.starstrat.adapter;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ImageButton;
import android.widget.ImageView;
import android.widget.TextView;

import java.util.List;

import hearc.ch.starstrat.MainActivity;
import hearc.ch.starstrat.R;
import hearc.ch.starstrat.model.StrategyListItem;

/**
 * Created by JuUsT on 26.12.2014.
 */
public class StrategyListAdapter extends ArrayAdapter<StrategyListItem>
{
    public StrategyListAdapter(Context mContext,List<StrategyListItem> items)
    {
        super(mContext, R.layout.list_strategy_layout,items);
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent)
    {

        if(convertView == null)
        {
            LayoutInflater inflater = LayoutInflater.from(getContext());
            convertView = inflater.inflate(R.layout.list_strategy_layout,parent, false);


        }

        ImageView logoRace = (ImageView)convertView.findViewById(R.id.ivIcon);
        TextView titleText = (TextView)convertView.findViewById(R.id.tvTitle);
        TextView descriptionText = (TextView)convertView.findViewById(R.id.tvDescription);
        ImageButton playButton = (ImageButton) convertView.findViewById(R.id.playButton);
        ImageButton editButton = (ImageButton) convertView.findViewById(R.id.editButton);
        ImageButton removeButton = (ImageButton) convertView.findViewById(R.id.removeButton);
        final StrategyListItem item = getItem(position);
        titleText.setText(item.title);
        descriptionText.setText(item.description);
        if(position == 0)
        {

            logoRace.setVisibility(View.INVISIBLE);
            editButton.setVisibility(View.INVISIBLE);
            playButton.setVisibility(View.INVISIBLE);
            logoRace.setVisibility(View.INVISIBLE);
            removeButton.setImageResource(R.drawable.ic_add);
            removeButton.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    ((MainActivity)getContext()).setStrategieMakerFragement(null);
                }
            });
        }
        else

        {



            logoRace.setImageResource(item.raceIcon);

            playButton.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    ((MainActivity)getContext()).playStrat(item.getItem());
                }
            });
            editButton.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    ((MainActivity)getContext()).editStrat(item.getItem());
                }
            });
            removeButton.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    ((MainActivity)getContext()).removeStrat(item.getItem());
                }
            });

        }

        return convertView;
    }

}
