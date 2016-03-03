package is.hi.hbv2.tvwatch;

import android.app.ListFragment;
import android.content.Context;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ListAdapter;
import android.widget.ListView;
import android.widget.TextView;

import java.util.ArrayList;

import is.hi.hbv2.tvwatch.BroadCastItem;

/**
 * Created by ari on 13-Feb-16.
 */
public class FavoritesFragment extends Fragment {
    ListView listView;

    private ArrayList<BroadCastItem> sched = new ArrayList<BroadCastItem>();
    View parentView;
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        parentView = inflater.inflate(R.layout.fravorites_fragment, container, false);
        populateSched();
        populateLayout();
        return parentView;
    }

    public void populateSched(){
        sched.add(new BroadCastItem("Þáttur1", "lýsing1"));
        sched.add(new BroadCastItem("Þáttur2", "lýsing2"));
        sched.add(new BroadCastItem("Þáttur3", "lýsing3"));
        sched.add(new BroadCastItem("Þáttur4", "lýsing4"));
        sched.add(new BroadCastItem("Þáttur5", "lýsing5"));

    }
    /*
    @Override
    public void onViewCreated(View view, Bundle savedInstanceState) {
        populateLayout();
        super.onViewCreated(view, savedInstanceState);

    }
    */
    public void populateLayout(){
        ListView listView = (ListView)parentView.findViewById(R.id.listview);
        //View v =(View) parentView.findViewById(R.layout.single_boradcastitem_layout);

        LayoutInflater inflater = (LayoutInflater) getContext()
                .getSystemService(Context.LAYOUT_INFLATER_SERVICE);
        View rowView = inflater.inflate(R.layout.single_boradcastitem_layout, null);
        boolean boo = (rowView == null);
        Log.w("RowView",""+boo);
        TextView tt = (TextView)rowView.findViewById(R.id.item_title);
        TextView td = (TextView)rowView.findViewById(R.id.item_description);
        ArrayList<String> tempStringList = new ArrayList<String>();
        for (BroadCastItem b : sched){
            tt.setText(b.getTitle());
            tempStringList.add(b.getTitle());
        }
        ArrayAdapter<String> adapter = new ArrayAdapter<String>(getContext(), R.layout.temporary_textview, tempStringList);
        listView.setAdapter(adapter);
    }
}