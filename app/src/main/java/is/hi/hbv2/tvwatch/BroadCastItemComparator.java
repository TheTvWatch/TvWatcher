package is.hi.hbv2.tvwatch;

import java.util.Comparator;

/**
 * Created by ari on 05-Mar-16.
 */
public class BroadCastItemComparator implements Comparator<BroadCastItem> {

    @Override
    public int compare(BroadCastItem b1, BroadCastItem b2){
        return b1.getStartDate().compareTo(b2.getStartDate());
    }
}
