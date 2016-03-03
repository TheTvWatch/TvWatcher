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
            vc.titleView = title;
            vc.descView = desc;
            convertView.setTag(vc);
        }else{
            vc = (ViewContainer)convertView.getTag();
        }
        BroadCastItem item = getItem(position);
        vc.titleView.setText(item.getTitle());
        vc.descView.setText(item.getDesc());

        return convertView;
    }
    static class ViewContainer{

        TextView titleView;
        TextView descView;
        FrameLayout frameLayout;
        ViewContainer (){

        }
    }
}

