package com.example.ae.yora.activities;


import android.content.Intent;
import android.os.Bundle;
import android.os.PersistableBundle;
import android.view.View;

import com.example.ae.yora.R;

public class LoginActivity extends BaseActivity {

    @Override
    public void onCreate(Bundle savedInstanceState, PersistableBundle persistentState) {
        super.onCreate(savedInstanceState, persistentState);
        setContentView(R.layout.activity_login);
    }

    public void doLogin(View view) {
        application.getAuth().getUser().setLoggedIn(true);
        startActivity(new Intent(this, MainActivity.class));
        finish();
    }
}
