package com.example.ae.yora.dialogs;


import android.app.DialogFragment;
import android.os.Bundle;

import com.example.ae.yora.InfraStructure.YoraApplication;

public abstract class BaseDialogFragment extends DialogFragment{
    protected YoraApplication application;

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        application = (YoraApplication) getActivity().getApplication();
    }
}
