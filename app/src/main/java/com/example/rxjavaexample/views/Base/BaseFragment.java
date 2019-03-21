package com.example.rxjavaexample.views.Base;

import android.support.v4.app.Fragment;
import android.view.View;

public  abstract class BaseFragment extends Fragment {

    protected abstract void initializeViews(View v);
    protected abstract void setListeners();
    protected abstract void bindViewModel();
    protected abstract void showProgressBar(Boolean shouldShow);





}
