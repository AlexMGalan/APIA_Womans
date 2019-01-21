package com.acacias.altfc;


import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.os.Handler;
import android.support.design.widget.NavigationView;
import android.support.v4.view.GravityCompat;
import android.support.v4.widget.DrawerLayout;
import android.support.v7.app.ActionBarDrawerToggle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.KeyEvent;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.Toast;


public class MainActivity extends AppCompatActivity
        implements NavigationView.OnNavigationItemSelectedListener {

    public static String myReport;
    public static String myNews;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        //Set up Next Game Fragment
        NextGameFragment nextgamefragment = new NextGameFragment();
        android.support.v4.app.FragmentManager manager = getSupportFragmentManager();
        manager.beginTransaction()
                .replace(R.id.mainLayout, nextgamefragment)
                .commit();

        //This Toolbar is for the AboutUs
        Toolbar toolbar2 = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar2);
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);

        //This is the Main Menu Drawer
        DrawerLayout drawer = (DrawerLayout) findViewById(R.id.drawer_layout);
       ActionBarDrawerToggle toggle = new ActionBarDrawerToggle(
               this, drawer, toolbar2, R.string.navigation_drawer_open, R.string.navigation_drawer_close);
       drawer.setDrawerListener(toggle);
       toggle.syncState();

        //What is this Navigation View?
       NavigationView navigationView = (NavigationView) findViewById(R.id.nav_view);
        navigationView.setNavigationItemSelectedListener(this);

    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
       //  Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.main, menu);
        return true;
    }

    private boolean exit = false;
    @Override
    public void onBackPressed() {
        if (exit)
            this.finish();
        else {
            Toast.makeText(this, "Press Back again to Exit.",
                    Toast.LENGTH_SHORT).show();
            exit = true;
            new Handler().postDelayed(new Runnable() {
                @Override
                public void run() {
                    exit = false;
                }
            }, 3 * 1000);

        }

    }
    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        int id = item.getItemId();

        //noinspection SimplifiableIfStatement
       if (id == R.id.action_exit) {
           this.finish();
            return true;
        }

        if (item.getItemId() == android.R.id.home) {
            //Title bar back press triggers onBackPressed()
            onBackPressed();
            return true;
        }
        return super.onOptionsItemSelected(item);
    }


    @SuppressWarnings("StatementWithEmptyBody")
    @Override
    public boolean onNavigationItemSelected(MenuItem item) {
        // Handle navigation view item clicks here.
        int id = item.getItemId();

        if (id == R.id.nav_game) {
           NextGameFragment nextgamefragment = new NextGameFragment();
          android.support.v4.app.FragmentManager manager = getSupportFragmentManager();
         manager.beginTransaction()
                  .replace(R.id.mainLayout, nextgamefragment)
                .commit();
            this.setTitle("Next Game");

        } else if (id == R.id.nav_squads) {
            SquadsFragment squadsfragment = new SquadsFragment();
            android.support.v4.app.FragmentManager manager = getSupportFragmentManager();
            manager.beginTransaction()
                    .replace(R.id.mainLayout, squadsfragment)
                    .commit();

        } else if (id == R.id.nav_ladders) {
            LadderFragment ladderfragment = new LadderFragment();
            android.support.v4.app.FragmentManager manager = getSupportFragmentManager();
            manager.beginTransaction()
                    .replace(R.id.mainLayout, ladderfragment)
                    .commit();

        } else if (id == R.id.nav_news) {
            NewsFragment newsfragment = new NewsFragment();
            android.support.v4.app.FragmentManager manager = getSupportFragmentManager();
            manager.beginTransaction()
                    .replace(R.id.mainLayout, newsfragment)
                    .commit();


        } else if (id == R.id.nav_coaches) {
            CoachesFragment coachesfragment = new CoachesFragment();
            android.support.v4.app.FragmentManager manager = getSupportFragmentManager();
            manager.beginTransaction()
                    .replace(R.id.mainLayout, coachesfragment)
                    .commit();

            this.setTitle("Coaches");

        } else if (id == R.id.nav_contacts) {
            ContactsFragment contactsfragment = new ContactsFragment();
           android.support.v4.app.FragmentManager manager = getSupportFragmentManager();
           manager.beginTransaction()
                 .replace(R.id.mainLayout, contactsfragment)
                   .commit();
            this.setTitle("Contacts");

        } else if (id == R.id.nav_partners) {
            SponsorsFragment sponsorsfragment = new SponsorsFragment();
            android.support.v4.app.FragmentManager manager = getSupportFragmentManager();
            manager.beginTransaction()
                    .replace(R.id.mainLayout, sponsorsfragment)
                    .commit();
            this.setTitle("Partners");
        }

        DrawerLayout drawer = (DrawerLayout) findViewById(R.id.drawer_layout);
        drawer.closeDrawer(GravityCompat.START);
        return true;
    }

    public void openBrowser(View view){

        //Get url from tag
        String url = (String)view.getTag();

        Intent intent = new Intent();
        intent.setAction(Intent.ACTION_VIEW);
        intent.addCategory(Intent.CATEGORY_BROWSABLE);

        //pass the url to intent data
        intent.setData(Uri.parse(url));

        startActivity(intent);
    }

    public void openBrowserFacebook(View view){

        //Get url from tag
        String url = (String)view.getTag();

        Intent intent = new Intent();
        intent.setAction(Intent.ACTION_VIEW);
        intent.addCategory(Intent.CATEGORY_BROWSABLE);

        //pass the url to intent data
        intent.setData(Uri.parse(url));

        startActivity(intent);
    }

    public void openBrowserTwitter(View view){

        //Get url from tag
        String url = (String)view.getTag();

        Intent intent = new Intent();
        intent.setAction(Intent.ACTION_VIEW);
        intent.addCategory(Intent.CATEGORY_BROWSABLE);

        //pass the url to intent data
        intent.setData(Uri.parse(url));

        startActivity(intent);
    }

    public void openBrowserInstagram(View view){

        //Get url from tag
        String url = (String)view.getTag();

        Intent intent = new Intent();
        intent.setAction(Intent.ACTION_VIEW);
        intent.addCategory(Intent.CATEGORY_BROWSABLE);

        //pass the url to intent data
        intent.setData(Uri.parse(url));

        startActivity(intent);
    }

    public void openBrowserWests(View view){

        //Get url from tag
        String url = (String)view.getTag();

        Intent intent = new Intent();
        intent.setAction(Intent.ACTION_VIEW);
        intent.addCategory(Intent.CATEGORY_BROWSABLE);

        //pass the url to intent data
        intent.setData(Uri.parse(url));

        startActivity(intent);
    }

    public void openBrowserCubic(View view){

        //Get url from tag
        String url = (String)view.getTag();

        Intent intent = new Intent();
        intent.setAction(Intent.ACTION_VIEW);
        intent.addCategory(Intent.CATEGORY_BROWSABLE);

        //pass the url to intent data
        intent.setData(Uri.parse(url));

        startActivity(intent);
    }

    public void openBrowser1st(View view){

        //Get url from tag
        String url = (String)view.getTag();

        Intent intent = new Intent();
        intent.setAction(Intent.ACTION_VIEW);
        intent.addCategory(Intent.CATEGORY_BROWSABLE);

        //pass the url to intent data
        intent.setData(Uri.parse(url));

        startActivity(intent);
    }

    public void openBrowserRes(View view){

        //Get url from tag
        String url = (String)view.getTag();

        Intent intent = new Intent();
        intent.setAction(Intent.ACTION_VIEW);
        intent.addCategory(Intent.CATEGORY_BROWSABLE);

        //pass the url to intent data
        intent.setData(Uri.parse(url));

        startActivity(intent);
    }

    public void openBrowser17(View view){

        //Get url from tag
        String url = (String)view.getTag();

        Intent intent = new Intent();
        intent.setAction(Intent.ACTION_VIEW);
        intent.addCategory(Intent.CATEGORY_BROWSABLE);

        //pass the url to intent data
        intent.setData(Uri.parse(url));

        startActivity(intent);
    }

    public void openBrowser15(View view){

        //Get url from tag
        String url = (String)view.getTag();

        Intent intent = new Intent();
        intent.setAction(Intent.ACTION_VIEW);
        intent.addCategory(Intent.CATEGORY_BROWSABLE);

        //pass the url to intent data
        intent.setData(Uri.parse(url));

        startActivity(intent);
    }

    public void openBrowser14(View view){

        //Get url from tag
        String url = (String)view.getTag();

        Intent intent = new Intent();
        intent.setAction(Intent.ACTION_VIEW);
        intent.addCategory(Intent.CATEGORY_BROWSABLE);

        //pass the url to intent data
        intent.setData(Uri.parse(url));

        startActivity(intent);
    }

    public void openBrowserGFDA(View view){

        //Get url from tag
        String url = (String)view.getTag();

        Intent intent = new Intent();
        intent.setAction(Intent.ACTION_VIEW);
        intent.addCategory(Intent.CATEGORY_BROWSABLE);

        //pass the url to intent data
        intent.setData(Uri.parse(url));

        startActivity(intent);
    }


    public void openBrowserCC(View view){

        //Get url from tag
        String url = (String)view.getTag();

        Intent intent = new Intent();
        intent.setAction(Intent.ACTION_VIEW);
        intent.addCategory(Intent.CATEGORY_BROWSABLE);

        //pass the url to intent data
        intent.setData(Uri.parse(url));

        startActivity(intent);
    }

    public void onBackStackChanged() {
        try {
            for (android.support.v4.app.Fragment fragment : getSupportFragmentManager().getFragments()) {
                if (fragment != null && fragment.isVisible()) {
                    if (fragment.getTag().equals(ContactsFragment.class.getSimpleName())) {
                      //  setTitle("Contacts");
                    } else if (fragment.getTag().equals(CoachesFragment.class.getSimpleName())) {
                    //    setTitle("Coaches");
                    } else if (fragment.getTag().equals(TabFragment1.class.getSimpleName())) {
                   //     setTitle("Squads");
                    } else if (fragment.getTag().equals(TabFragment2.class.getSimpleName())) {
                     //   setTitle("Squads");
                    } else if (fragment.getTag().equals(TabFragment3.class.getSimpleName())) {
                    //    setTitle("Squads");
                    } else if (fragment.getTag().equals(TabFragment4.class.getSimpleName())) {
                      //  setTitle("Squads");
                    } else if (fragment.getTag().equals(TabFragment5.class.getSimpleName())) {
                     //   setTitle("Squads");
                    } else if (fragment.getTag().equals(NextGameFragment.class.getSimpleName())) {
                            setTitle("NextGame");
                    } else if (fragment.getTag().equals(SponsorsFragment.class.getSimpleName())) {
                        setTitle("Partners");
                    }
                }
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }





    }

