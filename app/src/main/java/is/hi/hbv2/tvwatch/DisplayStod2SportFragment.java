package is.hi.hbv2.tvwatch;

import android.app.AlertDialog;
import android.content.DialogInterface;
import android.support.v4.app.Fragment;
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

        JSONTask jTask = new JSONTask(this,getActivity().getApplicationContext());
        jTask.execute("http://www.apis.is/tv/stod2sport");

        return parentView;
    }
    public void populateLayout(){
        ListView listView = (ListView)parentView.findViewById(R.id.listview);

        SingleProgrammAdapter adapter = new SingleProgrammAdapter(getContext(),R.layout.single_broadcast,sched);

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
        activity.runOnUiThread(new Runnable() {
            @Override
            public void run() {
                mDialog.dismiss();
            }
        });
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
