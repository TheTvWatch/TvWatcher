package is.hi.hbv2.tvwatch;

import android.util.Log;

import org.json.JSONException;
import org.json.JSONObject;

import java.lang.reflect.Array;
import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;

import static java.lang.Boolean.parseBoolean;

/**
 * Created by ari on 14-Feb-16.
 */
public class SingleProgramm {
    private String title = "";
    private String originalTitle = "";
    private String duration = "";
    private String description = "";
    private String shortDescription = "";
    private String station = "";
    private boolean live = false;
    private boolean premier = false;
    private Date startTime;
    public boolean favourite = false;
    private boolean reccuring = false;
    private int episode;
    private int series;

    public SingleProgramm(JSONObject json, String tvStation) {

        station = tvStation;

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

        try {
            JSONObject s = json.getJSONObject("series");
            try {
                String tempEpisodeString = s.getString("episode");
                String tempSeriesString = s.getString("series");
                if ( tempEpisodeString.isEmpty() && tempSeriesString.isEmpty() ){
                    reccuring = false;
                    episode = -1;
                    series = -1;
                } else {
                    reccuring = true;
                    episode = Integer.parseInt(tempEpisodeString);
                    series = Integer.parseInt(tempSeriesString);
                }

            } catch (JSONException e) {
                //
            }
        } catch (JSONException e) {
            //
        }
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
            return "N/A";
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
            return "No Short Description";
        }
        return shortDescription;
    }

    public String tvStation() {
        return station;
    }

    public Boolean isFavourite(){return favourite;}
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
    public Boolean setFavourites() {
        favourite=!favourite;
        Log.d("Success", "Thattur " + this.title() + " er favourite");
        return favourite;
    }
    public Boolean getFavourites() {
        return favourite;
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

    public String channel() {
        return "RUV";
    }
}
