package com.example.rxjavaexample.views.tikets.list;

import com.example.rxjavaexample.helper.Constants;
import com.example.rxjavaexample.models.dto.Price;
import com.example.rxjavaexample.models.dto.Ticket;
import com.example.rxjavaexample.retrofite.ServiceHelper;

import java.util.List;

import io.reactivex.Single;

public class RepositoryTickets {

    protected Single<List<Ticket>> getTickets() {
        return ServiceHelper.getApiService().searchTickets();
    }

    protected Single<Price> getPrice() {
        return ServiceHelper.getApiService().getPrice(Constants.Network.FLIGHT_NUMBER);
    }
}
