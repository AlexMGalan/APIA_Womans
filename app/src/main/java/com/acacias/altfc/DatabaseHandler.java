package com.acacias.altfc;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
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
    private static final String TABLE_SYSTEM = "system";

    private static final String KEY_ID = "id";
    private static final String KEY_NAME = "name";
    private static final String KEY_PH_NO = "phone_number";

    //Matches
    private static final String m_Round = "m_round";
    private static final String mDATE = "m_date";
    private static final String mHOME = "m_hometeam";
    private static final String mVISIT = "m_visitteam";
    private static final String mGROUND = "m_ground";
    private static final String mTIME1 = "m_time1";
    private static final String mTIME2 = "m_time2";
    private static final String mTIME17 = "m_time17";
    private static final String mTIME15 = "m_time15";
    private static final String mTIME14 = "m_time14";
    private static final String mLOGO = "m_logo";

    private static final String ADMIN = "admin";


    public DatabaseHandler(Context context) {
        super(context, DATABASE_NAME, null, DATABASE_VERSION);
        //3rd argument to be passed is CursorFactory instance


    }

    // Creating Tables
    @Override
    public void onCreate(SQLiteDatabase db) {

        String CREATE_SYSTEM_TABLE = "CREATE TABLE " + TABLE_SYSTEM + "("
                + "s_admin TINYINT" + ")";
        db.execSQL(CREATE_SYSTEM_TABLE);

      //  db.execSQL("INSERT INTO "  +  CREATE_SYSTEM_TABLE + "(s_admin) "
        //        + "VALUES (1) ");

        String CREATE_PLAYERS_TABLE = "CREATE TABLE " + TABLE_PLAYERS + "("
                + "p_team TINYINT, p_number INT, p_firstname TEXT, p_lastname TEXT" + ")";
        db.execSQL(CREATE_PLAYERS_TABLE);

        String CREATE_MATCHES_TABLE = "CREATE TABLE " + TABLE_MATCHES + "("
                + "m_round INT, m_date TEXT, m_hometeam TEXT, m_visitteam TEXT, m_ground TEXT, m_time1 TEXT, m_time2 TEXT, m_time17 TEXT, m_time15 TEXT, m_time14 TEXT, m_logo TEXT, m_lat Double, m_long Double)";

        db.execSQL(CREATE_MATCHES_TABLE);

        db.execSQL("INSERT INTO "  +  TABLE_PLAYERS + "(p_team,p_number,p_firstname,p_lastname) "
                + "VALUES (3, 48, 'Alannah', 'Galan' )");


        db.execSQL("INSERT INTO "  +  TABLE_MATCHES + "(m_round,m_date,m_hometeam,m_visitteam,m_ground,m_time1,m_time2, m_time17, m_time15, m_time14, m_logo, m_lat, m_long ) "
           + "VALUES (1, '2018-03-11', 'Southern Branch', 'APIA', 'SOUTH NOWRA FOOTBALL COMPLEX', '3:00PM','1:35PM', '12:00PM', '9:55AM', '8:30AM', 'southern_branch',-34.9003438, 150.604564 )");

        db.execSQL("INSERT INTO "  +  TABLE_MATCHES + "(m_round, m_date,m_hometeam,m_visitteam,m_ground,m_time1,m_time2, m_time17, m_time15, m_time14, m_logo, m_lat, m_long  ) "
                + "VALUES (2, '2018-03-18', 'Central Coast', 'APIA', 'International Football School Kariong', '3:00PM','1:35PM', '12:00PM', '9:55AM', '8:30AM', 'central_coast',-33.4287218,151.2952059 )");

        db.execSQL("INSERT INTO "  +  TABLE_MATCHES + "(m_round, m_date,m_hometeam,m_visitteam,m_ground,m_time1,m_time2, m_time17, m_time15, m_time14, m_logo, m_lat, m_long  ) "
                + "VALUES (3, '2018-03-25', 'APIA', 'SD Raiders', 'Lambert Park', '7:00PM','5:05PM', '3:30PM', '1:55PM', '12:30PM', 'sdraiders',-33.8845574,151.1441807 )");

        db.execSQL("INSERT INTO "  +  TABLE_MATCHES + "(m_round, m_date,m_hometeam,m_visitteam,m_ground,m_time1,m_time2, m_time17, m_time15, m_time14, m_logo, m_lat, m_long  ) "
                + "VALUES (4, '2018-04-02', 'APIA', 'Western NSW', 'Lambert Park', '4:30PM','2:35PM', '1:00PM', '11:25AM', '10:00AM', 'westnsw', -33.8845574,151.1441807 )");

        db.execSQL("INSERT INTO "  +  TABLE_MATCHES + "(m_round, m_date,m_hometeam,m_visitteam,m_ground,m_time1,m_time2, m_time17, m_time15, m_time14, m_logo, m_lat, m_long  ) "
                + "VALUES (5, '2018-04-08', 'APIA', 'Sydney Olympic', 'Lambert Park', '7:00PM','5:05PM', '3:30PM', '1:55PM', '12:00PM', 'sydneyolympic', -33.8845574,151.1441807 )");

        db.execSQL("INSERT INTO "  +  TABLE_MATCHES + "(m_round, m_date,m_hometeam,m_visitteam,m_ground,m_time1,m_time2, m_time17, m_time15, m_time14, m_logo, m_lat, m_long  ) "
                + "VALUES (6, '2018-04-15', 'Nepean FC', 'APIA', 'Cook Park', '6:30PM','4:35PM', '3:00PM', '1:25PM', '12:30PM', 'nepean', -33.7756267,150.7653697 )");

        db.execSQL("INSERT INTO "  +  TABLE_MATCHES + "(m_round, m_date,m_hometeam,m_visitteam,m_ground,m_time1,m_time2, m_time17, m_time15, m_time14, m_logo, m_lat, m_long  ) "
                + "VALUES (7, '2018-04-22', 'APIA', 'Inter Lions', 'Lambert Park', '7:00PM','5:05PM', '3:30PM', '1:55PM', '12:30PM', 'interlions', -33.8845574,151.1441807 )");

        db.execSQL("INSERT INTO "  +  TABLE_MATCHES + "(m_round, m_date,m_hometeam,m_visitteam,m_ground,m_time1,m_time2, m_time17, m_time15, m_time14, m_logo, m_lat, m_long  ) "
                + "VALUES (8, '2018-04-29', 'Marconi', 'APIA', 'Marconi Stadium', '3:00PM','1:35PM', '12:00PM', '9:55AM', '8:30AM', 'marconi', -33.8643667,150.8780015 )");

        db.execSQL("INSERT INTO "  +  TABLE_MATCHES + "(m_round, m_date,m_hometeam,m_visitteam,m_ground,m_time1,m_time2, m_time17, m_time15, m_time14, m_logo, m_lat, m_long  ) "
                + "VALUES (9, '2018-05-06', 'APIA', 'UNSW', 'Lambert Park', '7:00PM','5:05PM', '3:30PM', '1:55PM', '12:30PM', 'unsw', -33.8845574,151.1441807 )");

        db.execSQL("INSERT INTO "  +  TABLE_MATCHES + "(m_round, m_date,m_hometeam,m_visitteam,m_ground,m_time1,m_time2, m_time17, m_time15, m_time14, m_logo, m_lat, m_long  ) "
                + "VALUES (10, '2018-05-13', 'Gladesville Ravens', 'APIA', 'Christie Park', '3:00PM','1:35PM', '12:00PM', '9:55AM', '8:30AM', 'ravens', -33.7706816,151.1168373 )");

        db.execSQL("INSERT INTO "  +  TABLE_MATCHES + "(m_round, m_date,m_hometeam,m_visitteam,m_ground,m_time1,m_time2, m_time17, m_time15, m_time14, m_logo, m_lat, m_long  ) "
                + "VALUES (11, '2018-05-20', 'APIA', 'ST George', 'Lambert Park', '7:00PM','5:05PM', '3:30PM', '1:55PM', '12:30PM', 'stgeorge', -33.8845574,151.1441807 )");

        db.execSQL("INSERT INTO "  +  TABLE_MATCHES + "(m_round, m_date,m_hometeam,m_visitteam,m_ground,m_time1,m_time2, m_time17, m_time15, m_time14, m_logo, m_lat, m_long  ) "
                + "VALUES (12, '2018-05-27', 'Southern Branch', 'APIA', 'SOUTH NOWRA FOOTBALL COMPLEX', '3:00PM','1:35PM', '12:00PM', '9:55AM', '8:30AM', 'westnsw', -34.9003438, 150.604564 )");


        db.execSQL("INSERT INTO "  +  TABLE_MATCHES + "(m_round, m_date,m_hometeam,m_visitteam,m_ground,m_time1,m_time2, m_time17, m_time15, m_time14, m_logo, m_lat, m_long  ) "
                + "VALUES (13, '2018-06-03', 'APIA', 'Central Coast', 'Lambert Park', '7:00PM','5:05PM', '3:30PM', '1:55PM', '12:30PM', 'centralcoast', -33.8845574,151.1441807 )");

        db.execSQL("INSERT INTO "  +  TABLE_MATCHES + "(m_round, m_date,m_hometeam,m_visitteam,m_ground,m_time1,m_time2, m_time17, m_time15, m_time14, m_logo, m_lat, m_long  ) "
                + "VALUES (14, '2018-06-10', 'Sd Raiders', 'APIA', 'Ernie Smith Reserve', '6:00PM','4:05PM', '2:30PM', '12:55PM', '12:00PM', 'sdraiders', -33.9340737,150.9414135 )");

        db.execSQL("INSERT INTO "  +  TABLE_MATCHES + "(m_round, m_date,m_hometeam,m_visitteam,m_ground,m_time1,m_time2, m_time17, m_time15, m_time14, m_logo, m_lat, m_long ) "
                + "VALUES (15, '2018-06-17', 'Western NSW', 'APIA', 'Proctor Park', '3:00PM','1:35PM', '12:00PM', '9:55AM', '8:30AM', 'westnsw', -33.4301031,149.5862814 )");

        db.execSQL("INSERT INTO "  +  TABLE_MATCHES + "(m_round, m_date,m_hometeam,m_visitteam,m_ground,m_time1,m_time2, m_time17, m_time15, m_time14, m_logo, m_lat, m_long  ) "
                + "VALUES (16, '2018-06-24', 'Sydney Olympic', 'APIA', 'Peter Moore Field', '3:00PM','1:35PM', '12:00PM', '9:55AM', '8:30AM', 'sydneyolympic', -33.915913,151.0941328 )");

        db.execSQL("INSERT INTO "  +  TABLE_MATCHES + "(m_round, m_date,m_hometeam,m_visitteam,m_ground,m_time1,m_time2, m_time17, m_time15, m_time14, m_logo, m_lat, m_long  ) "
                + "VALUES (17, '2018-07-01', 'APIA', 'Nepean', 'Lambert Park', '7:00PM','5:05PM', '3:30PM', '1:55PM', '12:30PM', 'nepean', -33.8845574,151.1441807 )");

        db.execSQL("INSERT INTO "  +  TABLE_MATCHES + "(m_round, m_date,m_hometeam,m_visitteam,m_ground,m_time1,m_time2, m_time17, m_time15, m_time14, m_logo, m_lat, m_long  ) "
                + "VALUES (18, '2018-07-08', 'InterLions', 'APIA', 'Concord Oval', '3:00PM','1:35PM', '12:00PM', '9:55AM', '8:30AM', 'interlions', -33.8685739,151.1071847 )");

        db.execSQL("INSERT INTO "  +  TABLE_MATCHES + "(m_round, m_date,m_hometeam,m_visitteam,m_ground,m_time1,m_time2, m_time17, m_time15, m_time14, m_logo, m_lat, m_long  ) "
                + "VALUES (19, '2018-07-15', 'APIA', 'Marconi', 'Lambert Park', '7:00PM','5:05PM', '3:30PM', '1:55PM', '12:30PM', 'marconi', -33.8845574,151.1441807 )");

        db.execSQL("INSERT INTO "  +  TABLE_MATCHES + "(m_round, m_date,m_hometeam,m_visitteam,m_ground,m_time1,m_time2, m_time17, m_time15, m_time14, m_logo, m_lat, m_long  ) "
                + "VALUES (20, '2018-07-22', 'UNSW', 'APIA', 'David Phillips Field', '3:00PM','1:35PM', '12:00PM', '9:55AM', '8:30AM', 'unsw', -33.931135,151.2222627 )");

        db.execSQL("INSERT INTO "  +  TABLE_MATCHES + "(m_round, m_date,m_hometeam,m_visitteam,m_ground,m_time1,m_time2, m_time17, m_time15, m_time14, m_logo, m_lat, m_long ) "
                + "VALUES (21, '2018-07-29', 'APIA', 'Gladesville Ravens', 'Lambert Park', '7:00PM','5:05PM', '3:30PM', '1:55PM', '12:30PM', 'ravens', -33.8845574,151.1441807 )");

        db.execSQL("INSERT INTO "  +  TABLE_MATCHES + "(m_round, m_date,m_hometeam,m_visitteam,m_ground,m_time1,m_time2, m_time17, m_time15, m_time14, m_logo, m_lat, m_long  ) "
                + "VALUES (22, '2018-08-05', 'St George', 'APIA', 'St George Stadium', '3:00PM','1:35PM', '12:00PM', '9:55AM', '8:30AM', 'stgeorge',-33.9420635,151.1520375 )");

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

    // code to get a Match
    Match getMatch(int round) {
        SQLiteDatabase db = this.getReadableDatabase();

        String swhere;

        if (round == 0) {
            swhere= " WHERE m_date >= date('now', 'localtime')" ;
        } else {
            swhere= " WHERE m_round = " + round;
        }
       // Cursor cursor = db.rawQuery("SELECT * FROM "  + TABLE_MATCHES +  )", null);
        Cursor cursor = db.rawQuery("SELECT * FROM "  + TABLE_MATCHES +  swhere , null);

        if (cursor != null)
            cursor.moveToFirst();

        Match match = new Match( cursor.getInt(0), cursor.getString(1), cursor.getString(2), cursor.getString(3),
                cursor.getString(4), cursor.getString(5), cursor.getString(6), cursor.getString(7), cursor.getString(8), cursor.getString(9), cursor.getString(10),
                cursor.getDouble(11), cursor.getDouble(12));
        // return contact

        return match;
    }

  //  public List<Match>  getMatch() {
  //      List<Match> matchList = new ArrayList<Match>();
        // Select All Query
    //    String selectQuery = "SELECT  * FROM " + TABLE_MATCHES;
    //    SQLiteDatabase db = this.getWritableDatabase();
     //   Cursor cursor = db.rawQuery(selectQuery, null);

        // looping through all rows and adding to list
     //   if (cursor.moveToFirst()) {
      //      do {
         //       Match match = new Match();
         //       match.setDate(cursor.getString(0));
         //       match.setHomeTeam(cursor.getString(1));
         //       match.setVisitTeam(cursor.getString(2));
         //       match.setGround(cursor.getString(3));
         //       match.setTime1(cursor.getString(4));
         //       match.setTime2(cursor.getString(5));
        //        match.setTime17(cursor.getString(6));
        //        match.setTime15(cursor.getString(7));
        //        match.setTime14(cursor.getString(8));

                // Adding Match to list
        //        matchList.add(match);

         //   } while (cursor.moveToNext());
       // }
       // return matchList;
   // }

    // code to get all contacts in a list view
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
                // player.setID(Integer.parseInt(cursor.getString(0)));
                match.setDate(cursor.getString(0));
                match.setHomeTeam(cursor.getString(1));
                match.setVisitTeam(cursor.getString(2));
                match.setGround(cursor.getString(3));
                match.setTime1(cursor.getString(4));
                match.setTime2(cursor.getString(5));
                match.setTime17(cursor.getString(6));
                match.setTime15(cursor.getString(7));
                match.setTime14(cursor.getString(8));
                match.setTime14(cursor.getString(9));
                // Adding contact to list
                matchList.add(match);
            } while (cursor.moveToNext());
        }

        // return contact list
        return matchList;
    }
}