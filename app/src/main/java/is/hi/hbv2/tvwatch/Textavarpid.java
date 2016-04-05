package is.hi.hbv2.tvwatch;

import android.content.Context;
import android.util.Log;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.util.ArrayList;
import java.util.Collections;


/**
 * Created by ari on 05-Mar-16.
 */
public class Textavarpid implements JSONFetching{
    //API til að fá formattaða lista

    
    private ArrayList<SingleProgramm> sched = new ArrayList<SingleProgramm>();

    JSONArray jArr = new JSONArray();
    public Textavarpid(JSONTask jTask){
        //JSONTask jTask = new JSONTask(this);

        jTask.execute("http://www.apis.is/tv/stod2");

    }

    public void buildJsonArray(){
        for ( int i = 0; i < jArr.length(); i++) {

            try{
                sched.add(new SingleProgramm(jArr.getJSONObject(i), "ruv"));
            }catch (JSONException e){

            }
            //Collections.sort(sched, new SingleProgrammComparator());

            Log.d("villa", "" + i);
        }
    }




    public ArrayList<SingleProgramm> getFavorites(){
        return sched;
    }
    public ArrayList<SingleProgramm> getNextUp(){
        return sched;
    }




    @Override
    public void didFetch(JSONArray jsonArray, String tvStation) throws JSONException {
        jArr = jsonArray;
        buildJsonArray();

        try{
            Log.d("asd",jArr.getJSONObject(0).getString("title"));
        }catch (JSONException e){
            Log.d("didFetch failed", "Big time");
        }

    }
}
