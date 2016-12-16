package com.example.ae.yora.activities;

import android.os.Bundle;
import android.os.PersistableBundle;
import android.util.Log;

import com.example.ae.yora.R;
import com.example.ae.yora.fragments.LoginFragment;

public class LoginNarrowActivity extends BaseActivity implements LoginFragment.Callbacks{

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        setContentView(R.layout.activity_login_narrow);
    }

    @Override
    public void onLoggedIn() {
        setResult(RESULT_OK);
        finish();
    }
}
