package is.hi.hbv2.tvwatch;

import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ListView;

import java.util.ArrayList;

import is.hi.hbv2.tvwatch.BroadCastItem;

/**
 * Created by ari on 13-Feb-16.
 */
public class NextUpFragment extends Fragment {
    private ArrayList<BroadCastItem> sched;
    Textavarpid t = new Textavarpid();
    View parentView;
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        parentView = inflater.inflate(R.layout.next_up_fragment, container, false);
        populateLayout();
        return parentView;

    }


    public void populateLayout(){
        ListView listView = (ListView)parentView.findViewById(R.id.listview);
        //We get list from the textavarp

        ArrayList<BroadCastItem> sched = t.getNextUp();
        //We popluate with the data
        BroadCastItemAdapter adapter = new BroadCastItemAdapter(getContext(),R.layout.temporary_textview,sched);

        listView.setAdapter(adapter);
    }

}
