package is.hi.hbv2.tvwatch;

import android.content.Context;
import android.view.Display;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.WindowManager;
import android.widget.ArrayAdapter;
import android.widget.FrameLayout;
import android.widget.LinearLayout;
import android.widget.TextView;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by ari on 02-Mar-16.
 */
public class BroadCastItemAdapter extends ArrayAdapter<BroadCastItem> {
    private LayoutInflater inflater;

    public BroadCastItemAdapter(Context c,int id, List<BroadCastItem> myspace){
        super(c, id, myspace);
        inflater = (LayoutInflater)getContext().getSystemService(getContext().LAYOUT_INFLATER_SERVICE);
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent){
        ViewContainer vc = null;
        if (convertView == null){
            vc = new ViewContainer();
            convertView = inflater.inflate(R.layout.temporary_textview, null);
            TextView title = (TextView)convertView.findViewById(R.id.itemtitle);
            TextView desc = (TextView)convertView.findViewById(R.id.itemdesc);
            TextView starttime = (TextView)convertView.findViewById(R.id.startTimeView);
            TextView duration = (TextView)convertView.findViewById(R.id.durationView);
            TextView longDesc = (TextView)convertView.findViewById(R.id.description);
            //FrameLayout frame = (FrameLayout)convertView.findViewById(R.id.detailsView);


            vc.titleView = title;
            vc.descView = desc;
            vc.startTimeView = starttime;
            vc.durationView = duration;
            vc.longDescView = longDesc;
            convertView.setTag(vc);
        }else{
            vc = (ViewContainer)convertView.getTag();
        }
        BroadCastItem item = getItem(position);
        vc.titleView.setText(item.title());
        vc.descView.setText("+");
        vc.durationView.setText("Duration : +"+item.duration());
        vc.longDescView.setText(item.shortDescription());
        //
        //vc.startTimeView.setText(item.);

        //Set onlick listener to induvidual view
        convertView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                int vis = v.findViewById(R.id.detailsView).getVisibility();
                if (vis == View.GONE) {
                    v.findViewById(R.id.detailsView).setVisibility(View.VISIBLE);
                } else {
                    v.findViewById(R.id.detailsView).setVisibility(View.GONE);
                }

            }
        });

        return convertView;
    }
    static class ViewContainer{

        TextView titleView;
        TextView descView;
        TextView longDescView;
        TextView startTimeView;
        TextView durationView;
        ViewContainer (){

        }

    }

}


