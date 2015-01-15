package hearc.ch.starstrat;


import android.app.Fragment;
import android.app.FragmentManager;
import android.app.FragmentTransaction;
import android.content.res.Configuration;
import android.content.res.TypedArray;
import android.support.v4.widget.DrawerLayout;
import android.support.v7.app.ActionBarActivity;
import android.os.Bundle;
import android.support.v7.app.ActionBarDrawerToggle;
import android.util.Log;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ListView;

import java.util.ArrayList;

import hearc.ch.starstrat.adapter.NavDrawerListAdapter;
import hearc.ch.starstrat.dataBase.Use.UseBDD;
import hearc.ch.starstrat.model.NavDrawerItem;
import hearc.ch.starstrat.objects.StrategyItem;


public class MainActivity extends ActionBarActivity {

    private DrawerLayout mDrawerLayout;
    private ListView mDrawerList;
    private ActionBarDrawerToggle mDrawerToggle;

    // nav drawer title
    private CharSequence mDrawerTitle;

    // used to store app title
    private CharSequence mTitle;

    // slide menu items
    private String[] navMenuTitles;
    private TypedArray navMenuIcons;

    private ArrayList<NavDrawerItem> navDrawerItems;
    private NavDrawerListAdapter adapter;
    private UseBDD useBDD;
    private float speedOfGame = SpeedChooseFragment.fastSpeed;

    public void setSpeedOfGame(float speed)
    {
        speedOfGame = speed;
    }

    private StrategieFragment stratListFrag = null;


    public MainActivity() {
    }


    public UseBDD getDBInstance()
    {
        if(useBDD == null)
            useBDD = new UseBDD(this);
        return useBDD;
    }



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        useBDD = new UseBDD(this);



        mTitle = mDrawerTitle = getTitle();
        //setActionBar(new Toolbar(this));
        navMenuTitles = getResources().getStringArray(R.array.nav_drawer_items);
        navMenuIcons = getResources().obtainTypedArray(R.array.nav_drawer_icons);

        navMenuIcons = getResources().obtainTypedArray(R.array.nav_drawer_icons);

        mDrawerLayout = (DrawerLayout) findViewById(R.id.drawer_layout);
        mDrawerList = (ListView) findViewById(R.id.list_menu);

        navDrawerItems = new ArrayList<NavDrawerItem>();

        navDrawerItems.add(new NavDrawerItem(navMenuTitles[0],navMenuIcons.getResourceId(0,0)));
        navDrawerItems.add(new NavDrawerItem(navMenuTitles[1],navMenuIcons.getResourceId(1,0)));
        navDrawerItems.add(new NavDrawerItem(navMenuTitles[2],navMenuIcons.getResourceId(2,0)));
        navDrawerItems.add(new NavDrawerItem(navMenuTitles[3],navMenuIcons.getResourceId(3,0)));
        navMenuIcons.recycle();

        mDrawerList.setOnItemClickListener(new DrawerMenuClickListener() );


        adapter = new NavDrawerListAdapter(getApplicationContext(),navDrawerItems);
        mDrawerList.setAdapter(adapter);


        getSupportActionBar().setDisplayHomeAsUpEnabled(true);
        getSupportActionBar().setHomeButtonEnabled(true);

