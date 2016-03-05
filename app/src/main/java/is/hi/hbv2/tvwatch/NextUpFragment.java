package is.hi.hbv2.tvwatch;

import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ListView;

import java.util.ArrayList;

/**
 * Created by ari on 13-Feb-16.
 */
public class NextUpFragment extends Fragment {
    private ArrayList<SingleProgramm> sched;
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

        ArrayList<SingleProgramm> sched = t.getNextUp();
        //We popluate with the data
        SingleProgrammAdapter adapter = new SingleProgrammAdapter(getContext(),R.layout.temporary_textview,sched);

        listView.setAdapter(adapter);
    }

}
