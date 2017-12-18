package com.acacias.altfc;

import java.util.ArrayList;

/**
 * Created by Alex.Galan on 30/10/2017.
 */

public class Player {
    int _id;
    String _name;
    String _phone_number;
    public Player(){   }
    public Player(int id, String name, String _phone_number){
        this._id = id;
        this._name = name;
        this._phone_number = _phone_number;
    }

    public Player(String name, String _phone_number){
        this._name = name;
        this._phone_number = _phone_number;
    }
    public int getID(){
        return this._id;
    }

    public void setID(int id){
        this._id = id;
    }

    public String getName(){
        return this._name;
    }

    public void setName(String name){
        this._name = name;
    }

    public String getPhoneNumber(){
        return this._phone_number;
    }

    public void setPhoneNumber(String phone_number){
        this._phone_number = phone_number;
    }

//    public static ArrayList<Player> getRecipesFromFile(String s, SquadsFragment squadsFragment) {
  //      return [Player]"Alannah Galan";
    //}


}
