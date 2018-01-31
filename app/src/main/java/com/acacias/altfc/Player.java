package com.acacias.altfc;

import java.util.ArrayList;

/**
 * Created by Alex.Galan on 30/10/2017.
 */

public class Player {
    int _id;
    int _team;
    int _number;
    String _firstname;
    String _lastname;


    public Player(){   }
    public Player( int team, int number, String firstname, String lastname){
       // this._id = id;
       // this._id = id;
        this._team = team;
        this._number = number;
        this._firstname= firstname;
        this._lastname=lastname;

    }

   // public Player(String name, String _phone_number){
    //    this._name = name;
    //    this._phone_number = _phone_number;
   // }
   public int getID(){
        return this._id;
    }

  //  public void setID(int id){
    //    this._id = id;
  //  }

    //public int get_id(){
    //    return this._id();
    //}

    public int getTeam(){
        return this._team;
    }
    public int getNumber(){
        return this._number;
    }
    public  String  get_firstname(){
        return this._firstname;
    }
    public  String  get_lastname(){
        return this._lastname;
    }

    public void setID(int id){   this._id = id;};
    public void setTeam(int team){   this._team = team;};
    public void setNumber(int number){   this._number = number;};

    public void setFirstName(String name){
        this._firstname = name;
    }

    public void setLastName(String name){
        this._lastname = name;
    }

  //  public void setPhoneNumber(String phone_number){
   //     this._phone_number = phone_number;
   // }

//    public static ArrayList<Player> getRecipesFromFile(String s, SquadsFragment squadsFragment) {
  //      return [Player]"Alannah Galan";
    //}


}
