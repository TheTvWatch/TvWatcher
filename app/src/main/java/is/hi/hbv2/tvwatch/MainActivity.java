package is.hi.hbv2.tvwatch;


import android.app.ActionBar;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentActivity;
import android.support.v4.app.FragmentManager;
import android.os.Bundle;
import android.support.v7.app.ActionBarActivity;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;

public class MainActivity extends ActionBarActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        FragmentManager fm = getSupportFragmentManager();
        Fragment f = fm.findFragmentById(R.id.container);

        if(f == null){
            f = new MainMenuFragment();
            fm.beginTransaction().add(R.id.container, f).commit();
        }


        // get action bar
        ActionBar actionBar = getActionBar();

        // Enabling Up / Back navigation
        //actionBar.setDisplayHomeAsUpEnabled(true);
    }
    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        MenuInflater inflater = getMenuInflater();
        inflater.inflate(R.menu.activity_main_actions, menu);

        return super.onCreateOptionsMenu(menu);
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item){
        int id = item.getItemId();

        if(id == R.id.action_nextup){
            //swap to nextupfragment
            FragmentManager fm = getSupportFragmentManager();

            fm.beginTransaction().replace(R.id.container, new DisplayChannelFragment()).commit();

        }else if (id == R.id.action_channels){
            FragmentManager fm = getSupportFragmentManager();
            fm.beginTransaction().replace(R.id.container, new DisplayChannelFragment()).commit();
        }
        return super.onOptionsItemSelected(item);
    }

}
