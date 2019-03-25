package com.example.rxjavaexample.views.Base;

import android.support.v7.app.AppCompatActivity;


public abstract class BaseActivity extends AppCompatActivity {

    protected abstract void initializeViews();

    protected abstract void setListeners();

    protected abstract void addFragment();
}
