package is.hi.hbv2.tvwatch;

import java.util.Comparator;

/**
 * Created by ari on 05-Mar-16.
 */
public class SingleProgrammComparator implements Comparator<SingleProgramm> {

    @Override
    public int compare(SingleProgramm b1, SingleProgramm b2){
        return b1.getStartDate().compareTo(b2.getStartDate());
    }
}
