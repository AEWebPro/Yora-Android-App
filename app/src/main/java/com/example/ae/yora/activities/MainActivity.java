package com.example.ae.yora.activities;

import android.os.Bundle;
import android.util.Log;

import com.example.ae.yora.R;

public class MainActivity extends BaseAuthenticatedActivity{

    @Override
    protected void onYoraCreate(Bundle savedState) {
        Log.i("Main Activity", "We are here");
    }
}
