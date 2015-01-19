package hearc.ch.starstrat;


import android.app.Fragment;
import android.app.FragmentManager;
import android.app.FragmentTransaction;
import android.content.res.Configuration;
import android.content.res.TypedArray;
import android.os.Bundle;
import android.support.v4.widget.DrawerLayout;
import android.support.v7.app.ActionBarActivity;
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

    // titre du tiroire
    private CharSequence mDrawerTitle;

    // titre de l'application
    private CharSequence mTitle;

    // slide menu items
    private String[] navMenuTitles;
    private TypedArray navMenuIcons;

    private ArrayList<NavDrawerItem> navDrawerItems;
    private NavDrawerListAdapter adapter;
    private UseBDD useBDD;
    private float speedOfGame = SpeedChooseFragment.fastSpeed;

    public float getSpeedOfGame(){return speedOfGame;}
    public void setSpeedOfGame(float speed)
    {
        speedOfGame = speed;
    }

    private StrategieFragment stratListFrag = null;


    public MainActivity() {
    }

    //Permet de récupérer l'instance de connexion à la base de données
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
        //On instancie la connexion à la base de données
        getDBInstance();


        //On défini le titre du tiroire
        mTitle = mDrawerTitle = getTitle();


        //On récupère la liste des objets pour le tiroir (icone + texte)
        navMenuTitles = getResources().getStringArray(R.array.nav_drawer_items);
        navMenuIcons = getResources().obtainTypedArray(R.array.nav_drawer_icons);

        //On récupère le layout du drawer et de la liste
        mDrawerLayout = (DrawerLayout) findViewById(R.id.drawer_layout);
        mDrawerList = (ListView) findViewById(R.id.list_menu);

        //On créer nos éléments pour le drawer
        navDrawerItems = new ArrayList<NavDrawerItem>();

        //On ajoute les  éléments au drawer
        navDrawerItems.add(new NavDrawerItem(navMenuTitles[0],navMenuIcons.getResourceId(0,0)));
        navDrawerItems.add(new NavDrawerItem(navMenuTitles[1],navMenuIcons.getResourceId(1,0)));
        navDrawerItems.add(new NavDrawerItem(navMenuTitles[2],navMenuIcons.getResourceId(2,0)));
        navMenuIcons.recycle();
        //On prépare l'evenement onClick
        mDrawerList.setOnItemClickListener(new DrawerMenuClickListener() );

        //On créer l'adapteur pour notre liste d'objets du menu
        adapter = new NavDrawerListAdapter(getApplicationContext(),navDrawerItems);

        //On défini l'adapteur du drawer
        mDrawerList.setAdapter(adapter);


        getSupportActionBar().setDisplayHomeAsUpEnabled(true);
        getSupportActionBar().setHomeButtonEnabled(true);

        //Toogle du drawer
        mDrawerToggle = new ActionBarDrawerToggle(this, mDrawerLayout,R.string.drawer_open,R.string.drawer_close);
        mDrawerToggle.setToolbarNavigationClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                getSupportActionBar().setTitle(mTitle);
                invalidateOptionsMenu();
            }
        });

        mDrawerLayout.setDrawerListener(mDrawerToggle);

        //On affiche le fragment accueil
        if(savedInstanceState == null){
            displayView(0);
        }
    }


    //Mets à jour la liste des stratégies, peut être appelée depuis n'importe quel fragment
    public void updateStratFrag() {
        if(stratListFrag != null)
            stratListFrag.updateList();
    }


    //Ajoute une stratégie à la base de données
    public void addStrat(StrategyItem strat) {
        useBDD.addStrat(strat);

    }

    /**
     * OnClickListener pour le drawer
     * */
    private class DrawerMenuClickListener  implements
            ListView.OnItemClickListener {
        @Override
        public void onItemClick(AdapterView<?> parent, View view, int position,
                                long id) {
            // Affiche la vu pour l'object sélectionné dans la liste
            displayView(position);
        }
    }


    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_main, menu);
        menu.removeItem(0);
        return true;
    }

    //Fonction pour lancer la stratégie sélectionnée par l'utilisateur dans la fenetre de jeu
    public void playStrat(StrategyItem strat)
    {
        setLaunchGameFragment(strat);

    }

    //Affiche le LauchGameFragment
    private void setLaunchGameFragment(StrategyItem strat) {
        //On récupère une instance de LaunchGameFragment
        final Fragment fragment = LaunchGameFragment.newInstance(strat,speedOfGame);
        final FragmentManager fragmentManager = getFragmentManager();
        //Si il y'a encore des élémments de le backstack on le vide
        if(fragmentManager.getBackStackEntryCount() > 0) {
            fragmentManager.popBackStackImmediate(null, FragmentManager.POP_BACK_STACK_INCLUSIVE);
        }

        FragmentTransaction transaction = fragmentManager.beginTransaction();
        //On remplace le fragment actuel (StrategieFragment) et on l'ajoute au backstack
        transaction.replace(R.id.frame_container, fragment);

        transaction.addToBackStack(null);

        transaction.commit();
    }

    //Ouvre le fragment pour modifier la stratégie
    public void editStrat(StrategyItem strat)
    {

        setStrategieMakerFragement(strat);
    }

    //Supprimer une stratégie
    public void removeStrat(StrategyItem strat)
    {
        useBDD.removeStrat(strat);
        stratListFrag.updateList();
    }


    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
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


    //Lorsque l'on appui sur le bouton retour, permet de ne pas quitter mais de pop le backstack
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

            final Fragment fragment = StrategieMakerFragment.newInstance(strat);
            final FragmentManager fragmentManager = getFragmentManager();
            if(fragmentManager.getBackStackEntryCount() > 0) {
                fragmentManager.popBackStackImmediate(null, FragmentManager.POP_BACK_STACK_INCLUSIVE);
            }
            FragmentTransaction transaction = fragmentManager.beginTransaction();
            transaction.replace(R.id.frame_container, fragment);

            transaction.addToBackStack(null);

            transaction.commit();
        //}

    }



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
                FragmentManager manager = getFragmentManager();
                Fragment frag_strat = manager.findFragmentById(R.layout.fragment_strategie);
                if(stratListFrag == null) {
                    stratListFrag = StrategieFragment.newInstance();
                    fragment = stratListFrag;
                }
                else if(frag_strat != null) {
                    fragment = frag_strat;
                }
                else
                {
                    fragment = stratListFrag;
                }



                break;
			case 2: //Speed choice
                fragment = SpeedChooseFragment.newInstance();

                break;
            default:
                break;
        }
        setFragment(fragment, position);

    }
    private void setFragment(Fragment fragment, int position)
    {
        if (fragment != null) {
            FragmentManager fragmentManager = getFragmentManager();
            if(fragmentManager.getBackStackEntryCount() > 0) {
                fragmentManager.popBackStackImmediate(null, FragmentManager.POP_BACK_STACK_INCLUSIVE);
            }
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
