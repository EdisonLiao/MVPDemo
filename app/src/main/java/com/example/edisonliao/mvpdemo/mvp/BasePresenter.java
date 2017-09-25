package com.example.edisonliao.mvpdemo.mvp;

import android.support.annotation.MainThread;

import com.example.edisonliao.mvpdemo.retrofit.ApiClient;
import com.example.edisonliao.mvpdemo.retrofit.ApiStores;

import rx.Observable;
import rx.Subscriber;
import rx.android.schedulers.AndroidSchedulers;
import rx.schedulers.Schedulers;
import rx.subscriptions.CompositeSubscription;

/**
 * Created by EdisonLiao on 2017/9/23.
 */

public class BasePresenter<V> {
    public V mView;
    protected ApiStores mApiStores;
    private CompositeSubscription mComposite;

    public void attachView(V mView){
        this.mView = mView;
        mApiStores = ApiClient.retrofit().create(ApiStores.class);
    }

    public void detachView(){
        this.mView = null;
        onUnsubscribe();
    }

    //Rxjava取消注册，避免内存泄露
    public void onUnsubscribe(){
        if (mComposite != null && mComposite.hasSubscriptions()){
            mComposite.unsubscribe();
        }
    }

    public void addSubscription(Observable observable, Subscriber subscriber){
        if (mComposite == null){
            mComposite = new CompositeSubscription();
        }
        mComposite.add(observable
            .subscribeOn(Schedulers.io())
            .observeOn(AndroidSchedulers.mainThread())
            .subscribe(subscriber));

    }

}
