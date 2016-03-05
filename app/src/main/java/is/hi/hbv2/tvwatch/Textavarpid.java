package is.hi.hbv2.tvwatch;

import org.json.JSONObject;

import java.util.ArrayList;

/**
 * Created by ari on 05-Mar-16.
 */
public class Textavarpid {


    //API til að fá formattaða lista
    String superString = "{results:[{title:KrakkaRÚV,originalTitle:,duration:02:55:00,description:,"+
        "shortDescription:,live:false,premier:true,startTime:2016-03-05 07:00:00,aspectRatio:16:9,"+
            "series:{episode:1,series:1}},{title:Háværa ljónið Urri,originalTitle:Raa Raa,duration:00:10:04,"+
            "description:,shortDescription:,live:false,premier:true,startTime:2016-03-05 07:01:00,"+
            "aspectRatio:16:9,series:{episode:47,series:52}},{title:Nellý og Nóra,originalTitle:Nelly & Nora,"+
            "duration:00:07:15,description:,shortDescription:,live:false,premier:true,startTime:2016-03-05 07:11:00,"+
            "aspectRatio:16:9,series:{episode:14,series:52}},]}";

    JSONObject json = new JSONObject(superString);

    public static ArrayList<BroadCastItem> getFavorites(){
        return populateSched();
    }
    public static ArrayList<BroadCastItem> getNextUp(){
        return populateSched();
    }

    private static ArrayList<BroadCastItem> populateSched(){
        ArrayList<BroadCastItem> sched = new ArrayList<BroadCastItem>();
        sched.add(new BroadCastItem("Þáttur1", "lýsing1"));
        sched.add(new BroadCastItem("Þáttur2", "lýsing2"));
        sched.add(new BroadCastItem("Þáttur3", "lýsing3"));
        sched.add(new BroadCastItem("Þáttur4", "lýsing4"));
        sched.add(new BroadCastItem("Þáttur5", "lýsing5"));
        return sched;
    }
}
