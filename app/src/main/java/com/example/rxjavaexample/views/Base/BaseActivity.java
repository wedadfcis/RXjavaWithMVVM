package com.example.rxjavaexample.views.Base;

import android.support.v4.app.Fragment;
import android.support.v7.app.AppCompatActivity;


public abstract class BaseActivity extends AppCompatActivity {

    protected abstract void initializeViews();

    protected abstract void setListeners();


    protected void replaceFragment(int containerId, Fragment fragment, String tag) {
        getSupportFragmentManager().beginTransaction()
                .replace(containerId, fragment, tag)
                .commit();
    }
}
