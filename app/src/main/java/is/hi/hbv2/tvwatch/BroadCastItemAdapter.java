package is.hi.hbv2.tvwatch;

import android.content.Context;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by ari on 02-Mar-16.
 */
public class BroadCastItemAdapter extends ArrayAdapter<BroadCastItem> {

    public BroadCastItemAdapter(Context c,int id, List<BroadCastItem> myspace){
        super(c, id, myspace);
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent){
      return new View;
    }
}
