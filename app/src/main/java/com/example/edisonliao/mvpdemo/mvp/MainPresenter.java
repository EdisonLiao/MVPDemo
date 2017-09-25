package com.example.edisonliao.mvpdemo.mvp;

import com.example.edisonliao.mvpdemo.mvp.model.MainModelResponse;
import com.example.edisonliao.mvpdemo.retrofit.ApiCallBack;

/**
 * Created by EdisonLiao on 2017/9/23.
 */

public class MainPresenter extends BasePresenter<MainView> {

    public MainPresenter(MainView view){
        attachView(view);
    }

    public void start(String osType,String month,String day){
        mView.showLoading();
        addSubscription(mApiStores.loadDataByRetrofitRxjava(osType, month, day),
                new ApiCallBack<MainModelResponse>() {
                    @Override
                    public void onSuccess(MainModelResponse model) {
                        mView.getMainModelData(model);
                    }

                    @Override
                    public void onFailure(String msg) {
                        mView.getErrorMsg(msg);
                    }

                    @Override
                    public void onFinish() {
                        mView.hideLoading();
                    }
                });

    }

}
