package com.example.rxjavaexample.service;
import com.example.rxjavaexample.models.dto.Price;
import com.example.rxjavaexample.models.dto.Ticket;

import java.util.List;

import io.reactivex.Single;
import retrofit2.http.GET;
import retrofit2.http.Query;

public interface ApiInterface {
    @GET("airline-tickets.php")
    Single<List<Ticket>> searchTickets();
    @GET("airline-tickets-price.php")
    Single<Price> getPrice(@Query("flight_number") String flightNumber);
}

