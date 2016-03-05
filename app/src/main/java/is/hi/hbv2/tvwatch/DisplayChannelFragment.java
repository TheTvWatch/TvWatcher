package is.hi.hbv2.tvwatch;

import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

/**
 * Created by ari on 10-Feb-16.
 */
public class DisplayChannelFragment extends Fragment {

    //Textavarpid t = new Textavarpid();
    //private ArrayList<SingleProgramm> sched = new ArrayList<SingleProgramm>();
    View parentView;
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        parentView = inflater.inflate(R.layout.display_channel_fragment, container, false);
        //populateLayout();
        return parentView;
    }
    /*
    public void populateLayout(){
        ListView listView = (ListView)parentView.findViewById(R.id.listview);
        //View v =(View) parentView.findViewById(R.layout.single_boradcastitem_layout);
        ArrayList<SingleProgramm> sched = t.getNextUp();
        LayoutInflater inflater = (LayoutInflater) getContext()
                .getSystemService(Context.LAYOUT_INFLATER_SERVICE);

        //ArrayAdapter<String> adapter = new ArrayAdapter<String>(getContext(), R.layout.temporary_textview, tempStringList);
        SingleProgrammAdapter adapter = new SingleProgrammAdapter(getContext(),R.layout.temporary_textview,sched);

        listView.setAdapter(adapter);
    }
    */

}
