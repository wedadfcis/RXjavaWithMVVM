package com.example.rxjavaexample.views.tikets.list;

import android.arch.lifecycle.ViewModel;
import android.arch.lifecycle.ViewModelProvider;
import android.support.annotation.NonNull;

import javax.inject.Inject;
import javax.inject.Singleton;

@Singleton
public class ViewModelFactoryTickets implements ViewModelProvider.Factory {
    private LoadTickets loadTickets;

    @Inject
    public ViewModelFactoryTickets(LoadTickets loadTickets) {

        this.loadTickets = loadTickets;
    }

    @NonNull
    @Override
    public <T extends ViewModel> T create(@NonNull Class<T> modelClass) {
        return (T) new TicketsViewModel(loadTickets);
    }
}
