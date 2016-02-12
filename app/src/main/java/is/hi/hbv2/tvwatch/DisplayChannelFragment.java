package is.hi.hbv2.tvwatch;

import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import java.util.ArrayList;

import is.hi.hbv2.tvwatch.ItemHolster.BroadCastItem;

/**
 * Created by ari on 10-Feb-16.
 */
public class DisplayChannelFragment extends Fragment {
    private ArrayList<BroadCastItem> sched;
    View parentView;
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        parentView = inflater.inflate(R.layout.display_channel_fragment, container, false);

        return parentView;
    }

}
