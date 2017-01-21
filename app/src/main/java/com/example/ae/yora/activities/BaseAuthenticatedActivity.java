package com.example.ae.yora.activities;

import android.content.Intent;
import android.os.Bundle;
import android.os.PersistableBundle;
import android.util.Log;

public abstract class BaseAuthenticatedActivity extends BaseActivity {

  @Override
  protected final void onCreate(Bundle savedState){
      super.onCreate(savedState);

      if(!application.getAuth().getUser().isLoggedIn()){
          if(application.getAuth().hasAuthToken()){
              Intent intent = new Intent(this, AuthenticationActivity.class);
              intent.putExtra(AuthenticationActivity.EXTRA_RETURN_TO_ACTIVITY, getClass().getName());
              startActivity(intent);
          }else{
              startActivity(new Intent(this, LoginActivity.class));
          }
          finish();
          return;
      }

      onYoraCreate(savedState);
  }

    protected abstract void onYoraCreate(Bundle savedState);
}
