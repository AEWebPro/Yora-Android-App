package com.example.ae.yora.activities;


import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.widget.Toast;

import com.example.ae.yora.InfraStructure.Auth;
import com.example.ae.yora.R;
import com.example.ae.yora.services.Account;
import com.squareup.otto.Subscribe;

public class AuthenticationActivity extends BaseActivity{

    private Auth auth;

    public static final String EXTRA_RETURN_TO_ACTIVITY = "EXTRA RETURN TO ACTIVITY";

    @Override
    public void onCreate (Bundle savedState){
        super.onCreate(savedState);
        setContentView(R.layout.activity_authentication);

        auth = application.getAuth();
        if(!auth.hasAuthToken()){
            startActivity(new Intent(this,LoginActivity.class));
            finish();
            return;
        }

        bus.post(new Account.LoginWithLocalTokenRequest(auth.getAuthToken()));
    }

    @Subscribe
    public void onLoginWithLocalToken(Account.LoginWithLocalTokenResponse response){
        if(!response.didSucced()){
            Toast.makeText(this,"Please Login again!", Toast.LENGTH_LONG).show();
            auth.setAuthToken(null);
            startActivity(new Intent(this, LoginActivity.class));
            finish();
            return;
        }

        Intent intent;
        String returnTo = getIntent().getStringExtra(EXTRA_RETURN_TO_ACTIVITY);
        if(returnTo != null){
            try{
                Log.e("onLoginWithLocalToken: ",returnTo );
                intent = new Intent(this,Class.forName(returnTo));
            }catch (Exception ignored){
                Log.e("onLoginWithLocalToken: ","in the catch");
                intent = new Intent(this, MainActivity.class);
            }
        }else{
            Log.e("onLoginWithLocalToken: ","in the else" );
            intent = new Intent(this, MainActivity.class);
        }
        startActivity(intent);
        finish();
    }
}
