package com.example.ae.yora.activities;


import android.content.Intent;
import android.os.Bundle;
import android.os.PersistableBundle;
import android.util.Log;
import android.view.View;

import com.example.ae.yora.R;

public class LoginActivity extends BaseActivity implements View.OnClickListener {

    private View loginButton;

    @Override
    public void onCreate(Bundle savedInstanceState, PersistableBundle persistentState) {
        super.onCreate(savedInstanceState, persistentState);
        setContentView(R.layout.activity_login);
        Log.i("Login Activity", "We are here");

        loginButton = findViewById(R.id.fragment_login_loginButton);
        if(loginButton != null){
            loginButton.setOnClickListener(this);
        }
    }


    @Override
    public void onClick(View view) {
        if(view == loginButton){
            startActivity(new Intent(this, LoginNarrowActivity.class));
        }
    }
}
