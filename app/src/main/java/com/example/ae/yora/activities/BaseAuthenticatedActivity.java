package com.example.ae.yora.activities;

import android.content.Intent;
import android.os.Bundle;
import android.os.PersistableBundle;

public abstract class BaseAuthenticatedActivity extends BaseActivity {

  @Override
  protected final void onCreate(Bundle savedState){
      super.onCreate(savedState);

      if(!application.getAuth().getUser().isLoggedIn()){
          startActivity(new Intent(this, LoginActivity.class));
          finish();
          return;
      }

      onYoraCreate(savedState);
  }

    protected abstract void onYoraCreate(Bundle savedState);
}