        mDrawerToggle = new ActionBarDrawerToggle(this, mDrawerLayout,R.string.drawer_open,R.string.drawer_close);
        mDrawerToggle.setToolbarNavigationClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                getSupportActionBar().setTitle(mTitle);
                invalidateOptionsMenu();
            }
        });

        mDrawerLayout.setDrawerListener(mDrawerToggle);

        if(savedInstanceState == null){
            displayView(0);
        }

        //useBDD.close();
    }

    public void updateStratFrag() {
        if(stratListFrag != null)
            stratListFrag.updateList();
    }

    /**
     * Slide menu item click listener
     * */
    private class DrawerMenuClickListener  implements
            ListView.OnItemClickListener {
        @Override
        public void onItemClick(AdapterView<?> parent, View view, int position,
                                long id) {
            // display view for selected nav drawer item
            displayView(position);
        }
    }


    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_main, menu);
        return true;
    }

    public void playStrat(StrategyItem strat)
    {
        setLaunchGameFragment(strat);

    }

    private void setLaunchGameFragment(StrategyItem strat) {
        final Fragment fragment = LaunchGameFragment.newInstance(strat,speedOfGame);
        final FragmentManager fragmentManager = getFragmentManager();
        FragmentTransaction transaction = fragmentManager.beginTransaction();
        transaction.replace(R.id.frame_container, fragment);

        transaction.addToBackStack(null);

        transaction.commit();
    }

    public void editStrat(StrategyItem strat)
    {
        setStrategieMakerFragement(strat);
    }
    public void removeStrat(StrategyItem strat)
    {
        useBDD.removeStrat(strat);
        stratListFrag.updateList();
    }


    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        int id = item.getItemId();
        if(mDrawerToggle.onOptionsItemSelected(item))
        {
            return true;
        }

        //noinspection SimplifiableIfStatement
        if (id == R.id.action_settings) {
            return true;
        }

        return super.onOptionsItemSelected(item);
    }

    @Override
    public void onBackPressed() {
        FragmentManager fragmentManager = getFragmentManager();
        if(fragmentManager.getBackStackEntryCount() > 0) {
            fragmentManager.popBackStack();
            stratListFrag.updateList();
        }
        else
            this.finish();

    }





    public void setStrategieMakerFragement(StrategyItem strat)
    {
        if(strat == null) {
            final Fragment fragment = new StrategieMakerFragment();
            ((StrategieMakerFragment)fragment).setUseBDD(useBDD);

            final FragmentManager fragmentManager = getFragmentManager();
            FragmentTransaction transaction = fragmentManager.beginTransaction();

            transaction.replace(R.id.frame_container, fragment);

            transaction.addToBackStack(null);

            transaction.commit();


        }
        else
        {
            final Fragment fragment = StrategieMakerFragment.newInstance(strat);
            final FragmentManager fragmentManager = getFragmentManager();
            FragmentTransaction transaction = fragmentManager.beginTransaction();
            transaction.replace(R.id.frame_container, fragment);

            transaction.addToBackStack(null);

            transaction.commit();
        }

    }
    public void getUnitFromId(int unitId){
        //useBDD.g
    }

    /*public void displayViewMaker(StrategyItem strat)
    {
        Fragment fragment = null;
        fragment = StrategieMakerFragment.newInstance(strat);
        ((StrategieMakerFragment)fragment).setUseBDD(useBDD);
        setFragment(fragment, 3);
    }*/

    /**
     * Diplaying fragment view for selected nav drawer list item
     * */
    public void displayView(int position) {
        // update the main content by replacing fragments
        Fragment fragment = null;
        switch (position) {
            case 0: //Accueil
                fragment = new HomeFragment();
                break;
            case 1://StrategyList
                if(stratListFrag == null)
                    stratListFrag = StrategieFragment.newInstance(useBDD);
                else
                    stratListFrag.updateList();
                fragment = stratListFrag;

                break;
			case 2: //Speed choice
                fragment = SpeedChooseFragment.newInstance();

                break;
            case 3://About
                StrategyItem strat = new StrategyItem();
                for(int i = 0; i < 40; i+=2)
                {
                    strat.addItem("Zerg",0,0,i,true);
                }
                fragment = LaunchGameFragment.newInstance(strat,speedOfGame);
            break;
            case 4://Hidden - LauchGameFragment
                //TODO LaunchGameFragment
                break;
            case 5://Hidden - StrategyMaker Fragment
                fragment = new StrategieMakerFragment();
                ((StrategieMakerFragment)fragment).setUseBDD(useBDD);
            default:
                break;
        }
        setFragment(fragment, position);

    }
    private void setFragment(Fragment fragment, int position)
    {
        if (fragment != null) {
            FragmentManager fragmentManager = getFragmentManager();
            fragmentManager.beginTransaction()
                    .replace(R.id.frame_container, fragment).commit();

            // update selected item and title, then close the drawer
            mDrawerList.setItemChecked(position, true);
            mDrawerList.setSelection(position);
            setTitle(navMenuTitles[position]);
            mDrawerLayout.closeDrawer(mDrawerList);
        } else {
            // error in creating fragment
            Log.e("MainActivity", "Error in creating fragment");
        }
    }


    /* *
	 * Called when invalidateOptionsMenu() is triggered
	 */
    @Override
    public boolean onPrepareOptionsMenu(Menu menu) {
        // if nav drawer is opened, hide the action items
        boolean drawerOpen = mDrawerLayout.isDrawerOpen(mDrawerList);
        menu.findItem(R.id.action_settings).setVisible(!drawerOpen);
        return super.onPrepareOptionsMenu(menu);
    }

    @Override
    public void setTitle(CharSequence title) {
        mTitle = title;
        getSupportActionBar().setTitle(mTitle);
    }

    /**
     * When using the ActionBarDrawerToggle, you must call it during
     * onPostCreate() and onConfigurationChanged()...
     */

    @Override
    protected void onPostCreate(Bundle savedInstanceState) {
        super.onPostCreate(savedInstanceState);
        // Sync the toggle state after onRestoreInstanceState has occurred.
        mDrawerToggle.syncState();
    }

    @Override
    public void onConfigurationChanged(Configuration newConfig) {
        super.onConfigurationChanged(newConfig);
        // Pass any configuration change to the drawer toggls
        mDrawerToggle.onConfigurationChanged(newConfig);
    }

}
