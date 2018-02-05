package com.acacias.altfc;

import android.app.FragmentManager;
import android.content.Intent;
import android.content.res.Resources;
import android.net.Uri;
import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.support.design.widget.TabLayout;
import android.support.v4.view.ViewPager;
import android.view.View;
import android.support.design.widget.NavigationView;
import android.support.v4.view.GravityCompat;
import android.support.v4.widget.DrawerLayout;
import android.support.v7.app.ActionBarDrawerToggle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.ImageView;
import android.widget.ListView;
import android.widget.Toast;


import java.util.List;

public class MainActivity extends AppCompatActivity
        implements NavigationView.OnNavigationItemSelectedListener {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

    //Set up database
   // DatabaseHandler db = new DatabaseHandler(this);

        // Inserting Contacts
       // Log.d("Insert: ", "Inserting ..");
      //  db.addContact(new Player("Ravi", "9100000000"));
      //  db.addContact(new Player("Srinivas", "9199999999"));
      //  db.addContact(new Player("Tommy", "9522222222"));
      //  db.addContact(new Player("Karthik", "9533333333"));

        // Reading all contacts
        //Log.d("Reading: ", "Reading all contacts..");
      //  List<Player> players = db.getAllPlayers();

        //for (Player cn : players) {
           //   Toast.makeText(MainActivity.this, "Name: " + cn.getName(),
           //          Toast.LENGTH_LONG).show();

         //   String log = "Id: "+cn.getID()+" ,Name: " + cn.getName() + " ,Phone: " +
          //          cn.getPhoneNumber();
            // Writing Contacts to log
          //  Log.d("Name: ", log);
       // }

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
       if (id == R.id.action_settings) {
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

        } else if (id == R.id.nav_squads) {
            SquadsFragment squadsfragment = new SquadsFragment();
            android.support.v4.app.FragmentManager manager = getSupportFragmentManager();
            manager.beginTransaction()
                    .replace(R.id.mainLayout, squadsfragment)
                    .commit();

          //  startActivity(new Intent(getApplicationContext(), ListViewAndroidExample.class));
          //  return true;


        } else if (id == R.id.nav_fixtures) {
            FixturesFragment fixturesfragment = new FixturesFragment();
            android.support.v4.app.FragmentManager manager = getSupportFragmentManager();
            manager.beginTransaction()
                    .replace(R.id.mainLayout, fixturesfragment)
                    .commit();

        } else if (id == R.id.nav_about) {
            HistoryFragment historyfragment = new HistoryFragment();
            android.support.v4.app.FragmentManager manager = getSupportFragmentManager();
            manager.beginTransaction()
                    .replace(R.id.mainLayout, historyfragment)
                    .commit();

        } else if (id == R.id.nav_about) {
            HomeFragment homefragment = new HomeFragment();
           android.support.v4.app.FragmentManager manager = getSupportFragmentManager();
           manager.beginTransaction()
                 .replace(R.id.mainLayout, homefragment)
                   .commit();


        } else if (id == R.id.nav_sponsors) {
            SponsorsFragment sponsorsfragment = new SponsorsFragment();
            android.support.v4.app.FragmentManager manager = getSupportFragmentManager();
            manager.beginTransaction()
                    .replace(R.id.mainLayout, sponsorsfragment)
                    .commit();

        } else if (id == R.id.nav_coaches) {
            HomeFragment homefragment = new HomeFragment();
            android.support.v4.app.FragmentManager manager = getSupportFragmentManager();
            manager.beginTransaction()
                    .replace(R.id.mainLayout, homefragment)
                    .commit();

        }   else if (id == R.id.nav_matchday) {
            MatchFragment matchfragment = new MatchFragment();
            android.support.v4.app.FragmentManager manager = getSupportFragmentManager();
            manager.beginTransaction()
                    .replace(R.id.mainLayout, matchfragment)
                    .commit();
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



    }
