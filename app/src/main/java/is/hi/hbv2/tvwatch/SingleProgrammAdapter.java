package is.hi.hbv2.tvwatch;

import android.content.Context;
import android.graphics.Color;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.CheckBox;
import android.widget.CompoundButton;
import android.widget.ImageView;
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
            convertView = inflater.inflate(R.layout.single_broadcast, null);
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
        vc.durationView.setText("Duration : +"+item.duration());
        vc.longDescView.setText(item.description());
        if(vc.programData.isOnAir()){
            vc.etaView.setText("Live NOW");
        }
        else{
            vc.etaView.setText(item.startTimeAsString());
        }


        //vc.imgView.setImageResource();
       String station = vc.programData.tvStation();
        switch (station){
            case "ruv":
                vc.imgView.setImageResource(R.drawable.ruv);
                break;
            case "stod2":
                vc.imgView.setImageResource(R.drawable.stod2);
                break;
            case "stod2sport":
                vc.imgView.setImageResource(R.drawable.sport_logo);
                break;
            case "stod2sport2":
                vc.imgView.setImageResource(R.drawable.sport2_logo);
                break;
            case "stod2sport3":
                vc.imgView.setImageResource(R.drawable.sport3_logo);
                break;
            case "stod2sport4":
                vc.imgView.setImageResource(R.drawable.sport4_logo);
                break;
            case "stod2sport5":
                vc.imgView.setImageResource(R.drawable.sport5_logo);
                break;
            case "stod2sport6":
                vc.imgView.setImageResource(R.drawable.sport6_logo);
                break;
            case "stod3":
                vc.imgView.setImageResource(R.drawable.stod_3_logo_2013);
                break;
            case "stod2bio":
                vc.imgView.setImageResource(R.drawable.stod2bio_logo);
                break;
            case "skjareinn":
                vc.imgView.setImageResource(R.drawable.skjareinn);
                break;

            default:
                break;
        }

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

        if(vc.programData.isLive()){
            vc.titleView.setTextColor(Color.parseColor("#00FF00"));
        }
        else{
            vc.titleView.setTextColor(Color.parseColor("#FFFFFF"));
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


