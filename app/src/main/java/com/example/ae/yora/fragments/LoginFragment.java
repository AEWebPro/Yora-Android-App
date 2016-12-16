package com.example.ae.yora.fragments;


import android.app.Activity;
import android.content.Context;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;

import com.example.ae.yora.R;

public class LoginFragment extends BaseFragment implements View.OnClickListener {
    private Button loginButton;
    private Callbacks callbacks;
    @Override
    public View onCreateView (LayoutInflater inflater, ViewGroup group, Bundle savedState){
        View view = inflater.inflate(R.layout.fragment_login, group, false);

        loginButton = (Button) view.findViewById(R.id.fragment_login_loginButton);
        loginButton.setOnClickListener(this);

        return view;
    }

    @Override
    public void onClick(View view) {
        if(view == loginButton){
            application.getAuth().getUser().setLoggedIn(true);
            callbacks.onLoggedIn();
        }
    }

    @Override
    public void onAttach(Context context) {
        super.onAttach(context);
        callbacks = (Callbacks) context;
    }
    /*@Override
    public void onAttach(Activity activity) {
        super.onAttach(activity);
        callbacks = (Callbacks) activity;
    }*/

    @Override
    public void onDetach() {
        super.onDetach();
        callbacks = null;
    }


    public interface Callbacks{
        void onLoggedIn();
    }
}
