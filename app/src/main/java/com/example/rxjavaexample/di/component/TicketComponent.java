package com.example.rxjavaexample.di.component;

import com.example.rxjavaexample.di.scope.TicketScope;
import com.example.rxjavaexample.views.tikets.list.TicketModule;
import com.example.rxjavaexample.views.tikets.list.TicketsFragment;

import dagger.Component;

@TicketScope
@Component(modules = TicketModule.class)
public interface TicketComponent {

    void inject(TicketsFragment ticketsFragment);
}
