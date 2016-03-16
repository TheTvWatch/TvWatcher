package is.hi.hbv2.tvwatch;

import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ListView;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.util.ArrayList;

/**
 * Created by ari on 13-Feb-16.
 */
public class NextUpFragment extends Fragment implements JSONFetching {
    private ArrayList<SingleProgramm> sched;
    //Textavarpid t = new Textavarpid();
    View parentView;
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        parentView = inflater.inflate(R.layout.next_up_fragment, container, false);

        new JSONTask(this).execute("http://apis.is/tv/stod2");

        //populateLayout();
        return parentView;

    }


    public void populateLayout(){
        ListView listView = (ListView)parentView.findViewById(R.id.listview);
        //We get list from the textavarp

        ArrayList<SingleProgramm> sched;// = t.getNextUp();
        //We popluate with the data
        SingleProgrammAdapter adapter = new SingleProgrammAdapter(getContext(),R.layout.temporary_textview,this.sched);

        listView.setAdapter(adapter);
    }
    public void didFetch(JSONArray result)
    {

        ArrayList<SingleProgramm> listdata = new ArrayList<SingleProgramm>();
        JSONArray jArray = result;
        if (jArray != null) {
            for (int i=0;i<jArray.length();i++){
                try
                {
                    listdata.add(new SingleProgramm(jArray.getJSONObject(i)));
                }
                catch (JSONException e)
                {
                    e.printStackTrace();
                }
            }
        }

        this.sched = listdata;
        this.populateLayout();
    }
}
