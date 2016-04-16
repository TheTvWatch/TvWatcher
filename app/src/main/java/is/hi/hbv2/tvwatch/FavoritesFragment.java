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
<<<<<<< HEAD
    public void onViewCreated(View view, Bundle savedInstanceState) {
        populateLayout();
        super.onViewCreated(view, savedInstanceState);

    }



    public void populateLayout(){
        ListView listView = (ListView)parentView.findViewById(R.id.listview);


        LayoutInflater inflater = (LayoutInflater) getContext()
                .getSystemService(Context.LAYOUT_INFLATER_SERVICE);


        SingleProgrammAdapter adapter = new SingleProgrammAdapter(getContext(),R.layout.single_broadcast_item,sched);

        listView.setAdapter(adapter);
    }


    @Override
    public void didFetch(JSONArray jsonArray, String tvStation) throws JSONException {
        for ( int i = 0; i < jsonArray.length(); i++) {

            try{
                sched.add(new SingleProgramm(jsonArray.getJSONObject(i), tvStation));
            }catch (JSONException e){

=======
    public void addSingleProgram(JSONArray jsonArray, int index, String tvStation, boolean onAir)
    {
        try{
            SingleProgramm program = new SingleProgramm(jsonArray.getJSONObject(index), tvStation, onAir);
            if (program.favourite)
            {
                sched.add(program);
>>>>>>> a0d38b388c06c7cd733ca151eba4c4e22530e48d
            }
        }catch (JSONException e){

        }
    }
}