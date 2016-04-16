package is.hi.hbv2.tvwatch;

import android.content.Context;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.ListView;

import org.json.JSONArray;
import org.json.JSONException;

import java.util.ArrayList;
import android.app.AlertDialog;
import android.content.DialogInterface;
/**
 * Created by ari on 10-Feb-16.
 */
public class DisplayChannelFragment extends Fragment implements JSONFetching {
    ListView listView;
    JSONTask jTask;
    private ArrayList<SingleProgramm> sched = new ArrayList<SingleProgramm>();
    View parentView;
    SingleProgrammAdapter adapter;
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        parentView = inflater.inflate(R.layout.display_channel_fragment, container, false);
        jTask = new JSONTask(this,getActivity().getApplicationContext());
        Button ruvButton = (Button) parentView.findViewById(R.id.gotoRuvButton);
        Button stodButton = (Button) parentView.findViewById(R.id.gotoStod2);
        ruvButton.setOnClickListener(new View.OnClickListener() {
             @Override
             public void onClick(View v) {
                 jTask.execute("http://www.apis.is/tv/ruv");

             }
         });
        stodButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                jTask.execute("http://www.apis.is/tv/stod2");
            }
        });
        return parentView;
    }
    public void populateLayout(){

        ListView listView = (ListView)parentView.findViewById(R.id.listviewChannels);




        LayoutInflater inflater = (LayoutInflater) getContext()
                .getSystemService(Context.LAYOUT_INFLATER_SERVICE);


        if(adapter == null){
            adapter = new SingleProgrammAdapter(getContext(),R.layout.single_broadcast,sched);

        }else{

            adapter = new SingleProgrammAdapter(getContext(),R.layout.single_broadcast,sched);

        }



        listView.setAdapter(adapter);
    }

    @Override
    public void didFetch(JSONArray jsonArray, String tvStation) throws JSONException {
        for ( int i = 0; i < jsonArray.length(); i++) {

            try{
                sched.add(new SingleProgramm(jsonArray.getJSONObject(i), tvStation, false));
            }catch (JSONException e){

            }
        }
        populateLayout();
    }

    @Override
    public void didFailToFetch() {
        Log.d("Internet connection failure!","Internet is Down cannot fetch data");
        final MainActivity activity = (MainActivity) getActivity();

        if (activity.isAlertRunning)
        {
            return;
        }
        AlertDialog alertDialog = new AlertDialog.Builder(activity).create();
        alertDialog.setTitle("No Internet Connection");
        alertDialog.setMessage("Please establish a solid internet connection and try again.");

        alertDialog.setButton(AlertDialog.BUTTON_NEUTRAL, "OK",

                new DialogInterface.OnClickListener() {

                    public void onClick(DialogInterface dialog, int which) {
                        dialog.dismiss();
                        dialog.cancel();
                        activity.isAlertRunning = false;

                    }

                });
        alertDialog.show();
        activity.isAlertRunning = true;
    }
}
