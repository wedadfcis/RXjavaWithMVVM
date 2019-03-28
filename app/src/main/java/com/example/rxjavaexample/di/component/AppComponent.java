package com.example.rxjavaexample.di.component;

import com.example.rxjavaexample.di.scope.ApplicationScope;
import com.example.rxjavaexample.service.ApiInterface;
import com.example.rxjavaexample.service.RetrofitModule;

import dagger.Component;

@ApplicationScope
@Component(modules = {RetrofitModule.class})
public interface AppComponent {
    ApiInterface getApiInterface();

}
