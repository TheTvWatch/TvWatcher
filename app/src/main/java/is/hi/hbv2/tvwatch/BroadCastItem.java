package is.hi.hbv2.tvwatch;

import android.util.Log;

import org.json.JSONException;
import org.json.JSONObject;

import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;

import static java.lang.Boolean.parseBoolean;

/**
 * Created by ari on 14-Feb-16.
 */
public class BroadCastItem {
    private String title = "";
    private String originalTitle = "";
    private String duration = "";
    private String description = "";
    private String shortDescription = "";
    private boolean live = false;
    private boolean premier = false;
    private Date startTime;
    private boolean reccuring = false;
    private int episode;
    private int series;
    public BroadCastItem(JSONObject json) {

        try{
            title = json.getString("title");
        } catch (JSONException e){

        }
        try{
            originalTitle = json.getString("originalTitle");
        } catch (JSONException e){
            //
        }
        try{
            duration = json.getString("duration");
        } catch (JSONException e){
            //
        }
        try{
            description = json.getString("description");
        } catch (JSONException e){
            //
        }
        try{
            shortDescription = json.getString("shortDescription");
        } catch (JSONException e){
            //
        }
        try{
            originalTitle = json.getString("originalTitle");
        } catch (JSONException e){
            //
        }
        try{
            live = parseBoolean(json.getString("live"));
        } catch (JSONException e){
            //
        }
        try{
            premier = parseBoolean(json.getString("premier"));
        } catch (JSONException e){
            //
        }
        try{
            title = json.getString("title");
        } catch (JSONException e){
            //
        }
        //startTime":"2016-03-05 07:45:00",
        try {
            DateFormat dateformat = new SimpleDateFormat("yyyy-mm-dd HH:mm:ss");
            try {
                startTime = dateformat.parse(json.getString("startTime"));
            } catch(ParseException p) {
                //
            }
        } catch (JSONException e){
            Log.d("Failiure", "Could Not Get Date Thingy");
        }
        
        /*
        JSONObject s = json.getJSONObject("series");
        episode = Integer.parseInt(s.getString("episode"));
        series = Integer.parseInt(s.getString("series"));
        //reccuring = parseBoolean(json.getString())
        */

        Log.d("Success", "Thattur " + this.title() + " buinn til");
    }
    public String title() {
        if (title.isEmpty()) {
            return "No Title";
        }
        return title;
    }
    public String originalTitle() {
        if (originalTitle.isEmpty()) {
            return "No Original Title";
        }
        return originalTitle;
    }
    public String duration() {
        if (duration.isEmpty()){
            return "";
        }
        return duration;
    }
    public String description() {
        if (description.isEmpty()){
            return "No Description";
        }
        return description;
    }
    public String shortDescription() {
        if (shortDescription.isEmpty()){
            return "";
        }
        return shortDescription;
    }
    public boolean isLive() {
        return live;
    }
    public boolean isPremier() {
        return premier;
    }

    public String startTimeAsString() {
        String ret = "";
        ret += startTime.getHours() + ":" + startTime.getMinutes();
        return ret;
    }

    public Date getStartDate() {
        return startTime;
    }

    public boolean isReccuring() {
        return reccuring;
    }
    public int episode() {
        return episode;
    }
    public int series() {
        return series;
    }
}
