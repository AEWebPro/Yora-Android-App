package com.example.ae.yora.activities;

import android.os.Bundle;
import android.util.Log;

import com.example.ae.yora.R;
import com.example.ae.yora.views.MainNavDrawer;

public class MainActivity extends BaseAuthenticatedActivity{

    @Override
    protected void onYoraCreate(Bundle savedState) {
        setContentView(R.layout.activity_main);
        getSupportActionBar().setTitle("Inbox");

        setNavDrawer(new MainNavDrawer(this));
    }
}
