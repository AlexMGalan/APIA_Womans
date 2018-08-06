package com.acacias.altfc;
import java.util.ArrayList;
import java.util.List;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

public class DatabaseHandler extends SQLiteOpenHelper {
    private static final int DATABASE_VERSION = 5;
    private static final String DATABASE_NAME = "dbAPIA";
    private static final String TABLE_PLAYERS = "players";
    private static final String TABLE_MATCHES = "matches";

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

        String CREATE_MATCHES_TABLE = "CREATE TABLE " + TABLE_MATCHES + "("
                + "m_round INT, m_date TEXT, m_hometeam TEXT, m_visitteam TEXT, m_ground TEXT, m_time1 TEXT, m_time2 TEXT, m_time17 TEXT, m_time15 TEXT, m_time14 TEXT, m_logo TEXT, m_lat Double, m_long Double, m_address TEXT)";

        db.execSQL(CREATE_MATCHES_TABLE);

        db.execSQL("INSERT INTO "  +  TABLE_MATCHES + "(m_round,m_date,m_hometeam,m_visitteam,m_ground,m_time1,m_time2, m_time17, m_time15, m_time14, m_logo, m_lat, m_long, m_address ) "
           + "VALUES (1, '2018-03-11', 'Southern Branch', 'APIA', 'SOUTH NOWRA FOOTBALL COMPLEX', ' 3:00PM',' 1:35PM', '12:00PM', ' 9:55AM', ' 8:30AM', 'southern_branch',-34.9003438, 150.604564, 'Mulbulla Street, South Nowra' )");

        db.execSQL("INSERT INTO "  +  TABLE_MATCHES + "(m_round, m_date,m_hometeam,m_visitteam,m_ground,m_time1,m_time2, m_time17, m_time15, m_time14, m_logo, m_lat, m_long, m_address  ) "
                + "VALUES (2, '2018-03-18', 'Central Coast', 'APIA', 'Pluim Park', ' 3:00PM',' 1:35PM', '12:00PM', ' 9:55AM', ' 8:30AM', 'central_coast',-33.4287218,151.2952059, 'Tuggerah St, Lisarow' )");

        db.execSQL("INSERT INTO "  +  TABLE_MATCHES + "(m_round, m_date,m_hometeam,m_visitteam,m_ground,m_time1,m_time2, m_time17, m_time15, m_time14, m_logo, m_lat, m_long, m_address  ) "
                + "VALUES (3, '2018-03-25', 'APIA', 'SD Raiders', 'Lambert Park', ' 7:00PM',' 5:05PM', ' 3:30PM', ' 1:55PM', '12:30PM', 'sdraiders',-33.8845574,151.1441807, '20-22 Marion St, Leichhardt' )");

        db.execSQL("INSERT INTO "  +  TABLE_MATCHES + "(m_round, m_date,m_hometeam,m_visitteam,m_ground,m_time1,m_time2, m_time17, m_time15, m_time14, m_logo, m_lat, m_long, m_address  ) "
                + "VALUES (4, '2018-04-02', 'APIA', 'Western NSW', 'Lambert Park', ' 4:30PM',' 2:35PM', ' 1:00PM', '11:25AM', '10:00AM', 'westnsw', -33.8845574,151.1441807, '20-22 Marion St, Leichhardt' )");

        db.execSQL("INSERT INTO "  +  TABLE_MATCHES + "(m_round, m_date,m_hometeam,m_visitteam,m_ground,m_time1,m_time2, m_time17, m_time15, m_time14, m_logo, m_lat, m_long, m_address  ) "
                + "VALUES (5, '2018-04-08', 'APIA', 'Sydney Olympic', 'Lambert Park', ' 7:00PM',' 5:05PM', ' 3:30PM', ' 1:55PM', '12:00PM', 'sydneyolympic', -33.8845574,151.1441807, '20-22 Marion St, Leichhardt' )");

        db.execSQL("INSERT INTO "  +  TABLE_MATCHES + "(m_round, m_date,m_hometeam,m_visitteam,m_ground,m_time1,m_time2, m_time17, m_time15, m_time14, m_logo, m_lat, m_long, m_address  ) "
                + "VALUES (6, '2018-04-15', 'Nepean FC', 'APIA', 'Cook Park', ' 6:30PM',' 4:35PM', ' 3:00PM', ' 1:25PM', '12:30PM', 'nepean', -33.7756267,150.7653697, 'Wilson Street, ST MARYS, NSW' )");

