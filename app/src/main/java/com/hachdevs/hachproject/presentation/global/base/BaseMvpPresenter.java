package com.hachdevs.hachproject.presentation.global.base;

import io.reactivex.disposables.CompositeDisposable;

public class BaseMvpPresenter<T extends BaseMvpView> {

    private T view;
    private CompositeDisposable subscriptions;

    public void attachView(T view) {
        this.view = view;
        subscriptions = new CompositeDisposable();
    }

    public void detachView() {
        subscriptions.dispose();
        view = null;
    }

    protected T getView() {
        return view;
    }

    public CompositeDisposable getSubscriptions() {
        return subscriptions;
    }
}