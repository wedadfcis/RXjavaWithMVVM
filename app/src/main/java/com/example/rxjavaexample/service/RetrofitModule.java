package com.example.rxjavaexample.service;

import com.example.rxjavaexample.di.scope.ApplicationScope;
import com.example.rxjavaexample.helper.Constants;
import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import com.jakewharton.retrofit2.adapter.rxjava2.RxJava2CallAdapterFactory;

import java.util.concurrent.TimeUnit;

import dagger.Module;
import dagger.Provides;
import okhttp3.OkHttpClient;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

@Module
public class RetrofitModule {

    String baseUrl;

    public RetrofitModule(String baseUrl) {
        this.baseUrl = baseUrl;
    }

    @ApplicationScope
    @Provides
    public Retrofit provideRetrofit(OkHttpClient okHttpClient, GsonConverterFactory gsonConverterFactory) {
        return new Retrofit.Builder().baseUrl(baseUrl)
                .client(okHttpClient)
                .addConverterFactory(gsonConverterFactory)
                .addCallAdapterFactory(RxJava2CallAdapterFactory.create())
                .build();

    }

    @ApplicationScope
    @Provides
    public OkHttpClient provideOkHttp() {
        return new OkHttpClient.Builder()
                .readTimeout(Constants.Network.READ_TIMEOUT, TimeUnit.SECONDS)
                .connectTimeout(Constants.Network.CONNECT_TIMEOUT, TimeUnit.SECONDS)
                .build();
    }

    @ApplicationScope
    @Provides
    public Gson gson() {
        GsonBuilder gsonBuilder = new GsonBuilder();
        return gsonBuilder.create();
    }

    @ApplicationScope
    @Provides
    public GsonConverterFactory gsonConverterFactory() {
        return GsonConverterFactory.create(gson());
    }

    @ApplicationScope
    @Provides
    public ApiInterface provideApiInterface(Retrofit retrofit) {
        return retrofit.create(ApiInterface.class);
    }

}
