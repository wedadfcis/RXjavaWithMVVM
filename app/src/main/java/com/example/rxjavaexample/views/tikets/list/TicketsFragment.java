package com.example.rxjavaexample.views.tikets.list;

import android.arch.lifecycle.ViewModelProviders;
import android.content.Context;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ProgressBar;

import com.example.rxjavaexample.R;
import com.example.rxjavaexample.di.component.DaggerTicketComponent;
import com.example.rxjavaexample.di.component.TicketComponent;
import com.example.rxjavaexample.helper.Utils;
import com.example.rxjavaexample.models.dto.Ticket;
import com.example.rxjavaexample.views.Base.BaseFragment;

import java.util.List;

import javax.inject.Inject;


public class TicketsFragment extends BaseFragment implements LoadTickets {
    private RecyclerView rvTickets;
    private ProgressBar progressBar;
    private TicketsViewModel ticketsViewModel;
    private LoadTickets loadTickets;
    private TicketAdapter ticketAdapter;
    @Inject
    ViewModelFactoryTickets viewModelFactoryTickets;

    public TicketsFragment() {
        // Required empty public constructor
    }


    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view = inflater.inflate(R.layout.fragment_flights, container, false);
        initializeViews(view);
        return view;
    }


    @Override
    public void onAttach(Context context) {
        super.onAttach(context);
    }

    @Override
    public void onDetach() {
        super.onDetach();

    }

    @Override
    public void onActivityCreated(@Nullable Bundle savedInstanceState) {
        super.onActivityCreated(savedInstanceState);
        loadTickets = this;
        injectDependencies();
        initViewModels();
        bindViewModel();
        initializeRecyclerView();
    }

    @Override
    protected void initializeViews(View v) {
        rvTickets = v.findViewById(R.id.rvTickets);
        progressBar = v.findViewById(R.id.progressBar);
    }

    @Override
    protected void setListeners() {

    }

    @Override
    protected void bindViewModel() {
        // start fetching Tickets
        ticketsViewModel.getTickets();
        // observer on loading
        ticketsViewModel.getLoadingLiveData().observe(this, this::showProgressBar);
    }

    @Override
    protected void showProgressBar(Boolean shouldShow) {
        if (shouldShow == true) {
            progressBar.setVisibility(View.VISIBLE);
        } else {
            progressBar.setVisibility(View.GONE);
        }

    }

    @Override
    protected void injectDependencies() {
        TicketComponent ticketComponent = DaggerTicketComponent.builder()
                .ticketModule(new TicketModule(loadTickets))
                .build();
        ticketComponent.inject(this);
    }

    @Override
    protected void initViewModels() {
        //define viewModel
        ticketsViewModel = ViewModelProviders.of(getActivity(), viewModelFactoryTickets).get(TicketsViewModel.class);
    }

    public void initializeRecyclerView() {
        rvTickets.setLayoutManager(new LinearLayoutManager(getActivity()));
        ticketAdapter = new TicketAdapter(getActivity());
        rvTickets.setAdapter(ticketAdapter);
    }

    @Override
    public void loadTickets(List<Ticket> tickets) {

        if (tickets != null && tickets.size() > 0) {
            ticketAdapter.setTickets(tickets);
        } else {
            Utils.showToastMessage(getString(R.string.no_data), getActivity());
        }
    }
}
