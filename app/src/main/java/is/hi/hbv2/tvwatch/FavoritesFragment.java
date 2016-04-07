package is.hi.hbv2.tvwatch;

import android.content.Context;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ListView;

import org.json.JSONArray;
import org.json.JSONException;

import java.util.ArrayList;

/**
 * Created by ari on 13-Feb-16.
 */
public class FavoritesFragment extends Fragment implements JSONFetching{
    ListView listView;

    private ArrayList<SingleProgramm> sched = new ArrayList<SingleProgramm>();
    View parentView;
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        parentView = inflater.inflate(R.layout.fravorites_fragment, container, false);

        JSONTask jTask = new JSONTask(this);
        jTask.execute("http://www.apis.is/tv/stod2");

        return parentView;
    }

    @Override
    public void onViewCreated(View view, Bundle savedInstanceState) {
        populateLayout();
        super.onViewCreated(view, savedInstanceState);

    }



    public void populateLayout(){
        ListView listView = (ListView)parentView.findViewById(R.id.listview);


        LayoutInflater inflater = (LayoutInflater) getContext()
                .getSystemService(Context.LAYOUT_INFLATER_SERVICE);


        SingleProgrammAdapter adapter = new SingleProgrammAdapter(getContext(),R.layout.temporary_textview,sched);

        listView.setAdapter(adapter);
    }


    @Override
    public void didFetch(JSONArray jsonArray, String tvStation) throws JSONException {
        for ( int i = 0; i < jsonArray.length(); i++) {

            try{
                sched.add(new SingleProgramm(jsonArray.getJSONObject(i), tvStation, false));
            }catch (JSONException e){

            }
            //Collections.sort(sched, new SingleProgrammComparator());

        }
        populateLayout();
    }
}