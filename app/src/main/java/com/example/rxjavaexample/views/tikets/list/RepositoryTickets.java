package com.example.rxjavaexample.views.tikets.list;

import com.example.rxjavaexample.di.Injector;
import com.example.rxjavaexample.helper.Constants;
import com.example.rxjavaexample.models.dto.Price;
import com.example.rxjavaexample.models.dto.Ticket;
import com.example.rxjavaexample.service.ApiInterface;

import java.util.List;

import javax.inject.Inject;

import io.reactivex.Single;

public class RepositoryTickets {

    @Inject
    ApiInterface apiInterface;

    public RepositoryTickets() {

        apiInterface = Injector.INSTANCE.getAppComponent().getApiInterface();
    }

    protected Single<List<Ticket>> getTickets() {
        return apiInterface.searchTickets();
    }

    protected Single<Price> getPrice() {
        return apiInterface.getPrice(Constants.Network.FLIGHT_NUMBER);
    }
}