        db.execSQL("INSERT INTO "  +  TABLE_MATCHES + "(m_round, m_date,m_hometeam,m_visitteam,m_ground,m_time1,m_time2, m_time17, m_time15, m_time14, m_logo, m_lat, m_long, m_address  ) "
                + "VALUES (7, '2018-04-22', 'APIA', 'Inter Lions', 'Lambert Park', ' 7:00PM',' 5:05PM', ' 3:30PM', ' 1:55PM', '12:30PM', 'interlions', -33.8845574,151.1441807, '20-22 Marion St, Leichhardt ' )");

        db.execSQL("INSERT INTO "  +  TABLE_MATCHES + "(m_round, m_date,m_hometeam,m_visitteam,m_ground,m_time1,m_time2, m_time17, m_time15, m_time14, m_logo, m_lat, m_long, m_address  ) "
                + "VALUES (8, '2018-04-29', 'Marconi', 'APIA', 'Marconi Stadium', ' 3:00PM',' 1:35PM', '12:00PM', ' 9:55AM', ' 8:30AM', 'marconi', -33.8643667,150.8780015, 'Restwell Road, Bossley Park' )");

        db.execSQL("INSERT INTO "  +  TABLE_MATCHES + "(m_round, m_date,m_hometeam,m_visitteam,m_ground,m_time1,m_time2, m_time17, m_time15, m_time14, m_logo, m_lat, m_long, m_address  ) "
                + "VALUES (9, '2018-05-06', 'APIA', 'UNSW', 'Lambert Park', ' 7:00PM',' 5:05PM', ' 3:30PM', ' 1:55PM', '12:30PM', 'unsw', -33.8845574,151.1441807, '20-22 Marion St, Leichhardt' )");

        db.execSQL("INSERT INTO "  +  TABLE_MATCHES + "(m_round, m_date,m_hometeam,m_visitteam,m_ground,m_time1,m_time2, m_time17, m_time15, m_time14, m_logo, m_lat, m_long, m_address  ) "
                + "VALUES (10, '2018-05-13', 'Gladesville Ravens', 'APIA', 'Christie Park', ' 3:00PM',' 1:05PM', '11:30AM', ' 9:55AM', ' 8:30AM', 'ravens', -33.7706816,151.1168373, '12a Christie Rd, Macquarie Park' )");

        db.execSQL("INSERT INTO "  +  TABLE_MATCHES + "(m_round, m_date,m_hometeam,m_visitteam,m_ground,m_time1,m_time2, m_time17, m_time15, m_time14, m_logo, m_lat, m_long, m_address  ) "
                + "VALUES (11, '2018-05-20', 'APIA', 'ST George', 'Lambert Park', ' 7:00PM',' 5:05PM', ' 3:30PM', ' 1:55PM', ' 12:30PM', 'stgeorge', -33.8845574,151.1441807, '20-22 Marion St, Leichhardt' )");

        db.execSQL("INSERT INTO "  +  TABLE_MATCHES + "(m_round, m_date,m_hometeam,m_visitteam,m_ground,m_time1,m_time2, m_time17, m_time15, m_time14, m_logo, m_lat, m_long, m_address  ) "
                + "VALUES (12, '2018-05-27', 'Southern Branch', 'APIA', 'SOUTH NOWRA FOOTBALL COMPLEX', ' 3:00PM',' 01:05PM', '11:30AM', '09:55AM', ' 8:30AM', 'westnsw', -34.9003438, 150.604564, 'Mulbulla Street, South Nowra' )");

        db.execSQL("INSERT INTO "  +  TABLE_MATCHES + "(m_round, m_date,m_hometeam,m_visitteam,m_ground,m_time1,m_time2, m_time17, m_time15, m_time14, m_logo, m_lat, m_long, m_address  ) "
                + "VALUES (13, '2018-06-03', 'APIA', 'Central Coast', 'Lambert Park', ' 7:00PM',' 5:05PM', ' 3:30PM', ' 1:55PM', '12:30PM', 'central_coast', -33.8845574,151.1441807, '20-22 Marion St, Leichhardt' )");

        db.execSQL("INSERT INTO "  +  TABLE_MATCHES + "(m_round, m_date,m_hometeam,m_visitteam,m_ground,m_time1,m_time2, m_time17, m_time15, m_time14, m_logo, m_lat, m_long, m_address  ) "
                + "VALUES (14, '2018-06-11', 'Sd Raiders', 'APIA', 'Ernie Smith Reserve', ' 6:00PM',' 4:05PM', ' 2:30PM', '12:55PM', '11:30AM', 'sdraiders', -33.9340737,150.9414135, 'Kelso Crescent Moorebank' )");

