package com.example.rxjavaexample.helper;

import android.app.Application;

import com.example.rxjavaexample.di.Injector;


public class MyApplication extends Application {


    @Override
    public void onCreate() {
        super.onCreate();
        initializeApplicationComponent();

    }

    private void initializeApplicationComponent() {
        if (Injector.INSTANCE.getAppComponent() == null) {
            Injector.INSTANCE.initializeAppComponent();
        }
    }

}
