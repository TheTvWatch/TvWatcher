package is.hi.hbv2.tvwatch;

import android.util.Log;

import org.json.JSONException;
import org.json.JSONObject;

import java.util.Date;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;

import static java.lang.Boolean.parseBoolean;

/**
 * Created by ari on 14-Feb-16.
 */
public class BroadCastItem {
    private String title ;
    private String originalTitle;
    private String duration;
    private String description;
    private String shortDescription;
    private boolean live;
    private boolean premier;
    private Date startTime;
    private boolean reccuring;
    private int episode;
    private int series;
    public BroadCastItem(JSONObject json) {

        try{
            title = json.getString("title");
        } catch (JSONException e){
            //
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
            shortDescription = json.getString("description");
        } catch (JSONException e){
            //
        }
        try{
            title = json.getString("title");
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
        try{
            title = json.getString("title");
        } catch (JSONException e){
            //
        }


        Log.d("Success", "Thattur" + this.title() + "buinn til");

        /*
        //description = json.getString("description");
        JSONObject s = json.getJSONObject("series");
        //startTime = json.getString("startTime");
        episode = Integer.parseInt(s.getString("episode"));
        series = Integer.parseInt(s.getString("series"));
        //reccuring = parseBoolean(json.getString())
        */
    }
    public String title() {
        if (title.isEmpty()) {
            return "";
        }
        return title;
    }
    public String originalTitle() {
        if (originalTitle.isEmpty()) {
            return "";
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
        if (!live){
            return false;
        }
        return live;
    }
    public boolean isPremier() {
        if (!premier){
            return false;
        }
        return premier;
    }
    /*
    public Date startTime() {
        return startTime;
    }
    */
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