        db.execSQL("INSERT INTO "  +  TABLE_MATCHES + "(m_round, m_date,m_hometeam,m_visitteam,m_ground,m_time1,m_time2, m_time17, m_time15, m_time14, m_logo, m_lat, m_long, m_address ) "
                + "VALUES (15, '2018-06-17', 'Western NSW', 'APIA', 'Sir Jack Brabham Park', ' 3:00PM',' 1:05PM', '11:30AM', ' 9:55AM', ' 8:30AM', 'westnsw', -33.3097367,149.0972249, '1641 Forest Rd, Orange' )");

        db.execSQL("INSERT INTO "  +  TABLE_MATCHES + "(m_round, m_date,m_hometeam,m_visitteam,m_ground,m_time1,m_time2, m_time17, m_time15, m_time14, m_logo, m_lat, m_long, m_address  ) "
                + "VALUES (16, '2018-06-24', 'Sydney Olympic', 'APIA', 'Peter Moore Field', ' 3:00PM',' 1:05PM', ' 11:30AM', ' 9:55AM', '8:30AM', 'sydneyolympic', -33.915913,151.0941328, '1C Leylands Parade, Belmore' )");

        db.execSQL("INSERT INTO "  +  TABLE_MATCHES + "(m_round, m_date,m_hometeam,m_visitteam,m_ground,m_time1,m_time2, m_time17, m_time15, m_time14, m_logo, m_lat, m_long, m_address  ) "
                + "VALUES (17, '2018-07-01', 'APIA', 'Nepean', 'Lambert Park', ' 7:00PM',' 5:05PM', ' 3:30PM', ' 1:55PM', '12:30PM', 'nepean', -33.8845574,151.1441807, '20-22 Marion St, Leichhardt' )");

        db.execSQL("INSERT INTO "  +  TABLE_MATCHES + "(m_round, m_date,m_hometeam,m_visitteam,m_ground,m_time1,m_time2, m_time17, m_time15, m_time14, m_logo, m_lat, m_long, m_address  ) "
                + "VALUES (18, '2018-07-08', 'InterLions', 'APIA', 'Concord Oval', ' 3:00PM',' 1:35PM', '11:30PM', ' 9:55AM', ' 8:30AM', 'interlions', -33.8685739,151.1071847, 'Loftus St, Concord' )");

        db.execSQL("INSERT INTO "  +  TABLE_MATCHES + "(m_round, m_date,m_hometeam,m_visitteam,m_ground,m_time1,m_time2, m_time17, m_time15, m_time14, m_logo, m_lat, m_long, m_address  ) "
                + "VALUES (19, '2018-07-15', 'APIA', 'Marconi', 'Lambert Park', ' 7:00PM',' 5:05PM', ' 3:30PM', ' 1:55PM', '12:30PM', 'marconi', -33.8845574,151.1441807,'20-22 Marion St, Leichhardt' )");

        db.execSQL("INSERT INTO "  +  TABLE_MATCHES + "(m_round, m_date,m_hometeam,m_visitteam,m_ground,m_time1,m_time2, m_time17, m_time15, m_time14, m_logo, m_lat, m_long, m_address  ) "
                + "VALUES (20, '2018-07-22', 'UNSW', 'APIA', 'David Phillips Field', ' 3:00PM',' 1:35PM', '11:30AM', ' 9:55AM', ' 8:30AM', 'unsw', -33.931135,151.2222627, 'Gwea Avenue Daceyville' )");

        db.execSQL("INSERT INTO "  +  TABLE_MATCHES + "(m_round, m_date,m_hometeam,m_visitteam,m_ground,m_time1,m_time2, m_time17, m_time15, m_time14, m_logo, m_lat, m_long, m_address ) "
                + "VALUES (21, '2018-07-29', 'APIA', 'Gladesville Ravens', 'Lambert Park', ' 7:00PM',' 5:05PM', ' 3:30PM', ' 1:55PM', '12:30PM', 'ravens', -33.8845574,151.1441807, '20-22 Marion St, Leichhardt' )");

        db.execSQL("INSERT INTO "  +  TABLE_MATCHES + "(m_round, m_date,m_hometeam,m_visitteam,m_ground,m_time1,m_time2, m_time17, m_time15, m_time14, m_logo, m_lat, m_long, m_address  ) "
                + "VALUES (22, '2018-08-05', 'St George', 'APIA', 'St George Stadium', ' 3:00PM',' 1:05PM', '11:30AM', ' 9:55AM', ' 8:30AM', 'stgeorge',-33.9420635,151.1520375, '88 Bestic Street, Rockdale' )");

    }

    // Upgrading database
    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
        db.execSQL("DROP TABLE IF EXISTS " + TABLE_MATCHES);

        // Create tables again
        onCreate(db);
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
                cursor.getDouble(11), cursor.getDouble(12), cursor.getString(13));
        // return contact

        return match;
    }

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