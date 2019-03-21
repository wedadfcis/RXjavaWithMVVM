package com.example.rxjavaexample.views.tikets;

import android.arch.lifecycle.ViewModel;
import android.arch.lifecycle.ViewModelProvider;
import android.support.annotation.NonNull;

public class ViewModelFactoryTickets implements ViewModelProvider.Factory {
    private LoadTickets loadTickets;

    public ViewModelFactoryTickets(LoadTickets loadTickets) {
        this.loadTickets = loadTickets;
    }

    @NonNull
    @Override
    public <T extends ViewModel> T create(@NonNull Class<T> modelClass) {
        return (T) new TicketsViewModel(loadTickets);
    }
}
