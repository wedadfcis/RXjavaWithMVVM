package com.example.rxjavaexample.views.tikets.list;


import android.content.Context;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;

import com.example.rxjavaexample.di.scope.TicketScope;

import dagger.Module;
import dagger.Provides;

@Module
public class TicketModule {

    private final LoadTickets loadTickets;
    private final Context context;


    public TicketModule(LoadTickets loadTickets ,Context context) {
        this.loadTickets = loadTickets;
        this.context = context;

    }

    @TicketScope
    @Provides
    RepositoryTickets provideRepositoryTickets()
    {
        return new RepositoryTickets();
    }

    @TicketScope
    @Provides
    LoadTickets providesLoadTickets() {
        return loadTickets;
    }


    @TicketScope
    @Provides
    ViewModelFactoryTickets provideViewModelFactory( RepositoryTickets repositoryTickets) {
        return new ViewModelFactoryTickets(loadTickets,repositoryTickets);
    }

    @TicketScope
    @Provides
    public RecyclerView.LayoutManager provideLayoutManger() {
        return new LinearLayoutManager(context);
    }

    @TicketScope
    @Provides

    public TicketAdapter provideTicketAdapter()
    {
        return new TicketAdapter(context);
    }

}
