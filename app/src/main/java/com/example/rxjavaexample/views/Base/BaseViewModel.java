package com.example.rxjavaexample.views.Base;

import android.arch.lifecycle.MutableLiveData;
import android.arch.lifecycle.ViewModel;

import io.reactivex.disposables.CompositeDisposable;
import io.reactivex.disposables.Disposable;

public class BaseViewModel extends ViewModel {

    private CompositeDisposable compositeDisposable = new CompositeDisposable();
    private MutableLiveData<Boolean> loadingLiveData;

    public BaseViewModel() {
        this.loadingLiveData = new MutableLiveData<>();
    }


    protected boolean addDisposable(Disposable disposable) {
        return compositeDisposable.add(disposable);
    }

    @Override
    protected void onCleared() {
        compositeDisposable.clear();
        super.onCleared();
    }

    protected void showLoading(boolean show) {
        loadingLiveData.postValue(show);
    }

    public MutableLiveData<Boolean> getLoadingLiveData() {

        return loadingLiveData;
    }


}
