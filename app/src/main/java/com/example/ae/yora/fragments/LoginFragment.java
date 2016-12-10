package com.example.ae.yora.fragments;


import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.example.ae.yora.R;

public class LoginFragment extends BaseFragment{

    @Override
    public View onCreateView (LayoutInflater inflater, ViewGroup group, Bundle savedState){
        View view = inflater.inflate(R.layout.fragment_login, group, false);

        return view;
    }
}
