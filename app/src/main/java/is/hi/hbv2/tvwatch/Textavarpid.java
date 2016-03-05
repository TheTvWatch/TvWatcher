package is.hi.hbv2.tvwatch;

import android.util.Log;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.util.ArrayList;
import java.util.Collections;

/**
 * Created by ari on 05-Mar-16.
 */
public class Textavarpid {
    //API til að fá formattaða lista
    private String superString = "{  \n" +
            "   \"results\":[  \n" +
            "      {  \n" +
            "         \"title\":\"Númer 23\",\n" +
            "         \"originalTitle\":\"The Number 23\",\n" +
            "         \"duration\":\"1:35\",\n" +
            "         \"description\":\"Jim Carrey fer hér á kostum í óvenjulegu, dramatísku hlutverki manns sem gengur af göflunum eftir að hafa lesið skáldsögu. Hann fyllist þeirri þráhyggju að sagan hafi verið skrifuð um hann.\",\n" +
            "         \"live\":false,\n" +
            "         \"premier\":false,\n" +
            "         \"startTime\":\"2016-03-05 03:40:00\",\n" +
            "         \"aspectRatio\":\"16/9\",\n" +
            "         \"series\":{  \n" +
            "            \"episode\":\"\",\n" +
            "            \"series\":\"\"\n" +
            "         }\n" +
            "      },\n" +
            "      {  \n" +
            "         \"title\":\"Fréttir og Ísland í dag\",\n" +
            "         \"originalTitle\":\"\",\n" +
            "         \"duration\":\"0:55\",\n" +
            "         \"description\":\"Fréttir og Ísland í dag endursýnt frá því fyrr í kvöld.\",\n" +
            "         \"live\":false,\n" +
            "         \"premier\":false,\n" +
            "         \"startTime\":\"2016-03-05 05:15:00\",\n" +
            "         \"aspectRatio\":\"4/3\",\n" +
            "         \"series\":{  \n" +
            "            \"episode\":\"\",\n" +
            "            \"series\":\"\"\n" +
            "         }\n" +
            "      },\n" +
            "      {  \n" +
            "         \"title\":\"Strumparnir\",\n" +
            "         \"originalTitle\":\"\",\n" +
            "         \"duration\":\"0:25\",\n" +
            "         \"description\":\"Strumparnir og Kjartan galdrakarl fara á kostum í ævintýrum sínum í Strumpabæ.\",\n" +
            "         \"live\":false,\n" +
            "         \"premier\":false,\n" +
            "         \"startTime\":\"2016-03-05 07:00:00\",\n" +
            "         \"aspectRatio\":\"16/9\",\n" +
            "         \"series\":{  \n" +
            "            \"episode\":\"\",\n" +
            "            \"series\":\"\"\n" +
            "         }\n" +
            "      },\n" +
            "      {  \n" +
            "         \"title\":\"UKI\",\n" +
            "         \"originalTitle\":\"\",\n" +
            "         \"duration\":\"0:10\",\n" +
            "         \"description\":\"Flottir og fræðandi þættir um litlu gulu veruna Uki sem er alltaf að uppgötva nýja og skemmtilega hluti og finnst fátt skemmtilegra en að deila þeim með okkur.\",\n" +
            "         \"live\":false,\n" +
            "         \"premier\":false,\n" +
            "         \"startTime\":\"2016-03-05 07:25:00\",\n" +
            "         \"aspectRatio\":\"16/9\",\n" +
            "         \"series\":{  \n" +
            "            \"episode\":\"\",\n" +
            "            \"series\":\"\"\n" +
            "         }\n" +
            "      },\n" +
            "      {  \n" +
            "         \"title\":\"Mæja býfluga\",\n" +
            "         \"originalTitle\":\"\",\n" +
            "         \"duration\":\"0:10\",\n" +
            "         \"description\":\"Skemmtilegir þættir um forvitnu bífluguna Mæju sem lendir í alls konar ævintýrum með vinum sínum, þeim Skildi, Villa og Max.\",\n" +
            "         \"live\":false,\n" +
            "         \"premier\":true,\n" +
            "         \"startTime\":\"2016-03-05 07:35:00\",\n" +
            "         \"aspectRatio\":\"16/9\",\n" +
            "         \"series\":{  \n" +
            "            \"episode\":\"\",\n" +
            "            \"series\":\"\"\n" +
            "         }\n" +
            "      },\n" +
            "      {  \n" +
            "         \"title\":\"Brúðubíllinn\",\n" +
            "         \"originalTitle\":\"\",\n" +
            "         \"duration\":\"0:35\",\n" +
            "         \"description\":\"Frábærir þættir sem gerast í Brúðubílnum hennar Helgu Steffensen en þar lifna brúður við og bregða á leik.\",\n" +
            "         \"live\":false,\n" +
            "         \"premier\":false,\n" +
            "         \"startTime\":\"2016-03-05 07:45:00\",\n" +
            "         \"aspectRatio\":\"4/3\",\n" +
            "         \"series\":{  \n" +
            "            \"episode\":\"\",\n" +
            "            \"series\":\"\"\n" +
            "         }\n" +
            "      },\n" +
            "      {  \n" +
            "         \"title\":\"Víkingurinn Viggó\",\n" +
            "         \"originalTitle\":\"\",\n" +
            "         \"duration\":\"0:15\",\n" +
            "         \"description\":\"Skemmtilegir þættir um víkingastrákinn Viggó og félaga hans sem eru duglegir að lenda í alls konar ævintýrum.\",\n" +
            "         \"live\":false,\n" +
            "         \"premier\":true,\n" +
            "         \"startTime\":\"2016-03-05 08:20:00\",\n" +
            "         \"aspectRatio\":\"16/9\",\n" +
            "         \"series\":{  \n" +
            "            \"episode\":\"\",\n" +
            "            \"series\":\"\"\n" +
            "         }\n" +
            "      },\n" +
            "      {  \n" +
            "         \"title\":\"Tommi og Jenni\",\n" +
            "         \"originalTitle\":\"\",\n" +
            "         \"duration\":\"0:25\",\n" +
            "         \"description\":\"Frábærir þættir um þá félaga Tomma og Jenna.\",\n" +
            "         \"live\":false,\n" +
            "         \"premier\":false,\n" +
            "         \"startTime\":\"2013-03-05 08:35:00\",\n" +
            "         \"aspectRatio\":\"16/9\",\n" +
            "         \"series\":{  \n" +
            "            \"episode\":\"\",\n" +
            "            \"series\":\"\"\n" +
            "         }\n" +
            "      }\n" +
            "   ]\n" +
            "}";
    private ArrayList<SingleProgramm> sched = new ArrayList<SingleProgramm>();
    public Textavarpid(){

        //superString = superString.replaceAll("\n", "\\n");

        JSONObject json;
        JSONArray jsonArray = null;
        try{
            json = new JSONObject(superString);
            try {
                jsonArray = json.getJSONArray("results");
            } catch (JSONException e) {
                Log.d("Villa", "Array hlutinn");
            }
        } catch (JSONException e) {
            Log.d("Villa", "Gat ekki initad Json daemid");
        }



        for ( int i = 0; i < jsonArray.length(); i++) {
            //jsonArray.getJSONObject(i);
            try{
                sched.add(new SingleProgramm(jsonArray.getJSONObject(i)));
            }catch (JSONException e){

            }
            Collections.sort(sched, new SingleProgrammComparator());

            Log.d("villa", "" + i);
        }
    }




    public ArrayList<SingleProgramm> getFavorites(){
        return sched;
    }
    public ArrayList<SingleProgramm> getNextUp(){
        return sched;
    }

    private ArrayList<SingleProgramm> populateSched(){

        /*
        sched.add(new SingleProgramm("Þáttur1", "lýsing1"));
        sched.add(new SingleProgramm("Þáttur2", "lýsing2"));
        sched.add(new SingleProgramm("Þáttur3", "lýsing3"));
        sched.add(new SingleProgramm("Þáttur4", "lýsing4"));
        sched.add(new SingleProgramm("Þáttur5", "lýsing5"));
        */

        return sched;
    }
}
