package com.example.rxjavaexample.views.main;

import android.os.Bundle;

import com.example.rxjavaexample.R;
import com.example.rxjavaexample.helper.Constants;
import com.example.rxjavaexample.views.Base.BaseActivity;
import com.example.rxjavaexample.views.tikets.list.TicketsFragment;

public class MainActivity extends BaseActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        addFragment();
    }

    @Override
    protected void initializeViews() {

    }

    @Override
    protected void setListeners() {

    }

    @Override
    protected void addFragment() {
        TicketsFragment ticketsFragment = new TicketsFragment();
        getSupportFragmentManager().beginTransaction().add(R.id.content, ticketsFragment, Constants.FragmentTag.TICKETS_FRAGMENT_TAG).commit();
    }
}
