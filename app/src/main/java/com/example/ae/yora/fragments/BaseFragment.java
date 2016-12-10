package com.example.ae.yora.fragments;


import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;

import com.example.ae.yora.InfraStructure.YoraApplication;

public abstract class BaseFragment extends Fragment {
    protected YoraApplication application;

    @Override
    public void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        application = (YoraApplication) getActivity().getApplication();
    }
}
