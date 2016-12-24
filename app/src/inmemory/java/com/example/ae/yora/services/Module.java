package com.example.ae.yora.services;

import android.util.Log;

import com.example.ae.yora.InfraStructure.YoraApplication;

public class Module{
    public static void register(YoraApplication application){
        new InMemoryAccountService(application);
    }
}