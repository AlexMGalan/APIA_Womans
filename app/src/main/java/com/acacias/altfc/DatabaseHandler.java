package com.acacias.altfc;
import java.util.ArrayList;
import java.util.List;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
import android.widget.Toast;

import static android.widget.Toast.LENGTH_LONG;

public class DatabaseHandler extends SQLiteOpenHelper {
    private static final int DATABASE_VERSION = 1;
    private static final String DATABASE_NAME = "dbAPIA";
    private static final String TABLE_PLAYERS = "players";
    private static final String TABLE_MATCHES = "matches";

    private static final String KEY_ID = "id";
    private static final String KEY_NAME = "name";
    private static final String KEY_PH_NO = "phone_number";

    public DatabaseHandler(Context context) {
        super(context, DATABASE_NAME, null, DATABASE_VERSION);
        //3rd argument to be passed is CursorFactory instance


    }

    // Creating Tables
    @Override
    public void onCreate(SQLiteDatabase db) {
        String CREATE_PLAYERS_TABLE = "CREATE TABLE " + TABLE_PLAYERS + "("
                + "p_team TINYINT, p_number INT, p_firstname TEXT, p_lastname TEXT" + ")";
        db.execSQL(CREATE_PLAYERS_TABLE);

        String CREATE_MATCHES_TABLE = "CREATE TABLE " + TABLE_MATCHES + "("
                + "m_id INTEGER PRIMARY KEY, m_date TEXT, m_hometeam TEXT, m_visitteam TEXT, m_ground TEXT, m_time1 TEXT, m_time2 TEXT, m_time17 TEXT, m_time15 TEXT, m_time14 TEXT)";

        db.execSQL(CREATE_MATCHES_TABLE);


    }

    // Upgrading database
    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
        // Drop older table if existed
        db.execSQL("DROP TABLE IF EXISTS " + TABLE_PLAYERS);

        // Create tables again
        onCreate(db);

        db.execSQL("DROP TABLE IF EXISTS " + TABLE_MATCHES);

        // Create tables again
        onCreate(db);
    }

    // code to add the new player
    void addPlayer(Player player) {
        SQLiteDatabase db = this.getWritableDatabase();

        ContentValues values = new ContentValues();
        values.put("p_team", player.getTeam()); // Team Id
        values.put("p_number", player.getNumber()); // Player Number
        values.put("p_firstname", player.get_firstname()); // Player First Name
        values.put("p_lastname", player.get_lastname()); // Player Last Name

        // Inserting Row
        db.insert(TABLE_PLAYERS, null, values);
        //2nd argument is String containing nullColumnHack
        db.close(); // Closing database connection
    }

    // code to get the single contact
    Player getPlayer(int id) {
        SQLiteDatabase db = this.getReadableDatabase();

        Cursor cursor = db.query(TABLE_PLAYERS, new String[] { KEY_ID,
                        KEY_NAME, KEY_PH_NO }, KEY_ID + "=?",
                new String[] { String.valueOf(id) }, null, null, null, null);
        if (cursor != null)
            cursor.moveToFirst();

        Player player = new Player( cursor.getInt(1), cursor.getInt(2), cursor.getString(3), cursor.getString(4));
        // return contact
        return player;
    }

    // code to get all contacts in a list view
    public List<Player> getAllPlayers() {
        List<Player> contactList = new ArrayList<Player>();
        // Select All Query
        String selectQuery = "SELECT  * FROM " + TABLE_PLAYERS;

        SQLiteDatabase db = this.getWritableDatabase();
        Cursor cursor = db.rawQuery(selectQuery, null);

        // looping through all rows and adding to list
        if (cursor.moveToFirst()) {
            do {
                Player player = new Player();
               // player.setID(Integer.parseInt(cursor.getString(0)));
                player.setTeam(Integer.parseInt(cursor.getString(0)));
                player.setNumber(Integer.parseInt(cursor.getString(1)));
                player.setFirstName(cursor.getString(2));
               player.setLastName(cursor.getString(3));
                // Adding contact to list
                contactList.add(player);
            } while (cursor.moveToNext());
        }

        // return contact list
        return contactList;
    }

    // code to update the single contact
    public int updateContact(Player player) {
        SQLiteDatabase db = this.getWritableDatabase();

        ContentValues values = new ContentValues();
      //  values.put(KEY_NAME, player.getName());
       // values.put(KEY_PH_NO, player.getPhoneNumber());

        // updating row
        return db.update(TABLE_PLAYERS, values, KEY_ID + " = ?",
                new String[] { String.valueOf(player.getID()) });
    }

    // Deleting single contact
    public void deleteContact(Player player) {
    //    SQLiteDatabase db = this.getWritableDatabase();
    //    db.delete(TABLE_PLAYERS, KEY_ID + " = ?",
     //           new String[] { String.valueOf(player.getID()) });
     //   db.close();
    }

    // Getting contacts Count
    public int getContactsCount() {
        String countQuery = "SELECT  * FROM " + TABLE_PLAYERS;
        SQLiteDatabase db = this.getReadableDatabase();
        Cursor cursor = db.rawQuery(countQuery, null);
        cursor.close();

        // return count
        return cursor.getCount();
    }

    // code to add the new match
    void addMatch(Match match) {
        SQLiteDatabase db = this.getWritableDatabase();

        ContentValues values = new ContentValues();
        values.put("m_date", match.getDate());
        values.put("m_hometeam", match.getHomeTeam());
        values.put("m_visitteam", match.getVisitTeam());
        values.put("m_ground", match.getGround());
        values.put("m_time1", match.getTime1());
        values.put("m_time2", match.getTime2());
        values.put("m_time17", match.getTime17());
        values.put("m_time15", match.getTime15());
        values.put("m_time14", match.getTime14());


        // Inserting Row
        db.insert(TABLE_MATCHES, null, values);
        //2nd argument is String containing nullColumnHack
        db.close(); // Closing database connection
    }

    // code to get all matches
    public List<Match> getAllMatches() {
        List<Match> matchList = new ArrayList<Match>();
        // Select All Query
        String selectQuery = "SELECT  * FROM " + TABLE_MATCHES;

        SQLiteDatabase db = this.getWritableDatabase();
        Cursor cursor = db.rawQuery(selectQuery, null);

        // looping through all rows and adding to list
        if (cursor.moveToFirst()) {
            do {
                Match match = new Match();
                match.setDate(cursor.getString(0));
                match.setHomeTeam(cursor.getString(1));
                match.setVisitTeam(cursor.getString(2));
                match.setGround(cursor.getString(3));
                match.setTime1(cursor.getString(4));
                match.setTime2(cursor.getString(5));
                match.setTime17(cursor.getString(6));
                match.setTime15(cursor.getString(7));
                match.setTime14(cursor.getString(8));

                // Adding Match to list
                matchList.add(match);
            } while (cursor.moveToNext());
        }

        // return matchList list
        return matchList;
    }

    // code to get a Match
   // Player getMatch(String date) {
    //    SQLiteDatabase db = this.getReadableDatabase();

     //   Cursor cursor = db.query(TABLE_MATCHES, new String[] { KEY_ID,
     //                   KEY_NAME, KEY_PH_NO }, KEY_ID + "=?",
      //          new String[] { String.valueOf(date) }, null, null, null, null);
      //  if (cursor != null)
       //     cursor.moveToFirst();

      //  Match match = new Match( cursor.getInt(1), cursor.getInt(2), cursor.getString(3), cursor.getString(4));
        // return contact
     //   return match;
   // }






}