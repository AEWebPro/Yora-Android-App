package com.example.ae.yora.activities;

import android.os.Bundle;
import android.util.Log;

public class MainActivity extends BaseAuthenticatedActivity{

    @Override
    protected void onYoraCreate(Bundle savedState) {
        Log.i("Main Activity", "We are here");
    }
}
