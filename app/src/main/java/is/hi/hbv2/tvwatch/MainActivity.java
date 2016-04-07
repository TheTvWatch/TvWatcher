package is.hi.hbv2.tvwatch;


import android.app.ActionBar;
import android.app.Activity;
import android.app.FragmentTransaction;
import android.content.Context;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentActivity;
import android.support.v4.app.FragmentManager;
import android.os.Bundle;
import android.support.v4.app.FragmentPagerAdapter;
import android.support.v4.view.PagerAdapter;
import android.support.v4.view.ViewPager;
import android.support.v7.app.ActionBarActivity;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;

import java.util.ArrayList;

public class MainActivity extends FragmentActivity {
    Button gotoNextup, gotoChannels, gotoFavorites;
    private static Context mContext;
    private static final int NUM_PAGES = 3;

    /**
     * The pager widget, which handles animation and allows swiping horizontally to access previous
     * and next wizard steps.
     */
    private ViewPager mPager;

    /**
     * The pager adapter, which provides the pages to the view pager widget.
     */
    private PagerAdapter mPagerAdapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        mContext = getApplicationContext();
        FragmentManager fm = getSupportFragmentManager();
        Fragment f = fm.findFragmentById(R.id.container);

        if(f == null){
            f = new MainMenuFragment();
            fm.beginTransaction().add(R.id.container, f).commit();
        }

        setUpNavListeners();



    }

    public static Context getActivityContext()
    {
        return mContext;
    }

    public void setupDisplaySingleChannelButtons(View v){
        //findViewById(R.id.mainlayout).setVisibility(View.GONE);
        findViewById(R.id.pickachannelbuttans).setVisibility(View.VISIBLE);
        Button gotoRuv, gotoStod2, gotoSkjar, gotoRuvIthrottir, gotoStod2Sport, gotoStod2Gull, gotoStod2Bio;
        //setContentView(R.layout.pickachannel);
        gotoRuv = (Button) findViewById(R.id.displayRuv);
        gotoStod2 = (Button) findViewById(R.id.displayStod2);
        gotoSkjar = (Button) findViewById(R.id.displaySkjar);
        gotoRuvIthrottir = (Button) findViewById(R.id.displayRuvIthrottir);
        gotoStod2Sport =(Button) findViewById(R.id.displayStod2Sport);
        gotoStod2Gull = (Button) findViewById(R.id.displayStod2Gull);
        gotoStod2Bio = (Button) findViewById(R.id.displayStod2Bio);


        gotoRuv.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                FragmentManager fm = getSupportFragmentManager();
                fm.beginTransaction().replace(R.id.container, new DisplayRuvFragment()).commit();
                findViewById(R.id.pickachannelbuttans).setVisibility(View.GONE);

            }
        });
        gotoStod2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                FragmentManager fm = getSupportFragmentManager();
                fm.beginTransaction().replace(R.id.container, new DisplayStod2Fragment()).commit();
                findViewById(R.id.pickachannelbuttans).setVisibility(View.GONE);

            }
        });
        gotoSkjar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                /*FragmentManager fm = getSupportFragmentManager();
                fm.beginTransaction().replace(R.id.container, new DisplaySkjarEinnFragment()).commit();
                */
            }
        });
        gotoStod2Sport.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                FragmentManager fm = getSupportFragmentManager();
                fm.beginTransaction().replace(R.id.container, new DisplayStod2SportFragment()).commit();
                findViewById(R.id.pickachannelbuttans).setVisibility(View.GONE);

            }
        });
        gotoStod2Bio.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                FragmentManager fm = getSupportFragmentManager();
                fm.beginTransaction().replace(R.id.container, new DisplayStod2BioFragment()).commit();
                findViewById(R.id.pickachannelbuttans).setVisibility(View.GONE);

            }
        });
        gotoStod2Gull.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                FragmentManager fm = getSupportFragmentManager();
                fm.beginTransaction().replace(R.id.container, new DisplayStod2GullFragment()).commit();
                findViewById(R.id.pickachannelbuttans).setVisibility(View.GONE);

            }
        });
        gotoRuvIthrottir.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                FragmentManager fm = getSupportFragmentManager();
                fm.beginTransaction().replace(R.id.container, new DisplayRuvIthrottirFragment()).commit();
                findViewById(R.id.pickachannelbuttans).setVisibility(View.GONE);

            }
        });

    }

    public void setUpNavListeners(){
        gotoChannels = (Button)findViewById(R.id.channels_button);
        gotoNextup   = (Button)findViewById(R.id.nextup_button);
        gotoFavorites= (Button)findViewById(R.id.favorites_button);

        gotoChannels.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                /*
                FragmentManager fm = getSupportFragmentManager();
                Fragment f = fm.findFragmentById(R.id.dispFrag);
                if(f instanceof DisplayChannelFragment){
                    fm.beginTransaction().replace(R.id.container, f).commit();
                }else{
                    fm.beginTransaction().replace(R.id.container, new DisplayChannelFragment()).commit();
                }
                */
                setupDisplaySingleChannelButtons(v);
            }
        });
        gotoNextup.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                FragmentManager fm = getSupportFragmentManager();
                Fragment f = fm.findFragmentById(R.id.listview);
                if(f instanceof NextUpFragment){
                    fm.beginTransaction().replace(R.id.container, f).commit();
                }else{
                    fm.beginTransaction().replace(R.id.container, new NextUpFragment()).commit();
                }

            }
        });
        gotoFavorites.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                FragmentManager fm = getSupportFragmentManager();
                Fragment f = fm.findFragmentById(R.id.dispFrag);
                if(f instanceof DisplayChannelFragment){
                    fm.beginTransaction().replace(R.id.container, f).commit();
                }else{
                    fm.beginTransaction().replace(R.id.container, new FavoritesFragment()).commit();
                }

            }
        });
    }


}
