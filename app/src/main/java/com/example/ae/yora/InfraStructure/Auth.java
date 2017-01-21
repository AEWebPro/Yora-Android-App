package com.example.ae.yora.InfraStructure;

import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.util.Log;

import com.example.ae.yora.activities.LoginActivity;

public class Auth {
    private static final String AUTH_PREFRENCES = "AUTH_PREFERENCES";
    private static final String Auth_PREFERENCES_TOKEN = "Auth_PREFERENCES_TOKEN";

    private final Context context;
    private final SharedPreferences preferences;

    private User user;
    private String authToken;

    public Auth(Context context) {
        this.context = context;
        user = new User();

        preferences = context.getSharedPreferences(AUTH_PREFRENCES, context.MODE_PRIVATE);
        authToken = preferences.getString(Auth_PREFERENCES_TOKEN, null);
    }

    public User getUser() {
        return user;
    }

    public String getAuthToken(){
        return authToken;
    }
    public boolean hasAuthToken(){
        return authToken != null && !authToken.isEmpty();
    }
    public void setAuthToken(String authToken){
        this.authToken = authToken;

        SharedPreferences.Editor editor = preferences.edit();
        editor.putString(Auth_PREFERENCES_TOKEN, authToken);
        editor.commit();
    }

    public void logout(){
        setAuthToken(null);

        Intent loginIntent = new Intent(context, LoginActivity.class);
        loginIntent.setFlags(Intent.FLAG_ACTIVITY_CLEAR_TASK | Intent.FLAG_ACTIVITY_NEW_TASK);
        context.startActivity(loginIntent);
    }
}






