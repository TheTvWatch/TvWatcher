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
import org.json.JSONObject;

import java.util.Calendar;
import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.TimeZone;

/**
 * Created by ari on 13-Feb-16.
 */
public class NextUpFragment extends Fragment implements JSONFetching{
    ListView listView;
    private ArrayList<SingleProgramm> sched = new ArrayList<SingleProgramm>();
    private int counter = 0;

    View parentView;
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        parentView = inflater.inflate(R.layout.next_up_fragment, container, false);


        // TODO: Get endpoints from apis.is/tv and use those instead of having it hardcoded
        JSONTask jTask = new JSONTask(this);
        jTask.execute("http://www.apis.is/tv/ruv");
        /*
        JSONTask jTask2 = new JSONTask(this);
        jTask2.execute("http://www.apis.is/tv/stod2");
        JSONTask jTask3 = new JSONTask(this);
        jTask3.execute("http://www.apis.is/tv/stod3");
        */

        return parentView;

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

        Log.d("TvStation", tvStation);

        // NEXT UP CASE
        for ( int i = 0; i < jsonArray.length(); i++) {

            JSONObject obj = jsonArray.getJSONObject(i);

            Date currentDate = new Date();
            Date startTimeDate = new Date();
            DateFormat showDateFormat = new SimpleDateFormat("yyyy-mm-dd HH:mm:ss");
            try {
                startTimeDate = showDateFormat.parse(obj.getString("startTime"));
            } catch(ParseException p) {

            }

            try {
                currentDate = showDateFormat.parse(giveDate());
            } catch (ParseException p) {
            }

            try {
                if ( startTimeDate.before(currentDate)) {
                    continue;
                }
            } catch (NullPointerException n) {
                //
            }

            try {
                if (startTimeDate.after(getBufferDate(currentDate, 4))) {
                    continue;
                }
            } catch (NullPointerException n) {

            }

            try{
                sched.add(new SingleProgramm(jsonArray.getJSONObject(i), tvStation));
            }catch (JSONException e){

            }
            //Collections.sort(sched, new SingleProgrammComparator());
        }
        counter += 1;

        if ( counter == 1 ) {
            populateLayout();
        }
    }
    public String giveDate() {
        Calendar cal = Calendar.getInstance();
        SimpleDateFormat sdf = new SimpleDateFormat("yyyy-mm-dd HH:mm:ss");
        sdf.setTimeZone(TimeZone.getTimeZone("GMT"));
        return sdf.format(cal.getTime());
    }

    public static Date getBufferDate(Date currentTime, int timeBuffer) {
        Calendar calendar = Calendar.getInstance();
        calendar.setTime( currentTime );
        calendar.add(Calendar.HOUR, timeBuffer);
        return calendar.getTime();
    }
}


