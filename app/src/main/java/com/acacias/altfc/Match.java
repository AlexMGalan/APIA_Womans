package com.acacias.altfc;


import java.util.ArrayList;


/**
 * Created by Alex.Galan on 30/10/2017.
 */

public class Match {
    String _date;
    String _teamhome;
    String _teamvisit;
    String _ground;
    String _time1;
    String _time2;
    String _time17;
    String _time15;
    String _time14;


    public Match(){   }
    public Match( String date, String teamhome, String teamvisit, String ground,String time1, String time2, String time17, String time15, String time14){
        // this._id = id;
        // this._id = id;
        this._date = date;
        this._teamhome = teamhome;
        this._teamvisit= teamvisit;
        this._ground=ground;

        this._time1=time1;
        this._time2=time2;
        this._time17=time17;
        this._time15=time15;
        this._time14=time14;

    }

    // public Player(String name, String _phone_number){
    //    this._name = name;
    //    this._phone_number = _phone_number;
    // }
    public String getDate(){
        return this._date;
    }
    public String getHomeTeam(){
        return this._teamhome;
    }
    public String getVisitTeam(){
        return this._teamvisit;
    }
    public  String  getGround(){
        return this._ground;
    }
    public  String  getTime1(){
        return this._time1;
    }
    public  String  getTime2(){
        return this._time2;
    }
    public  String  getTime17(){
        return this._time17;
    }
    public  String  getTime15(){
        return this._time15;
    }
    public  String  getTime14(){return this._time14;}

    public void setDate(String date){   this._date = date;};
    public void setHomeTeam(String hometeam){   this._teamhome = hometeam;};
    public void setVisitTeam(String visitteam){   this._teamvisit = visitteam;};
    public void setGround(String ground){
        this._ground = ground;
    }
    public void setTime1(String time1st){
        this._time1 = time1st;
    }
   public void setTime2(String timeres){
        this._time2 = timeres;
    }

   public void setTime17(String time17){
        this._time17 = time17;
    }

    public void setTime15(String time15){
        this._time15 = time15;
   }

    public void setTime14(String time14){
        this._time14 = time14;
    }




}
