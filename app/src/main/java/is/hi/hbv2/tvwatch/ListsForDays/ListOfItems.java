package is.hi.hbv2.tvwatch.ListsForDays;

import java.util.ArrayList;

import is.hi.hbv2.tvwatch.ItemHolster.BroadCastItem;

/**
 * Created by ari on 10-Feb-16.
 */
public class ListOfItems {
    protected ArrayList<BroadCastItem> items = new ArrayList<BroadCastItem>();
    public ListOfItems(ArrayList<BroadCastItem> i){
        this.items = i;
    }
}
