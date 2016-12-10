package com.example.ae.yora.activities;

import android.os.Bundle;
import android.os.PersistableBundle;
import android.support.v7.app.AppCompatActivity;

import com.example.ae.yora.InfraStructure.YoraApplication;

public abstract class BaseActivity extends AppCompatActivity{
    protected YoraApplication application;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        application = (YoraApplication) getApplication();
    }
}
