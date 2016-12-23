package com.example.ae.yora.activities;

import android.os.Bundle;

import com.example.ae.yora.R;
import com.example.ae.yora.views.MainNavDrawer;


public class SendMessagesActivity extends BaseAuthenticatedActivity {
    @Override
    protected void onYoraCreate(Bundle savedState) {
        setContentView(R.layout.activity_sent_messages);
        setNavDrawer(new MainNavDrawer(this));
    }
}
