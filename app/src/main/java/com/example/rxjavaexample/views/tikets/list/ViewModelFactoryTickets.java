package com.example.rxjavaexample.views.tikets.list;

import android.arch.lifecycle.ViewModel;
import android.arch.lifecycle.ViewModelProvider;
import android.support.annotation.NonNull;

import javax.inject.Inject;
import javax.inject.Singleton;

public class ViewModelFactoryTickets implements ViewModelProvider.Factory {
    private LoadTickets loadTickets;
    private RepositoryTickets repositoryTickets;

    @Inject
    public ViewModelFactoryTickets(LoadTickets loadTickets ,RepositoryTickets repositoryTickets) {

        this.loadTickets = loadTickets;
        this.repositoryTickets = repositoryTickets;
    }

    @NonNull
    @Override
    public <T extends ViewModel> T create(@NonNull Class<T> modelClass) {
        return (T) new TicketsViewModel(loadTickets ,repositoryTickets);
    }
}
