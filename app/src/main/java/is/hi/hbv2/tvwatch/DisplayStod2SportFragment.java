package is.hi.hbv2.tvwatch;

import android.support.v4.app.Fragment;
import android.content.Context;
import android.os.Bundle;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ListView;

import org.json.JSONArray;
import org.json.JSONException;

import java.util.ArrayList;

/**
 * Created by ari on 16/04/04.
 */
public class DisplayStod2SportFragment extends Fragment implements JSONFetching {

    private ArrayList<SingleProgramm> sched = new ArrayList<SingleProgramm>();
    View parentView;
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        parentView = inflater.inflate(R.layout.fravorites_fragment, container, false);

        JSONTask jTask = new JSONTask(this);
        jTask.execute("http://www.apis.is/tv/stod2sport");

        return parentView;
    }
    public void populateLayout(){
        ListView listView = (ListView)parentView.findViewById(R.id.listview);

        SingleProgrammAdapter adapter = new SingleProgrammAdapter(getContext(),R.layout.temporary_textview,sched);

        listView.setAdapter(adapter);
    }


    @Override
    public void didFetch(JSONArray jsonArray) throws JSONException {
        for ( int i = 0; i < jsonArray.length(); i++) {

            try{
                sched.add(new SingleProgramm(jsonArray.getJSONObject(i)));
            }catch (JSONException e){

            }
            //Collections.sort(sched, new SingleProgrammComparator());

            Log.d("villa", "" + i);
        }
        populateLayout();
    }
}
