package is.hi.hbv2.tvwatch;

import android.widget.ListView;

import org.json.JSONArray;
import org.json.JSONException;


/**
 * Created by ari on 13-Feb-16.
 */
public class FavoritesFragment extends NextUpFragment implements JSONFetching{
    ListView listView;


    @Override
    public void addSingleProgram(JSONArray jsonArray, int index, String tvStation, boolean onAir)
    {
        try{
            SingleProgramm program = new SingleProgramm(jsonArray.getJSONObject(index), tvStation, onAir);
            if (program.favourite)
            {
                sched.add(program);
            }
        }catch (JSONException e){

        }
    }
}