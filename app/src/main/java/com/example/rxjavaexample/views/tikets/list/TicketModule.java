package com.example.rxjavaexample.views.tikets.list;


import com.example.rxjavaexample.di.scope.TicketScope;

import dagger.Module;
import dagger.Provides;

@Module
public class TicketModule {

    LoadTickets loadTickets;

    public TicketModule(LoadTickets loadTickets) {
        this.loadTickets = loadTickets;
    }

    @TicketScope
    @Provides
    LoadTickets providesLoadTickets() {
        return loadTickets;
    }


    @TicketScope
    @Provides
    ViewModelFactoryTickets provideViewModelFactory(LoadTickets loadTickets) {
        return new ViewModelFactoryTickets(loadTickets);
    }

}
