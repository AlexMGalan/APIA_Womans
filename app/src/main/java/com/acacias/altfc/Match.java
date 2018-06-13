package com.acacias.altfc;

/**
 * Created by Alex.Galan on 30/10/2017.
 */

public class Match {
    int _round;
    String _date;
    String _teamhome;
    String _teamvisit;
    String _ground;
    String _time1;
    String _time2;
    String _time17;
    String _time15;
    String _time14;
    String _logo;
    double _lat;
    double _long;
    String _address;


    public Match(){   }
    public Match(int round, String date, String teamhome, String teamvisit, String ground,String time1, String time2, String time17, String time15, String time14, String logo,
                 double mlat, double mlong, String address){
        // this._id = id;
        // this._id = id;
        this._round = round;
        this._date = date;
        this._teamhome = teamhome;
        this._teamvisit= teamvisit;
        this._ground=ground;

        this._time1=time1;
        this._time2=time2;
        this._time17=time17;
        this._time15=time15;
        this._time14=time14;
        this._logo=logo;
        this._lat=mlat;
        this._long=mlong;
        this._address=address;

    }

    // public Player(String name, String _phone_number){
    //    this._name = name;
    //    this._phone_number = _phone_number;
    // }
    public int getRound(){
        return this._round;
    }
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
    public  String  getlogo(){return this._logo;}
    public  double  getlat(){return this._lat;}
    public  double  getlong(){return this._long;}
    public  String  getAddress(){return this._address;}

    public void setRound(int round){   this._round= round;};
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
    public void setTime17(String time17){ this._time17 = time17;}
    public void setTime15(String time15){
        this._time15 = time15;
   }
    public void setTime14(String time14){
        this._time14 = time14;
    }
    public void setLat(double mlat){
        this._lat = mlat;
    }
    public void setLong(double mlong){this._long = mlong;}
    public void setAddress(String address){this._address = address;}
}
