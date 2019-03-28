package com.example.rxjavaexample.views.tikets.list;

import com.example.rxjavaexample.models.dto.Ticket;

import java.util.List;

public interface LoadTickets {

    public void loadTickets(List<Ticket> tickets);

    public void showError(String message);
}


