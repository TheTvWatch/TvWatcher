package is.hi.hbv2.tvwatch;

import java.util.ArrayList;

/**
 * Created by ari on 05-Mar-16.
 */
public class Textavarpid {


    //API til að fá formattaða lista


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
