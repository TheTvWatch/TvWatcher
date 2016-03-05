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
    //Listi með dagskrá - viljum að þessi listi innihleldur aðeins favorites
    Textavarpid t = new Textavarpid();
    View parentView;
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        parentView = inflater.inflate(R.layout.fravorites_fragment, container, false);

        populateLayout();
        return parentView;
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
        //Fáum lista úr textavarpinu

        ArrayList<BroadCastItem> sched = t.getFavorites();
        //populeitum listviewið með gögnunum
        BroadCastItemAdapter adapter = new BroadCastItemAdapter(getContext(),R.layout.temporary_textview,sched);

        //líma adater við listview
        listView.setAdapter(adapter);
    }
}