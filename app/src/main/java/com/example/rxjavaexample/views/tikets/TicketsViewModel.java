package com.example.rxjavaexample.views.tikets;

import android.app.Application;

import com.example.rxjavaexample.R;
import com.example.rxjavaexample.views.Base.BaseViewModel;
import com.example.rxjavaexample.common.helper.Utils;
import com.example.rxjavaexample.models.dto.Price;
import com.example.rxjavaexample.models.dto.Ticket;

import java.util.List;

import io.reactivex.Single;
import io.reactivex.android.schedulers.AndroidSchedulers;
import io.reactivex.functions.BiFunction;
import io.reactivex.observers.DisposableSingleObserver;
import io.reactivex.schedulers.Schedulers;

public class TicketsViewModel extends BaseViewModel {

    private RepositoryTickets repositoryTickets;
    private LoadTickets loadTickets;

    public TicketsViewModel(LoadTickets loadTickets) {
        this.loadTickets = loadTickets;
    }

    protected void getTickets() {
            repositoryTickets = new RepositoryTickets();
            getTicketsObservable().zipWith(getPriceObservable(), new BiFunction<List<Ticket>, Price, List<Ticket>>() {
                        @Override
                        public List<Ticket> apply(List<Ticket> tickets, Price price) {
                            for (int i = 0; i < tickets.size(); i++) {
                                tickets.get(i).setPrice(price);
                            }
                            return tickets;
                        }
                    }
            ).subscribeOn(Schedulers.io())
                    .doOnSubscribe(disposable -> showLoading(true))
                    .doOnSuccess(disposable -> showLoading(false))
                    .doOnError(disposable -> showLoading(false))
                    .observeOn(AndroidSchedulers.mainThread())
                    .subscribe(getTicketsObserver());


    }

    private DisposableSingleObserver getTicketsObserver() {
        DisposableSingleObserver disposableSingleObserver = new DisposableSingleObserver() {

            @Override
            public void onSuccess(Object o) {
                loadTickets.loadTickets((List<Ticket>) Utils.convertObjectToList(o));
            }

            @Override
            public void onError(Throwable e) {

            }
        };
        //add to CompositeDisposable
        addDisposable(disposableSingleObserver);
        return disposableSingleObserver;

    }

    private Single<List<Ticket>> getTicketsObservable() {
        return repositoryTickets.getTickets();

    }

    private Single<Price> getPriceObservable() {
        return repositoryTickets.getPrice();
    }


}
