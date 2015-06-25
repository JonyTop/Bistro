package com.example.oscarsanchez.app2;
import android.content.Context;
import android.content.SharedPreferences;

/**
 * Created by Oscar Sanchez on 24/06/2015.
 */
public class UserLocalStore {

    public static final String SP_NAME = "userDetails";
    SharedPreferences userLocalDatabase;

    public UserLocalStore(Context context){
        userLocalDatabase = context.getSharedPreferences(SP_NAME,0);


    }
    public void setUserLocalDatabase(User user){
        SharedPreferences.Editor spEditer = userLocalDatabase.edit();
        spEditer.putString("name", user.name);
        spEditer.putInt("age", user.age);
        spEditer.putString("username", user.username);
        spEditer.putString("password", user.password);
        spEditer.commit();


    }
    public User getLoggedInUser(){
        String name = userLocalDatabase.getString("name", "");
        int age = userLocalDatabase.getInt("age", -1);
        String username = userLocalDatabase.getString("username", "");
        String password = userLocalDatabase.getString("password", "");

        User storedUser = new User(name, age, username, password);

        return storedUser;
    }
    public void setUserLoggedIn(boolean loggedIn){
        SharedPreferences.Editor spEditor = userLocalDatabase.edit();
        spEditor.putBoolean("LoggedIn", loggedIn);
        spEditor.commit();
    }
    public boolean getUserLoggedIn(){
        if (userLocalDatabase.getBoolean("LoggedIn", false) == true){
            return true;
        }else {
            return false;
        }
    }
    public void clearUserData(){
        SharedPreferences.Editor spEditor = userLocalDatabase.edit();
        spEditor.clear();
        spEditor.commit();
    }


    public void storeUserData(User user) {

    }
}

