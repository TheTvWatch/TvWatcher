package is.hi.hbv2.tvwatch.ListsForDays;

import java.util.ArrayList;

import is.hi.hbv2.tvwatch.SingleProgramm;

/**
 * Created by ari on 10-Feb-16.
 */
public class ListOfItems {
    protected ArrayList<SingleProgramm> items = new ArrayList<SingleProgramm>();
    public ListOfItems(ArrayList<SingleProgramm> i){
        this.items = i;
    }
}
