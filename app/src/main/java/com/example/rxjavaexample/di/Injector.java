package com.example.rxjavaexample.di;


import com.example.rxjavaexample.di.component.AppComponent;
import com.example.rxjavaexample.di.component.DaggerAppComponent;
import com.example.rxjavaexample.helper.Constants;
import com.example.rxjavaexample.helper.MyApplication;
import com.example.rxjavaexample.service.RetrofitModule;

public enum Injector {

    INSTANCE;
    private AppComponent appComponent;

    public AppComponent initializeAppComponent(MyApplication application) {
        appComponent = DaggerAppComponent.builder()
                .retrofitModule(new RetrofitModule(Constants.Network.BASE_NETWORK_URL))
                .build();
        return appComponent;
    }

    public AppComponent getAppComponent() {
        return appComponent;
    }
}
