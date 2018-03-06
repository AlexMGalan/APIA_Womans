package com.acacias.altfc;

import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.support.design.widget.NavigationView;
import android.support.v4.view.GravityCompat;
import android.support.v4.widget.DrawerLayout;
import android.support.v7.app.ActionBarDrawerToggle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;

public class MainActivity extends AppCompatActivity
        implements NavigationView.OnNavigationItemSelectedListener {


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
    public void onBackPressed() {
        DrawerLayout drawer = (DrawerLayout) findViewById(R.id.drawer_layout);
        if (drawer.isDrawerOpen(GravityCompat.START)) {
            drawer.closeDrawer(GravityCompat.START);
        } else {
            super.onBackPressed();
        }
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
       //  Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.main, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
       //  Handle action bar item clicks here. The action bar will
       //  automatically handle clicks on the Home/Up button, so long
      //   as you specify a parent activity in AndroidManifest.xml.
        int id = item.getItemId();

        //noinspection SimplifiableIfStatement
       if (id == R.id.action_exit) {
           this.finish();
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
            // Handle the camera action
         //  Toast.makeText(MainActivity.this, "Next Game",
           //       Toast.LENGTH_LONG).show();
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

          //  this.setTitle("Squads");

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


       }   else if (id == R.id.nav_notifications) {
            NotifyFragment notifyfragment = new NotifyFragment();
           android.support.v4.app.FragmentManager manager = getSupportFragmentManager();
            manager.beginTransaction()
                    .replace(R.id.mainLayout, notifyfragment)
                    .commit();
            this.setTitle("Notifications");
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

    public void openBrowserDolc(View view){

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
