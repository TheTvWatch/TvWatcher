package is.hi.hbv2.tvwatch;

import android.content.Context;
import android.content.res.AssetManager;
import android.graphics.drawable.Drawable;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.CheckBox;
import android.widget.CompoundButton;
import android.widget.ImageView;
import android.widget.ListAdapter;
import android.widget.TextView;

import java.util.List;

/**
 * Created by ari on 02-Mar-16.
 */
public class SingleProgrammAdapter extends ArrayAdapter<SingleProgramm> {
    private LayoutInflater inflater;

    public SingleProgrammAdapter(Context c, int id, List<SingleProgramm> myspace){
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
            TextView eta = (TextView)convertView.findViewById(R.id.itemEta);
            TextView starttime = (TextView)convertView.findViewById(R.id.startTimeView);
            TextView duration = (TextView)convertView.findViewById(R.id.durationView);
            TextView desc = (TextView)convertView.findViewById(R.id.description);
            ImageView img =(ImageView)convertView.findViewById(R.id.imageView);
            CheckBox cb = (CheckBox)convertView.findViewById(R.id.favoritesCheckBox);

            vc.titleView = title;
            vc.etaView = eta;
            vc.startTimeView = starttime;
            vc.durationView = duration;
            vc.longDescView = desc;
            vc.imgView = img;
            vc.checkMeOut = cb;
            convertView.setTag(vc);
        }else{
            vc = (ViewContainer)convertView.getTag();
        }
        SingleProgramm item = getItem(position);

        vc.programData = item;
        vc.titleView.setText(item.title());
        vc.etaView.setText(item.startTimeAsString());
        vc.durationView.setText("Duration : +"+item.duration());
        vc.longDescView.setText(item.description());

        //vc.imgView.setImageResource(R.drawable.ruv_logo);
        //Setja byrjunar t�man � startTimeView ur itemi
        //vc.startTimeView.setText();

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

        if(vc.programData.getFavourites()){
          vc.checkMeOut.setChecked(true);
        }

        final ViewContainer finalVc = vc;
        vc.checkMeOut.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {
                if(isChecked){
                    finalVc.programData.setFavourites();
                }else if(!isChecked){
                    finalVc.programData.setFavourites();
                }
            }
        });

        return convertView;
    }
    static class ViewContainer{

        TextView titleView;
        TextView etaView;
        TextView longDescView;
        TextView startTimeView;
        TextView durationView;
        ImageView imgView;
        SingleProgramm programData;
        CheckBox checkMeOut;
        ViewContainer (){

        }

    }
    public void refresh()
    {
        super.clear();
        this.notifyDataSetChanged();
    }



}


